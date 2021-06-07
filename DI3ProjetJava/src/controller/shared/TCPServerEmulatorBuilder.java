package controller.shared;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import controller.emulator.EmulatorSettings;

public class TCPServerEmulatorBuilder extends TCPInfo {
	
	protected ServerSocket ss; protected Socket s; // the passive and active sockets 
	protected InetSocketAddress isA; // the address 
	//protected InputStream in;
	  
	TCPServerEmulatorBuilder() { 
		ss = null; s = null; 
		isA = null; 
		//in = null;
	} 
	 
	public void setSocket() throws IOException { 
		
		isA = new InetSocketAddress(EmulatorSettings.getIPaddress(),EmulatorSettings.getNumPort());
		ss = new ServerSocket(isA.getPort());
		//setStreamBuffer(ss.getReceiveBufferSize());
		//s = ss.accept(); 
	}

}
