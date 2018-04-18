<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, cinema.user.entity.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String email = request.getParameter("email");
	
	
	ManageUser mu = new ManageUser();
	if(mu.isValidEmail(email)){ %>
		email is not registered on our site, redirecting to registration page
		<% response.setHeader("Refresh", "3; register.jsp"); %>
	<% } else {
	SendEmail sendemail = new SendEmail();
	String newPW = sendemail.sendForgotPassword(email);
	User u = mu.getByEmail(email);
	mu.updatePassword(u.getUserId(), newPW);
	u.setResetPassword(false);
	%>
	<b>New password sent to </b><%= request.getParameter("email")%><b>.</b>
	<% } %>
</body>
</html>