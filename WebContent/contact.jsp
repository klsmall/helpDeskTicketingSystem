<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Contact Us</title>
	<link rel="stylesheet" href="style2.css">
    <link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script>
</head>
<body>
	<%
		//Check to see if user is logged in
		HttpSession sess = request.getSession(false);
		Object name = sess.getAttribute("user");
		
		if(name == null)
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
    
    <div class="ticket">
    	<form action="contactServlet" method="post">
    		<fieldset>
    			<legend>Contact Us</legend>
    			<h2>Send any questions or concerns through this form and we will get back with you as soon as possible.</h2>
			
				<br>
			
				<p>Name:</p>
				<input type="text" name="name" required>
				
				<p>Email:</p>
				<input type="email" name="email" required>
				 
				<p>Phone Number:</p>
				<input type="text" name="phoneNumber"  required>
				
				<p>Message:</p>
				<textarea name="message" rows="10" cols="50" required></textarea>
				
				<br>
				
				<input type="submit" value="Submit">
				<input type="reset">
    		</fieldset>
    	</form>
    </div>
	
</body>
</html>