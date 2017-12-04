<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.TicketingSystem.User "%>
<%@ page import="com.TicketingSystem.UserManager "%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<link rel="shortcut icon" href="">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Current Users</title>
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
   
    <form action = /AssignedTicketsServlet method = GET>
    <%
	UserManager manager = new UserManager();
    manager.setUp();
    ArrayList<User> list = new ArrayList();
   	list = (ArrayList) manager.getList();
   	String user = (String) session.getAttribute("user");
   	int priv = Integer.parseInt((String) session.getAttribute("priv"));
	
    
    request.setAttribute("list",list);
    
    
    %>


</form>

 
  
 
 
<TABLE>
		Users
		<c:forEach items = "${list}" var = "User">
			<tr>
				<td>Username:  <c:out value="${User.getUsername()}"></c:out></td>		
				<td>Priviledge Level:    <c:out value="${User.getPriv()}"></c:out></td>		
				
			</tr>
		</c:forEach>
		
</TABLE>

<div class="ticket">
      <form action="UserManagerServlet" method="post">
        <fieldset>
          <legend>Manage User</legend>
          <p>USER: </p>
          <input type="text" name="username" required>
          
          <p>General Issue: </p>
          <select name="action" required>
          	<option value="">Select one</option>
          	<option value="add">Add</option>
          	<option value="delete">Delete</option>
          	<option value="update">Update</option>
          	
          </select>
          
          <br>
          
          <input type="submit" value="Submit">
          <input type="reset">
        </fieldset>
      </form>
    </div>

    
    </div>
</body>
</html>