<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "cinema.user.entity.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
  <!--  Meta  -->
  <meta charset="UTF-8" />
  <title>History</title>
  <style>
    <style>

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 70%;
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
  <link rel="stylesheet" href="styles/index.processed.css">
  <link rel="stylesheet" href="styles/basic.css">
  <link rel="stylesheet" href="styles/button.css">
</head>
<body>
<div class="modal">
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
	<form action="index2.jsp" method="POST">
		<input class="logo" type="image" src="imgs/logo.png" style="margin-left:15%;">
	</form>
	<%
	ManageBooking mb = new ManageBooking();
	ManageTicket mt = new ManageTicket();
	ManageMovie mm = new ManageMovie();
	ManageShowTime ms = new ManageShowTime();
	List<Booking> bList = mb.getBookingList();
	List<Ticket> tList = mt.getTicketList();
	List<Movie> mList = mm.getMoviesList();
	List<ShowTime> stList = ms.getShowTimeList();
	String title = "";
	String date= "";
	String time = "";
	%>
<div class="modal-content greybox container">
	<table>
  <tr>
    <th>Booking ID</th>
    <th>Price</th>
    <th>Adult Tickets</th>
    <th>Senior Tickets</th>
    <th>Child Tickets</th>
    <th>Request Refund</th>

  </tr>
    	<%for(Booking tempBooking : bList) { %>
    	<%
	 		if(tempBooking.getUserId() == thisUser.getUserId()){
	 			
	 			
	 		%>
	 		<tr>
			 	<td><%=tempBooking.getBookingNo() %></td>
			 	<td><%=tempBooking.getTotal() %></td>
			 	<td><%=tempBooking.getNumberOfAdults() %></td>
			 	<td><%=tempBooking.getNumberOfSeniors() %></td>
			 	<td><%=tempBooking.getNumberOfChildren() %></td>
			 	<td><form action="refund.jsp" method="POST">
			 		<input type="hidden" name="bid" value="<%=tempBooking.getBookingNo() %>">
			 		<button type="submit" class="goldenbtn">Refund</button>
			 	</form></td>
			 	
			 	
     		</tr>
	 		
	 		<%
	 		}}
	 		%>
</table>
	

	</div>
	<br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
</div>

</body>
</html>