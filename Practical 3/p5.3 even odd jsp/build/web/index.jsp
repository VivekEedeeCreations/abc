<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>5358 Samruddhi Surve</title>
	</head>
    
	<body>
    	<h1>5358 Samruddhi Surve</h1>
    	<form>
        	<input type='number' name="num1" />
        	<input type="submit" value="Check Number" />
    	</form>

    	<%
    	String newStr = request.getParameter("num1");
    	if (newStr != null && !newStr.isEmpty()) {
        	try {
            	int num1 = Integer.parseInt(newStr); // Parse the age input to an integer

            	if (num1%2==0) { %>
                	<p>Number is Even.</p>
            	<% } else { %>
                	<p>Number is Odd.</p>
            	<% }
        	} catch (NumberFormatException e) {
            	out.println("<h3>Please enter a valid Number.</h3>"); // Handling invalid input
        	}
    	}
    	%>

	</body>
</html>

