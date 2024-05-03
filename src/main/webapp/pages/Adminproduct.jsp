<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
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
body {
    font-family: Arial, sans-serif;
    background-color: #B3C8CF;
    margin: 0;
    padding: 0;
 }
 
 .container {
    max-width: 800px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
 }
 
 .admin-product-form-container {
    margin-bottom: 20px;
 }
 
 .admin-product-form-container h3 {
    margin-bottom: 10px;
    font-size: 1.2rem;
 }
 
 .box {
    width: 100%;
    margin-bottom: 10px;
    padding: 8px;
    border: 1px solid #ff0000;
    border-radius: 3px;
 }
 
 .btn {
    padding: 8px 16px;
    background-color: #B3C8CF;
    color: #fff;
    margin:10px;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    text-decoration: none;
 }
 
 .btn:hover {
    background-color: #ff0000;
 }
 
 .product-display-table {
    width: 100%;
    border-collapse: collapse;
 }
 
 .product-display-table th,
 .product-display-table td {
    padding: 8px;
    border-bottom: 1px solid #ccc;
 }
 
 .product-display-table th {
    text-align: left;
 }
 
 .product-display-table img {
    max-width: 100px;
    height: auto;
 }
 
 .message {
    display: block;
    padding: 8px;
    margin-bottom: 10px;
    color: #333;
    background-color: #f9f9f9;
    border: 1px solid #ccc;
    border-radius: 3px;
 }
 
</style>
<body>


<div class="container">

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
                                        <input type="hidden" name="delete_id" value="${product.productId}">
                                        <button type="submit" class="btn">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
