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
  <title>contacts Page</title>
  <!--  Styles  -->
  <link rel="stylesheet" href="styles/index.processed.css">
  <link rel="stylesheet" href="styles/basic.css">
</head>
<style>
/* Add padding to container elements */
.container {
    padding: 16px;
}</style>
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
    <form action="index2.jsp" method="POST">
        <input class="logo" type="image" src="imgs/logo.png" style="margin-left:15%;">
    </form>
      <%}else{ %>
      <!-- menu -->
    <ul id="nav" style="margin-left:15%;">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="allMovies.jsp">Current Showings</a></li>
      <li><a href="contacts.jsp">Contacts</a></li>
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
    <div class="modal-content">
    <div class="greybox container">
      <h1 class="whitefont">Contacts</h1>
      <hr>
      <h2 class="whitefont">Team Members</h2>
      <p class="whitefont">Richard Deng</p>
      <p class="whitefont">Kevin Berger</p>
      <p class="whitefont">Hoonjae Won</p>
      <p class="whitefont">Sanggyun Jerry Jang</p>
      <p class="whitefont">Guangqian Zhang</p>
      <br></br>
      <h2 class="whitefont">Cinema Email</h2>
      <p class="whitefont">cinema4050@gmail.com</p>
    </div>
    </div>
 </div>
 </body>
</html>