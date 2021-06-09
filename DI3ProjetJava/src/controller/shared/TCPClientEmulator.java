package controller.shared;

import java.io.IOException;
import java.io.ObjectOutputStream;

import model.shared.CheckInOut;

public class TCPClientEmulator extends TCPClientEmulatorBuilder implements Runnable {

	public TCPClientEmulator(CheckInOut checkInOutToSend) {
		super(checkInOutToSend);
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
