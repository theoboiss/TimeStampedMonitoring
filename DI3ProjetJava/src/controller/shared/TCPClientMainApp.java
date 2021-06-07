package controller.shared;

import java.io.*; 

class TCPClientMainApp extends TCPClientMainAppBuilder implements Runnable {
	
	 public void run() { 
		 try { 
				 System.out.println("TCPClientMainApp launched ...");
				 setSocket(); 
				 System.out.println("Hello, the client mainApp is connected");
				 send(s, isA);
		 } 
		 catch(IOException e) 
		 	{ 
				 System.out.println("IOException TCPClientMainApp"); 
				 try {
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
		 	} 
	 }
	 
}
