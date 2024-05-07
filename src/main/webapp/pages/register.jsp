<%@ page import="util.stringUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/register.css" />
</head>
<body>
    <div class="container">
    <% String error = (String) request.getAttribute(stringUtil.MESSAGE_ERROR); %>
		        <% if (error != null && !error.isEmpty()) { %>
		           <div style="color: red;"><%= error %></div>
		     	 <% }
	     	%>
        <header>Registration Form</header>
        <form action="/GadgetGuru_Accessories/RegisterServlet" method="POST" enctype="multipart/form-data">
            <div class="input-box">
                <label for="username">User Name</label>
                <input id="username" name="<%=stringUtil.user_name %>" type="text" placeholder="Enter user name" required />
            </div>
            <div class="input-box">
                <label for="fullName">Full Name</label>
                <input id="fullName" name="<%=stringUtil.full_name %>" type="text" placeholder="Enter full name" required />
            </div>
            <div class="input-box">
                <label for="email">Email Address</label>
                <input id="email" name="<%=stringUtil.email %>"type="email" placeholder="Enter email address" required />
            </div>
            <div class="column">
                <div class="input-box">
                    <label for="phoneNumber">Phone Number</label>
                    <input id="phoneNumber" name="<%=stringUtil.phone_number %>" type="tel" placeholder="Enter phone number" required />
                </div>
                <div class="input-box">
                    <label for="birthdate">Birth Date</label>
                    <input id="birthdate" name="<%=stringUtil.dobString %>" type="date" placeholder="Enter birth date" required />
                </div>
            </div>
            <div class="input-box">
                <label for="address">Address</label>
                <input id="address" name="<%=stringUtil.address %>" type="text" placeholder="Enter address" required />
            </div>
            <div class="column">
                <div class="input-box">
                    <label for="password">Password</label>
                    <input id="password" name="<%=stringUtil.password %>" type="password" placeholder="Enter password" required />
                </div>
                <div class="input-box">
                    <label for="confirmPassword">Confirm Password</label>
                    <input id="confirmPassword" name="<%=stringUtil.confirm_password %>" type="password" placeholder="Enter confirm password" required />
                </div>
            </div>
            <div class="input-box">
                <label for="gender">Gender</label>
                <select id="gender" name="<%=stringUtil.gender %>" required>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </div>
            <div class="form-row">
                <div class="col">
                  <label for="user_image">User Image:</label>
                  <input type="file" id="user_image" name="user_image" accept="image/png, image/jpeg, image/jpg" class="custom-file-input" required>
                </div>
              </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
