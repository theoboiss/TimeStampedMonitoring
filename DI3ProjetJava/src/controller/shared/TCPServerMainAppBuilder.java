package controller.shared;

import java.net.*;

import controller.emulator.EmulatorSettings;

import java.io.*; 

public class TCPServerMainAppBuilder {

	protected ServerSocket ss; protected Socket s; // the passive and active sockets 
	protected InetSocketAddress isA; // the address 
	protected transient InputStream sIn;
	protected transient ObjectInputStream ois;
	  
	TCPServerMainAppBuilder() { 
		ss = null; s = null; 
		isA = null; 
		sIn = null;
		ois = null;
	} 
	 
	public void setSocket() throws IOException { 
		
		isA = new InetSocketAddress(EmulatorSettings.getIPaddress(),EmulatorSettings.getNumPort());
		ss = new ServerSocket(isA.getPort());
		//ss.setSoTimeout(10000);
		 
	}

}