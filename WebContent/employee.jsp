<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "cinema.user.entity.*, java.time.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <style>
.floating-box {
    display: inline-block;
    width: 300px;
    height: 150px;
    margin: 10px;
    border-style: groove;
}
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
td:first-child{
  width: 5%;
}
</style>
  <!--  Meta  -->
  <meta charset="UTF-8" />
  <title>employee</title>
  
  <!-- Menu Bar -->
  <ul>
  <li><a href="employee.jsp">Home</a></li>
	<li><a href="allMovies.jsp">Current Showings</a></li>
  <li style="float:right"><a class="active" href="logout.jsp">Logout</a></li>
  </ul>
  
  <!--  Styles  -->
  <link rel="stylesheet" href="styles/index.processed.css">
  <title>employee</title>
 
 
</head>

<body>

<h2>Schedule</h2>
<script>
 var n =  new Date();
 var m = n.getMonth() + 1;
 var d = n.getDate();
 document.getElementById("date").innerHTML = m + "/" + d;
 function validateForm(){
	 var x = document.forms["schedule"]["showDay"].value;
	 var y = document.forms["schedule"]["showMonth"].value;
	 if(y == m){
		 if(x <= d){
			 alert("Date already has passed!");
			 return false;
		 }
	 }
 }
 </script>
<table>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Showing Time</th>
    <th></th>
  </tr>
  <%
  	ManageMovie mm = new ManageMovie();
  	ManageShowTime ms = new ManageShowTime();
  	List<Movie> mList = mm.getMoviesList();
  	List<ShowTime> stList = ms.getShowTimeList();
  	for(Movie tempMovie : mList) {
	%>
	
	 <tr>
	 	<td><%=tempMovie.getMovieId() %></td>
	 	<td><%=tempMovie.getTitle() %></td>
	 	<td>
	 		<form action="showTime.jsp" method="POST">
     		<input type="hidden" name="mid" value="<%=tempMovie.getMovieId()%>">
			<button type="submit">show Times</button>
			</form>
	 	</td>
     	<td>
     		<form action="deleteMovie.jsp" method="POST">
     		<input type="hidden" name="mid" value="<%=tempMovie.getMovieId()%>">
			<button type="submit">Delete</button>
			</form>
			<form action="movie.jsp" method="POST">
     		<input type="hidden" name="mid" value="<%=tempMovie.getMovieId()%>">
			<button type="submit">Go</button>
			</form>
			<form action="hall.jsp" method="POST" name="schedule"
					onsubmit="return validateForm()">
     		<input type="hidden" name="mid" value="<%=tempMovie.getMovieId()%>">
     		<select id="hall" name="hall" required>
     			<option value="">Select Hall</option>
     			<option value="1">Hall 1</option>
     			<option value="2">Hall 2</option>
     			<option value="3">Hall 3</option>
     			<option value="4">Hall 4</option>
     		</select>
     		<select id="time" name="time" required>
     			<option value="">Select Time</option>
     			<option value="A">1:00 PM</option>
     			<option value="B">4:00 PM</option>
     			<option value="C">7:00 PM</option>
     			<option value="D">10:00 PM</option>
     		</select>
			<select id="showMonth" name="showMonth" required>
				<option value="">Select Month</option>
				<% Calendar now = Calendar.getInstance();
					int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
					int day = now.get(Calendar.DAY_OF_MONTH);
				for(int i=month;i< month+3;i++){
					if(i > 12){%>
						<option value="<%= i-12%>"><%= i-12 %></option>
				<%  }else{ %>
						<option value="<%= i%>"><%= i%></option>
				<% }}%>
				
     		</select>
     		<select id="showDay" name="showDay" required>
				<option value="">Select Day</option>
				<% for(int i=1;i< 32;i++){ %>
					<option value="<%= i%>"><%= i%></option>
					<%}%>
		
			</select>
			<button type="submit">Schedule</button>
			</form>
		</td>
     </tr>
<%} %>
</table>

<form action="addMovie.jsp" method="POST">
<p>Add Movie</p>
  <input type="text" placeholder="Title" name="title" required>
  <input type="text" placeholder="icon" name="icon">
  <input type="text" placeholder="Summary" name="summary">
  <input type="text" placeholder="Genre" name="genre">
  <input type="text" placeholder="Length" name="length">
  <input type="text" placeholder="FilmRating" name="filmRating">
  <button type="submit">ADD MOVIE</button>
</form>
<p></p>
<h2>Promotions</h2>
<table>
  <tr>
    <th>ID</th>
    <th>Discount Amount</th>
    <th>Code</th>
    <th>Currently Active?</th>
    <th>Activate/Deactivate</th>
  </tr>
  <%
  	ManagePromotion mp = new ManagePromotion();
  	List<Promotion> pList = mp.getPromotionList();
  	for(Promotion tempPromotion : pList) {
	%>
	
	 <tr>
	 	<td><%=tempPromotion.getPromoId() %></td>
	 	<td><%=tempPromotion.getDiscount() %></td>
	 	<td><%=tempPromotion.getPromoCode() %></td>
	 	<td><%if(tempPromotion.getExpire()){ %>
	 		YES<%}else{ %>
	 		NO<%} %></td>
	 	<td>
	 		<form action="expire.jsp" method="POST">
	 			<input type="hidden" name="pid" value="<%=tempPromotion.getPromoId() %>">
	 			<button type="submit">Update</button>
	 		</form>
	 	</td>
     	
     </tr>
<%} %>
</table>

<form action="addPromo.jsp" method="POST">
<p>Add Promo</p>
  <input type="text" placeholder="Code" name="code" required>
  <input type="text" placeholder="Amount" name="amount" required>
  <button type="submit">ADD PROMO</button>
</form>
<p></p>

</body>
</html>