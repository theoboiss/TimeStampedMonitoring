package model.shared;

import model.mainapp.Department;
import model.mainapp.Employee;

public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Shared model\n");
		
		Department A = new Department("JavaTech", new Employee("Le", "Patron"));

		Integer IDOfEmployeeToCopy = 1;
		try {
			Employee employeeToCopy = A.searchEmployee(IDOfEmployeeToCopy);
			
			EmployeeInfo infoEmployee = new EmployeeInfo(employeeToCopy.getID(), employeeToCopy.getFirstName(), employeeToCopy.getLastName());
			System.out.println(infoEmployee);
		} catch (RuntimeException e) {
			System.out.println("No employee with ID="+IDOfEmployeeToCopy);
		}
	}
}
