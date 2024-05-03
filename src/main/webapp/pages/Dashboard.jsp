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
 

:root {
    --main-color: #da2f20;
    --color-dark: #BED7DC;
    --text-grey: #B0B0B0;
}

* {
    margin: 0;
    padding: 0;
    text-decoration: none;
    list-style-type: none;
    box-sizing: border-box;
    font-family: 'Merriweather', sans-serif;
}

#menu-toggle {
    display: none;
}

.sidebar {
    position: fixed;
    height: 100%;
    width: 165px;
    left: 0;
    bottom: 0;
    top: 0;
    z-index: 100;
    background: var(--color-dark);
    transition: left 300ms;
}





.side-content {
    background: #1C4E80;
    height: 100%;
    overflow: auto;
}

/* width */
.side-content::-webkit-scrollbar {
  width: 5px;
}

/* Track */
.side-content::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px rgb(128, 128, 128); 
  border-radius: 10px;
}
 
/* Handle */
.side-content::-webkit-scrollbar-thumb {
  background: #b0b0b0; 
  border-radius: 10px;
}

/* Handle on hover */
.side-content::-webkit-scrollbar-thumb:hover {
  background: #b30000; 
}

.profile {
    text-align: center;
    padding: 2rem 0rem;
}

.bg-img {
    background-repeat: no-repeat;
    background-size: cover;
    border-radius: 50%;
    background-size: cover;
}


/* Add this to the end of Dashboard.css or header.css */

.login-wrapper {
    position: absolute;
    bottom: 0;
    display: flex;
    align-items: center;
    margin-left: 20px;
    color: #333;
    font-size: 14px;
}font-size: 14px;
}

.login-wrapper form {
    display: flex;
    align-items: center;
}

.login-wrapper input[type="submit"] {
    padding: 6px 15px;
    font-size: 14px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    background-color: #333;
    color: #fff;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.login-wrapper input[type="submit"]:hover {
    background-color: crimson;
}

.login-wrapper span {
    margin-top: 5px; /* Add margin between icon and text */
}



.side-menu ul {
    text-align: center;
}

.side-menu a {
    display: block;
    padding: 1.2rem 0rem;
}

.side-menu a.active {
    background: #B3C8CF;
}

.side-menu a.active span, .side-menu a.active small {
    color: #fff;
}

.side-menu a span {
    display: block;
    text-align: center;
    font-size: 1.7rem;
}

.side-menu a span, .side-menu a small {
    color: #899DC1;
}

#menu-toggle:checked ~ .sidebar {
    width: 60px;
}

#menu-toggle:checked ~ .sidebar .side-header span {
    display: none;
}

#menu-toggle:checked ~ .main-content {
    margin-left: 60px;
    width: calc(100% - 60px);
}

#menu-toggle:checked ~ .main-content header {
    left: 60px;
}

#menu-toggle:checked ~ .sidebar .profile,
#menu-toggle:checked ~ .sidebar .side-menu a small {
    display: none;
}

#menu-toggle:checked ~ .sidebar .side-menu a span {
    font-size: 1.3rem;
}


.main-content {
    margin-left: 165px;
    width: calc(100% - 165px);
    transition: margin-left 300ms;
}

header {
    position: fixed;
    right: 0;
    top: 0;
    left: 165px;
    z-index: 100;
    height: 60px;
    box-shadow: 0px 5px 5px -5px rgb(0 0 0 /10%);
    background: #fff;
    transition: left 300ms;
}

.header-content, .header-menu {
    display: flex;
    align-items: center;
}

.header-content {
    justify-content: space-between;
    padding: 0rem 1rem;
}

.header-content label:first-child span {
    font-size: 1.3rem;
}

.header-content label {
    cursor: pointer;
}

.header-menu {
    justify-content: flex-end;
    padding-top: .5rem;
}

.header-menu label,
.header-menu .notify-icon {
    margin-right: 2rem;
    position: relative;
}

.header-menu label span,
.notify-icon span:first-child {
    font-size: 1.3rem;
}



.user {
    display: flex;
    align-items: center;
}

