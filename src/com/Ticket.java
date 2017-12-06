package com.TicketingSystem;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  this class contains the information for a ticket
 * @author Gavin
 *
 */
@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	private long id;
	private String createdBy;
	private String technician;
	private String compSpecs;
	private String description;
	private String openDate;
	private String closeDate;
	private String title;
	private String problemCatagory;
	private File photo;
	private String deviceType;
	private String email;
	

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public Ticket(){
		
	}
	
	public Ticket(long id, String createdBy, String technician, String compSpecs, String description, String openDate, String closeDate, String title, String problemCatagory,String deviceType,String email){
		this.id = id;
		this.createdBy = createdBy;
		this.technician = technician;
		this.compSpecs = compSpecs;
		this.description = description;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.title = title;
		this.problemCatagory = problemCatagory;
		this.deviceType = deviceType;
		this.email = email;
		
	}
	
	public Ticket(long id, String createdBy, String technician, String compSpecs, String description, String openDate, String closeDate, String title, String problemCatagory,String deviceType,String email,File photo){
		this.id = id;
		this.createdBy = createdBy;
		this.technician = technician;
		this.compSpecs = compSpecs;
		this.description = description;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.title = title;
		this.problemCatagory = problemCatagory;
		this.deviceType = deviceType;
		this.email = email;
		this.photo = photo;

	}
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getTechnician() {
		return technician;
	}

	public void setTechnician(String technician) {
		this.technician = technician;
	}

	public String getCompSpecs() {
		return compSpecs;
	}
	public String getProblemCatagory(){
		return problemCatagory;
	}

	public void setCompSpecs(String compSpecs) {
		this.compSpecs = compSpecs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setProblemCatagory(String problemCatagory){
		this.problemCatagory = problemCatagory;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setDeviceType(String device){
		deviceType = device;
	}
	
	public String getDeviceType(){
		return deviceType;
	}
}
