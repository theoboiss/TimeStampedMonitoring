package controller.shared;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.ArrayList;

import controller.emulator.Emulator;
import controller.emulator.EmulatorSettings;
import model.shared.EmployeeInfo;


public class TCPServerEmulator extends TCPServerEmulatorBuilder implements Runnable {
	
	public TCPServerEmulator(EmulatorSettings emulator, InetAddress IPaddress, int numPort) {
		super(emulator, IPaddress, numPort);
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
				 @SuppressWarnings("unchecked")
				ArrayList<EmployeeInfo> listEmployees = (ArrayList<EmployeeInfo>) ois.readObject();
				 if (listEmployees != null) {
					 Emulator.setListEmployeeInfo(listEmployees);
					 System.out.println("Server emulator received : " + listEmployees.toString());
				 }
				 sOut = s.getOutputStream();
				 oos = new ObjectOutputStream(sOut);
				 oos.writeBoolean(true);
				 oos.flush();
				 ois.close();
				 oos.close();
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
