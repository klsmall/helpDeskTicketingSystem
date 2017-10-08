package com.TicketingSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * this class manages the transformation of a ticket object to a database entry into the
 * mysql database
 * @author Gavin
 *
 */
public class TextChainManager {
	protected SessionFactory sessionFactory;

	protected void setUp() throws Exception {
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
	
	protected void create(long id){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		TextChain chain = new TextChain(id);
		session.save(chain);
		session.getTransaction().commit();
		session.close();
		
	}
	
	protected TextChain read(long id){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		TextChain chain = session.get(TextChain.class, id);
		if(chain != null){
			return chain;
		}
		System.out.println("entry " + id + " could not be found");
		session.close();
		
		return null;
	}
	
	protected void delete(long id){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		TextChain chain = session.get(TextChain.class, id);
		if(chain == null){
			System.out.println("entry " + id + " could not be found");
			return;
		}
		session.clear();
		TextChain chain1 = new TextChain();
		chain1.setId(id);
		session.delete(chain1);
		session.getTransaction().commit();
		session.close();
		
	}
	
	protected void update(long id,String sender, String msg){
		Session session = sessionFactory.getCurrentSession();
		TextChain chain = session.get(TextChain.class, id);
		if(chain !=null){
			chain.addMsg(sender, msg);
		}
		System.out.println("entry " + id + " could not be found");
		session.close();
	}
}