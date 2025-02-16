

<%
	int age=Integer.parseInt(request.getParameter("age")) ;
	if (age>=18)
	{
    	out.println("You are Eligible for voting");
	}
	else
	{
    	out.println("You are not Eligible for Voting" );
	}
	%>
