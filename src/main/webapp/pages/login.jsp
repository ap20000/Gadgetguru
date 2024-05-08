<%@ page import="util.stringUtil" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/login.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<style>
/* Import Google font - Poppins */



</style>
</head>
<body>
    <div class="container">
        <input type="checkbox" id="check">
        <div class="login form">
            <header>Signup</header>
            <% String error = (String) request.getAttribute(stringUtil.MESSAGE_ERROR); %>
		        <% if (error != null && !error.isEmpty()) { %>
		           <div style="color: red;"><%= error %></div>
		     	 <% }
	     	%>
            <form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
                <div class="input-icon">
                    <i class="fas fa-user"></i>
                    <input type="text" id="username" name="username" placeholder="Enter your email">
                </div>
                <div class="input-icon">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="password" name="password" placeholder="Enter your password">
                </div>
                
                <div class="forget">
			        <button type="submit" id="loginButton">Log In</button>
			        <a href="${pageContext.request.contextPath}/pages/forgetPassword.jsp">Forget password?</a>
			      </div>
			      
			      
			      <div class="register">
			        <p>Don't have an account? <a href="${pageContext.request.contextPath}/pages/register.jsp" id="registerLink">Register</a></p>
			    </div>

            </form>
            
        </div>
        
    </div>
</body>
</html>