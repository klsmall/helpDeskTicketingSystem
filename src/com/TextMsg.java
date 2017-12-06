package com.TicketingSystem;

public class TextMsg {
	private String user;
	private String text;
	private long id;


public TextMsg(String sender,String msg){
	user = sender;
	text = msg;

}

public String getMsg(){
	return text;
}

public String getUser(){
	return user;
}


}
