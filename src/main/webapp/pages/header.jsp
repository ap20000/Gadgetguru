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
/* Navbar styling */
/* Navbar styling */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
}

html {
    scroll-behavior: smooth;
}

.max-width {
    max-width: 1300px;
    padding: 0 80px;
    margin: auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.navbar {
    position: fixed;
    width: 100%;
    z-index: 999;
    padding: 30px 0;
    font-family: 'Ubuntu', sans-serif;
    transition: all 0.3s ease;
    background-color: #B3C8CF;
    top: 0; /* Position the navbar at the top of the page */
}

.navbar.sticky {
    padding: 15px 0;
    background: crimson;
}

.navbar .logo a {
    color: #fcfcfc;
    font-size: 35px;
    font-weight: 600;
    display: flex; /* Added */
    align-items: center; /* Added */
    margin-left: 10px;
    text-decoration: none;
}

.navbar .logo a span {
    color: crimson;
    transition: all 0.3s ease;
}

.navbar.sticky .logo a span {
    color: #fff;
}

.navbar .menu {
    display: flex; /* Added */
    align-items: center; /* Added */
}

.navbar .menu li {
    list-style: none;
    display: inline-block;
    margin-left: 15px;
}

.navbar .menu li a {
    display: block;
    color: #ffffff;
    font-size: 18px;
    font-weight: 500;
    transition: color 0.3s ease;
}

.navbar .menu li a:hover {
    color: crimson;
}

.navbar.sticky .menu li a:hover {
    color: #fff;
}

/* Search bar styling */
.search-container {
    display: flex;
}

.search-container input[type="text"] {
    padding: 8px 15px;
    font-size: 17px;
    border: none;
    border-radius: 5px;
    background-color: #f1f1f1;
    margin-right: 5px;
}

.search-container button {
    padding: 6px 15px;
    font-size: 17px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    background-color: #333;
    color: #fff;
}

.login-wrapper {
    display: flex;
    align-items: center;
    margin-left: 20px;
    color: #333;
    font-size: 14px;
}

.login-wrapper form {
    display: flex;
    align-items: center;
}

.login-wrapper input[type="submit"] {
    padding: 6px 15px;
    font-size: 14px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    background-color: #333;
    color: #fff;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.login-wrapper input[type="submit"]:hover {
    background-color: crimson;
}

.login-wrapper span {
    margin-top: 5px; /* Add margin between icon and text */
}


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
                <li><a href="${pageContext.request.contextPath}/pages/userproduct.jsp" class="menu-btn">Profile</a></li>
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
