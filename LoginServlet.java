package com.csci490.javaee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	//Define necessary variables
	private static final long serialVersionUID = 1L;
    Connection connection = null;
    Statement queryStmt = null;
    ResultSet result = null;
    User user = null;
    Object obj[] = null;
	
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
			HttpSession session = request.getSession(true);
			session.setAttribute("user", uName);
			session.setMaxInactiveInterval(30);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		else if (user != null && uName.equals(user.getUsername()))
		{
			System.out.println("ERROR: Password Incorrect.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else
		{
			System.out.println("ERROR: User " + uName + " could not be found.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
