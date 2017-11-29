package com.TicketingSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

/**
 * Servlet implementation class AssignedTickets
 */
@WebServlet("/AssignedTicketsServlet")
public class AssignedTicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignedTicketsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketManager manager = new TicketManager();
		ArrayList<Ticket> list;
		try {
			manager.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		list = (ArrayList) manager.getList();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("List", list);
		request.getRequestDispatcher("assignedTickets.jsp").forward(request,response);
		System.out.println(list);
	}
}
