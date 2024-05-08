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
body {
    overflow-x: hidden; /* Prevent vertical scrolling */
}

/* home content */


/* .home {
    width: 100%;
    display: flex;
    align-items: center;
    background-color: #a9a9a92b;
    margin-top: 100px; Add margin-top to move the header down
    height: calc(100vh - 100px); Set height to fill the remaining viewport height
    overflow: hidden; or auto, depending on your content
} */
.home .img {
    flex: 1 1 300px; /* Adjust as needed */
    position: relative;
    overflow: hidden;
}

.home .img img {
    width: 100%;
    height: auto;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
.home .content {
    flex: 1 1 400px;
    margin-top: 200px;
    order: 2; /* Change the order to move the text to the right side */
    text-align: center; /* Center the text */
}

.content h1 {
    color: rgb(67 0 86);
    font-weight: bold;
    margin-left: 0; /* Remove the margin on the left */
    font-size: 55px;
    text-shadow: -1px 1px 1px black;
}

.content h1 span {
    color: rgb(67 0 86);
    text-shadow: 1px 1px 1px black;
}

#span2 {
    color: #cd2900;
}

.content p {
    margin-left: 0; /* Remove the margin on the left */
}

.btn {
	margin-top:100px;
    margin-left: 0; /* Remove the margin on the left */
    text-align: center; /* Center the button */
}

.btn button {
    width: 150px;
    height: 32px;
    letter-spacing: 3px;
    background-color: rgb(67 0 86);
    color: white;
    border-radius: 5px;
    border: none;
    transition: 0.5s ease;
    cursor: pointer;
    padding: 10px 20px; /* Add padding */
    margin-top: 20px; /* Add margin */
}

.btn button:hover {
    background-color: #ff0800;
    color: black;
    border: none;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
}

.products {
    background-color: #fff;
    padding: 20px;
    margin-top: 20px;
}

.product {
    width: 30%; /* Adjust as needed */
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    overflow: hidden;
    background-color: #fff;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.product img {
    width: 100%;
    height: 200px; /* Set a fixed height for the images */
    object-fit: cover; /* Maintain aspect ratio and crop if necessary */
}


.product-info {
    padding: 15px;
}

.product-name {
    font-size: 1.2rem;
    font-weight: bold;
    margin-bottom: 5px;
}

.product-price {
    font-size: 1rem;
    color: #888;
    margin-bottom: 10px;
}

.buy-btn {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #B3C8CF;
    color: #fff;
    text-align: center;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.buy-btn:hover {
    background-color: #ff0d00;
}

.lg-title {
    font-size: 2rem;
    font-weight: bold;
    margin-bottom: 20px;
}

.text-light {
    color: #888;
    font-size: 1rem;
    line-height: 1.5;
}
</style>


  
    <!-- home content -->
    <section class="home">
        <div class="img">
          <img src="${pageContext.request.contextPath}/resources/hero.png" alt="">
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
   <jsp:include page="footer.jsp"/> 
  </body>
</html>