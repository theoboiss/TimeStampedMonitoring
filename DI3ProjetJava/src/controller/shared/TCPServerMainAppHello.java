package controller.shared;

import java.io.*; 

public class TCPServerMainAppHello extends TCPServerMainAppBuilder implements Runnable {
	
	public void run( ) { 
		 try { 
			 setSocket(); ssInfo("The server mainApp sets the passive socket", ss); 
			 s = ss.accept(); sInfo("The server mainApp accepts the connexion",s); 
			 s.close(); sInfo("The server mainApp closes a connexion",s); 
			 ss.close(); ssInfo("The server mainApp closes the passive socket", ss);
		 } 
		 catch(IOException e) 
		 	{ System.out.println("IOException TCPServerMainAppHello"); } 
	 } 

}