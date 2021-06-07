package controller.shared;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import controller.emulator.EmulatorSettings;

public class TCPClientEmulatorBuilder extends TCPInfo {
	
	protected Socket s; 
	protected InetSocketAddress isA; 
	//protected OutputStream out;
	
	TCPClientEmulatorBuilder() { 
		s = null; 
		isA = null; 
		//out = null;
	} 
	
	protected void setSocket() throws IOException { 
		isA = new InetSocketAddress(EmulatorSettings.getIPaddress(),EmulatorSettings.getNumPort()); 
		s = new Socket(isA.getHostName(), isA.getPort());
		//setStreamBuffer(s.getReceiveBufferSize());
		/** we can include more setting, later … */ 
	} 

}
