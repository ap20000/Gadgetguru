<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="util.stringUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/forggetPassword.css" />
</head>
<body>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Forget</header>
      <form action="/GadgetGuru_Accessories/ForgetPassword" method="POST" >
        <div class="input-icon">
          <i class="fas fa-user"></i>
          <input type="text" id="username" name="<%=stringUtil.user_name %>" placeholder="Enter your username">
        </div>
        <div class="input-icon">
          <i class="fas fa-lock"></i>
          <input type="password" id="confirmpassword" name="<%=stringUtil.confirm_password %>" placeholder="Enter your new password">
        </div>
        <div class="input-icon">
          <i class="fas fa-lock"></i>
          <input type="password" id="confirmnewpassword" name="<%=stringUtil.confirm_new_password %>" placeholder="Enter confirm password">
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  </div>
</body>
</html>