<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/landingpage.css" />
</head>
<body class="hold-transition sidebar-mini layout-fixed"> 
<jsp:include page="header.jsp"/>
  
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
        <div class="container">
          <div class="heading">
            <span>Our customer love this</span>
            <h1>Our Products</h1>
          </div>
          <div class="row">
            <!-- 1st product -->
            <div class="col">
              <div class="imgContainer">
                <img src="a.jpg" alt="image" />
              </div>
              <div class="title">
                <h2>Pizza</h2>
                <p>$120.00</p>
              </div>
              <div class="para">
                <p>
                  Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nemo,
                  laudantium.
                </p>
              </div>
              <div class="footer">
                <div class="star-container">
                  <ul>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                  </ul>
                </div>
                <div class="button-container">
                  <button>Add To Cart</button>
                </div>
              </div>
            </div>
  
            <!-- 2nd product -->
            <div class="col">
              <div class="imgContainer">
                <img src="./images/burger.png" alt="image" />
              </div>
              <div class="title">
                <h2>Burger</h2>
                <p>$20.00</p>
              </div>
              <div class="para">
                <p>
                  Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nemo,
                  laudantium.
                </p>
              </div>
              <div class="footer">
                <div class="star-container">
                  <ul>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                  </ul>
                </div>
                <div class="button-container">
                  <button>Add To Cart</button>
                </div>
              </div>
            </div>
  
            <!-- 3rd product -->
            <div class="col">
              <div class="imgContainer">
                <img src="./images/potpie.png" alt="image" />
              </div>
              <div class="title">
                <h2>Pot Pie</h2>
                <p>$19.23</p>
              </div>
              <div class="para">
                <p>
                  Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nemo,
                  laudantium.
                </p>
              </div>
              <div class="footer">
                <div class="star-container">
                  <ul>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                  </ul>
                </div>
                <div class="button-container">
                  <button>Add To Cart</button>
                </div>
              </div>
            </div>
  
            <!-- 4th product -->
            <div class="col">
              <div class="imgContainer">
                <img src="./images/chicken-bucket.png" alt="image" />
              </div>
              <div class="title">
                <h2>Chicken Bucket</h2>
                <p>$28.78</p>
              </div>
              <div class="para">
                <p>
                  Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nemo,
                  laudantium.
                </p>
              </div>
              <div class="footer">
                <div class="star-container">
                  <ul>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star checked"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                    <li>
                      <i class="fa fa-star"></i>
                    </li>
                  </ul>
                </div>
                <div class="button-container">
                  <button>Add To Cart</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
 
  </body>
</html>