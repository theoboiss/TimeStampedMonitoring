package controller.shared;

import java.net.*;

import controller.mainapp.MainappSettings;

import java.io.*; 

public class TCPServerMainAppBuilder extends TCPInfo {

	protected ServerSocket ss; protected Socket s; // the passive and active sockets 
	protected InetSocketAddress isA; // the address 
	//protected InputStream in;
	  
	TCPServerMainAppBuilder() { 
		ss = null; s = null; 
		isA = null; 
		//in = null;
	} 
	 
	public void setSocket() throws IOException { 
		
		isA = new InetSocketAddress(MainappSettings.getIPaddress(),MainappSettings.getNumPort());
		ss = new ServerSocket(isA.getPort());
		//setStreamBuffer(ss.getReceiveBufferSize());
		//s = ss.accept(); 
	}

}