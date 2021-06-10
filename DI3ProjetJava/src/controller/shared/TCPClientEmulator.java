package controller.shared;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.ArrayList;

import controller.emulator.EmulatorSettings;
import model.shared.CheckInOut;

public class TCPClientEmulator extends TCPClientEmulatorBuilder implements Runnable {

	public TCPClientEmulator(CheckInOut checkInOutToSend, InetAddress IPaddress, int numPort) {
		super(checkInOutToSend, IPaddress, numPort);
	}
	
	public TCPClientEmulator(EmulatorSettings emulator, ArrayList<CheckInOut> checkInOutToSend, InetAddress IPaddress, int numPort) {
		super(emulator, checkInOutToSend, IPaddress, numPort);
	}

	public void run() { 
		 try { 
			 System.out.println("TCPClientEmulator launched ...");
			 setSocket(); 
			 System.out.println("Hello, the client emulator is connected"); 
			 sOut = s.getOutputStream();
			 oos = new ObjectOutputStream(sOut);
			 oos.writeObject(checkInOut);
			 oos.flush();
			 oos.close();
			 s.close();
		 } catch(IOException e) { 
				 System.out.println("IOException TCPClientEmulator : " + e.getMessage());
		 }
	 } 
	
}
