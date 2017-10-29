package com.TicketingSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 * 
 * Allows values from createAccount.jsp to be passed 
 * to the sql database.
 * @author Kimberly Small
 * 
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uName = request.getParameter("username");
		String pWord = request.getParameter("password");
		String uType = request.getParameter("userType");
		short priv = Short.parseShort(request.getParameter("userType"));//Short.parseShort(uType);
		
		User user = new User();
		user.setUsername(uName);
		user.setPassword(pWord);
		user.setPriv(priv);
		
		UserManager manager = new UserManager();
		manager.setUp();
		manager.create(uName, pWord, priv);
		manager.close();
		
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + uName + "</h1>");
		writer.println("<p>Password Entered: " + pWord + "</p>");
		writer.println("<p>User Type: " + priv + "</p>");
		writer.close();
	}

}