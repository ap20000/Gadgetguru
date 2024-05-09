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
<style>


</style>
<jsp:include page="header.jsp"/> 
  <main>
    <article>

      <section class="home" id="home"style="background-image: url('${pageContext.request.contextPath}/resources/home.png')">
        <div class="max-width">
            <div class="home-content">
                <div class="text-1">Welcome to,</div>
                <div class="text-2">Computer</div>
                <div class="text-3">Accessories</div>
                
                <a href="https://t.me/abhi_0214">Hire me</a>
                
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
	<%-- 	                    <p class="product-title">Product Title: ${product.product_title}</p> --%>
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
<footer>
<jsp:include page="footer.jsp"/> 
</footer>


</body>
</html>
