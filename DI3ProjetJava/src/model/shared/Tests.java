package model.shared;

import model.mainapp.Department;
import model.mainapp.Employee;

public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Shared model\n");
		
		Department B = new Department("JavaTech");
		B.addEmployee(new Employee());
		B.addEmployee(new Employee());
		B.addEmployee(new Employee());
		B.getEmployee(2).setFirstName("Theo");
		B.getEmployee(2).setLastName("Boisseau");
		
		Employee employeeToCopy = B.getEmployee(2);
		EmployeeInfo infoEmployee = new EmployeeInfo(employeeToCopy.getID(), employeeToCopy.getFirstName(), employeeToCopy.getLastName());
		
		System.out.println(infoEmployee);
	}
}
