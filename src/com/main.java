package com.TicketingSystem;

public class main {
	public static void main(String[] args) {


		TicketManager manager1 = new TicketManager();
		
		try{
			manager1.setUp();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	
		System.out.print(manager1.getList());
		
		
	}
}
