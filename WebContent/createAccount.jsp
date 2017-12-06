<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sign Up</title>
	<link rel="stylesheet" href="style3.css">
	<link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script> 
</head>
<body>
	<div class="login">
      <center>
        <h2>Help Desk Ticketing System</h2>
        <form class="card" action="registerServlet" method="post">
          <h3>Create an Account </h3>
            <input type="text" name="username" placeholder="Create a Username" required/>
            <input type="password" name="password" placeholder="Create a Password" required/>
          <select name="userType" required>
            <option value="">Select One</option>
            <option value="1">Client</option>
            <option value="2">Technician</option>
            <option value="3">Administrator</option>
          </select>
          <button class="signup-btn" type="submit" value="Submit">Create Account</button>
        </form> 
        <p>Already signed up?</p>
        <a class="login-btn" href="login.jsp">Login</a>
      </center>
    </div>
</body>
</html>
