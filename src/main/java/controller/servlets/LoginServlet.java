package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.GadgetDbController;
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
        System.out.println("Email from user: " + username);
        String password = request.getParameter("password");
        System.out.println("Password from user: " + password);

        UserLoginModel userLoginmodel = new UserLoginModel(username, password);
        
        System.out.println("Password from user: " + userLoginmodel);

        // Call DBController to validate login credentials
        int loginResult = dbController.getUserLoginInfo(userLoginmodel);
        System.out.println("Password from database: " + loginResult);

        if (loginResult == 1) {
            // Login successful
        	HttpSession userSession = request.getSession();
			userSession.setAttribute("username", username);
			userSession.setMaxInactiveInterval(30*30);
            System.out.println("Redirecting to home page...");
            response.sendRedirect(request.getContextPath() + "/pages/welcome.jsp");
        } else {
            // Login unsuccessful
            System.out.println("Login unsuccessful. Redirecting to login page...");
            request.setAttribute(stringUtil.MESSAGE_ERROR, stringUtil.MESSAGE_ERROR_LOGIN);
            request.getRequestDispatcher(stringUtil.PAGE_URL_LOGIN).forward(request, response);
        }
    }
}
