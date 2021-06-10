package controller.shared;

import java.net.*;

import controller.mainapp.MainappSettings;

import java.io.*; 

public class TCPClientMainAppBuilder extends ExchangeViaSocket {
	
	protected InetAddress IPaddress;
	protected int numPort;
	protected Socket s; 
	protected InetSocketAddress isA; 
	
	TCPClientMainAppBuilder(InetAddress IPaddress, int numPort) { 
		this.IPaddress = IPaddress;
		this.numPort = numPort;
		s = null; 
		isA = null; 
		sOut = null;
		sIn = null;
		ois = null;
		oos = null;
	} 
	
	protected void setSocket() throws IOException { 
		isA = new InetSocketAddress(IPaddress, numPort); 
		s = new Socket(isA.getHostName(), isA.getPort());
		//s.setSoTimeout(1000);

		/** we can include more setting, later … */ 
	} 

}