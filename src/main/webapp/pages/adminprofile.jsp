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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/profile.css">
</head>
<body>

    <div class="profile">
        <h2>User Profile</h2>
        <div class="profile-image">
		    <i class="fas fa-user"></i>
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
            <label for="location">Address</label>
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
        <%-- <form action="${pageContext.request.contextPath}/ProfileEditServlet" method="post">
                <input type="hidden" id="username" name="username" value="<%= useraaprofile.getUser_Name() %>">
                <input type="hidden" id="fullname" name="fullname" value="<%= useraaprofile.getFull_Name() %>">
                <input type="hidden" id="email" name="email" value="<%= useraaprofile.getEmail() %>">
                <input type="hidden" id="phone_number" name="phone_number" value="<%= useraaprofile.getPhone_Number() %>">
                <input type="hidden" id="address" name="address" value="<%= useraaprofile.getAddress() %>">
	        <div class="update-button">
                    <button type="submit">Update</button>
            </div>
	    </form> --%>
	    
	    <div class="goback-container">
	        <a href="${pageContext.request.contextPath}/pages/Dashboard.jsp" class="btn">Go Back</a>
	    </div>
    </div>
    <style>
        <style>
     .goback-container {
    position: fixed;
    bottom: 20px;
    left: 20px;
    z-index: 1000; /* Ensure it's above other elements */
}

.goback-container .btn {
    padding: 8px 16px;
    background-color: #B3C8CF;
    color: #fff;
    border: none;
    border-radius: 3px;
    text-decoration: none;
}

.goback-container .btn:hover {
    background-color: #ff0000;
}
    </style>
    </style>

   </body>
</html>