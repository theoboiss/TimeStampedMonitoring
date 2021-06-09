package controller.mainapp;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;


public abstract class TCPMainAppSettings implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	protected static InetAddress IPaddress;
	protected static int numPort;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public TCPMainAppSettings() {
		byte[] ipAddr = new byte[]{127, 0, 0, 3};
		
		try {
			setIPaddress(InetAddress.getByAddress(ipAddr)); // to change when it will be possible to serialize
			setNumPort(8085); // to change when it will be possible to serialize
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
