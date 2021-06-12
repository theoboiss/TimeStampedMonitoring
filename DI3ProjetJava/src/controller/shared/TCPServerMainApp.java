package controller.shared;

import java.io.*;
import java.net.InetAddress;
import java.util.ArrayList;

import controller.mainapp.Mainapp;
import model.shared.CheckInOut; 
import model.mainapp.*;

/**
 * 
 * @brief Class which represents a server tcp from the main application.
 * 		  Extends TCPServerMainAppBuilder.
 * @implNote Runnable.
 *
 */
public class TCPServerMainApp extends TCPServerMainAppBuilder implements Runnable {
	
	public TCPServerMainApp(InetAddress IPaddress, int numPort) {
		super(IPaddress, numPort);
	}
	
	/**
	 * @brief Method which add the received data in the database of the main application.
	 * @param readChecks
	 */
	public static void addChecksToMainApp(ArrayList<CheckInOut> readChecks) {
		if (readChecks != null) {
			for (int i = 0; i < readChecks.size(); i++) {
				Employee employee = SearchInMainapp.searchEmployee(Mainapp.getCurrentModel(), readChecks.get(i).getEmployeeID());
				 if (employee != null) {
					 try {
						Mainapp.getCurrentModel().getDepartment(employee.getDepartment()).getListEmployees().get(employee.getID()).getListChecks().add(readChecks.get(i));
						System.out.println("Server mainapp received : " + readChecks.get(i).toString());
					} catch (Exception e) {
						System.out.println("Exception TCPServerMainApp : " + e.getMessage());
					}
					 
				 }
			}
		} else {
			System.out.println("No checks to save");
		}
	}

	/**
	 * @apiNote The server always run, until there is an exception.
	 */
	public void run( ) { 
		 try { 
			 System.out.println("TCPServerMainApp launched ..."); 
			 setSocket();
			 while(true) { 
				 s = ss.accept();
				 System.out.println("Hello, the server mainApp accepts");
				 sIn = s.getInputStream();
				 ois = new ObjectInputStream(sIn);
				 ArrayList<CheckInOut> readChecks = (ArrayList<CheckInOut>) ois.readObject();
				 addChecksToMainApp(readChecks);
				 System.out.println("ServerMainApp received : " + readChecks.toString());
				 sOut = s.getOutputStream();
				 oos = new ObjectOutputStream(sOut);
				/*while data have been received the server send a response
				  to the client */
				 oos.writeBoolean(true);  
				 oos.flush();
				 ois.close();
				 s.close();
			 }

		 	} catch(IOException e) { 
		 		System.out.println("IOException TCPServerMainApp : " + e.getMessage());
		 	} catch (ClassNotFoundException e) {
		 		System.out.println("ClassNotFoundException TCPServerMainApp : " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception TCPServerMainApp : " + e.getMessage());
			} 
	 }

}