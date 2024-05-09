<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/landingpage.css" />
</head>
<body class="hold-transition sidebar-mini layout-fixed"> 
<jsp:include page="header.jsp"/> 
<style>


</style>
<section class="home" id="home">
    <div class="max-width">
        <div class="home-content">
            <!-- Content for the home section -->
        </div>
    </div>
</section>

<section>
    <sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/gadgetguru_accessories" user="root" password="" />
    <sql:query dataSource="${dataSource}" var="products">
        SELECT * FROM computer;
    </sql:query>

    <div class="container">
        <c:forEach var="product" items="${products.rows}">
            <div class="product">
                <img src="${pageContext.request.contextPath}/resources/images/user/${product.product_image}" alt="Product Image">
                <div class="product-info">
                    <h2 class="product-name">${product.computer_name}</h2>
                    <p class="product-price">${product.price}</p>
                    <a href="#" class="buy-btn">Buy Now</a>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<footer>
<jsp:include page="footer.jsp"/> 
</footer>


</body>
</html>
