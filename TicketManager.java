package com.TicketingSystem;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.service.Service;

/**
 * this class manages the transformation of a ticket object to a database entry into the
 * mysql database
 * @author Gavin
 *
 */
public class TicketManager {
	protected SessionFactory sessionFactory;

	public void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configures
																											// settings
																											// from
																											// hibernate.cfg.xml

		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
			throw new RuntimeException(e);
		}
	}

	/**
	 * close the session factory
	 */
	protected void close() {
		sessionFactory.close();
	}
	
	
	/**
	 * gets all the ticket objects in the ticket table
	 * @return an arraylist of the ticket objects
	 */
	public  List  getList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		
		List  list = (List) session.createCriteria(Ticket.class).list();
		session.close();
		return list;
   }


	/**
	 * creates a ticket entry and inserts it into the database
	 * @param id the id of the ticket
	 * @param createdBy the user who created the ticket
	 * @param technician the technician assigned to the ticket
	 * @param compSpecs the computer specs of the user who created the ticket
	 * @param description the description of the problem of the user
	 * @param openDate the date the ticket was opened
	 * @param closeDate the date the ticket was closed
	 * @param title the title of the ticket
	 */
	protected void create(long id, String createdBy, String technician, String compSpecs, String description, String openDate, String closeDate, String title, String problemCatagory, String deviceType, String email) {
		Ticket ticket = new Ticket(id, createdBy, technician, compSpecs, description, openDate, closeDate, title, problemCatagory, deviceType ,email);
		
		TextChainManager manager = new TextChainManager();
		try {
			manager.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(ticket);
		manager.create((Long) session.getIdentifier(ticket));
		manager.close();
		session.getTransaction().commit();
		
		session.close();
	}
	
	/**
	 * 
	 * creates a ticket entry and inserts it into the database
	 * @param id the id of the ticket
	 * @param createdBy the user who created the ticket
	 * @param technician the technician assigned to the ticket
	 * @param compSpecs the computer specs of the user who created the ticket
	 * @param description the description of the problem of the user
	 * @param openDate the date the ticket was opened
	 * @param closeDate the date the ticket was closed
	 * @param title the title of the ticket
	 * @param file the picture to be attached to the ticket
	 */
	
	protected void create(long id, String createdBy, String technician, String compSpecs, String description, String openDate, String closeDate, String title, String problemCatagory, String deviceType, String email, File file) {
		Ticket ticket = new Ticket(id, createdBy, technician, compSpecs, description, openDate, closeDate, title, problemCatagory, deviceType, email, file);
		
		TextChainManager manager = new TextChainManager();
		try {
			manager.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(ticket);
		manager.create((Long) session.getIdentifier(ticket));
		manager.close();
		session.getTransaction().commit();
		
		session.close();
	}
	
	

	/**
	 * reads in an entry from the database and will return the user object but currently doesnt
	 * @param id the id of the ticket
	 */
	protected Ticket read(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Ticket ticket = session.get(Ticket.class, id);

		if (ticket != null) {
			return ticket;
		}
		System.out.println("entry " + id + " could not be found");
		session.close();
		return null;
	}
	
	/**
	 * deletes the ticket at the entry specified by the id
	 * @param id the id of the ticket to be deleted
	 */
	protected void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		TextChainManager manager = new TextChainManager();
		try {
			manager.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.delete(id);
		session.beginTransaction();
		Ticket ticket1 = session.get(Ticket.class, id);
		if (ticket1 == null) {
			System.out.println("entry " + id + " could not be found");
			return;
		}
		session.clear();
		Ticket ticket = new Ticket();
		ticket.setId(id);
		session.delete(ticket);
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	
/**
 * updates the ticket entry at the specified id
 * @param id the id of the ticket to be updated
 * @param field the field to be updated
 * @param value the value to be updated at that field
 */
	protected void update(long id, String field, String value) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Ticket ticket1 = session.get(Ticket.class, id);
		session.clear();
		Ticket ticket = new Ticket();
		ticket.setCreatedBy(ticket1.getCreatedBy());
		ticket.setDescription(ticket1.getDescription());
		ticket.setId(ticket1.getId());
		ticket.setOpenDate(ticket1.getOpenDate());
		ticket.setCloseDate(ticket1.getCloseDate());
		ticket.setTechnician(ticket1.getTechnician());
		ticket.setTitle(ticket1.getTitle());
		ticket.setCompSpecs(ticket1.getCompSpecs());
		
		if (field.equalsIgnoreCase("id")) {
		/*	
			TicketManager manager = new TicketManager();
			try {
				manager.setUp();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			manager.delete(id);
			manager.create(Long.parseLong(value), ticket1.getCreatedBy(), ticket1.getTechnician(), ticket1.getCompSpecs()
					, ticket1.getDescription(), ticket1.getOpenDate(), ticket1.getCloseDate(), ticket1.getTitle());
			manager.close();
			session.close();
			return;
*/
			
		} else if (field.equalsIgnoreCase("createdBy")) {
			ticket.setCreatedBy(value);
		} else if (field.equalsIgnoreCase("technician")) {
			ticket.setTechnician(value);
		} else if(field.equalsIgnoreCase("description")) {
			ticket.setDescription(value);
		}else if(field.equalsIgnoreCase("openDate")){
			ticket.setOpenDate(value);
		}else if(field.equalsIgnoreCase("closeDate")){
			ticket.setCloseDate(value);
		}else if(field.equalsIgnoreCase("title")){
			ticket.setTitle(value);
		}else if(field.equalsIgnoreCase("compSpecs")){
			ticket.setCompSpecs(value);
		}else if(field.equalsIgnoreCase("problemCatagory")){
			ticket.setProblemCatagory(value);
		}else if(field.equalsIgnoreCase("deviceType")){
			ticket.setDeviceType(value);
		}else if(field.equalsIgnoreCase("email")){
			ticket.setEmail(value);
		}else{
			System.out.println("invalid command please enter a valid field");
		}

		session.update(ticket);
		session.getTransaction().commit();
		session.close();
	}

}

