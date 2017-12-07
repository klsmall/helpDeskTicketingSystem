package com.csci490.javaee;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/*
 * Author: Kimberly Small
 * Last Revised: December 4, 2017
 * Description: This is the email manager for the contact page.
 * 
 */
public class EmailManager 
{
	//Define the necessary variables
	Properties properties = new Properties();
	static Session emailSession;
	static MimeMessage emailMessage;
	
	//Define the properties needed for accessing the GMail SMTP Server
	static String host = "smtp.gmail.com";
	String port = "587";
	static String userEmail = "@gmail.com"; //Enter a gmail email here
	static String userPassword = " "; //Enter the password for the gmail account
	String toEmail = " "; //Enter the receiver's email
		
	public void setMailServerProperties()
	{
		properties = System.getProperties();
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", host);
	}
	
	//This will create a new email using the data from the contact form
	public void createEmailMessage(String emailSubject, String emailBody) throws AddressException, MessagingException
	{
		emailSession = Session.getDefaultInstance(properties, null);
		emailMessage = new MimeMessage(emailSession);
		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");
	}
	
	//Responsible for sending the contact form to the company email	
	public void sendEmail() throws AddressException, MessagingException
	{			
		Transport transport = emailSession.getTransport("smtp");
		transport.connect(host, userEmail, userPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
	}
}
