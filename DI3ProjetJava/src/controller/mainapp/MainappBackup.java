package controller.mainapp;

import java.io.EOFException;
import java.io.IOException;

import controller.shared.SerializationProcess;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import model.mainapp.Company;
import model.mainapp.Department;
import model.mainapp.Employee;

public class MainappBackup extends SerializationProcess {
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/

	public void save(String backupFileName, Object dataToSave) throws IOException {
		initialize(new FileOutputStream(backupFileName));
		insert(dataToSave);
	}
	
	public Object restore(String backupFileName) throws ClassNotFoundException, EOFException, IOException {
		initialize(new FileInputStream(backupFileName));
		Object backup = (Object) extract();
		
		if (backup instanceof Company) {
			//set up the listUsedIDs
			for (Department departementTemp : ((Company) backup).getListDepartment()) {
				for (Integer employeeID : departementTemp.getListEmployees().keySet()) {
					Employee.addUsedIDToList(employeeID);
				}
			}
		}
		
		return backup;
	}
}
