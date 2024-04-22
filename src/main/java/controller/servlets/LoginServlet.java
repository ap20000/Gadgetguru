package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.GadgetDbController;
import model.LoginResult;
import model.UserLoginModel;
import util.stringUtil;

@WebServlet(urlPatterns = "/LoginServlet", asyncSupported = true)
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GadgetDbController dbController;

    public LoginServlet() {
        super();
        this.dbController = new GadgetDbController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserLoginModel loginModel = new UserLoginModel(username, password);
        loginModel.setUser_name(username);
        loginModel.setPassword(password);


        LoginResult loginResult = dbController.getUserLoginInfo(loginModel);

        if (loginResult.getStatus() == 1) {
        	 HttpSession userSession = request.getSession();
             userSession.setAttribute("user_name", username);
            if ("admin".equals(loginResult.getRole())) {
            	
                // User is admin, redirect to admin dashboard
                response.sendRedirect(request.getContextPath() +"/pages/Dashboard.jsp");
            } else {

                // Redirect to home page
                response.sendRedirect(request.getContextPath() + "/pages/welcome.jsp");
                // User is not admin, redirect to home page
                response.sendRedirect(request.getContextPath() +"/pages/welcome.jsp");
            }
        } else {
            // Login failed, redirect to login page with error message
            response.sendRedirect(request.getContextPath() +"login.jsp?error=1");
        }
    }
}