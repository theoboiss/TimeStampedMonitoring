package controller.shared;

import java.io.IOException;
import java.io.ObjectInputStream;
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
		boolean dataSent = false;
		do {
			 try { 
				 System.out.println("TCPClientEmulator launched ...");
				 setSocket(); 
				 System.out.println("Hello, the client emulator is connected"); 
				 sOut = s.getOutputStream();
				 oos = new ObjectOutputStream(sOut);
				 oos.writeObject(checkInOut);
				 oos.flush();
				 sIn = s.getInputStream();
				 ois = new ObjectInputStream(sIn);
				 if(ois.readBoolean()) {
					 dataSent = true;
				 }				 
				 oos.close();
				 ois.close();
				 s.close();
				 checkInOut.removeAll(checkInOut);
			 } catch(IOException e) { 
					 System.out.println("IOException TCPClientEmulator : " + e.getMessage());
					 if(this.s != null && s.isConnected()) {
						 try {
							s.close();
						} catch (IOException e1) {
							System.out.println("IOException TCPClientEmulator : " + e1.getMessage());
						}
					 }
					 try {
						Thread.sleep(10000);
					} catch (InterruptedException e1) {
						System.out.println("InterruptedException TCPClientEmulator : " + e1.getMessage());
					}
			 }
		} while(isWaitingCheckList && !dataSent);
	 } 
	
}
