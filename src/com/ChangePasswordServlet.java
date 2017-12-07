package com.csci490.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Author: Kimberly Small
 * Last Revised: December 4, 2017
 * Description: This is the servlet for the change password page.
 * 
 */
@WebServlet("/changePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String confirmPass = request.getParameter("confirmPass");
		String field = "password"; 
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		String name = (String) sess.getAttribute("user");
		
		User user = new User();
		UserManager manager = new UserManager();
		manager.setUp();
		user = manager.read(name);
	
		
		
		if(user != null && oldPass.equals(user.getPassword()) && newPass.equals(confirmPass)) 
		{
			manager.update(name, field, newPass);
			manager.close();
			
			System.out.println("Password Successfully Changed!");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.include(request, response);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password Successfully Changed!');");
			out.println("location='home.jsp';");
			out.println("</script>");
		}
		else if(user !=  null && ! oldPass.equals(user.getPassword()))
		{
			System.out.println("ERROR: Old Password Incorrect!");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/changePassword.jsp");
			rd.include(request, response);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('ERROR: Old Password Incorrect!');");
			out.println("location='changePassword.jsp';");
			out.println("</script>");
		}
		else if(user != null && ! newPass.equals(confirmPass))
		{
			System.out.println("ERROR: (New) Passwords do not match!");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/changePassword.jsp");
			rd.include(request, response);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('ERROR: (New) Passwords do not match!')");
			out.println("location='changePassword.jsp';");
			out.println("</script>");
		}
		
		out.close();
	}

}
