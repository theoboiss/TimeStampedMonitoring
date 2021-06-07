package controller.shared;

import java.io.IOException;

public class TCPServerEmulatorHello extends TCPServerEmulatorBuilder implements Runnable {
	
	public void run( ) { 
		 try { 
			 setSocket(); ssInfo("The server emulator sets the passive socket", ss); 
			 s = ss.accept(); sInfo("The server emulator accepts the connexion",s); 
			 s.close(); sInfo("The server emulator closes a connexion",s); 
			 ss.close(); ssInfo("The server emulator closes the passive socket", ss);
		 } 
		 catch(IOException e) 
		 	{ System.out.println("IOException TCPServerEmulatorHello"); } 
	 } 

}
