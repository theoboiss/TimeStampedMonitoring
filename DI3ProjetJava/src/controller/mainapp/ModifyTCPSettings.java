package controller.mainapp;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import javax.swing.JTextField;

import view.mainapp.ViewSettings;

/**
 * @brief Class to modify port number and IP address
 *
 */
public class ModifyTCPSettings implements Serializable {

	private static final long serialVersionUID = -8826014027937834304L;
	private String regexPattern;
	private TCPMainAppSettings settings;
	
	
	public ModifyTCPSettings(TCPMainAppSettings settings2)
	{
		this.settings = settings2;	
	}

	/**
	 * @brief Method to modify port number and IP address in the main application
	 * @param request
	 * @return
	 */
	public String ModifyConnectionSettings(HashMap<String, JTextField> request) throws UnknownHostException {

		// extract information from the request
		String newPortNumberServer = request.get("portnumber_server").getText().split(getRegexPattern())[0];
		String newIPAddressServer = request.get("ipaddress_server").getText().split(getRegexPattern())[0];
		
		// Converting strings to the correct form 
		Integer portNumberServerToSet = Integer.parseInt(newPortNumberServer);
		byte[] IPAddressServerToSet = newIPAddressServer.getBytes();

		// Changing elements
		
		settings.setIPaddressServer(InetAddress.getByAddress(IPAddressServerToSet)); // to change when it will be possible to serialize
		settings.setNumPortServer(portNumberServerToSet); // to change when it will be possible to serialize
		//setIPaddressClient(InetAddress.getByAddress(ipAddrC));
		//setNumPortClient(4045);
		
		
		return "Port number and IP address successfully changed.";
	}

	/**
	 * @return the regexPattern
	 */
	public String getRegexPattern() {
		return regexPattern;
	}

	/**
	 * @param regexPattern the regexPattern to set
	 */
	public void setRegexPattern(String regexPattern) {
		this.regexPattern = regexPattern;
	}
}
