package controller.mainapp;

import java.io.IOException;

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
		
	}
}
