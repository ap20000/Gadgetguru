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
<body>
<jsp:include page="header.jsp"/>

<div class="container">

    <div class="admin-product-form-container">

        <h3>Add a New Product</h3>
        <form action="${pageContext.request.contextPath}/Addproduct" method="POST" enctype="multipart/form-data">
            <input type="text" placeholder="Enter product name" name="product_name" id="product_name" class="box">
            <input type="number" placeholder="Enter product price" name="product_price" id="product_price" class="box">
            <input type="file" accept="image/png, image/jpeg, image/jpg" name="product_image" id="product_image" class="box">
            <button type="submit" class="button">Add Product</button>
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
                            <td><img src="resources/images/user/${product.imageUrl}" height="100" alt="Product Image"></td>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <td>
                                <a href="#" class="btn"><i class="fas fa-edit"></i> Edit</a>
                                <a href="#" class="btn"><i class="fas fa-trash"></i> Delete</a>
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
