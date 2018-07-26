<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}


select {
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}


label {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}
             

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

</style>
<link rel="stylesheet" href="styles/basic.css">
  <link rel="stylesheet" href="styles/index.processed.css">
<link rel="stylesheet" href="styles/button.css">
<body>

<!-- <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Sign Up</button> -->

<div class="modal">
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
	
  <form class="modal-content" action="loginCheck2.jsp" method="POST">
    <div class="greybox container">
      <h1 class="whitefont">Log In</h1>
      <p></p>
      <hr>
      
      <label for="email" class="whitefont"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email">

      <label for="psw"><b class="whitefont">Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw">


      

      <div class="clearfix">
      	<a href="reset.jsp" style="color:#1E90FF; margin-left: 180px;">Forgot Password?</a>
        <button type="submit" class="signupbtn goldenbtn">Log In</button>
      </div>
    </div>
  </form>
</div>



</body>
</html>
