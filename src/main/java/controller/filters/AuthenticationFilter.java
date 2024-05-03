package controller.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.GadgetDbController;
import model.ProductModeldata;
import util.stringUtil;
@WebFilter(urlPatterns = {"/pages/Dashboard.jsp", "/pages/Adminproduct.jsp"})
public class AuthenticationFilter implements Filter {
	private GadgetDbController dbController;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	this.dbController = new GadgetDbController();
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

    	HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
        String username = session != null ? (String) session.getAttribute(stringUtil.user_name) : null;
        String userRole = session != null ? (String) session.getAttribute(stringUtil.role) : null;

        System.out.println("Username: " + username); // Add logging
        System.out.println("Role: " + userRole); // Add logging

        // Check if the user is logged in and has the admin role
        if (isLoggedIn && "admin".equals(userRole)) {
            // User is authenticated and is an admin, allow access to admin panel
        	if (httpRequest.getRequestURI().endsWith("/pages/Adminproduct.jsp")) {
                // Fetch all helmets from the database
        		ArrayList<ProductModeldata> prods = dbController.getAllProducts();
        		request.setAttribute("products", prods);
            }
            chain.doFilter(request, response);
        } else {
            // User is not authenticated as admin, redirect to login page
            System.out.println("Admin access denied!"); // Add logging
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/pages/login.jsp");
        }
    }
    


    @Override
    public void destroy() {
    }
}
