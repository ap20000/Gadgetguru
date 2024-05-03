<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/product.css" />
</head>
<body>

        <div class = "products">
            <div class = "container">
                <h1 class = "lg-title">Computer Accessories</h1>
                <p class = "text-light">Enhance your computing experience with our wide selection of high-quality, reliable computer accessories. From keyboards and mice to monitors and cables, we have everything you need to upgrade your setup. Our accessories are designed to meet the demands of modern computing. Explore our collection today and find the perfect accessories for your computer.</p>

				
                
                <div class = "product-items">
                <c:if test="${empty products}">
                    <tr>
                        <td colspan="5">No products found.</td>
                    </tr>
                </c:if>
                <c:forEach var="product" items="${products}">

				    <div class="product">
				        <div class="product-content">
				            <div class="product-img">
				                <img src="/resources/images/user/${product.imageUrl}" height="100" alt="Product Image">
				            </div>
				            <div class="product-btns">
				                <button type="button" class="btn-cart"> add to cart
				                    <span><i class="fas fa-plus"></i></span>
				                </button>
				                <button type="button" class="btn-buy"> buy now
				                    <span><i class="fas fa-shopping-cart"></i></span>
				                </button>
				            </div>
				        </div>
				
				        <div class="product-info">
				            <div class="product-info-top">
				                <h2 class="product-name">${product.productName}</h2>
				            </div>
				         
				            <p class="product-price">${product.price}</p>
				        </div>
				    </div>
				</c:forEach>
                    
                    <!-- end of single product -->
                </div>
            </div>
        </div>

     
        
    </body>
</html>