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
        loginModel.setUser_Name(username);
        loginModel.setPassword(password);
        System.out.println("Username" + username);
        System.out.println("password"+  password);

        if (username.length() < 6) {
            String errorMessage = "Invalid User name. Please enter more than 6 characters";
            request.setAttribute(stringUtil.MESSAGE_ERROR, errorMessage);
            request.getRequestDispatcher(stringUtil.PAGE_URL_REGISTER).forward(request, response);
            return;
        }

        if (!username.matches("^[a-zA-Z0-9]{6,}$")) {
            String errorMessage = "Invalid User name. Please don't enter symbols.";
            request.setAttribute(stringUtil.MESSAGE_ERROR, errorMessage);
            request.getRequestDispatcher(stringUtil.PAGE_URL_REGISTER).forward(request, response);
            return;
        }

        LoginResult loginResult = dbController.getUserLoginInfo(loginModel);
        System.out.print("aaaa"+loginResult.getStatus());

        if (loginResult.getStatus() == 1) {
        	
        	System.out.print("aaaa");
            if ("admin".equals(loginResult.getRole())) {
            	HttpSession userSession = request.getSession();
                userSession.setAttribute("username", username);
                userSession.setAttribute("role", "admin");
                userSession.setAttribute("id", userSession.getId());
                userSession.setAttribute("loggedIn", true);
                // User is admin, redirect to admin dashboard
                response.sendRedirect(request.getContextPath() +"/pages/Dashboard.jsp");
            } else {

            	HttpSession userSession = request.getSession();
                userSession.setAttribute("username", username);
                userSession.setAttribute("id", userSession.getId());
                // Redirect to home page
                userSession.setAttribute("loggedIn", true);

                response.sendRedirect(request.getContextPath() + "/pages/landingpage.jsp");
                // User is not admin, redirect to home page
               
            }
        }else if (loginResult.getStatus() == -1) {
            // Username not found, redirect to register page
            String errorMessage = "Username not found. Please register.";
            request.setAttribute(stringUtil.MESSAGE_ERROR, errorMessage);
            request.getRequestDispatcher(stringUtil.PAGE_URL_REGISTER).forward(request, response);
        }  else {
            // Login failed, redirect to login page with error message
            response.sendRedirect(request.getContextPath() +"login.jsp?error=1");
        }
    }
}