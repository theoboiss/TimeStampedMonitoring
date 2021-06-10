package controller.shared;

import java.io.*;
import java.net.InetAddress; 

class TCPClientMainApp extends TCPClientMainAppBuilder implements Runnable {
	
	
	 TCPClientMainApp(InetAddress IPaddress, int numPort) {
		super(IPaddress, numPort);
	}

	public void run() { 
		 /*
		 try  { 
				 System.out.println("TCPClientMainApp launched ...");
				 setSocket(); 
				 System.out.println("Hello, the client mainApp is connected");
				 while(true) {
					 
				 }
				 //receive(s);
		 } catch(IOException e) { 
			 System.out.println("IOException TCPClientMainApp" + e.getMessage()); 
				 
		 } catch (ClassNotFoundException e) {

			 System.out.println("ClassNotFoundException TCPClientMainApp" + e.getMessage()); 
		 } */
	 }
	 
}
