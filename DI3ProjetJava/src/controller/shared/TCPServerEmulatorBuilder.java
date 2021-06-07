package controller.shared;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import controller.mainapp.MainappSettings;

public class TCPServerEmulatorBuilder extends ExchangeViaSocket {
	
	protected ServerSocket ss; protected Socket s; // the passive and active sockets 
	protected InetSocketAddress isA; // the address 
	  
	TCPServerEmulatorBuilder() { 
		ss = null; s = null; 
		isA = null; 
		sIn = null;
	} 
	 
	public void setSocket() throws IOException { 
		
		isA = new InetSocketAddress(MainappSettings.getIPaddress(),MainappSettings.getNumPort());
		ss = new ServerSocket(isA.getPort());
		s = ss.accept(); 
	}

}
