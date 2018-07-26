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

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 90%;
}
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 5px;
}
tr:nth-child(even) {
    background-color: #dddddd;
}
tr:nth-child(odd) {
    color: white;
}
td:first-child{
  width: 5%;
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
  
 <!--  Styles  -->
 <link rel="stylesheet" href="styles/button.css">
  <link rel="stylesheet" href="styles/index.processed.css">
  <link rel="stylesheet" href="styles/basic.css">
</head>
<body>

<%
  	ManageMovie mm = new ManageMovie();
  	ManageShowTime ms = new ManageShowTime();
  	List<Movie> mList = mm.getMoviesList();
  	List<ShowTime> stList = ms.getOrderedByDate();
  	int movieId = Integer.parseInt(request.getParameter("mid"));
  	Movie m = mm.getMovie(movieId);
  	int count = 0;
	%>
<div class="modal">
<!-- menu -->
	<ul id="nav" style="margin-left:15%;">
	  <li><a href="index.jsp">Home</a></li>
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
	 <div class="modal-content greybox container">
<h2 class="whitefont"><%= m.getTitle()%> Show Times</h2>
<table>
  <tr>
    <th class="whitefont">Date</th>
    <th class="whitefont">Time</th>
    <th class="whitefont">Seats Available</th>
    <th class="whitefont">Hall</th>
    <th></th>
  </tr>
    	<%for(ShowTime show: stList) { %>
    	<%
	 		if(show.getShowMovieId() == movieId){
	 		%>
	 		<tr>
	 	<td><%=show.getShowingDate() %></td>
	 	<%
	 	String time = "";
	 	switch(show.getShowingTime()){
	 	case "A": time = "1:00 PM";
	 			break;
	 	case "B": time = "4:00 PM";
	 			break;
	 	case "C": time = "7:00 PM";
	 			break;
	 	case "D": time = "10:00 PM";
	 			break;
	 	} %>
	 	<td><%=time %></td>
	 	<td><%
	 	count = 0;
	 	for(int i=0; i<32; i++){
	 		if(ms.isOccupied(show.getShowTimeId(), i)){
	 			count = count + 1;
	 		}
	 	} %><%=32-count%></td>
	 	<td><%=show.getHallNo() %></td>
     	<td>
     		<form action="pickSeats.jsp" method="POST">
     		<input type="hidden" name="sid" value="<%=show.getShowTimeId()%>">
     		<input type="hidden" name="mid" value="<%=request.getParameter("mid") %>">
			<button type="submit" class="goldenbtn">Go</button>
			</form>
			
			
		</td>
		<%}} %>
     </tr>
</table>

</div>
<br></br><br></br><br></br><br></br><br></br><br></br>
</div>
</body>
</html>
