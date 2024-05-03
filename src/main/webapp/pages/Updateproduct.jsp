<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
   
</style>
<body>
    <div class="profile-form">
        <h2>User Profile Form</h2>
        <form action="${pageContext.request.contextPath}/UpdateAccessoriesServlet" method="post">
	        <div class="form-group">
	                <label for="computer_Id">Product Name:</label>
	                <input type="text" id="computer_Id" name="computer_Id" value="${computer_Id}" readonly>
	         </div>
            <div class="form-group">
                <label for="productname">Product Name:</label>
                <input type="text" id="computer_Name" name="computer_Name" value="${computer_Name}" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="${price}" required>
            </div>
            
            <div class="form-group">
                <input type="submit" value="Update Profile">
            </div>
        </form>
    </div>
</body>
</html>