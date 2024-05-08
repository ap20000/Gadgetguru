<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/product.css" />
<style>



}
</style>
</head>
<body>
<jsp:include page="header.jsp"/> 
    <div class="products">
        
            <h1 class="lg-title">Computer Accessories</h1>
            <p class="text-light">Enhance your computing experience with our wide selection of high-quality, reliable computer accessories. From keyboards and mice to monitors and cables, we have everything you need to upgrade your setup. Our accessories are designed to meet the demands of modern computing. Explore our collection today and find the perfect accessories for your computer.</p>

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
        </div>
    </div>
  <jsp:include page="footer.jsp"/> 
</body>
</html>
