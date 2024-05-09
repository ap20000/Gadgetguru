<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="util.stringUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/Dashboard.css" />
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
 <style>
 














 
 </style>
</head>

<body>

<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute("username");
    String contextPath = request.getContextPath();
%>
   <input type="checkbox" id="menu-toggle">
    <div class="sidebar">
        
        
        <div class="side-content">
            <div class="profile">
                <h4>Abhishek Patel</h4>
                <small>Admin</small>
            </div>

            <div class="side-menu">
                <ul>
                	<li>
                	 <div class="login-wrapper">
		                <form action="<%
		                    // Conditionally set the action URL based on user session
		                    if (currentUser != null) {
		                        out.print(contextPath + "/LogoutServlet");
		                    } else {
		                        out.print(contextPath + "/pages/login.jsp");
		                    }
		                %>" method="post">
		                    <input type="submit" value="<%
		                        // Conditionally set the button label based on user session
		                        if (currentUser != null) {
		                            out.print("Logout");
		                        } else {
		                            out.print("Login");
		                        }
		                    %>"/>
		                </form>
		                </div>
		            </li>
                    <li>
                       <a href="" class="active">
                            <span class="las la-home"></span>
                            <small>Dashboard</small>
                        </a>
                    </li>
                    <li>
                       <a href="${pageContext.request.contextPath}/pages/adminprofile.jsp">
                            <span class="las la-user-alt"></span>
                            <small>Profile</small>
                        </a>
                    </li>
                    
                    
                    <li>
                       <a href="${pageContext.request.contextPath}/pages/adminproduct.jsp">
                            <span class="las la-shopping-cart"></span>
                            <small>Product</small>
                        </a>
                    </li>
                    

                </ul>
                
            </div>
            
        </div>
    </div>
    
    <div class="main-content">
        
        
        
        
        <main>
            
            <div class="page-header">
                <h1>Dashboard</h1>
                <small>Home / Dashboard</small>
            </div>
            
            <div class="page-content">
            
                <div class="analytics">

                    <div class="card">
                        <div class="card-head">
                            <h2>2</h2>
                            <span class="las la-user-friends"></span>
                        </div>
                        <div class="card-progress">
                            <small>User activity this month</small>
                            <div class="card-indicator">
                                <div class="indicator one" style="width: 20%"></div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-head">
                            <h2>2</h2>
                            <span class="las la-eye"></span>
                        </div>
                        <div class="card-progress">
                            <small>Page views</small>
                            <div class="card-indicator">
                                <div class="indicator two" style="width: 80%"></div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-head">
                            <h2>10</h2>
                            <span class="las la-shopping-cart"></span>
                        </div>
                        <div class="card-progress">
                            <small>Total Product</small>
                            <div class="card-indicator">
                                <div class="indicator three" style="width: 65%"></div>
                            </div>
                        </div>
                    </div>

                    

                </div>


                
            
            </div>
            
        </main>
        
    </div>
</body>
</html>