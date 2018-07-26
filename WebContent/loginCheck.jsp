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
	if(mu.getByEmail(email).getBanStatus()){
		%> <script>alert("YOU ARE BANNED")</script><%
	response.setHeader("Refresh", "0; index.jsp");
	}else if(email == ""){ %>
	<script>alert("Enter Email!")
</script>
	<% response.setHeader("Refresh", "0; login.jsp"); %>
<% }else if(mu.isValidEmail(email)){ %>
		<script>alert("Email is not valid! Register if you dont have an account!");
	</script>
		<% response.setHeader("Refresh", "0; login.jsp"); %>
	<% }else if(!mu.isConfirmed(email)){ %>
		<script>alert("Email is not confirmed! Confirm email through email registered!");
		</script>
		<% response.setHeader("Refresh", "0; login.jsp");
	}else {
	
	
	boolean goodLogin = mu.IsValidLogin(email, password);
	boolean goodLogin2 = mu.isConfirmed(email);
	User u = mu.getByEmail(email);
	if(goodLogin && goodLogin2){
		int id = u.getUserId();
		session.setAttribute("currentID", id);
		u.setResetPassword(true);
		if(mu.isEmp(u.getUserId())){ %>
			Employee login successful. Redirecting...
			<%
			response.setHeader("Refresh", "1; employee.jsp");
		}else if(mu.isAdmin(u.getUserId())){ %>
			Admin login successful. Redirecting...
		<%
		response.setHeader("Refresh", "1; admin.jsp");
		}else{%>
		<form action="add" method="post">
  			<input type="hidden" name="fname" value="<% u.getFname(); %>"><br>
  		</form>
		<%response.setHeader("Refresh", "0; index2.jsp");}
	}else{ %>
		<script>alert("Incorrect email/password combination!");
		</script>
	<% response.setHeader("Refresh", "0; login.jsp");
	}
	%>
	
	<% } %>
</body>
</html>