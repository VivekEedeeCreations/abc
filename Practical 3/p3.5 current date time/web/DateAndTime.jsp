<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Date and time</title>
	</head>
	<body>
	<%java.util.Date currentDateTime = new java.util.Date();
	out.println("<p><b>Current Date and Time: " + currentDateTime + "</b></p>");
	%>
	</body>
</html>
