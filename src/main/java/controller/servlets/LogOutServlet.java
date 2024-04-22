package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.stringUtil;



/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet( urlPatterns = "/LogoutServlet", asyncSupported = true)
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handle logout request (assuming this is a logout servlet)

		
		// 2. Invalidate user session (if it exists)
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// 3. Redirect to login page
		response.sendRedirect(request.getContextPath() + "/pages/welcome.jsp");
	}

}
