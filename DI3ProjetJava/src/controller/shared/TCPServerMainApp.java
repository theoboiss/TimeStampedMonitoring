package controller.shared;

import java.io.*; 

public class TCPServerMainApp extends TCPServerMainAppBuilder implements Runnable {
	
	public void run( ) { 
		 try { 
			 System.out.println("TCPServerMainApp launched ..."); 
			 setSocket();
			 do { 
				 System.out.println("Hello, the server mainApp accepts");
				 sIn = s.getInputStream();
				 sIn.read();
			 } while(true);
			 
		 } 
		 catch(IOException e) 
		 	{ 
			 System.out.println("IOException TCPServerMainApp");
			 try {
				s.close();
				ss.close(); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			} 
	 }

}