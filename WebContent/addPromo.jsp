<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*, cinema.user.entity.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adding Promo</title>
</head>
<body>

<%
	SendEmail se = new SendEmail();
	ManageUser mu = new ManageUser();
	List<User> uList = mu.getUsersList();
	String promoCode = request.getParameter("code");
	double discount = Double.parseDouble(request.getParameter("amount"));
	ManagePromotion mp = new ManagePromotion();
	mp.addPromotion(true, discount, promoCode);
	for(User temp : uList){
		if(temp.getSubscribed()){
			se.mailPromo(temp.getFname(), temp.getEmail(), promoCode, discount);
		}
	}
%>
	
	<b>Redirecting to Admin page...</b> <% response.setHeader("Refresh", "0; admin.jsp"); %>
</body>
</html>