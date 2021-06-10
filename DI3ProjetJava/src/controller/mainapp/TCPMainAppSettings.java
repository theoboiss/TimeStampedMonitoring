package controller.mainapp;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;


public abstract class TCPMainAppSettings implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	protected InetAddress IPaddress;
	protected int numPort;
	
	
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
	public InetAddress getIPaddress() {
		return IPaddress;
	}
	/**
	 * @param iPaddress the iPaddress to set
	 */
	public void setIPaddress(InetAddress iPaddress) {
		this.IPaddress = iPaddress;
	}
	
	/****************************** numPort ******************************/
	
	/**
	 * @return the numPort
	 */
	public int getNumPort() {
		return numPort;
	}
	/**
	 * @param numPort the numPort to set
	 */
	public void setNumPort(int numPort) {
		this.numPort = numPort;
	}

}
