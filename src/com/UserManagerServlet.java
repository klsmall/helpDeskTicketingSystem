package com.TicketingSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserManagerServlet
 */
@WebServlet("/UserManagerServlet")
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  = request.getParameter("action");
		String userName = request.getParameter("username");
		
		if(action.equals("add")){
			response.sendRedirect("managerCreateUser");
		}else if(action.equals("delete")){
			UserManager manager = new UserManager();
			manager.setUp();
			manager.delete(userName);
		}else{
			response.sendRedirect("managerUpdateUser");
		}
		
		response.sendRedirect("manageUsers.jsp");
		
	}
	
	
}
