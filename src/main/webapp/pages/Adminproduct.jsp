<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
<%@ page import="util.stringUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/Adminproduct.css">
<link rel="stylesheet" type="text/css"
    href="<%=contextPath%>/stylesheets/header.css" />
<link rel="stylesheet" type="text/css"
    href="<%=contextPath%>/stylesheets/footer.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<style>

 
 
</style>
<body>


<div class="container">
<% String error = (String) request.getAttribute(stringUtil.MESSAGE_ERROR); %>
		        <% if (error != null && !error.isEmpty()) { %>
		           <div style="color: red;"><%= error %></div>
		     	 <% }
	     	%>
	     	
	     	<% String success = (String) request.getAttribute(stringUtil.MESSAGE_SUCCESS); %>
		<% if (success != null && !success.isEmpty()) { %>
   		<div style="color: green;"><%= success %></div>
		<% } %>

    <div class="admin-product-form-container">

        <h3>Add a New Product</h3>
        <form action="${pageContext.request.contextPath}/Addproduct" method="POST" enctype="multipart/form-data">
            <input type="text" placeholder="Enter product name" name="product_name" id="product_name" class="box" required>
            <input type="number" placeholder="Enter product price" name="product_price" id="product_price" class="box" required>
            <input type="file" accept="image/png, image/jpeg, image/jpg" name="product_image" id="product_image" class="box" required>
            <button type="submit" class="btn">Add Product</button>
        </form>

    </div>

    <div class="product-display">
        <table class="product-display-table">
            <thead>
                <tr>
                    <th>Computer Id</th>
                    <th>Computer Image</th>
                    <th>Computer Name</th>
                    <th>Computer Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${empty products}">
                    <tr>
                        <td colspan="5">No products found.</td>
                    </tr>
                </c:if>
                <c:if test="${not empty products}">
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.productId}</td>
                            <td><img src="${pageContext.request.contextPath}/resources/images/user/${product.imageUrl}" height="100" alt="Product Image"></td>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/EditAccessoriesServlet" method="post">
                                        <input type="hidden" id="computer_Id" name="computer_Id" value="${product.productId}">
                                        <input type="hidden" id="computer_Name" name="computer_Name" value="${product.productName}">
                                        <input type="hidden" id="price" name="price" value="${product.price}">
         
                                        <button type="submit" class="btn">Edit</button>
                                    </form>
                                <form action="/GadgetGuru_Accessories/ProductChange" method="post">
                                        <input type="hidden" name="delete_accessories" value="${product.productId}">
                                        <button type="submit" class="btn">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
    <div class="goback-container">
        <a href="${pageContext.request.contextPath}/pages/Dashboard.jsp" class="btn">Go Back</a>
    </div>


</div>


</body>
</html>
