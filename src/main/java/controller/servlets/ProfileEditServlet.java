package controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileEditServlet
 */
@WebServlet("/ProfileEditServlet")
public class ProfileEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileEditServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		    String user_name = request.getParameter("username");
		    System.out.println("username"+user_name);
	        String full_name = request.getParameter("fullname");
	        System.out.println("username"+full_name);
	        String email = request.getParameter("email");
	        String phone_number = request.getParameter("phone_number");
	        String address = request.getParameter("address");

	        // Set attributes to forward to the JSP
	        request.setAttribute("username", user_name);
	       
	        request.setAttribute("fullname", full_name);
	       
	        request.setAttribute("email", email);
	        System.out.println("username"+email);
	        request.setAttribute("phone_number", phone_number);
	        System.out.println("username"+phone_number);
	        request.setAttribute("address", address);
	        System.out.println("username"+address);

	        // Forward to the JSP for editing
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Updateprofile.jsp");
	        dispatcher.forward(request, response);
	}

}