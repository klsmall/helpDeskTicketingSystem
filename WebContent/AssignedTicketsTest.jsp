<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%List eList = (List)session.getAttribute("Ticket");
  request.setAttribute("eList", eList);%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Assigned Tickets</title>
    <link rel="stylesheet" href="style2.css">
    <link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script>
</head>
<body>
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
	<div class = "Displayed Tickets">
	<table align="left">
		<c:forEach items="${eList}" var ="ticket">
			<tr>
				<td>ID: <c:out value="${ticket.ID}"/></td>
				<td>Title:<c:out value="${ticket.Title}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
