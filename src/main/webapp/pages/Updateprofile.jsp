<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/updateprofile.css" />
</head>
<body>
    <div class="profile-form">
        <h2>User Profile Form</h2>
        <form action="${pageContext.request.contextPath}/ProfileUpdateServlet" method="post">
            <div class="form-group">
                <label for="productname">User Name:</label>
                <input type="text" id="username" name="username" value="${username}" readonly>
            </div>
            <div class="form-group">
                <label for="productname">Full Name:</label>
                <input type="text" id="fullname" name="fullname" value="${fullname}" required>
            </div>
            <div class="form-group">
                <label for="price">Email</label>
                <input type="text" id="email" name="email" value="${email}" required>
            </div>
            <div class="form-group">
                <label for="price">Phone Number</label>
                <input type="text" id="phone_number" name="phone_number" value="${phone_number}" required>
            </div>
            <div class="form-group">
                <label for="price">Address</label>
                <input type="text" id="address" name="address" value="${address}" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Update Profile">
            </div>
        </form>
    </div>
</body>
</html>