import java.util.Scanner;

public class Logger { 
	
	
	
	public static void main(String[] args){
		
		
	String DBPass; //Pulled Using DataAccess
	String TempName; //to store entered User Name
	String TempPass;//to store entered Password
	TempName = RetrieveUserName();
	TempPass = RetrievePassword();
	}
	
	public static String RetrieveUserName()
	{
		Scanner in = new Scanner(System.in);
		//pull entered user name to check against data base
		String tempname;
		//do something to pull name from interface
		return (tempname);
	}
	
	public static String RetrievePassword()
	{
		Scanner in = new Scanner(System.in);
		//pull entered password to check against database
		String temppass;
		//do something to pull password from interface
		return (temppass);
		
	}
	public void DBPass()
	{
		
		DBPass = DatabaseAccess(Password,User,TempName==UserName);//pulling pass from database
	}
	
	public int Autentication()
	{
		if(TempPass == DBPass){
		//check entered information against database entries
		return 1;
		}
		return 0;
	}
	
}



