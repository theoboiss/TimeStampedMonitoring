package model.mainapp;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.mainapp.MainappData;

import model.shared.CheckInOut;

public class Tests {
	public static void main(String[] args) throws IOException{
		System.out.println("Hello from Test from model.mainapp\n");

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		try {
			MainappData savingProcess;
			savingProcess = new MainappData();
			savingProcess.save(companyToSave);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
