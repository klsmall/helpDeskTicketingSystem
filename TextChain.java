package com.TicketingSystem;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "textChain")
public class TextChain {
	//private TextMsg msg;
	private ArrayList<TextMsg> list;
	@Id
	private long id;
	
	public TextChain(){
	 list = new ArrayList<TextMsg>();	
	}
	
	public TextChain(long id){
		list = new ArrayList<TextMsg>();
		this.id =id;
	}
	
	public void addMsg(String sender, String text){
		TextMsg msg = new TextMsg(sender, text);
		list.add(msg);
	}
	
	public void setId(long a){
		id = a;
	}
	
	public long getId(){
		return id;
	}
	public TextMsg getMsg(int index){
		if(list.isEmpty()){
			return null;
		}
		return list.get(index-1);
		
	}

}

