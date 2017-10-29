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
		HttpSession sess = request.getSession(false);
		Object name = sess.getAttribute("user");
		String priv = (String)sess.getAttribute("priv");
		
		if (name != null && priv.equals("1"))
		{
			//Deny access if the user is a client
			response.sendRedirect("denyAccess.jsp");
			return;
		}
		else if (name == null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
	
	%>
	<div class="navSection top">
      <div class="navSectionWrapper">
        <a href="home.jsp"><h1 class="logo">Help Desk <span>Ticketing System</span></h1></a>
        <ul>
          <li><a href="logoutServlet">Logout</a></li>
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