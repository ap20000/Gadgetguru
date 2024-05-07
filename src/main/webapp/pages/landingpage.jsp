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

  
    <!-- home content -->
    <section class="home">
        <div class="content">
          <h1> <span>Computer Products</span>
            <br>
            Up To <span id="span2">50%</span> Off
          </h1>
          <p>
            Explore the latest in computing technology with our wide range of computers. 
            <br>Experience the best in performance and design. Discover more today!
          </p>
          <div class="btn"><button>Shop Now</button></div>
    
        </div>
        <div class="img">
          <img src="a.jpg" alt="">
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
 
  </body>
</html>