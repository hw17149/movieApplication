<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User registeration happening</title>
</head>
<body>
<%
	String userName = null;
	String fname = request.getParameter("first-name");
	String lname = request.getParameter("last-name");
	String email = request.getParameter("email");
	String password = request.getParameter("psw");
	String location = null;
	int userType = 1;
	boolean confirmation = false;
	boolean sub;
	String subscribed = request.getParameter("subscribe");
	if(subscribed.equals("true")){
		sub = true;
	}else{
		sub = false;
	}
	String year = request.getParameter("birthyear");
	String month = request.getParameter("birthmonth");
	String day = request.getParameter("birthday");
	String bDate = year + "-" + month + "-" + day;
	boolean resetPassword = false;
	
	ManageUser mu = new ManageUser();
	if(!mu.isValidEmail(email)){ %>
	<script>alert("email already registered!");
	</script>
		<% response.setHeader("Refresh", "0; register.jsp"); %>
	<% } else {
	
	final String un = "cinema4050@gmail.com";
	final String pw = "movie4050";
	SendEmail sendemail = new SendEmail();
	Properties props = sendemail.makeProps();
	sendemail.registerConfirmation(props, un, pw, email);
	
	mu.addUser(userName, fname, lname, email, password, location, userType, confirmation, sub, bDate, resetPassword, false);
%>
	<script>alert("Confirmation sent! Please verify the email!");
	</script>
	<b>Redirecting to home page</b> <% response.setHeader("Refresh", "0; index.jsp");} %>
</body>
</html>