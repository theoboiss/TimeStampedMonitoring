package controller.shared;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

import controller.emulator.EmulatorSettings;
import model.shared.CheckInOut;

public class TCPClientEmulatorBuilder {
	
	protected InetAddress IPaddress;
	protected int numPort;
	protected Socket s; 
	protected InetSocketAddress isA; 
	protected ArrayList<CheckInOut> checkInOut;
	protected transient InputStream sIn;
	protected transient ObjectInputStream ois;
	protected transient OutputStream sOut;
	protected transient ObjectOutputStream oos;
	protected transient boolean isWaitingCheckList;
	
	TCPClientEmulatorBuilder(CheckInOut checkInOutToSend, InetAddress IPaddress, int numPort) {
		this.IPaddress = IPaddress;
		this.numPort = numPort;
		s = null; 
		isA = null; 
		sOut = null;
		oos = null;
		isWaitingCheckList = false;
		checkInOut = new ArrayList<CheckInOut>();
		checkInOut.add(checkInOutToSend);
		checkInOutToSend.setStatus(false);
	} 
	
	TCPClientEmulatorBuilder(EmulatorSettings emulator, ArrayList<CheckInOut> checkInOutToSend, InetAddress IPaddress, int numPort) {
		this.IPaddress = IPaddress;
		this.numPort = numPort;
		s = null; 
		isA = null; 
		sOut = null;
		oos = null;
		isWaitingCheckList = true;
		checkInOut = checkInOutToSend;
	} 
	
	protected void setSocket() throws IOException { 
		isA = new InetSocketAddress(IPaddress, numPort); 
		s = new Socket(isA.getHostName(), isA.getPort());

	} 

}
