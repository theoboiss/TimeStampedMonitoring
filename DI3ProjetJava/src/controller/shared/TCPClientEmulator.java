package controller.shared;

import java.io.IOException;

public class TCPClientEmulator extends TCPClientEmulatorBuilder implements Runnable {

	public void run() { 
		 try { 
			 System.out.println("TCPClientEmulator launched ...");
			 setSocket(); 
			 System.out.println("Hello, the client emulator is connected"); 
		 } 
		 catch(IOException e) 
		 	{ 
				 System.out.println("IOException TCPClientEmulator");
				 try {
					s.close();
				 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
		 	} 
	 } 
	
}
