package controller.mainapp;

import java.net.InetAddress;


public abstract class TCPMainAppSettings {
	
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
		return TCPMainAppSettings.IPaddress;
	}
	/**
	 * @param iPaddress the iPaddress to set
	 */
	public static void setIPaddress(InetAddress iPaddress) {
		TCPMainAppSettings.IPaddress = iPaddress;
	}
	
	/****************************** numPort ******************************/
	
	/**
	 * @return the numPort
	 */
	public static int getNumPort() {
		return TCPMainAppSettings.numPort;
	}
	/**
	 * @param numPort the numPort to set
	 */
	public static void setNumPort(int numPort) {
		TCPMainAppSettings.numPort = numPort;
	}

}
