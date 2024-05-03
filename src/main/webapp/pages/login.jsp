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


* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

body {
  margin: 0;
  padding: 0;
  background: #B3C8CF; /* Replace 'background.jpg' with the path to your background image */
  background-size: cover;
  background-position: center;
  font-family: sans-serif;
}

.container {
  position: fixed;
  top: 50%;
  left: 30%;
  transform: translate(-50%, -50%);
  width: 400px; /* Set the desired width of the login card */
  background: rgba(255, 255, 255, 0.8); /* Change the last value (0.8) to adjust transparency */
  border-radius: 7px;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
  padding: 20px; /* Added padding for better spacing */
}

.container .registration {
  display: none;
}

#check:checked ~ .registration {
  display: block;
}

#check:checked ~ .login {
  display: none;
}

#check {
  display: none;
}

.container .form {
  padding: 2rem;
}

.form header {
  font-size: 2rem;
  font-weight: 500;
  text-align: center;
  margin-bottom: 1.5rem;
}

.form input {
  height: 60px;
  width: 100%;
  padding: 0 15px;
  font-size: 17px;
  margin-bottom: 1.3rem;
  border: 1px solid #ddd;
  border-radius: 6px;
  outline: none;
}

.form input:focus {
  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.2);
}

.form a {
  font-size: 16px;
  color: rgb(0, 0, 0);
  text-decoration: none;
}

.form a:hover {
  text-decoration: underline;
}

.form input.button {
  color: #fff;
  background: #007bff; /* Button background color */
  font-size: 1.2rem;
  font-weight: 500;
  letter-spacing: 1px;
  margin-top: 1.7rem;
  cursor: pointer;
  transition: 0.4s;
  border: none; /* Remove default button border */
  padding: 10px 20px; /* Add padding for better button appearance */
  border-radius: 6px; /* Add border radius for rounded corners */
  outline: none; /* Remove default outline */
}

.form input.button:hover {
  background: #0056b3; /* Change button background color on hover */
}


.button {
  color: #fff;
  background-color: #007bff; /* Button background color */
  border: 1px solid #007bff; /* Button border color */
  padding: 0.5rem 1rem; /* Padding around the button text */
  font-size: 1rem; /* Button text font size */
  cursor: pointer; /* Cursor style on hover */
  border-radius: 0.25rem; /* Border radius for rounded corners */
}

.button:hover {
  background-color: #0056b3; /* Button background color on hover */
  border-color: #0056b3; /* Button border color on hover */
}
/* Icon for input fields */
.input-icon {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center; 
}

.input-icon i {
  color: #333;
  margin-right: 10px;
  margin-bottom: 10%;
  left: 20%;
}
.forget {
  display: flex;
  align-items: center;
  justify-content: flex-end; 
  margin: 25px 0 35px 0;
  color: #000; /* Set text color to black */
}





.Wrapper a {
  color: #000; /* Set link color to black */
  text-decoration: none;
}

.Wrapper a:hover {
  text-decoration: underline;
}

button {
  background: #000; /* Set button background color to black */
  color: #fff;
  font-weight: 600;
  border: none;
  padding: 12px 20px;
  cursor: pointer;
  border-radius: 3px;
  font-size: 16px;
  border: 2px solid transparent;
  transition: 0.3s ease;
  display: block;
  margin: 0 auto;
}

button:hover {
  color: #000; /* Set button text color to black on hover */
  background: rgba(0, 0, 0, 0.15);
}

.register {
  text-align: center;
  margin-top: 30px;
  color: #000; /* Set text color to black */
}
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
            <form action="/GadgetGuru_Accessories/LoginServlet" method="POST">
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
			        <p>Don't have an account? <a href="/pages/register.jsp" id="registerLink">Register</a></p>
			    </div>

            </form>
            
        </div>
        
    </div>
</body>
</html>