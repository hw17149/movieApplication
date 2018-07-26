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
  <title>Home Page</title>
  
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
	
	<div class="iframe1">
	<h2 style="text-align:center; color:white;">MOVIE ETIQUETTE</H2>
	<iframe width="560" height="315"
	src="https://www.youtube.com/embed/Dz5Qwd93VpE" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen>
	</iframe>
</div>
	
<div class="slideshow-container" style="margin-left:10%;">
<h2 style="text-align:center; color:white; margin-top:20%;">NEW MOVIES</H2>
	<div class="mySlides fade">
		<form action="movie.jsp" method="POST">
			  <div width="50%">
			  	<input type="image" src="imgs/blackpanther.jpg" width="400px" alt="Submit">
			  	<input type="hidden" name="mid" value="1">
			  </div>
		</form>
	  	<div class="text">Black Panther</div>
	</div>
	
	<div class="mySlides fade">
  		<form action="movie.jsp" method="POST">
		  <div width="50%">
		  	<input type="image" src="imgs/harrypotter.jpg" width="400px" alt="Submit">
		  	<input type="hidden" name="mid" value="2">
		  </div>
		</form>
  		<div class="text">Harry Potter</div>
	</div>

	<div class="mySlides fade">
  	  	<form action="movie.jsp" method="POST">
  	  		<div width="50%">
		  		<input type="image" src="imgs/player1.jpg" width="400px" alt="Submit">
		  		<input type="hidden" name="mid" value="3">
      		</div>
		</form>
  	<div class="text">Ready Player One</div>
	</div>
	<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	<a class="next" onclick="plusSlides(1)">&#10095;</a>
	<br></br>
	<div style="text-align:center">
	  <span class="dot" onclick="currentSlide(1)"></span> 
	  <span class="dot" onclick="currentSlide(2)"></span> 
	  <span class="dot" onclick="currentSlide(3)"></span> 
	</div>
</div>
<br></br><br></br>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 4000); // Change image every 4 seconds
}
</script>
<br></br><br></br><br></br><br></br><br></br><br></br>
</div>
<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>
</body>
</html>