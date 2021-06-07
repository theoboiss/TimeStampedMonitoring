package controller.shared;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import controller.emulator.EmulatorSettings;

public class TCPClientEmulatorBuilder extends ExchangeViaSocket {
	
	protected Socket s; 
	protected InetSocketAddress isA; 
	
	TCPClientEmulatorBuilder() { 
		s = null; 
		isA = null; 
		sOut = null;
	} 
	
	protected void setSocket() throws IOException { 
		isA = new InetSocketAddress(EmulatorSettings.getIPaddress(),EmulatorSettings.getNumPort()); 
		s = new Socket(isA.getHostName(), isA.getPort());
		/** we can include more setting, later … */ 
	} 

}
