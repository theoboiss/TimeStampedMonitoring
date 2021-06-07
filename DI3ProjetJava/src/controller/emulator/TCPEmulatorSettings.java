package controller.emulator;

import java.net.InetAddress;


public abstract class TCPEmulatorSettings {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	protected static InetAddress IPaddress;
	protected static int numPort;
	
	
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
