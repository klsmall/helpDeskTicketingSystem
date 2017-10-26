<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Assigned Tickets</title>
	<link rel="stylesheet" href="style2.css">
    <link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script>
</head>
<body>
	<%
		//Checks to see if user is logged in
		Cookie[] loggedIn = request.getCookies();
		if (loggedIn != null)
		{
			for (int i = 0; i < loggedIn.length; i++)
			{
				String name = loggedIn[i].getName();
				String value = loggedIn[i].getValue();
				if (name.equals("user"))
				{
					break;
				}
				if (i == (loggedIn.length - 1))
				{
					response.sendRedirect("login.jsp");
				}
				i++;
			}
		}
		else
		{
			response.sendRedirect("login.jsp");
			return;
		}
	%>
	<div class="navSection top">
      <div class="navSectionWrapper">
        <h1 class="logo">Help Desk <span>Ticketing System</span></h1>
        <ul>
          <li><a href="home.jsp">Home</a></li>
          <li><a href="createTicket.jsp">Create a Ticket</a></li>
          <li><a href="login.jsp">Logout</a></li>
          <li><a href="contact.jsp">Contact Us</a></li>
        </ul>
      </div>
    </div>
    
    <div class="description">
    	<h1>Here are your assigned tickets:</h1>
	</div>
	
	<div class="assignedTickets">
		<table align="center">
			<tr>
				<th>ID #</th>
				<th>Created</th>
				<th>Client</th>
				<th>Subject</th>
				<th>Status</th>
				<th>Priority</th>
			</tr>
		</table>
	</div>
</body>
</html>