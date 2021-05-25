package model.mainapp;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.*;

public class Search {
	
	/*********************************************************************/
	/*************************** RETURN CHECKS ***************************/
	/*********************************************************************/
	static public CopyOnWriteArrayList<CheckInOut> searchCheckInOut(Employee employee, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<CheckInOut> resultList = new CopyOnWriteArrayList<CheckInOut>();
		CopyOnWriteArrayList<CheckInOut> listChecks = employee.getListChecks();
		
		//the most recent checks are in the end of the array so we start searching from there
		for (Integer iterator = listChecks.size()-1; iterator > 0; iterator--) {
			CheckInOut checkTmp = listChecks.get(iterator);
			if (checkTmp.getCheckTime().isAfter(beforeCheck)
			 && checkTmp.getCheckTime().isBefore(afterCheck)) {
				resultList.add(checkTmp);
			}
		}
		
		return resultList;
	}
	
	static public CopyOnWriteArrayList<CheckInOut> searchCheckInOut(Department department, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<CheckInOut> resultList = new CopyOnWriteArrayList<CheckInOut>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			resultList.addAll(searchCheckInOut(currentEmployee,beforeCheck, afterCheck));
		}
		return resultList;
	}
	
	//overall
	static public CopyOnWriteArrayList<CheckInOut> searchCheckInOut(Company company, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<CheckInOut> resultList = new CopyOnWriteArrayList<CheckInOut>();
		//TODO
		return resultList;
	}
	
	
	/*********************************************************************/
	/************************* RETURN EMPLOYEES **************************/
	/*********************************************************************/
	
	/************************ according to check *************************/
	
	static public CopyOnWriteArrayList<Employee> searchEmployee(Department department, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<Employee> resultList = new CopyOnWriteArrayList<Employee>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			if (!searchCheckInOut(currentEmployee,beforeCheck, afterCheck).isEmpty()) {
				resultList.add(currentEmployee);
			}
		}
		return new CopyOnWriteArrayList<Employee>(resultList);
	}
	
	static public CopyOnWriteArrayList<Employee> searchEmployee(Company company, LocalDateTime beforeCheck, LocalDateTime afterCheck); //overall
	//TODO
	
	
	/************************* according to ID ***************************/
	//necessarily only one employee per ID
	
	static public Employee searchEmployee(Department department, Integer ID) {
		return department.getListEmployees().get(ID);
	}
	
	static public Employee searchEmployee(Company company, Integer ID); //overall
	//TODO
	
	
	/************************ according to name **************************/
	
	//per name
	static public CopyOnWriteArrayList<Employee> searchEmployee(Department department, String firstName, String LastName) {
		CopyOnWriteArrayList<Employee> resultList = new CopyOnWriteArrayList<Employee>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			if (currentEmployee.getFirstName().equals(firstName) && currentEmployee.getLastName().equals(LastName)) {
				resultList.add(currentEmployee);
			}
		}
		return new CopyOnWriteArrayList<Employee>(resultList);
	}

	static public CopyOnWriteArrayList<Employee> searchEmployee(Department department, String name) {
		CopyOnWriteArrayList<Employee> resultList = new CopyOnWriteArrayList<Employee>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			if (currentEmployee.getFirstName().equals(name) || currentEmployee.getLastName().equals(name)) {
				resultList.add(currentEmployee);
			}
		}
		return new CopyOnWriteArrayList<Employee>(resultList);
	}
	
	static public CopyOnWriteArrayList<Employee> searchEmployee(Company company, String firstName, String LastName);
	//TODO
	static public CopyOnWriteArrayList<Employee> searchEmployee(Company company, String name); //overall
	//TODO
}
