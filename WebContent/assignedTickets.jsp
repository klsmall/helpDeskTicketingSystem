<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.TicketingSystem.Ticket "%>
<%@ page import="com.TicketingSystem.TicketManager "%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<link rel="shortcut icon" href="">
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
   
    <form action = /AssignedTicketsServlet method = GET>
    <%
    TicketManager manager = new TicketManager();
    manager.setUp();
    ArrayList<Ticket> list = new ArrayList();
   	list = (ArrayList) manager.getList();
   	String user = (String) session.getAttribute("user");
   	//int priv = Integer.parseInt((String) session.getAttribute("priv"));
	
    ArrayList<Ticket> list2 = new ArrayList();
    for(int x = 0; x < list.size(); x++){
    	String createdBy = list.get(x).getCreatedBy();
    	String tech = list.get(x).getTechnician();
    	
    	if(createdBy.equals(user)||(tech.equals(user))){
    		list2.add(list.get(x));
    	}
    }
    
    request.setAttribute("list",list2);
   
    
    %>


</form>

 
  
 
 
<TABLE>
		Tickets
		<c:forEach items = "${list}" var = "Ticket">
			<tr>
				<td>ID:  <c:out value="${Ticket.getId()}"></c:out></td>		
				<td>Title:    <c:out value="${Ticket.getTitle()}"></c:out></td>		
				<td>Created By:  <c:out value="${Ticket.getCreatedBy()}"></c:out></td>		
				<td>Assigned Technician:  <c:out value="${Ticket.getTechnician()}"></c:out></td>		
				<td>Computer Specs:  <c:out value="${Ticket.getCompSpecs()}"></c:out></td>		
				<td>Problem Catagory:  <c:out value="${Ticket.getProblemCatagory()}"></c:out></td>		
				<td>Description:  <c:out value="${Ticket.getDescription()}"></c:out></td>	
				<td>Email:  <c:out value="${Ticket.getEmail()}"></c:out></td>	
				<td>Device type:  <c:out value="${Ticket.getDeviceType()}"></c:out></td>	
				<td>Open Date:  <c:out value="${Ticket.getOpenDate()}"></c:out></td>		
				<td>Closed Date:  <c:out value="${Ticket.getCloseDate()}"></c:out></td>		
				
			</tr>
		</c:forEach>
		
</TABLE>
<div class="box">
            <h1></h1>
        </div>

    
    </div>
</body>
</html>
