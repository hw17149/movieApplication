<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*, cinema.user.entity.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adding Movie</title>
</head>
<body>

<%
	String title = request.getParameter("title");
	String icon = request.getParameter("icon");
	if(icon == ""){
		icon = "empty.jpg";
	}
	String summary = request.getParameter("summary");
	String genre = request.getParameter("genre");
	String len = request.getParameter("length");
	String filmRating = request.getParameter("filmRating");

	int length = 0;
	double rating = 0;
	
	
	ManageMovie mm = new ManageMovie();
	mm.addMovie(title, icon,summary, rating, genre, length, filmRating);
%>
	
	<b>Redirecting to Admin page...</b> <% response.setHeader("Refresh", "0; admin.jsp"); %>
</body>
</html>