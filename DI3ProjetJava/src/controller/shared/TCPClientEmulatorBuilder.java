package controller.shared;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import controller.emulator.EmulatorSettings;
import model.shared.CheckInOut;

public class TCPClientEmulatorBuilder extends ExchangeViaSocket {
	
	protected Socket s; 
	protected InetSocketAddress isA; 
	protected CheckInOut checkInOut;
	
	TCPClientEmulatorBuilder(CheckInOut checkInOutToSend) { 
		s = null; 
		isA = null; 
		sIn = null;
		sOut = null;
		ois = null;
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
