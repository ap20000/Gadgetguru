//package controller.filters;
//
//import java.io.IOException;
//
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//
//import util.stringUtil;
//@WebFilter(urlPatterns = {"/pages/profile.jsp", "/pages/contact.jsp","/pages/home.jsp"})
//public class UserPageFilter implements Filter {
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    	
//    }
//
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//    	HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession session = httpRequest.getSession(false);
//
//        boolean LogIn = session != null && session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
//        String username = session != null ? (String) session.getAttribute(stringUtil.user_name) : null;
//
//        
//        // Check if the user is logged in 
//        if (LogIn) {
//            // User is authenticated allow access to pages
//            chain.doFilter(request, response);
//        } else {
//            // User is not authenticated, redirect to login page
//            System.out.println("Access denied!"); // Add logging
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/pages/login.jsp");
//        }
//    }
//    
//
//
//    @Override
//    public void destroy() {
//    }
//}
