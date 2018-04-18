<%@ page  import="cinema.hibernate.SendEmail" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Test</title>
</head>
<body>
	<form action="sent.jsp" method="POST">
		Email: <input type="text" name="email">		
		<input type="submit" value="Submit" />
	</form>
</body>
</html>