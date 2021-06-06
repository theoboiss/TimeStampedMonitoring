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

	/******************************* save ********************************/

	public void save(String backupFileName, Object dataToSave) throws IOException {
		initialize(new FileOutputStream(backupFileName));
		insert(dataToSave);
	}

	public void save(String backupFileName, Object dataToSave, int streamStatus) throws IOException {
		if (streamStatus > 0)
			initialize(new FileOutputStream(backupFileName));
		else
			initialize(getsOut());
		insert(dataToSave, streamStatus);
	}

	/****************************** restore ******************************/
	
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
	
	public Object restore(String backupFileName, int streamStatus) throws ClassNotFoundException, EOFException, IOException {
		if (streamStatus > 0)
			initialize(new FileInputStream(backupFileName));
		else
			initialize(getsIn());
		Object backup = (Object) extract(streamStatus);
		
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
