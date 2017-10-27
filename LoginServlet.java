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
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 * 
 * Checks database for user, checks to see if the user/password combination matches, 
 * and uses cookies to start a login session for the user
 * 
 * @author Kimberly Small
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
		
		PrintWriter pw = response.getWriter();
		
		User user = new User();
		UserManager manager = new UserManager();
		manager.setUp();
		user = manager.read(uName);
		manager.close();
		
		//Checks to see if user exists and if the username/password combination is valid
		if(user != null && uName.equals(user.getUsername()) && pWord.equals(user.getPassword()))
		{
			System.out.println("SUCCESS: Login Accepted.");
			System.out.println("Welcome " + user.getUsername() + "!");
	
			Short priv = user.getPriv();
			String grantAccess = String.valueOf(priv);
			System.out.println(grantAccess);
			
			//Creates a login session for the user
			HttpSession session = request.getSession();
			session.setAttribute("user", uName);
			session.setAttribute("priv", grantAccess);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.include(request, response);
		}
		else if (user != null && uName.equals(user.getUsername()))
		{
			System.out.println("ERROR: Password Incorrect.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.include(request, response);
			pw.println("ERROR: Password incorrect. Please login using correct credintials.");
		}
		else
		{
			System.out.println("ERROR: User " + uName + " could not be found.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.include(request, response);
			pw.println("ERROR: User not found.");
		}
		pw.close();
	}
}
