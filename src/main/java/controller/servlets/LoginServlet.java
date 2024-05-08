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
   
            request.setAttribute("errorMessage",stringUtil.MESSAGE_ERROR );
            request.getRequestDispatcher(stringUtil.URL_PAGE_LOGIN).forward(request, response);
            return;
        }

        if (!username.matches("^[a-zA-Z0-9]{6,}$")) {

            request.setAttribute( "errorMessage",stringUtil.MESSAGE_ERROR_USERNAME_INVALIDL);
            request.getRequestDispatcher(stringUtil.URL_PAGE_LOGIN).forward(request, response);
            return;
        }

        LoginResult loginResult = dbController.getUserInfo(loginModel);
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
                response.sendRedirect(request.getContextPath() +stringUtil.PAGE_URL_DASHBOARD);
            } else {

            	HttpSession userSession = request.getSession();
                userSession.setAttribute("username", username);
                userSession.setAttribute("id", userSession.getId());
                // Redirect to home page
                userSession.setAttribute("loggedIn", true);

                response.sendRedirect(request.getContextPath() +stringUtil.URL_PAGE_HOME);
                // User is not admin, redirect to home page
               
            }
        }else if (loginResult.getStatus() == 0) {
            // Username not found, redirect to register page

            request.setAttribute(stringUtil.MESSAGE_ERROR_CREATE_ACCOUNT, "errorMessage");
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
        }
        else if (loginResult.getStatus() == -1) {
            // SERVER not found, redirect to register page

            request.setAttribute(stringUtil.MESSAGE_ERROR_SERVER, "errorMessage");
            request.getRequestDispatcher(stringUtil.URL_PAGE_LOGIN).forward(request, response);
        } 
        else {
            // Login failed, redirect to login page with error message
        	request.setAttribute(stringUtil.MESSAGE_ERROR_LOGIN, "errorMessage");
            request.getRequestDispatcher(stringUtil.URL_PAGE_LOGIN).forward(request, response);
        }
    }
}