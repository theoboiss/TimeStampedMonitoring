package model.mainapp;

import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;
import controller.emulator.CheckInOut;
import model.shared.Department;

public class Company {
	
	//MODIFIER LES TYPES DES TABLEAUX!!!!!!!!!!!!!!!!!!!

	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private ConcurrentHashMap <Employee, CheckInOut[]> listCheckPerEmployee;
	private ConcurrentHashMap <String, Employee[]> listEmployeesPerDepartment;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @brief Default constructor.
	 */
	public Company() {
		this.listCheckPerEmployee = new ConcurrentHashMap <Employee, CheckInOut[]>();
		this.listEmployeesPerDepartment = new ConcurrentHashMap <String, Employee[]>();
	}
	
	/**
	 * @brief Copy constructor.
	 * 
	 * @param listCheckPerEmployee
	 * @param listEmployeesPerDepartment
	 */
	public Company(ConcurrentHashMap<Employee, CheckInOut[]> listCheckPerEmployee,
			ConcurrentHashMap<String, Employee[]> listEmployeesPerDepartment) {
		setListCheckPerEmployee(listCheckPerEmployee);
		setListEmployeesPerDepartment(listEmployeesPerDepartment);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/*********************** ListChecksPerEmployee ***********************/
	
	/**
	 * @return the listCheckPerEmployee
	 */
	public ConcurrentHashMap<Employee, CheckInOut[]> getListCheckPerEmployee() {
		return listCheckPerEmployee;
	}

	/**
	 * @param listCheckPerEmployee the listCheckPerEmployee to set
	 */
	private void setListCheckPerEmployee(ConcurrentHashMap<Employee, CheckInOut[]> listCheckPerEmployee) {
		this.listCheckPerEmployee = listCheckPerEmployee;
	}
	
	
	/********************* ListEmployeesPerDepartment ********************/
	
	/**
	 * @return the listEmployeesPerDepartment
	 */
	public ConcurrentHashMap<String, Employee[]> getListEmployeesPerDepartment() {
		return listEmployeesPerDepartment;
	}

	/**
	 * @param listEmployeesPerDepartment the listEmployeesPerDepartment to set
	 */
	private void setListEmployeesPerDepartment(ConcurrentHashMap<String, Employee[]> listEmployeesPerDepartment) {
		this.listEmployeesPerDepartment = listEmployeesPerDepartment;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	/**
	 * @brief Add employee to listCheckPerEmployee.
	 * 
	 * @param employee
	 */
	private void addEmployeeInListChecksPerEmployee(Employee employee) {
		this.listCheckPerEmployee.put(employee, null);
	}
	/*
	private void addCheckInListCheckPerEmployee (CheckInOut checkInOut) {
		this.listCheckPerEmployee.forEach((key, value)-> {
			if (key.getID()==checkInOut.getEmployeeID()) {
				value.a
			}
		});
	}*/
	
	/*
	@Override
	public String toString() {
		return this.planning.toString().replace("=", "\n").replace(",", "\n\n");
	}*/
	
	public static void main(String[] args){
		
		Department department1 = new Department("A");
		Department department2 = new Department("B");
		Department department3 = new Department("C");
		Employee employee1 = new Employee("Sarah", "DENIS");
		Employee employee2 = new Employee("Théo", "BOISSEAU");
		Employee employee3 = new Employee("Mohammed", "RMICH");
		Employee employee4 = new Employee("Chadi", "YASSIN");
		Employee employee5 = new Employee("Bernard", "LHERMITE");
		Employee employee6 = new Employee("Sylvie", "JEANNE");		
		
	}
	
}
