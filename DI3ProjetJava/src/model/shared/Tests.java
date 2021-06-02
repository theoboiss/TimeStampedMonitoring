package model.shared;

import model.mainapp.Department; //ONLY FOR THE TEST
import model.mainapp.Employee; //ONLY FOR THE TEST
import model.mainapp.SearchInMainapp; //ONLY FOR THE TEST

public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Shared model\n");
		

		Integer IDOfEmployeeToCopy = 1;
		try {
			Department A = new Department("JavaTech", new Employee("Mr.", "Boss"));
			Employee employeeToCopy = SearchInMainapp.searchEmployee(A,IDOfEmployeeToCopy);
			
			EmployeeInfo infoEmployee = new EmployeeInfo(employeeToCopy.getID(), employeeToCopy.getFirstname(), employeeToCopy.getLastname());
			System.out.println(infoEmployee);
		} catch (Exception e) {
			System.out.println("No employee with ID="+IDOfEmployeeToCopy);
		}
	}
}
