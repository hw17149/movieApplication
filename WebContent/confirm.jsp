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
    width: 100%
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
			String scount = "s";
			String check = "";
			String price = "";
			int totalPrice = 0;
		  	ManageUser mu = new ManageUser();
			ManageMovie mm = new ManageMovie();
			ManageShowTime ms = new ManageShowTime();
			int movieid = Integer.parseInt(request.getParameter("mid"));
			int showid = Integer.parseInt(request.getParameter("sid"));
			Movie m = mm.getMovie(movieid);
			ShowTime s = ms.getShowTime(showid);
			String title = m.getTitle();
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
	<link rel="icon" href="imgs/favicon.ico">

	
</head>

<body>
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
  <form action="purchase.jsp" method="POST">
	<table>
	  <caption class="whitefont" style="font-size:25px">Your Cart</caption>
  <tr>
    <th>Seat</th>
    <th>Seat Type</th>
  </tr>
  	<%int c = Integer.parseInt(request.getParameter("count"));
  	for(int i=0;i<c;i++){
%>
	<tr>
		<th><%scount = scount+Integer.toString(i);%>
			<%=request.getParameter(scount)%>
			 <input type="hidden" name="n<%=i%>" value="<%=request.getParameter(scount) %>">
			<%scount = "s"; %></th>
		<th>
			<% 
			switch(request.getParameter(Integer.toString(i))){
		 	case "0": price = "$8.00";
		 				totalPrice=totalPrice+8;
 					break;
		 	case "1": price = "$11.00";
		 	totalPrice=totalPrice+11;
		 			break;
		 	case "2": price = "$9.00";
		 	totalPrice=totalPrice+9;
		 			break;
 			}
 			%>
 			<input type="hidden" name="s<%=i%>" value="<%=request.getParameter(Integer.toString(i)) %>">
 			<%=price %>
		</th>
	</tr>
<%
  }%>
</table>
<%
	String code = request.getParameter("promo");
	ManagePromotion mp = new ManagePromotion();
	int pid = mp.isValidPromo(code);
	if(code != ""){
		if(pid != -1){
		double disc = mp.getPromotion(pid).getDiscount();
			%><p class="whitefont">YOU HAVE SUCCESSFULLY USED PROMO CODE <%=code %> TO TAKE OFF $<%=disc %> FROM YOUR TOTAL PRICE.</p>
		<%totalPrice = totalPrice - (int)disc;
		}else if(pid == -1){%>
			<p class="whitefont">THE CODE <%=code %> IS NOT VALID.</p>
	<%}} %>
<p class="whitefont"><b>TOTAL PRICE: </b>$<%=totalPrice %>.00</p>
	<p class="whitefont">Card Number 
	<input type="text" placeholder="XXXX" name="card1" maxlength="4" pattern="[0-9].{3,4}" size="5" required>-
	<input type="text" placeholder="XXXX" name="card2" maxlength="4" pattern="[0-9].{3,4}" size="5" required>-
	<input type="text" placeholder="XXXX" name="card3" maxlength="4" pattern="[0-9].{3,4}" size="5" required>-
	<input type="text" placeholder="XXXX" name="card4" maxlength="4" pattern="[0-9].{3,4}" size="5" required>
	</p>
	<p class="whitefont">Expiration Date
	<select name="month" required>
		<option value="">MM</option>
		<% for(int i=1;i<13;i++){%>
			<option value="<%=i%>"><%=i%></option>
			<% }%>
	</select>
	<select name="year" required>
		<option value="">YY</option>
		<% for(int i=18;i<26;i++){%>
			<option value="<%=i%>"><%=i%></option>
			<% }%>
	</select>
	</p>
	<p class="whitefont">Security Number
	<input type="text" placeholder="XXX" name="scc" maxlength="3" pattern="[0-9].{2,3}" size="4" required>
	</p>
	<p align="center">
	<button type="submit" class="goldenbtn" style="width:50%">submit</button>
	</p>
	<input type="hidden" name="totalPrice" value="<%=totalPrice %>">
	<%	Promotion tempPromo;
		if(code != ""){
			if(pid != -1){ 
				tempPromo = mp.getPromotion(pid);
			%>
			<input type="hidden" name="pid" value="<%=tempPromo.getPromoId() %>">
			<%
			}else{%>
			<input type="hidden" name="pid" value="-1">
			<% }}else{%> <input type="hidden" name="pid" value="-1">
			<% }%>
	  <input type="hidden" name="count" value="<%=request.getParameter("count") %>">
	  <input type="hidden" name="sid" value="<%=s.getShowTimeId()%>">
	<input type="hidden" name="mid" value="<%=request.getParameter("mid") %>">
	 </form>
  </div>
  <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
</div>
</body>
</html>