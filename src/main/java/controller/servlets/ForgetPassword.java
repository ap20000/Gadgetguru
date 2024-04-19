package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.GadgetDbController;

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
	    String username = request.getParameter("username");
	    System.out.println("Username: " + username);
	    String newPassword = request.getParameter("newPassword");
	    System.out.println("New Password: " + newPassword);

	    // Call the updateUserPasswordIfValid method from GadgetDbController
	    int result = dbController.updateUserPasswordIfValid(username, newPassword); 
	    // Pass only the new password

	    System.out.println("Result: " + result);
	    if (result == 1) {
	        // Password updated successfully
	        System.out.println("Password updated successfully for user: " + username);
	        // Redirect to a success page or show a success message
	    } else if (result == -2) {
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
