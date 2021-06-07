package controller.emulator;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class EmulatorSettings extends TCPEmulatorSettings {
	
	public EmulatorSettings() {
		
		byte[] ipAddr = new byte[]{127, 0, 0, 2};
		
		try {
			setIPaddress(InetAddress.getByAddress(ipAddr)); // to change when it will be possible to serialize
			setNumPort(4045); // to change when it will be possible to serialize
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}

}
