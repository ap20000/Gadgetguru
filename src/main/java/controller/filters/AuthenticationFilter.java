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
@WebFilter(urlPatterns = {"/pages/Dashboard.jsp", "/pages/adminproduct.jsp"})
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

        boolean LogIn = session != null && session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");

        String accessories_role = session != null ? (String) session.getAttribute(stringUtil.role) : null;

        
   

     
        if (LogIn && "admin".equals(accessories_role)) {
           
        	if (httpRequest.getRequestURI().endsWith("/pages/Adminproduct.jsp")) {
               
        		ArrayList<ProductModeldata> prods = dbController.getAllAccessories();
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
