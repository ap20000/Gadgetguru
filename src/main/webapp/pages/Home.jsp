<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/home.css" />
<body>

 

  





  <main>
    <article>

      <!-- 
        - #HERO
      -->

      <section class="hero" id="home" style="background-image: url('hero.png')">
        <div class="container">

          <div class="hero-content">

            <p class="hero-subtitle">Computer Accessories</p>

            <h2 class="h1 hero-title">Unrivalled Fashion House</h2>

            <button class="btn btn-primary">Shop Now</button>

          </div>

        </div>
      </section>





      <!-- 
        - #SERVICE
      -->

      <section class="service">
        <div class="container">

          <ul class="service-list">

            <li class="service-item">
              <div class="service-item-icon">
                <img src="./assets/images/service-icon-1.svg" alt="Service icon">
              </div>

              <div class="service-content">
                <p class="service-item-title">Free Shipping</p>

                <p class="service-item-text">On All Order Over $599</p>
              </div>
            </li>

            <li class="service-item">
              <div class="service-item-icon">
                <img src="./assets/images/service-icon-2.svg" alt="Service icon">
              </div>

              <div class="service-content">
                <p class="service-item-title">Easy Returns</p>

                <p class="service-item-text">10 Day Returns Policy</p>
              </div>
            </li>

            <li class="service-item">
              <div class="service-item-icon">
                <img src="./assets/images/service-icon-3.svg" alt="Service icon">
              </div>

              <div class="service-content">
                <p class="service-item-title">Secure Payment</p>

                <p class="service-item-text">100% Secure Gaurantee</p>
              </div>
            </li>

           

          </ul>

        </div>
      </section>





     





      <!-- 
        - #PRODUCT
      -->

	<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
	                url="jdbc:mysql://localhost:3306/gadgetguru_accessories" user="root" password="" />
	            <sql:query dataSource="${dataSource}" var="products">
	                SELECT * FROM computer;
	            </sql:query>
	    
      <section class="section product">
  
        <div class="container">

          <h2 class="h2 section-title">Products of the week</h2>

          

	    <c:forEach var="product" items="${products.rows}">
          <ul class="product-list">

            <li>
              <div class="product-card">

                <figure class="card-banner">

                  <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/images/user/${product.product_image}" alt="Varsi Leather Bag" loading="lazy" width="800"
                      height="1034" class="w-100">
                  </a>


                  <!-- <div class="card-actions">

                    <button class="card-action-btn" aria-label="Quick view">
                      <ion-icon name="eye-outline"></ion-icon>
                    </button>

                    <button class="card-action-btn cart-btn">
                      <ion-icon name="bag-handle-outline" aria-hidden="true"></ion-icon>

                      <p>Add to Cart</p>
                    </button>

                    <button class="card-action-btn" aria-label="Add to Whishlist">
                      <ion-icon name="heart-outline"></ion-icon>
                    </button>

                  </div>
 -->
                </figure>

				
	                <div class="card-content">
	                  <h3 class="h4 card-title">
	                    <a href="#">${product.computer_name}</a>
	                  </h3>
	
	                  <div class="card-price">
	                    
	
	                    <data value="65.00">&pound;${product.price}</data>
	                  </div>
	                </div>
                 </c:forEach>

              </div>
            </li>

           

            
              

          <button class="btn btn-outline">View All Products</button>

        </div>
      </section>





      <!-- 
        - #BLOG
      -->

      <section class="section blog">
        <div class="container">

          <h2 class="h2 section-title">Latest computer accessories news</h2>

          <ul class="blog-list">

            <li>
              <div class="blog-card">

                <figure class="card-banner">
                  <a href="#">
                    <img src="4.png" alt="Worthy Cyber Monday Fashion From Casmart" loading="lazy"
                      width="1020" height="700" class="w-100">
                  </a>
                </figure>

                <div class="card-content">

                  <ul class="card-meta-list">

                    <li class="card-meta-item">
                      <ion-icon name="folder-open-outline"></ion-icon>

                      <a href="#" class="card-meta-link">accessories</a>
                    </li>

                    <li class="card-meta-item">
                      <ion-icon name="time-outline"></ion-icon>

                      <a href="#" class="card-meta-link">
                        <time datetime="2021-03-31">31 Mar 2021</time>
                      </a>
                    </li>

                  </ul>

                  <h3 class="h3 card-title">
                    <a href="#"> PC</a>
                  </h3>

                </div>

              </div>
            </li>

            <li>
              <div class="blog-card">

                <figure class="card-banner">
                  <a href="#">
                    <img src="5.png" alt="Holiday Home Decoration I’ve Recently Ordered"
                      loading="lazy" width="1020" height="700" class="w-100">
                  </a>
                </figure>

                <div class="card-content">

                  <ul class="card-meta-list">

                    <li class="card-meta-item">
                      <ion-icon name="folder-open-outline"></ion-icon>

                      <a href="#" class="card-meta-link">accessories</a>
                    </li>

                    <li class="card-meta-item">
                      <ion-icon name="time-outline"></ion-icon>

                      <a href="#" class="card-meta-link">
                        <time datetime="2021-03-31">31 Mar 2021</time>
                      </a>
                    </li>

                  </ul>

                  <h3 class="h3 card-title">
                    <a href="#">Pendrive</a>
                  </h3>

                </div>

              </div>
            </li>

            <li>
              <div class="blog-card">

                <figure class="card-banner">
                  <a href="#">
                    <img src="7.png" alt="Unique Ideas for Fashion You Haven’t heard yet"
                      loading="lazy" width="1020" height="700" class="w-100">
                  </a>
                </figure>

                <div class="card-content">

                  <ul class="card-meta-list">

                    <li class="card-meta-item">
                      <ion-icon name="folder-open-outline"></ion-icon>

                      <a href="#" class="card-meta-link">accessories</a>
                    </li>

                    <li class="card-meta-item">
                      <ion-icon name="time-outline"></ion-icon>

                      <a href="#" class="card-meta-link">
                        <time datetime="2021-03-31">31 Mar 2021</time>
                      </a>
                    </li>

                  </ul>

                  <h3 class="h3 card-title">
                    <a href="#">Mouse</a>
                  </h3>

                </div>

              </div>
            </li>

          </ul>

        </div>
      </section>





      <!-- 
        - #NEWSLETTER
      -->

      
        





  <!-- 
    - custom js link
  -->
  <script src="./assets/js/script.js"></script>

  <!-- 
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>

</html>