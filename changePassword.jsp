<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ticket Confirmation</title>
	<link rel="stylesheet" href="style4.css">
	<link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script> 
</head>
<body>
	<%
		//Checks to see if user is logged in
		HttpSession sess = request.getSession(false);
		Object name = sess.getAttribute("user");
		
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
    
    <div class="pass-card">
    	<form class="card" action="changePasswordServlet" method="post">
          <h1>Change Password</h1>
          <h3>Help us keep your account secure <i class="fa fa-lock" aria-hidden="true"></i></h3>
          <br>
          <br>
          <label>Enter Old Password:</label><input type="password" name="oldPass" placeholder="" required/>
          <label>Enter New Password:</label><input type="password" name="newPass" placeholder="" required/>
          <label>Confirm New Password:</label><input type="password" name="confirmPass" placeholder="" required/>
          <br>
          <button class="signup-btn" type="submit" value="Submit">Change Password</button>
        </form> 
    </div>
</body>
</html>