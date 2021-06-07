package controller.shared;

import java.io.*; 

class TCPClientMainAppHello extends TCPClientMainAppBuilder implements Runnable {
	
	 public void run() { 
		 try { 
			 setSocket(); 
			 sInfo("The clients mainApp is connected",s); 
			 s.close(); sInfo("The client mainApp is disconnected",s);
		 } 
		 catch(IOException e) 
		 	{ System.out.println("IOException TCPClientMainAppHello"); } 
	 } 
	 
}
