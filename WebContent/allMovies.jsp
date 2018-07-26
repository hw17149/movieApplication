<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*, cinema.user.entity.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
 
li{
	z-index: 2;
}
</style>
<head>
<%
		  	ManageUser mu = new ManageUser();
		  	List<User> uList = mu.getUsersList();
		  	User thisUser = new User();
		  	for(User tempUser : uList) {
			%>
			<%
				if(tempUser.getUserId() == request.getSession().getAttribute("currentID")){
					thisUser = tempUser;
					break;
				}
		  	}
			%>
  
</style>
<!--  Styles  -->
  <link rel="stylesheet" href="styles/index.processed.css">
  <link rel="stylesheet" href="styles/basic.css">

	<% 
	ManageMovie mm = new ManageMovie();
	List<Movie> mList = mm.getMoviesList();
	
	%>
	
	<title>All Movies</title>
	
</head>

<body>
<div class="modal">
	  <ul>
	  <%if(request.getSession().getAttribute("currentID") != null){ %>
		<!-- menu -->
	<ul id="nav" style="margin-left:15%;">
	  <li><a href="index2.jsp">Home</a></li>
	  <li><a href="allMovies.jsp">Current Showings</a></li>
	  <li><a href="contacts.jsp">Contacts</a></li>
	  <li style="float:right"><a href="logout.jsp">Logout</a></li>
	  <li style="float:right"><a class="hsubs">My Account</a>
	  	<ul class="subs" style="margin-left: 970px;">
	  		<li><a></a></li>
	  		<li><a href="profile.jsp" style="border: 1px solid white;">profile</a></li>
	  		<li><a href="history.jsp">History</a></li>
	  	</ul>
	  </li>
	  <div id="lavalamp"></div>	  
	</ul>
	 <!-- Home Logo Image Button -->
	<form action="index.jsp" method="POST">
		<input class="logo" type="image" src="imgs/logo.png" style="margin-left:15%;">
	</form>
	  <%}else{ %>
	  <!-- menu -->
	<ul id="nav" style="margin-left:15%;">
	  <li><a href="index.jsp">Home</a></li>
	  <li><a href="allMovies.jsp">Current Showings</a></li>
	  <li><a href="">Contacts</a></li>
	  <li style="float:right"><a href="login.jsp">Login</a></li>
	  <li style="float:right"><a href="register.jsp">Sign Up</a></li>
	  <div id="lavalamp"></div>
	</ul>
	 <!-- Home Logo Image Button -->
	<form action="index.jsp" method="POST">
		<input class="logo" type="image" src="imgs/logo.png" style="margin-left:15%;">
	</form>
  <%} %>
	</ul>
  <div class="modal-content" style="width:500px;">
	  <%for(Movie tempMovie : mList){ %>
	  <form action="movie.jsp" method="POST">
		  <div>
		  	<input type="image" src="imgs/<%=tempMovie.getIcon() %>" width="500px" alt="Submit">
		  	<input type="hidden" name="mid" value="<%=tempMovie.getMovieId() %>">
		  </div>
		   </form>
	 <% } %>
  </div>
</div>



</body>
</html>
