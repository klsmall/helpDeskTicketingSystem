package com.csci490.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketServlet
 */
@WebServlet("/ticketServlet")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String clientName = request.getParameter("clientName");
		String email = request.getParameter("email");
		String manufacturer = request.getParameter("manufacturer");
		String deviceType = request.getParameter("device");
		String genIssue = request.getParameter("genIssue");
		String messageSub = request.getParameter("subject");
		String message = request.getParameter("message");
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + clientName + "</h1>");
		writer.println("<p>Email: " + email + "</p>");
		writer.println("<p>Manufacturer: " + manufacturer + "</p>");
		writer.println("<p>Device Type: " + deviceType + "</p>");
		writer.println("<p>genIssue: " + genIssue + "</p>");
		writer.println("<p>Subject: " + messageSub + "</p>");
		writer.println("<p>Description of Issue: " + message + "</p>");
		writer.close();
	}

}
