package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.GadgetDbController;
import util.stringUtil;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private GadgetDbController dbController;

    public ForgetPassword() {
        super();
        dbController = new GadgetDbController(); // Instantiate GadgetDbController
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String user_Name = request.getParameter("user_Name");
	    System.out.println("Username: " + user_Name);
	    String new_Password = request.getParameter("new_Password");
	    System.out.println("New Password: " + new_Password);

	    // Call the updateUserPasswordIfValid method from GadgetDbController
	    int result = dbController.ValidupdateUserPassword(user_Name, new_Password); 
	    // Pass only the new password

	    System.out.println("Result: " + result);
	    if (result == 1) {
	    	request.setAttribute(stringUtil.MESSAGE_SUCCESS_FORGET, stringUtil.MESSAGE_SUCCESS_FORGET);
			response.sendRedirect(request.getContextPath() + stringUtil.URL_PAGE_LOGIN);
	        // Password updated successfully
	        System.out.println("Password updated successfully for user: " + user_Name);
	        // Redirect to a success page or show a success message
	    } else if (result == 0) {
	        // Incorrect old password
	        // Redirect to a page showing an error message
	    } else if (result == -1) {
	        // Username not found
	        // Redirect to a page showing an error message
	    } else {
	        // Error updating password
	        // Redirect to a page showing an error message
	    }
	}
}
