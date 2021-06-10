package controller.shared;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServerEmulatorBuilder extends ExchangeViaSocket {
	
	protected InetAddress IPaddress;
	protected int numPort;
	protected ServerSocket ss; protected Socket s; // the passive and active sockets 
	protected InetSocketAddress isA; // the address 
	  
	TCPServerEmulatorBuilder(InetAddress IPaddress, int numPort) { 
		this.IPaddress = IPaddress;
		this.numPort = numPort;
		ss = null; s = null; 
		isA = null; 
		sIn = null;
		sOut = null;
		ois = null;
		oos = null;
	} 
	 
	public void setSocket() throws IOException { 
		
		isA = new InetSocketAddress(IPaddress,numPort);
		ss = new ServerSocket(isA.getPort());
		s = ss.accept(); 
	}

}
