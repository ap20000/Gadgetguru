<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/header.css" /> 
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>


<body>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<style>



</style>
<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute("username");
    String contextPath = request.getContextPath();
%>
    <nav class="navbar">
        <div class="max-width">
            <div class="logo"><a href="#">Gadget<span>Accessories</span></a></div>
            <ul class="menu">
                <li><a href="#home" class="menu-btn">Home</a></li>
                <li><a href="#about" class="menu-btn">About</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/userproduct.jsp" class="menu-btn">Product</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/Profile.jsp" class="menu-btn">Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/contact.jsp" class="menu-btn">Contact</a></li>
                <li>
                    <div class="search-container">
                        <input type="text" placeholder="Search...">
                        <button type="submit"><i class="fa fa-search"></i></button>
                        <div class="login-wrapper">
                        
		                 	
				                <form action="<%
				                    // Conditionally set the action URL based on user session
				                    if (currentUser != null) {
				                        out.print(contextPath + "/LogoutServlet");
				                    } else {
				                        out.print(contextPath + "/pages/login.jsp");
				                    }
				                %>" method="post">
				                    <input type="submit" value="<%
				                        // Conditionally set the button label based on user session
				                        if (currentUser != null) {
				                            out.print("Logout");
				                        } else {
				                            out.print("Login");
				                        }
				                    %>"/>
				                </form>
				            
                            
                        </div>
                    </div>
                </li>
                
            </ul>            
        </div>    
    </nav>
</body>
</html>
