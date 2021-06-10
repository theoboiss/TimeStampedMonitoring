package controller.shared;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.util.ArrayList;

import model.mainapp.Employee;


public class TCPServerEmulator extends TCPServerEmulatorBuilder implements Runnable {
	
	public TCPServerEmulator(InetAddress IPaddress, int numPort) {
		super(IPaddress, numPort);
	}

	public void run( ) { 
		try { 
			 System.out.println("TCPServerEmulator launched ..."); 
			 setSocket();
			 while(true) { 
				 s = ss.accept();
				 System.out.println("Hello, the server Emulator accepts");
				 sIn = s.getInputStream();
				 ois = new ObjectInputStream(sIn);
				 ArrayList<Employee> listEmployees = (ArrayList<Employee>) ois.readObject();
				 System.out.println("Server emulator received : " + listEmployees.toString());
				 ois.close();
				 s.close();
			 }

		 	} catch(IOException e) { 
		 		System.out.println("IOException TCPServerMainApp : " + e.getMessage());
		 	} catch (ClassNotFoundException e) {
		 		System.out.println("ClassNotFoundException TCPServerMainApp : " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception TCPServerMainApp : " + e.getMessage());
			} 
	}
}
