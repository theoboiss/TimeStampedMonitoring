package controller.shared;

import java.io.IOException;

public class TCPClientEmulatorHello extends TCPClientEmulatorBuilder implements Runnable {

	 public void run() { 
		 try { 
			 setSocket(); 
			 sInfo("The clients emulator is connected",s); 
			 s.close(); sInfo("The client emulator is disconnected",s);
		 } 
		 catch(IOException e) 
		 	{ System.out.println("IOException TCPClientEmulatorHello"); } 
	 } 
	
}
