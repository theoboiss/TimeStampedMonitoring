package controller.mainapp;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class TCPMainAppSettings implements Serializable {

	private static final long serialVersionUID = 1L;

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	protected InetAddress IPaddressServer;
	protected int numPortServer;

	protected InetAddress IPaddressClient;
	protected int numPortClient;

	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	public TCPMainAppSettings() {
		//byte[] ipAddrS = new byte[] { 127, 0, 0, 3 };
		//byte[] ipAddrC = new byte[] { 127, 0, 0, 2 };

		setIPaddressServer(getIPaddressServer()); // to change when it will be possible to serialize
		setNumPortServer(getNumPortServer()); // to change when it will be possible to serialize
		setIPaddressClient(getIPaddressClient());
		setNumPortClient(getNumPortClient());
	}

	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/************************** IPaddressServer **************************/

	/**
	 * @return the iPaddressServer
	 */
	public InetAddress getIPaddressServer() {
		return IPaddressServer;
	}

	/**
	 * @param iPaddressServer the iPaddressServer to set
	 */
	public void setIPaddressServer(InetAddress iPaddressServer) {
		IPaddressServer = iPaddressServer;
	}

	/*************************** numPortServer ***************************/

	/**
	 * @return the numPortServer
	 */
	public int getNumPortServer() {
		return numPortServer;
	}

	/**
	 * @param numPortServer the numPortServer to set
	 */
	public void setNumPortServer(int numPortServer) {
		this.numPortServer = numPortServer;
	}

	/*************************** IPaddressClient *************************/

	/**
	 * @return the iPaddressClient
	 */
	public InetAddress getIPaddressClient() {
		return IPaddressClient;
	}

	/**
	 * @param iPaddressClient the iPaddressClient to set
	 */
	public void setIPaddressClient(InetAddress iPaddressClient) {
		IPaddressClient = iPaddressClient;
	}

	/**************************** numPortClient **************************/

	/**
	 * @return the numPortClient
	 */
	public int getNumPortClient() {
		return numPortClient;
	}

	/**
	 * @param numPortClient the numPortClient to set
	 */
	public void setNumPortClient(int numPortClient) {
		this.numPortClient = numPortClient;
	}

}
