<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
/* home content */
/* home content */
body {
    overflow-x: hidden; /* Prevent vertical scrolling */
}

/* home content */
.home {
    width: 100%;
    display: flex;
    align-items: center;
    background-color: #a9a9a92b;
    margin-top: 100px; /* Add margin-top to move the header down */
    height: calc(100vh - 100px); /* Set height to fill the remaining viewport height */
    overflow: hidden; /* or auto, depending on your content */
}

.home {
    width: 100%;
    display: flex;
    align-items: center;
    background-color: #a9a9a92b;
    margin-top: 100px; /* Add margin-top to move the header down */
    height: calc(100vh - 100px); /* Set height to fill the remaining viewport height */
    overflow: hidden; /* or auto, depending on your content */
}
.home .img {
    flex: 1 1 300px;
}
.home .img img {
    margin-top: 30px;
    width: 100%;
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
}

.btn button:hover {
    background-color: #ff0800;
    color: black;
    border: none;
}

  
  



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
        <div class="container">
          <div class="heading">
            <span>Our customer love this</span>
            <h1>Our Products</h1>
          </div>
          		<c:if test="${empty products}">
                    <tr>
                        <td colspan="5">No products found.</td>
                    </tr>
                </c:if>
                <c:forEach var="product" items="${products}">
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
		                
		                <div class="button-container">
		                  <button>Add To Cart</button>
		                </div>
		              </div>
		            </div>
		            
		  
		           
		          </div>
		   
		        </c:forEach>
		        </div>
      </section>
 
  </body>
</html>