.user div, .client-img {
    height: 40px;
    width: 40px;
    margin-right: 1rem;
}

.user span:last-child {
    display: inline-block;
    margin-left: .3rem;
    font-size: .8rem;
}

main {
    margin-top: 60px;
}

.page-header {
    padding: 1.3rem 1rem;
    color: #666;
    border-bottom: 1px solid #dee2e8;
    
}

.page-header h1, .page-header small {
    color: #5b5d61;
}

.page-content {
    padding: 2rem 4rem;
    background: #ffffff;
}

.analytics {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-gap: 2rem;
    margin-top: .5rem;
    margin-bottom: 2rem;
}

.card {
    box-shadow: 0px 5px 5px -5px rgb(0 0 0 / 10%);
    background: #B3C8CF;
    padding: 1rem 6rem;
    
    border-radius: 5px;
}

.card-head {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.card-head h2 {
    color: #000000;
    font-size: 1.8rem;
    font-weight: 500;
}

.card-head span {
    font-size: 3.2rem;
    color: var(--text-grey);
}

.card-progress small {
    color: #777;
    font-size: .8rem;
    font-weight: 600;
}

.card-indicator {
    margin: .7rem 0rem;
    height: 10px;
    border-radius: 4px;
    background: #e9edf2;
    overflow: hidden;
}

.indicator {
    height: 10px;
    border-radius: 4px;
}

.indicator.one {
    background: #e37e0b;
}

.indicator.two {
    background: #066678;
}

.indicator.three {
    background: #a44f04d7;
}



.records {
    box-shadow: 0px 5px 5px -5px rgb(0 0 0 / 10%);
    background: #fff;
    border-radius: 3px;
}

.record-header {
    padding: 1rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
    
}

.add {
    display: flex;
    align-items: center;
}

.add span {
    display: inline-block;
    margin-right: .6rem;
    font-size: .9rem;
    color: #555;
}



.add select {
    height: 35px;
    border: 1px solid #b0b0b0;
    border-radius: 3px;
    display: inline-block;
    width: 75px;
    padding: 0rem .5rem;
    margin-right: .8rem;
    color: #666;
}

.add button {
    background: var(--main-color);
    color: #fff;
    height: 37px;
    border-radius: 4px;
    padding: 0rem 1rem;
    border: none;
    font-weight: 600;
}


.table-responsive {
    width: 100%;
    overflow: auto;
}

table {
    border-collapse: collapse;
}

table thead tr {
    background: #e9edf2;
}

table thead th {
    padding: 1rem 0rem;
    text-align: left;
    color: #444;
    font-size: .9rem;
}

table thead th:first-child {
    padding-left: 1rem;
}

table tbody td {
    padding: 1rem 0rem;
    color: #444;
}

table tbody td:first-child {
    padding-left: 1rem;
    color: var(--main-color);
    font-weight: 600;
    font-size: .9rem;
}

table tbody tr {
    border-bottom: 1px solid #dee2e8;
}

.client {
    display: flex;
    align-items: center;
}

.client-img {
    margin-right: .5rem;
    border: 2px solid #b0b0b0;
    height: 45px;
    width: 45px;
}

.client-info h4 {
    color: #555;
    font-size: .95rem;
}

.status h4{
    color: var(--main-color);
    font-size: .95rem;
}

.client-info small {
    color: #777;
}

.actions span {
    display: inline-block;
    font-size: 1.5rem;
    margin-right: .5rem;
}

.paid {
    display: inline-block;
    text-align: center;
    font-weight: 600;
    color: var(--main-color);
    background: #e5f8ed;
    padding: .5rem 1rem;
    border-radius: 20px;
    font-size: .8rem;
}
.Unstatus {
    display: inline-block;
    text-align: center;
    font-weight: 600;

    padding: .5rem 1rem;
    border-radius: 20px;
    font-size: .8rem;
}












 
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
                       <a href="">
                            <span class="las la-user-alt"></span>
                            <small>Profile</small>
                        </a>
                    </li>
                    
                    
                    <li>
                       <a href="${pageContext.request.contextPath}/pages/Adminproduct.jsp">
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