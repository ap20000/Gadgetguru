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
		                <form action="<%
		                    // Conditionally set the action URL based on user session
		                    if (currentUser != null) {
		                        out.print(contextPath + "/LogOutServlet");
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
		            </li>
                    <li>
                       <a href="" class="active">
                            <span class="las la-home"></span>
                            <small>Dashboard</small>
                        </a>
                    </li>
                    <li>
                       <a href="">
                            <span class="las la-user-alt"></span>
                            <small>Profile</small>
                        </a>
                    </li>
                    
                    
                    <li>
                       <a href="">
                            <span class="las la-shopping-cart"></span>
                            <small>Product</small>
                        </a>
                    </li>
                    

                </ul>
                
            </div>
            
        </div>
    </div>
    
    <div class="main-content">
        
        <header>
            <div class="header-content">
                <label for="menu-toggle">
                    <span class="las la-bars"></span>
                </label>
                
                <div class="header-menu">
                    
                    
                    <div class="user">
                        <div class="bg-img" style="background-image: url(img/1.jpeg)"></div>
                        
                        <span class="las la-power-off"></span>
                        <td>
                            <span class="">Log Out</span>
                        </td>
                    </div>
                </div>
            </div>
        </header>
        
        
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


                <div class="records table-responsive">

                    <div class="record-header">
                        <div class="add">
                            <span>Entries</span>
                            <select name="" id="">
                                <option value="">ID</option>
                            </select>
                            <button>Add record</button>
                        </div>

                        
                    </div>

                    <div>
                        <table width="100%">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th><span class="las la-sort"></span> Product Name </th>
                                    <th><span class="las la-sort"></span> Price </th>
                                    <th><span class="las la-sort"></span> Brand</th>
                                    <th><span class="las la-sort"></span> Stock Qunatity</th>
                                    <th><span class="las la-sort"></span> ACTIONS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>
                                        <div class="client">
                                           <div class="client-img bg-img" style="background-image: url(img/3.jpeg)"></div>
                                            <div class="client-info">
                                                <h4>Mouse</h4>
                                                <small>Brand</small>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        $3171
                                    </td>
                                    <td>
                                        19 April, 2022
                                    </td>
                                    <td>
                                        -$205
                                    </td>
                                    <td>
                                        <span class="paid">Complete</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>
                                        <div class="client">
                                           <div class="client-img bg-img" style="background-image: url(img/1.jpeg)"></div>
                                            <div class="client-info">
                                                <h4>keyboard</h4>
                                                <small>Brand</small>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        $3171
                                    </td>
                                    <td>
                                        19 April, 2022
                                    </td>
                                    <td>
                                        -$205
                                    </td>
                                    <td>
                                        <span class="Unstatus">Uncomplete</span>
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>
                                        <div class="client">
                                           <div class="client-img bg-img" style="background-image: url(img/1.jpeg)"></div>
                                            <div class="client-info">
                                                <h4>PC</h4>
                                                <small>Brand</small>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        $2171
                                    </td>
                                    <td>
                                        19 April, 2022
                                    </td>
                                    <td>
                                        <span class="paid">Paid</span>
                                    </td>
                                    <td>
                                        <span class="Unstatus">Uncomplete</span>
                                    </td>
                                </tr>
                               
                               
                                
                                
                                
                                
                            </tbody>
                        </table>
                    </div>

                </div>
            
            </div>
            
        </main>
        
    </div>
</body>
</html>