<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="style1.css">
	<link href="https://fonts.googleapis.com/css?family=Work+Sans" rel="stylesheet">
    <script src="https://use.fontawesome.com/297c6b8454.js"></script>
</head>
<body>
	<div class="login">
      <center>
        <h2>Help Desk Ticketing System</h2>
        <form class="card" action="loginServlet" method="post">
          <h3>Login to Continue</h3>
          <div class="login-fields">
            <span class="fa fa-user-o"></span>
            <input type="text" name="username" placeholder="Enter Username" required/>
            <span class="fa fa-lock"></span>
            <input type="password" name="password" placeholder="Enter Password" required/>
          </div>
          <button class="login-btn" value="Submit">Login</button>
        </form> 
        <a class="signup-btn" href="createAccount.jsp">Create Account</a>
      </center>
    </div>
</body>
</html>
