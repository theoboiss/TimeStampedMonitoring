package controller.emulator;

import java.net.InetAddress;
import java.net.UnknownHostException;


public abstract class TCPEmulatorSettings {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	protected static InetAddress IPaddress;
	protected static int numPort;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public TCPEmulatorSettings() {
		byte[] ipAddr = new byte[]{127, 0, 0, 2};
		
		try {
			setIPaddress(InetAddress.getByAddress(ipAddr)); // to change when it will be possible to serialize
			setNumPort(4045); // to change when it will be possible to serialize
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/***************************** IPaddress *****************************/
	
	/**
	 * @return the iPaddress
	 */
	public static InetAddress getIPaddress() {
		return TCPEmulatorSettings.IPaddress;
	}
	/**
	 * @param iPaddress the iPaddress to set
	 */
	public static void setIPaddress(InetAddress iPaddress) {
		TCPEmulatorSettings.IPaddress = iPaddress;
	}
	
	/****************************** numPort ******************************/
	
	/**
	 * @return the numPort
	 */
	public static int getNumPort() {
		return TCPEmulatorSettings.numPort;
	}
	/**
	 * @param numPort the numPort to set
	 */
	public static void setNumPort(int numPort) {
		TCPEmulatorSettings.numPort = numPort;
	}
	
}
