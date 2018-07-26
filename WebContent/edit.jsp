<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*, cinema.user.entity.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit profile</title>
</head>
<body>
<%
	ManageUser mu = new ManageUser();
	List<User> uList = mu.getUsersList();
	User thisUser = new User();
	int currentId = (Integer) request.getSession().getAttribute("currentID");
	for(User tempUser : uList) {
		if(tempUser.getUserId() == currentId){
			thisUser = tempUser;
			break;
		}
	}
	String userName = request.getParameter("P_username");
	String fname = request.getParameter("P_fname");
	String lname = request.getParameter("P_lname");
	String email = request.getParameter("P_email");
	String password = request.getParameter("P_psw");
	String location = request.getParameter("P_location");
	boolean sub;
	String subscribed = request.getParameter("P_subscribe");
	if(subscribed.equals("true")){
		sub = true;
	}else{
		sub = false;
	}
	String year = request.getParameter("P_year"), y = "0000";
	String month = request.getParameter("P_month"), m = "00";
	String day = request.getParameter("P_day"), d = "00";
	String birthdate = thisUser.getBdate();
	if(birthdate.length() == 10){
  		y = birthdate.substring(0,4);
  		m = birthdate.substring(5,7);
  		d = birthdate.substring(8,10);
  	}
	if(year.equals("%00")){ year = y; }
	if(month.equals("%00")){ month = m; }
	if(day.equals("%00")){ day = d; }
	String bDate = year + "-" + month + "-" + day;
	
	System.out.println("pROFILE");
	if(userName != "")
		mu.updateUserName(currentId, userName);
	if(fname != "")
		mu.updateFname(currentId, fname);
	if(lname != "")
		mu.updateLname(currentId, lname);
	if(email != ""){
		if(mu.isValidEmail(email)){
			mu.updateEmail(currentId, email);
		}else{ %>
		<script>alert("Duplicate Email: try to use other email.");</script>
		<% 	}
	}
	if(password != "")
		mu.updatePassword(currentId, password);
	if(location != "")
		mu.updateLocation(currentId, location);
	mu.updateSubscribed(currentId, sub);
	mu.updatebDate(currentId, bDate);

	%>
	<b>Redirecting to profile page...</b> <% response.setHeader("Refresh", "0; profile.jsp"); %>
</body>
</html>