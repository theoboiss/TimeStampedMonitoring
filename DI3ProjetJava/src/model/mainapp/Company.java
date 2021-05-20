package model.mainapp;

import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;

import model.shared.CheckInOut;

import java.util.concurrent.CopyOnWriteArrayList;

public class Company {
	
	//MODIFIER LES TYPES DES TABLEAUX!!!!!!!!!!!!!!!!!!!

	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private ConcurrentHashMap <Employee, CopyOnWriteArrayList<CheckInOut>> listCheckPerEmployee;
	private ConcurrentHashMap <String, CopyOnWriteArrayList<Employee>> listEmployeesPerDepartment;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @brief Default constructor.
	 */
	public Company() {
		super();
		this.listCheckPerEmployee = new ConcurrentHashMap <Employee, CopyOnWriteArrayList<CheckInOut>>();
		this.listEmployeesPerDepartment = new ConcurrentHashMap <String, CopyOnWriteArrayList<Employee>>();
	}
	
	/**
	 * @brief Copy constructor.
	 * 
	 * @param listCheckPerEmployee
	 * @param listEmployeesPerDepartment
	 */
	public Company(ConcurrentHashMap<Employee, CopyOnWriteArrayList<CheckInOut>> listCheckPerEmployee,
			ConcurrentHashMap<String, CopyOnWriteArrayList<Employee>> listEmployeesPerDepartment) {
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
	public ConcurrentHashMap<Employee, CopyOnWriteArrayList<CheckInOut>> getListCheckPerEmployee() {
		return listCheckPerEmployee;
	}

	/**
	 * @param listCheckPerEmployee the listCheckPerEmployee to set
	 */
	private void setListCheckPerEmployee(ConcurrentHashMap<Employee, CopyOnWriteArrayList<CheckInOut>> listCheckPerEmployee) {
		this.listCheckPerEmployee = listCheckPerEmployee;
	}
	
	
	/********************* ListEmployeesPerDepartment ********************/
	
	/**
	 * @return the listEmployeesPerDepartment
	 */
	public ConcurrentHashMap<String, CopyOnWriteArrayList<Employee>> getListEmployeesPerDepartment() {
		return listEmployeesPerDepartment;
	}

	/**
	 * @param listEmployeesPerDepartment the listEmployeesPerDepartment to set
	 */
	private void setListEmployeesPerDepartment(ConcurrentHashMap<String, CopyOnWriteArrayList<Employee>> listEmployeesPerDepartment) {
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
		//this.listCheckPerEmployee.put(employee, employee.getListChecks());
	}
	
	
	/**
	 * @brief Add department to listEmployeesPerDepartment.
	 * 
	 * @param department
	 */
	private void addDepartmentInListEmployeesPerDepartment (Department department) {
		this.listEmployeesPerDepartment.put(department.getName(), null);
	}
	
	/******************************* Others ******************************/
	
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
