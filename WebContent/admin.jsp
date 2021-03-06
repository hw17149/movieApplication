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
  <title>admin</title>
  
  <!-- Menu Bar -->
  <ul>
  <li><a href="admin.jsp">Home</a></li>
	<li><a href="allMovies.jsp">Current Showings</a></li>
  <li style="float:right"><a class="active" href="logout.jsp">Logout</a></li>
  </ul>
  
  <!--  Styles  -->
  <link rel="stylesheet" href="styles/index.processed.css">
  <title>admin</title>
 
 
</head>

<body>
<%
ManageUser mu = new ManageUser();
User tempU;
if(request.getSession().getAttribute("currentID") == null){
	response.setHeader("Refresh", "0; index.jsp");
}
tempU = mu.getUser((Integer)request.getSession().getAttribute("currentID"));
if(tempU.getUserType()!=2){
%><script>alert("YOU ARE NOT AN ADMIN >:^U")</script>
<% response.setHeader("Refresh", "0; index2.jsp");}%>
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

<p></p>
<h2>User List</h2>

<table>
  <tr>
    <th>UserType</th>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Birthday</th>
    <th>Banned?</th>
    <th></th>
  </tr>
  <%
  	
  	List<User> uList = mu.getUsersList();
  	for(User tempUser : uList) {
	%>
	
	 <tr>
	 	<td><%=tempUser.getUserType() %></td>
	 	<td><%=tempUser.getUserId() %></td>
     	<td><%=tempUser.getUserName()  %></td>
     	<td><%=tempUser.getEmail() %></td>
     	<td><%=tempUser.getBdate() %></td>
     	<td><%if(tempUser.getBanStatus()){ %> YES <%}else{ %> NO <%} %></td>
     	<td>
     		<form action="deleteUser.jsp" method="POST">
     		<input type="hidden" name="uid" value="<%=tempUser.getUserId()%>">
			<button type="submit">Ban/Unban</button>
			</form>
		</td>
     </tr>
  <% 	
	}
  %>
</table>

<div>

