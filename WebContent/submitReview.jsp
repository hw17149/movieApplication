<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*, cinema.user.entity.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*, java.lang.Math.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.* ,java.time.*, java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adding Movie</title>
</head>
<body>

<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	int rating = Integer.parseInt(request.getParameter("rate"));
	String comment = request.getParameter("comment");
	int mid = Integer.parseInt(request.getParameter("mid"));
	//String date = request.getParameter("currentDate");
	int userid = (Integer) request.getSession().getAttribute("currentID");
	ManageReview mr = new ManageReview();
	mr.addReview(userid,mid,comment,rating,date);
	double newAvg = mr.averageReview(mid);
	ManageMovie mm = new ManageMovie();
	mm.updateAverageUserRating(mid, (double)Math.round(newAvg * 100)/100);
%>
	<form id="myForm" action="movie.jsp" method="POST">
        <input type="hidden" name="mid" value="<%=mid %>"/>
   </form>

	<script type="text/javascript">
    window.onload=function(){
        var auto = setTimeout(function(){ submitform(); }, 1);
        function submitform(){
          document.forms["myForm"].submit();
        }
    }
</script>
	<b>Redirecting to Admin page...</b> <% //response.setHeader("Refresh", "1; movie.jsp"); %>
</body>
</html>