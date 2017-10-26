package com.csci490.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	//Define necessary variables
	private static final long serialVersionUID = 1L;
    User user = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uName = request.getParameter("username").trim();
		String pWord = request.getParameter("password").trim();
		System.out.println(uName + " " + pWord);
		
		User user = new User();
		UserManager manager = new UserManager();
		manager.setUp();
		user = manager.read(uName);
		manager.close();
		
		
		if(user != null && uName.equals(user.getUsername()) && pWord.equals(user.getPassword()))
		{
			System.out.println("SUCCESS: Login Accepted.");
			System.out.println("Welcome " + user.getUsername() + "!");
	
			//Create a Cookie to keep track of user login
			Cookie userName = new Cookie("user", uName);
			userName.setMaxAge(30*60); //sets length of login session to 30 minutes
			response.addCookie(userName);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.include(request, response);
		}
		else if (user != null && uName.equals(user.getUsername()))
		{
			System.out.println("ERROR: Password Incorrect.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
		else
		{
			System.out.println("ERROR: User " + uName + " could not be found.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}

	}

}
