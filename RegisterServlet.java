package com.csci490.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;


/**
 * Servlet implementation class RegisterServlet
 * 
 * Allows values from createAccount.jsp to be passed 
 * to the sql database.
 * 
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
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uName = request.getParameter("username");
		String pWord = request.getParameter("password");
		short priv = Short.parseShort(request.getParameter("userType"));//Short.parseShort(uType);
		
		User user = new User();
		user.setUsername(uName);
		user.setPassword(pWord);
		user.setPriv(priv);
		
		UserManager manager = new UserManager();
		manager.setUp();
		manager.read(uName);
		
		try
		{
			manager.create(uName, pWord, priv);
			manager.close();
			
			System.out.println("STATUS: User created.");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.include(request, response);
			pw.println("You have successfully created an account. Please login.");
			pw.close();
		}
		catch(PersistenceException e)
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/createAccount.jsp");
			rd.include(request, response);
			pw.println("ERROR: Username already in use.");
		}
		
	}

}
