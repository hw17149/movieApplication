<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "cinema.hibernate.*, cinema.user.entity.*, java.util.*, javax.mail.*" %>
<%@ page import = "javax.mail.internet.*,javax.activation.*, java.io.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*, org.hibernate.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	SendEmail se = new SendEmail();
	int userid = (Integer) request.getSession().getAttribute("currentID");
	ManageUser mu = new ManageUser();
	String fname = mu.getUser(userid).getFname();
	String email = mu.getUser(userid).getEmail();
	ManageShowTime ms = new ManageShowTime();
	ManageTicket mt = new ManageTicket();
	ManageBooking mb = new ManageBooking();
	int bookid = Integer.parseInt(request.getParameter("bid"));
	List<Ticket> tList = mt.userOrderHistory(userid);
	for(Ticket temp : tList){
		if(temp.getBookingNo() == bookid){
			ms.unreserveSeat(temp.getShowTimeId(), temp.getSeatNo());
			mt.deleteTicket(temp.getTicketId());
		}
	}
	
	double price = mb.getBooking(bookid).getTotal();
	int numOfTicket = mb.getBooking(bookid).getNumberOfAdults() + mb.getBooking(bookid).getNumberOfChildren() + mb.getBooking(bookid).getNumberOfSeniors();
	se.refundConfirmation(fname, email, price, numOfTicket, bookid);
	mb.deleteBooking(bookid);
	%>
	<b>Redirecting to showTime page...</b> <% response.setHeader("Refresh", "0; history.jsp"); %>
</body>
</html>