<form action="sent2.jsp" method="POST">
  <h2>Add User</h2>
  <input type="text" placeholder="User Type" name="usertype" required>
  <input type="text" placeholder="User Name" name="username">
  <input type="text" placeholder="First Name" class="require" name="first-name" required>
  <input type="text" placeholder="Last Name" name="last-name" required><p></p>
  <p>Date of Birth
      <select id="birthyear" name="birthyear"placeholder="%00">
      	<option value="%00">Select Year</option>
        <option value="2018">2018</option>
        <option value="2017">2017</option>
        <option value="2016">2016</option>
        <option value="2015">2015</option>
        <option value="2014">2014</option>
        <option value="2013">2013</option>
        <option value="2012">2012</option>
        <option value="2011">2011</option>
        <option value="2010">2010</option>
        <option value="2009">2009</option>
        <option value="2008">2008</option>
        <option value="2007">2007</option>
        <option value="2006">2006</option>
        <option value="2005">2005</option>
        <option value="2004">2004</option>
        <option value="2003">2003</option>
        <option value="2002">2002</option>
        <option value="2001">2001</option>
        <option value="2000">2000</option>
        <option value="1999">1999</option>
        <option value="1998">1998</option>
        <option value="1997">1997</option>
        <option value="1996">1996</option>
        <option value="1995">1995</option>
        <option value="1994">1994</option>
        <option value="1993">1993</option>
        <option value="1992">1992</option>
        <option value="1991">1991</option>
        <option value="1990">1990</option>
        <option value="1989">1989</option>
        <option value="1988">1988</option>
        <option value="1987">1987</option>
        <option value="1986">1986</option>
        <option value="1985">1985</option>
        <option value="1984">1984</option>
        <option value="1983">1983</option>
        <option value="1982">1982</option>
        <option value="1981">1981</option>
        <option value="1980">1980</option>
        <option value="1979">1979</option>
        <option value="1978">1978</option>
        <option value="1977">1977</option>
        <option value="1976">1976</option>
        <option value="1975">1975</option>
        <option value="1974">1974</option>
        <option value="1973">1973</option>
        <option value="1972">1972</option>
        <option value="1971">1971</option>
        <option value="1970">1970</option>
        <option value="1969">1969</option>
        <option value="1968">1968</option>
        <option value="1967">1967</option>
        <option value="1966">1966</option>
        <option value="1965">1965</option>
        <option value="1964">1964</option>
        <option value="1963">1963</option>
        <option value="1962">1962</option>
        <option value="1961">1961</option>
        <option value="1960">1960</option>
        <option value="1959">1959</option>
        <option value="1958">1958</option>
        <option value="1957">1957</option>
        <option value="1956">1956</option>
        <option value="1955">1955</option>
        <option value="1954">1954</option>
        <option value="1953">1953</option>
        <option value="1952">1952</option>
        <option value="1951">1951</option>
        <option value="1950">1950</option>
        <option value="1949">1949</option>
        <option value="1948">1948</option>
        <option value="1947">1947</option>
        <option value="1946">1946</option>
        <option value="1945">1945</option>
        <option value="1944">1944</option>
        <option value="1943">1943</option>
        <option value="1942">1942</option>
        <option value="1941">1941</option>
        <option value="1940">1940</option>
        <option value="1939">1939</option>
        <option value="1938">1938</option>
        <option value="1937">1937</option>
        <option value="1936">1936</option>
        <option value="1935">1935</option>
        <option value="1934">1934</option>
        <option value="1933">1933</option>
        <option value="1932">1932</option>
        <option value="1931">1931</option>
        <option value="1930">1930</option>
        <option value="1929">1929</option>
        <option value="1928">1928</option>
        <option value="1927">1927</option>
        <option value="1926">1926</option>
        <option value="1925">1925</option>
        <option value="1924">1924</option>
        <option value="1923">1923</option>
        <option value="1922">1922</option>
        <option value="1921">1921</option>
        <option value="1920">1920</option>
        <option value="1919">1919</option>
        <option value="1918">1918</option>
        <option value="1917">1917</option>
        <option value="1916">1916</option>
        <option value="1915">1915</option>
        <option value="1914">1914</option>
        <option value="1913">1913</option>
        <option value="1912">1912</option>
        <option value="1911">1911</option>
        <option value="1910">1910</option>
        <option value="1909">1909</option>
        <option value="1908">1908</option>
        <option value="1907">1907</option>
        <option value="1906">1906</option>
        <option value="1905">1905</option>
        <option value="1904">1904</option>
        <option value="1903">1903</option>
        <option value="1902">1902</option>
        <option value="1901">1901</option>
        <option value="1900">1900</option>
      </select>
      <select id="birthmonth" name="birthmonth" placeholder="%00">
      	<option value="%00">Month</option>
        <option value="01">January</option>
        <option value="02">February</option>
        <option value="03">March</option>
        <option value="04">April</option>
        <option value="05">May</option>
        <option value="06">June</option>
        <option value="07">July</option>
        <option value="08">August</option>
        <option value="09">September</option>
        <option value="10">October</option>
        <option value="11">November</option>
        <option value="12">December</option>
      </select>
      <select id="birthday" name="birthday" placeholder="%00">
      	<option value="%00">Day</option>
        <option value="01">01</option>
        <option value="02">02</option>
        <option value="03">03</option>
        <option value="04">04</option>
        <option value="05">05</option>
        <option value="06">06</option>
        <option value="07">07</option>
        <option value="08">08</option>
        <option value="09">09</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
      </select></p>

      <input type="text" placeholder="Enter Email" name="mail" required>
      <input type="password" placeholder="Enter Password" name="password" required><p></p>
  
		  <input type="radio" name="subscribe" value="true" checked="checked"> Yes<br>
		  <input type="radio" name="subscribe" value="false"> No<br>

<button type="submit">ADD USER</button>
  </form>

</div>

<p></p>
<!-- <div class="floating-box">
  <p>Add promotion</p>
  Code: <input type="text" name="promo-code">
  <p>Percentage: <input type="text" name="amount-off"></p>
  <p><button>Add</button>
</div> -->

</body>
</html>