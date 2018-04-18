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
	String password = request.getParameter("psw");
	
	
	ManageUser mu = new ManageUser();
	if(mu.isValidEmail(email)){ %>
		email is not already registered on our site, redirecting to registration page
		<% response.setHeader("Refresh", "3; register.jsp"); %>
	<% } else {
	
	
	boolean goodLogin = mu.IsValidLogin(email, password);
	User u = mu.getByEmail(email);
	if(goodLogin){
		u.setResetPassword(true);
		if(mu.isAdmin(u.getUserId())){ %>
			Admin login successful. Redirecting...
		<%
		response.setHeader("Refresh", "3; admin.jsp");
		}else{%>
		<form action="add" method="post">
  			<input type="hidden" name="fname" value="<% u.getFname(); %>"><br>
  		</form>
	  Login successful. Redirecting.....
		<%response.setHeader("Refresh", "3; index2.html");}
	}else{ %>
		Incorrect email/password combination, redirecting to Login page.
	<% response.setHeader("Refresh", "3; login.jsp");
	}
	%>
	
	<% } %>
</body>
</html>