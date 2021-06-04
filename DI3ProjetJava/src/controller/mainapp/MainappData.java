package controller.mainapp;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.mainapp.*;

public abstract class MainappData {
	/*********************************************************************/
	/*************************** STATIC METHODS **************************/
	/*********************************************************************/
	
	public static void save(String fileName, Company companyToSave) throws IOException {
		final FileOutputStream fichierOut = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fichierOut);
		oos.writeObject(companyToSave);
		oos.flush();
		oos.close();
	}
	
	public static Company restore(String fileName) throws ClassNotFoundException, EOFException, IOException {
		final FileInputStream fichierIn = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fichierIn);
		Company newModel = (Company) ois.readObject();
		ois.close();
		
		//set up the listUsedIDs
		for (Department departementTemp : newModel.getListDepartment()) {
			for (Integer employeeID : departementTemp.getListEmployees().keySet()) {
				Employee.addUsedIDToList(employeeID);
			}
		}
		return newModel;
	}
}
