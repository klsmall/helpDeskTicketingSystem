package com.TicketingSystem;

import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createTicketServlet
 */
@WebServlet("/createTicketServlet")
public class createTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E MM.dd.yyyy 'at' hh:mm:ss a zzz");
		String date1 = "Open";
		
		String tech = "not Assigned";
		String client = request.getParameter("clientName");
		String manufacturer = request.getParameter("manufacturer");
		String device = request.getParameter("device");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String problemCatagory = request.getParameter("genIssue");
		File file = null;
		
		try{
		 file = new File(request.getParameter("file"));
		}catch(NullPointerException e){
			
			file = new File("C:/Users/Gavin/Desktop/Workspace/490/490TS/no_image_thumb.gif");
		}
		TicketManager manager = new TicketManager();
		try {
			manager.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			manager.create(0, client, tech, manufacturer, message, ft.format(date), date1, subject, problemCatagory,file);
			manager.close();
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
