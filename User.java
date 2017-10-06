package com.TicketingSystem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  this class contains the information for a user
 * @author Gavin
 *
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	private String username;
	private String password;
	private short priv;

	
	
	public User() {

	}

	public User(String username, String password, short priv) {

		this.password = password;
		this.priv = priv;
		this.username = username;
		

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short getPriv() {
		return priv;
	}

	public void setPriv(short priv) {
		this.priv = priv;
	}

}
