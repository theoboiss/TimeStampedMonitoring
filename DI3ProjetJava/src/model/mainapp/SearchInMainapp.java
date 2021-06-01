package model.mainapp;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.shared.*;

public abstract class SearchInMainapp {
	
	/*********************************************************************/
	/*************************** RETURN CHECKS ***************************/
	/*********************************************************************/
	static public ArrayList<CheckInOut> searchCheckInOut(Employee employee, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		ArrayList<CheckInOut> resultList = new ArrayList<CheckInOut>();
		ArrayList<CheckInOut> listChecks = new ArrayList<>(employee.getListChecks());
		
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
	
	static public ArrayList<CheckInOut> searchCheckInOut(Department department, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		ArrayList<CheckInOut> resultList = new ArrayList<CheckInOut>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			resultList.addAll(searchCheckInOut(currentEmployee,beforeCheck, afterCheck));
		}
		return resultList;
	}
	
	//overall
    static public ArrayList<CheckInOut> searchCheckInOut(Company company, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
        ArrayList<CheckInOut> resultList = new ArrayList<CheckInOut>();
        for (Department currentDepartment : company.getListDepartment()) {
        	resultList.addAll(searchCheckInOut(currentDepartment, beforeCheck, afterCheck));
        }
        return resultList;
    }
	
	
	/*********************************************************************/
	/************************* RETURN EMPLOYEES **************************/
	/*********************************************************************/
	
	/************************ according to check *************************/
	
	static public ArrayList<Employee> searchEmployee(Department department, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		ArrayList<Employee> resultList = new ArrayList<Employee>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			if (!searchCheckInOut(currentEmployee,beforeCheck, afterCheck).isEmpty()) {
				resultList.add(currentEmployee);
			}
		}
		return new ArrayList<Employee>(resultList);
	}
	
	//overall
	static public ArrayList<Employee> searchEmployee(Company company, LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		ArrayList<Employee> resultList = new ArrayList<Employee>();
		for (Department currentDepartment : company.getListDepartment()) {
        	resultList.addAll(searchEmployee(currentDepartment, beforeCheck, afterCheck));
        }
		return new ArrayList<Employee>(resultList);
	}

	
	
	/************************* according to ID ***************************/
	//necessarily only one employee per ID
	
	static public Employee searchEmployee(Department department, Integer ID) {
		return department.getListEmployees().get(ID);
	}
	
	//overall
	static public Employee searchEmployee(Company company, Integer ID) {
		for (Department currentDepartment : company.getListDepartment()) {
        	if (searchEmployee(currentDepartment, ID) != null) {
        		return searchEmployee(currentDepartment, ID);
        	}
        }
		return null;
	}
	
	
	/************************ according to name **************************/
	
	//per name
	static public ArrayList<Employee> searchEmployee(Department department, String firstName, String lastName) {
		ArrayList<Employee> resultList = new ArrayList<Employee>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			if (currentEmployee.getFirstName().equals(firstName) && currentEmployee.getLastName().equals(lastName)) {
				resultList.add(currentEmployee);
			}
		}
		return new ArrayList<Employee>(resultList);
	}

	static public ArrayList<Employee> searchEmployee(Department department, String name) {
		ArrayList<Employee> resultList = new ArrayList<Employee>();
		for (Employee currentEmployee : department.getListEmployees().values()) {
			if (currentEmployee.getFirstName().equals(name) || currentEmployee.getLastName().equals(name)) {
				resultList.add(currentEmployee);
			}
		}
		return new ArrayList<Employee>(resultList);
	}
	
	//overall
	static public ArrayList<Employee> searchEmployee(Company company, String firstName, String lastName) {
		ArrayList<Employee> resultList = new ArrayList<Employee>();
		for (Department currentDepartment : company.getListDepartment()) {
        	resultList.addAll(searchEmployee(currentDepartment, firstName, lastName));
        }
		return new ArrayList<Employee>(resultList);
	}
	
	//overall
	static public ArrayList<Employee> searchEmployee(Company company, String name) {
		ArrayList<Employee> resultList = new ArrayList<Employee>();
		for (Department currentDepartment : company.getListDepartment()) {
        	resultList.addAll(searchEmployee(currentDepartment, name));
        }
		return new ArrayList<Employee>(resultList);
	}
	
}
