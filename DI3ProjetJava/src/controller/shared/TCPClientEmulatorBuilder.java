package controller.shared;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import controller.emulator.EmulatorSettings;
import model.shared.CheckInOut;

public class TCPClientEmulatorBuilder {
	
	protected Socket s; 
	protected InetSocketAddress isA; 
	protected CheckInOut checkInOut;
	protected transient OutputStream sOut;
	protected transient ObjectOutputStream oos;
	
	TCPClientEmulatorBuilder(CheckInOut checkInOutToSend) { 
		s = null; 
		isA = null; 
		sOut = null;
		oos = null;
		checkInOut = new CheckInOut();
		checkInOut = checkInOutToSend;
	} 
	
	protected void setSocket() throws IOException { 
		isA = new InetSocketAddress(EmulatorSettings.getIPaddress(),EmulatorSettings.getNumPort()); 
		s = new Socket(isA.getHostName(), isA.getPort());
		/** we can include more setting, later … */ 
	} 

}
