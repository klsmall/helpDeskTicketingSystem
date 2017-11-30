<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href="home.css">
	<link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script> 
</head>
<body>
	<%
		//Checks to see if user is logged in
		HttpSession sess = request.getSession(false);
		Object name = sess.getAttribute("user");
		Object priv = sess.getAttribute("priv");
		
		if (name == null)
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
    
    <div class="welcome">
      <center>
        <h1>Welcome Back, <%=name %>!</h1>
        <p> Select an option below to get started </p>
      </center>
    </div>
    <div class="flex-containter">
      <a href="createTicket.jsp">
        <div class="flex-box">
          <i class="fa fa-ticket" aria-hidden="true"></i>
          <p>Create Ticket</p>
          <p class="description">Need help with your device?</p>
        </div>
      </a>
      
      
      <a href="ticketStatus.jsp">
        <div class="flex-box">
          <i class="fa fa-wrench" aria-hidden="true"></i>
          <p>Ticket Status</p>
          <p class="description">Get updates on your tickets.</p>
        </div>
      </a>
      
      
      <%
      if (name != null && priv.equals("2") || priv.equals("3"))
		{
	  %>
      <a href="assignedTickets.jsp">
        <div class="flex-box">
          <i class="fa fa-tasks" aria-hidden="true"></i>
          <p>Assigned Tickets</p>
          <p class="description">Resolve all client issues in one place.</p>
        </div>
      </a>
      <%
		}
     
      if (name != null && priv.equals("3"))
		{
	  %>
      <a href="allTickets.jsp">
        <div class="flex-box">
          <i class="fa fa-list-alt" aria-hidden="true"></i>
          <p>All Tickets</p>
          <p class="description">See what your technicians have been up to.</p>
        </div>
      </a>
      
      <a href="manageUsers.jsp">
      	<div class="flex-box">
      		<i class="fa fa-users" aria-hidden="true"></i>
      		<p>Manage Users</p>
      		<p class="description">Add, delete, and update users.</p>
      	</div>      
      </a>
      <%
		}
      %>
      
      <a href="changePassword.jsp">
      	<div class="flex-box">
      		<i class="fa fa-key" aria-hidden="true"></i>
          <p>Change Password</p>
          <p class="description">Keep your account secure.</p>
      	</div>
      </a>
    </div>
</body>
</html>