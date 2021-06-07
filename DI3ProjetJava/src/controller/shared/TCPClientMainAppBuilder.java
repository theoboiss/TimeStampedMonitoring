package controller.shared;

import java.net.*;

import controller.mainapp.MainappSettings;

import java.io.*; 

public class TCPClientMainAppBuilder extends TCPInfo {
	
	protected Socket s; 
	protected InetSocketAddress isA; 
	//protected OutputStream out;
	
	TCPClientMainAppBuilder() { 
		s = null; 
		isA = null; 
		//out = null;
	} 
	
	protected void setSocket() throws IOException { 
		isA = new InetSocketAddress(MainappSettings.getIPaddress(),MainappSettings.getNumPort()); 
		s = new Socket(isA.getHostName(), isA.getPort());
		//setStreamBuffer(s.getReceiveBufferSize());
		/** we can include more setting, later … */ 
	} 

}