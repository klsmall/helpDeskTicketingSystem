package com.csci490.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Author: Kimberly Small
 * Last Revised: December 4, 2017
 * Description: This is the contact servlet for the contact page.
 * 
 */
@WebServlet("/contactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = null;
		String status = null;
		
		PrintWriter out = response.getWriter();
		
		EmailManager emailManager = new EmailManager();
		emailManager.setMailServerProperties();
		String emailSubject = "Help Desk: New Contact Form";
		String emailBody = "";
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String emailMessage = request.getParameter("message");
		
		if( name != null)
		{
			emailBody = emailBody + "From: " + name + "<br>";
		}
		if( email != null )
		{
			emailBody = emailBody + "Email: " + email + "<br>";
		}
		if( phoneNumber != null )
		{
			emailBody = emailBody + "Phone Number: " + phoneNumber + "<br>";
		}
		if( emailMessage != null)
		{
			emailBody = emailBody + "<br>" + emailMessage + "<br>";
		}
		
		try {
			emailManager.createEmailMessage(emailSubject, emailBody);
			emailManager.sendEmail();
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.include(request, response);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Email Sent! Please allow 24 to 48 hours for a response.');");
			out.println("location='home.jsp';");
			out.println("</script>");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/contact.jsp");
			rd.include(request, response);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('ERROR: Message not sent, please try again.');");
			out.println("location='contact.jsp';");
			out.println("</script>");
		}
		
		out.close();
	}

}
