package view.mainapp;

import java.util.concurrent.CopyOnWriteArrayList;

public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Main view\n");
		
		CopyOnWriteArrayList<Employee> listEmployees = new CopyOnWriteArrayList<>();
		
		listEmployees.add(new Employee("Barney", "Stinson"));
		listEmployees.add(new Employee("Ted", "Mosby"));
		listEmployees.add(new Employee("Rachel", "Green"));
		listEmployees.add(new Employee("Joey", "Tribiani"));
		listEmployees.add(new Employee("Jesse", "Pinkman"));

		System.out.println("UsedIDs ="+Employee.getlistUsedIDs());
		for (Integer Iterator = 0; Iterator < 5; Iterator++)
		{
			System.out.println(listEmployees.get(Iterator).toString());
		}
	}
}
