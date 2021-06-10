package controller.shared;

import java.io.*;

import controller.mainapp.Mainapp;
import controller.mainapp.MainappBackup;
import model.shared.CheckInOut; 
import model.mainapp.*;

public class TCPServerMainApp extends TCPServerMainAppBuilder implements Runnable {
	
	public void run( ) { 
		 try { 
			 System.out.println("TCPServerMainApp launched ..."); 
			 setSocket();
			 while(true) { 
				 s = ss.accept();
				 System.out.println("Hello, the server mainApp accepts");
				 sIn = s.getInputStream();
				 ois = new ObjectInputStream(sIn);
				 CheckInOut readCheck = (CheckInOut) ois.readObject();
				 Employee employee = SearchInMainapp.searchEmployee(Mainapp.getCurrentModel(), readCheck.getEmployeeID());
				 if (employee != null) {
					 Mainapp.getCurrentModel().getDepartment(employee.getDepartment()).getListEmployees().get(employee.getID()).getListChecks().add(readCheck);
					 System.out.println(readCheck);
				 } else {
					 System.out.println("Employee not in mainapp");
				 }
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