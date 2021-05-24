package model.shared;

import model.mainapp.Department; //ONLY FOR THE TEST
import model.mainapp.Employee; //ONLY FOR THE TEST

public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Shared model\n");
		

		Integer IDOfEmployeeToCopy = 1;
		try {
			Department A = new Department("JavaTech", new Employee("Mr.", "Boss"));
			Employee employeeToCopy = A.searchEmployee(IDOfEmployeeToCopy);
			
			EmployeeInfo infoEmployee = new EmployeeInfo(employeeToCopy.getID(), employeeToCopy.getFirstName(), employeeToCopy.getLastName());
			System.out.println(infoEmployee);
		} catch (Exception e) {
			System.out.println("No employee with ID="+IDOfEmployeeToCopy);
		}
	}
}
