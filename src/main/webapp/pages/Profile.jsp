<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="controller.database.GadgetDbController" %>

<%@ page import="model.AccessoriesUserModel" %>
<%@ page import = "util.stringUtil" %>
<%@ page import="model.LoginResult" %>
    <%
    // Check if the user is logged in
    // Assuming you have a session attribute named "loggedInUser" that stores the logged-in user's username
    String loggedInUsername = (String) session.getAttribute(stringUtil.user_name);
    if (loggedInUsername == null || loggedInUsername.isEmpty()) {
        // Redirect to login page if not logged in
        response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
        return; // Stop further execution
    }

    // Initialize the database controller
    GadgetDbController dbController = new GadgetDbController();
    
    // Retrieve user profile information from the database based on the logged-in username
    AccessoriesUserModel useraaprofile = dbController.getuserprofile(loggedInUsername);

    // Check if user profile is null
    if (useraaprofile == null) {
        // Handle case where user profile is not found
        // For example, display an error message
        out.println("User profile not found");
        return; // Stop further execution
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/profile.css">
</head>
<body>
<jsp:include page="header.jsp"/> 
    <div class="profile">
        <h2>User Profile</h2>
        <div class="profile-image">
            <img src="path_to_your_image.jpg" alt="Profile Image">
        </div>
        <div class="profile-info">
            <label for="username">Username:</label>
            <p id="username" name="username"> <%= useraaprofile.getUser_Name() %></p>
        </div>
        <div class="profile-info">
            <label for="fullname">Full Name:</label>
            <p id="fullname" name="fullname" > <%= useraaprofile.getFull_Name() %></p>
        </div>
        <div class="profile-info">
            <label for="email">Email:</label>
            <p id="email" name="email" > <%= useraaprofile.getEmail() %></p>
        </div>
        <div class="profile-info">
            <label for="phone_number">Phone Number:</label>
            <p id="phone_number" name="phone_number" > <%= useraaprofile.getPhone_Number() %></p>
        </div>
        <div class="profile-info">
            <label for="location">Location:</label>
            <p id="address" name="address" > <%= useraaprofile.getAddress() %></p>
        </div>
        <div class="profile-info">
            <label for="dob">Date of Birth:</label>
            <p id="dob" name="dob" > <%= useraaprofile.getDob() %></p>
        </div>
        <div class="profile-info">
            <label for="gender">Gender:</label>
            <p id="gender" name="gender" > <%= useraaprofile.getGender() %></p>
        </div>
        <form action="${pageContext.request.contextPath}/ProfileEditServlet" method="post">
                <input type="hidden" id="username" name="username" value="<%= useraaprofile.getUser_Name() %>">
                <input type="hidden" id="fullname" name="fullname" value="<%= useraaprofile.getFull_Name() %>">
                <input type="hidden" id="email" name="email" value="<%= useraaprofile.getEmail() %>">
                <input type="hidden" id="phone_number" name="phone_number" value="<%= useraaprofile.getPhone_Number() %>">
                <input type="hidden" id="address" name="address" value="<%= useraaprofile.getAddress() %>">
	        <div class="update-button">
                    <button type="submit">Update</button>
            </div>
	    </form>
    </div>
  <jsp:include page="footer.jsp"/> 
   </body>
</html>