<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Create Ticket</title>
	<link rel="stylesheet" href="style2.css">
    <link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script>
    <script type="text/javascript">
    	function checkManufacturer(op)
    	{
    		var inputOption = document.getElementById('manufacturer');
    		if (op=="other")
    			inputOption.style.display='block';
    		else
    			inputOption.style.display='none';
    	}
    	
    	function checkDevice(op2)
    	{
    		var inputOption2 = document.getElementById('device');
    		if (op2=="other")
    			inputOption2.style.display='block';
    		else
    			inputOption2.style.display='none';
    	}
    </script>
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
    
    <div class="ticket">
      <form action="ticketServlet" method="post">
        <fieldset>
          <legend>Create Ticket</legend>
          <p>Client Name: </p>
          <input type="text" name="clientName" required>
          
          <p>Email: </p>
          <input type="email" name="email" required>
          
          <p>Device Manufacturer: </p>
          <select name="manufacturer" onchange='checkManufacturer(this.value);' required>
            <option value="">Select one</option>
            <option value="HP">HP</option>
            <option value="Apple">Apple</option>
            <option value="Dell">Dell</option>
            <option value="Toshiba">Toshiba</option>
            <option value="Lenovo">Lenovo</option>
            <option value="Samsung">Samsung</option>
            <option value="Asus">Asus</option>
            <option value="Microsoft">Microsoft</option>
            <option value="other">Other</option>
          </select>
          <input type="text" name="manufacturer" id="manufacturer" style='display:none' >
          
          <p>Device Type: </p>
          <select name="device" onchange='checkDevice(this.value);' required>
            <option value="">Select one</option>
            <option value="Desktop">Desktop</option>
            <option value="Laptop">Laptop</option>
            <option value="Tablet">Tablet</option>
            <option value="Smartphone">Smartphone</option>
            <option value="Firestick">Firestick</option>
            <option value="GamingDevice">Gaming Device</option>
            <option value="Printer">Printer</option>
            <option value="other">Other</option>
          </select>
          <input type="text" name="device" id="device" style='display:none' />
          
          <p>General Issue: </p>
          <select name="genIssue" required>
          	<option value="">Select one</option>
          	<option value="hardware">Hardware</option>
          	<option value="internet">Network & Internet</option>
          	<option value="sofware">Software</option>
          	<option value="infected">Virus/Malware</option>
          	<option value="other">Other</option>
          </select>
          
          <p>Subject: </p>
          <input type="text" name="subject" required>
          
          <p>Description of Issue</p>
          <textarea name="message" rows="10" cols="50" >What is the problem...</textarea>
          <br>
          
          <p>Photos of Issue: (optional)</p>
          <input type="file" name="img" multiple>
          <br>
          
          <input type="submit" value="Submit">
          <input type="reset">
        </fieldset>
      </form>
    </div>
  </body>
</html>