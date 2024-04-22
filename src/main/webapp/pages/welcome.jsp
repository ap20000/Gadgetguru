<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="util.stringUtil" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/welcome.css">
</head>
<body>
<jsp:include page="header.jsp"/>
	
	<%
		String userSession = (String) session.getAttribute(stringUtil.user_name);
		String cookieUsername  = null;
		String cookieSessionID = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals(stringUtil.USER)) cookieUsername = cookie.getValue();
				if(cookie.getName().equals(stringUtil.JSESSIONID)) cookieSessionID = cookie.getValue();
			}
		}
	%>
	<div class="welcome-container">
		<h1>Hello <%=userSession %>. Welcome to our page!</h1>
		<p>Session username: <%=userSession %></p>
		<a href="${pageContext.request.contextPath}/index.jsp">
			<button class="home-button">Continue to Home Page</button>
		</a>
	</div>
</body>
</html>
