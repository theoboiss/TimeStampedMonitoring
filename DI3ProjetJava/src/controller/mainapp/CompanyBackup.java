package controller.mainapp;

import java.io.EOFException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import model.mainapp.Company;
import model.mainapp.Department;
import model.mainapp.Employee;

public class CompanyBackup extends SerializationProcess {
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/

	public void save(String backupFileName, Company companyToSave) throws IOException {
		initialize(new FileOutputStream(backupFileName));
		insert(companyToSave);
	}
	
	public Company restore(String backupFileName) throws ClassNotFoundException, EOFException, IOException {
		initialize(new FileInputStream(backupFileName));
		Company backup = (Company) extract();
		
		//set up the listUsedIDs
		for (Department departementTemp : backup.getListDepartment()) {
			for (Integer employeeID : departementTemp.getListEmployees().keySet()) {
				Employee.addUsedIDToList(employeeID);
			}
		}
		return backup;
	}
}
