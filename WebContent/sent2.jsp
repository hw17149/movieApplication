<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	String userName = request.getParameter("username");
	String fname = request.getParameter("first-name");
	String lname = request.getParameter("last-name");
	String email = request.getParameter("mail");
	String password = request.getParameter("psw");
	String location = null;
	String strUserType = request.getParameter("usertype");
	int userType = Integer.parseInt(strUserType);
	boolean confirmation = true;
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
	
	System.out.println(userName);
	System.out.println(fname);
	System.out.println(lname);
	
	ManageUser mu = new ManageUser();
	if(!mu.isValidEmail(email)){ %>
		email already registered.
	<% } else {	
	
	mu.addUser(userName, fname, lname, email, password, location, userType, confirmation, sub, bDate, resetPassword);
	}
	%>
	
	<b>Redirecting to Admin page...</b> <% response.setHeader("Refresh", "3; admin.jsp"); %>
</body>
</html>