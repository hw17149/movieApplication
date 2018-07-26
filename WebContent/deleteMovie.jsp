<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*, cinema.user.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	ManageMovie mm = new ManageMovie();
	ManageReview mr = new ManageReview();
	ManageShowTime ms = new ManageShowTime();
	ManageTicket mt = new ManageTicket();
	String id = request.getParameter("mid");
	int movieid = Integer.parseInt(id);
	List<Review> rList = mr.getReviewList();
	List<ShowTime> sList = ms.getShowTimeList();
	List<Ticket> tList = mt.getTicketList();
	for(Ticket tempT: tList){
		if(tempT.getMovieId() == movieid){ %>
		<script> alert("Movie cannot be deleted after purchase!");</script>
	<% 
	break;
		}
	}
	
	for(ShowTime tempS: sList){
		if(tempS.getShowMovieId() == movieid){ %>
			<script> alert("Movie cannot be deleted after purchase!");</script>
		<% 
		}else{
			for(Review tempR: rList){
				if(tempR.getMovieId()==movieid)
					mr.deleteReview(tempR.getReviewNo());
			}
		}
	}
	
			
	
	try{
		mm.deleteMovie(movieid);
	}catch(Exception e){%>
	<%}
	%>

	
	<b>Redirecting to Admin page...</b> <% response.setHeader("Refresh", "0; admin.jsp"); %>
</body>
</html>