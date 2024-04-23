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
                <li><a href="#services" class="menu-btn">Product</a></li>
                <li><a href="#skills" class="menu-btn">Profile</a></li>
                <li><a href="#contact" class="menu-btn">Contact</a></li>
                <li>
                    <div class="search-container">
                        <input type="text" placeholder="Search...">
                        <button type="submit"><i class="fa fa-search"></i></button>
                        <div class="login-wrapper">
                            <a href="/pages/login.jsp" class="login-btn"><i class="fas fa-user"></i></a>
                            <span>Login</span>
                        </div>
                    </div>
                </li>
                <li>
                <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + "/LogOutServlet");
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
            </li>
                
            </ul>            
        </div>    
    </nav>
</body>
</html>
