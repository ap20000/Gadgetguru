<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/home.css" /> 
</head>
<body>
<jsp:include page="header.jsp"/> 
  <main>
    <article>

      <section class="hero" id="home" style="background-image: url('${pageContext.request.contextPath}/resources/home.png')">
        <div class="container">
          <div class="hero-content">
            <p class="hero-subtitle">Computer Accessories</p>
            <h2 class="h1 hero-title">Unrivalled Fashion House</h2>
            <button class="btn btn-primary">Shop Now</button>
          </div>
        </div>
      </section>
      
      <sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/gadgetguru_accessories" user="root" password="" />
      <sql:query dataSource="${dataSource}" var="products">
        SELECT * FROM computer;
      </sql:query>
      
      <section>
		    <h1>Latest Products</h1>
		    <div class="container-a">
		    
		        <c:forEach var="product" items="${products.rows}">
		            <div class="product">
		                <img src="${pageContext.request.contextPath}/resources/images/user/${product.product_image}" alt="Product Image">
		                <div class="product-info">
		                    <h2 class="product-name">${product.computer_name}</h2>
		                    <p class="product-title">Product Title: ${product.product_title}</p>
		                    <p class="product-price">${product.price}</p>
		                    <a href="#" class="buy-btn">Buy Now</a>
		                </div>
		            </div>
		        </c:forEach>
		    </div>
	</section>

      
      

    </article>
  </main>

  <script src="./assets/js/script.js"></script>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  <jsp:include page="footer.jsp"/> 
</body>
</html>
