package controller.shared;

import java.io.*;
import java.net.InetAddress;
import java.util.ArrayList;

import model.mainapp.Employee; 

public class TCPClientMainApp extends TCPClientMainAppBuilder implements Runnable {
	
	
	 public TCPClientMainApp(ArrayList<Employee> listEmployees, InetAddress IPaddress, int numPort) {
		super(listEmployees, IPaddress, numPort);
	}

	public void run() { 

		 try  { 
			 System.out.println("The client mainApp launched...");
			 setSocket(); 
			 System.out.println("Hello, the client mainApp is connected");
			 sOut = s.getOutputStream();
			 oos = new ObjectOutputStream(sOut);
			 oos.writeObject(listEmployees);
			 oos.flush();
			 oos.close();
			 s.close();
		 } catch(IOException e) { 
			 System.out.println("IOException TCPClientMainApp" + e.getMessage());  
		 } 
	}
	 
}
