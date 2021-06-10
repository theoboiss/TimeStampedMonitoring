package controller.shared;

import java.io.IOException;
import java.net.InetAddress;

public class TCPServerEmulator extends TCPServerEmulatorBuilder implements Runnable {
	
	TCPServerEmulator(InetAddress IPaddress, int numPort) {
		super(IPaddress, numPort);
	}

	public void run( ) { 
		 try { 
			 System.out.println("TCPServerEmulator launched ..."); 
			 setSocket(); 
			 do {
				 System.out.println("Hello, the server emulator accepts");
				 receive(s);
				 System.out.println("received");
			 } while(true);
		 } 
		 catch(IOException e) 
		 	{ 
				 System.out.println("IOException TCPServerEmulator"); 
				 try {
					s.close();
					ss.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
		 	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 } 

}
