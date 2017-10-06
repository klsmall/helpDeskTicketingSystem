package com.TicketingSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * this class manages the transformation of a user object to a database entry into the
 * mysql database
 * @author Gavin
 *
 */
public class UserManager {

	protected SessionFactory sessionFactory;

	/**
	 * sets up the factory for the UserManager object
	 * 
	 */
	protected void setUp() {
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
	 * closes the session factory
	 */
	protected void close() {
		sessionFactory.close();
	}

	
	/**
	 * creates a new user entry out of the provided user information
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param priv the privilege level of the user
	 */
	protected void create(String username, String password, short priv) {
		User user = new User(username, password, priv);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * locates the user entry in the database and will return it but currently just prints it.
	 * @param username the username of the user
	 */
	protected void read(String username) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user = session.get(User.class, username);

		if (user != null) {
			System.out.println("Username: " + user.getUsername() + " Password: " + user.getPassword()
					+ " privilege level: " + user.getPriv());
		} else {
			System.out.println("entry " + username + " could not be found");
		}

		session.close();
	}
	
	/**
	 * deletes the user entry with that user name in the database
	 * @param username the username of the user
	 */
	protected void delete(String username) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user1 = session.get(User.class, username);
		if (user1 == null) {
			System.out.println("entry " + username + " could not be found");
			return;
		}
		session.clear();
		User user = new User();
		user.setUsername(username);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	
/**
 * updates the user entry of the user at that username in the database
 * @param username the username of the user
 * @param field the field to be updated
 * @param value the value to be updated in that field
 */
	protected void update(String username, String field, String value) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		User user1 = session.get(User.class, username);
		session.clear();
		User user = new User();
		user.setPassword(user1.getPassword());
		user.setPriv(user1.getPriv());
		user.setUsername(user1.getUsername());
		
		if (field.equalsIgnoreCase("username")) {
			user.setUsername(value);
		} else if (field.equalsIgnoreCase("password")) {
			user.setPassword(value);
		} else if (field.equalsIgnoreCase("priv")) {
			user.setPriv( Short.parseShort(value));
		} else {
			System.out.println("invalid command please enter a valid field");
		}

		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

}
