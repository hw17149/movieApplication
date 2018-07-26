<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	ManageUser mu = new ManageUser();
	String id = request.getParameter("uid");
	int userid = Integer.parseInt(id);
	mu.updateBanStatus(userid, !mu.getUser(userid).getBanStatus());
	%>
	
	<b>Redirecting to Admin page...</b> <% response.setHeader("Refresh", "0; admin.jsp"); %>
</body>
</html>