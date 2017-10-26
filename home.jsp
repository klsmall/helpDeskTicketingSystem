<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>
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
          <li><a href="logoutServlet">Logout</a></li>
          <li><a href="contact.jsp">Contact Us</a></li>
        </ul>
      </div>
    </div>
    
    <div class="description">
        <h1>With top notch technicians, we are here to help!</h1>
    </div>
    
    <div class="actionBox">
      <h4 class="heading">Create a ticket</h4>
      <p class="text">Having a technical issue with one of your devices? No problem. Just fill out one of our help desk tickets and we will get back with you as soon as possible!</p>
      <a href="createTicket.jsp"><button class="btn">Create Ticket <i class="fa fa-ticket" aria-hidden="true"></i></button></a>
    </div>
    <div class="actionBox">
      <h4 class="heading">Check the status of your ticket</h4>
      <p class="text">Already filled out a ticket? Click below to check the status of your ticket. You also have the ability to chat with your technician, as well as give them a rating! </p>
      <a href="checkStatus.jsp"><button class="btn">Check Status <i class="fa fa-pencil-square-o" aria-hidden="true"></i></button></a>
    </div>
    <div class="actionBox">
      <h4 class="heading">View your assigned tickets</h4>
      <p class="text"><span>*TECH AND ADMIN ONLY*</span> You need to know which tickets are yours? Look no further! Click on the button below to view your assigned tickets.</p>
      <a href="assignedTickets.jsp"><button class="btn">Assigned Tickets <i class="fa fa-tasks" aria-hidden="true"></i></button></a>
    </div>
    <div class="actionBox">
      <h4 class="heading">View all available tickets</h4>
      <p class="text"><span>*ADMIN ONLY*</span> Click below to view and manage all available tickets. You will have access to all features, such as assigning technicians to tickets, checking technician ratings, etc.</p>
      <a href="allTickets.jsp"><button class="btn">All Tickets <i class="fa fa-list-ol" aria-hidden="true"></i></button></a>
    </div>
</body>
</html>