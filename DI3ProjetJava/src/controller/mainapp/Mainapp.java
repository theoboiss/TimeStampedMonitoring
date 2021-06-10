package controller.mainapp;

import java.io.IOException;

import controller.shared.TCPServerMainApp;
import controller.emulator.EmulatorSettings;
import controller.shared.TCPClientMainApp;
import controller.shared.TCPServerEmulator;
import model.mainapp.Company;
import model.mainapp.Department;
import model.mainapp.Employee;
import model.mainapp.SearchInMainapp;
import model.shared.CheckInOut;
import view.mainapp.ViewMainApp;


public class Mainapp extends MainappSettings {
	
	private static final long serialVersionUID = -6925599295800017000L;

	/****************************** BUILDERS *****************************/
	
	public Mainapp(MainappSettings mainappSettingsSaved, MainappBackup mainappRestorationProcess) {
		super(mainappSettingsSaved, mainappRestorationProcess);
	}

	public Mainapp(String backupFileName) {
		super(backupFileName);
	}

	
	/**************************** MAIN METHOD ****************************/
	
	public static void main(String[] args) {
		String target = "backupMainapp/serializedData.ser";
		MainappBackup restorationProcess = new MainappBackup();
		MainappSettings mainappSaved = null;
		
		try {
			mainappSaved = (MainappSettings) restorationProcess.restore(lastModifiedFileRelatedTo(target), 1);
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassCastException e) { System.out.println("Information : backup did not contain settings data."); }
		
		if (mainappSaved != null)
			new Mainapp(mainappSaved, restorationProcess);
		else 
			new Mainapp(lastModifiedFileRelatedTo(target));
		
		
		new ViewMainApp();
		EmulatorSettings emulator = new EmulatorSettings();
		new Thread(new TCPServerEmulator(emulator, emulator.getIPaddressServer(), emulator.getNumPortServer())).start(); //just test, to suppress
		new Thread(new TCPServerMainApp(mainappSaved.getIPaddressServer(), mainappSaved.getNumPortServer())).start();
		try {
			new Thread(new TCPClientMainApp(mainappSaved.getEmployeeInfo(), mainappSaved.getIPaddressClient(), mainappSaved.getNumPortClient())).start();
		} catch (Exception e) {
			System.out.println("Exception in Mainapp main : " + e.getMessage());
		}
		
		/*
		Company companyToSave = null;
		
		try {
			companyToSave = new Company();
			Department A = new Department("PolyGame");
			Department B = new Department("JavaTech", new Employee("default", "RH"));
			companyToSave.addDepartment(A); companyToSave.addDepartment(B);

			//add few checks to A
			
			CheckInOut exempleCheck1 = new CheckInOut();
			exempleCheck1.setEmployeeID(1);
			SearchInMainapp.searchEmployee(A,1).getListChecks().add(exempleCheck1);
			CheckInOut exempleCheck2 = new CheckInOut();
			SearchInMainapp.searchEmployee(A,1).getListChecks().add(exempleCheck2);
			exempleCheck2.setEmployeeID(1);
			CheckInOut exempleCheck3 = new CheckInOut();
			SearchInMainapp.searchEmployee(A,1).getListChecks().add(exempleCheck3);
			exempleCheck3.setEmployeeID(1);
			
			//add few employees to B
			B.addEmployee(new Employee("test","default"));
			B.addEmployee(new Employee("default3","test"));
	
			SearchInMainapp.searchEmployee(B,"default",1).get(0).setFirstname("Theo");
			SearchInMainapp.searchEmployee(B,"Theo","default").get(0).setLastname("Boisseau");
		}
		catch (Exception e) {};
		
		setCurrentModel(companyToSave);*/
	}
}
