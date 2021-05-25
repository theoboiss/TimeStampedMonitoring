package model.mainapp;

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

	public Company() {
		super();
		this.listCheckPerEmployee = new ConcurrentHashMap <Employee, CopyOnWriteArrayList<CheckInOut>>();
		this.listEmployeesPerDepartment = new ConcurrentHashMap <String, CopyOnWriteArrayList<Employee>>();
	}
	
	/**
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
	 * @return
	 */
	public ConcurrentHashMap<Employee, CopyOnWriteArrayList<CheckInOut>> getListCheckPerEmployee() {
		return listCheckPerEmployee;
	}

	/**
	 * @param listCheckPerEmployee
	 */
	private void setListCheckPerEmployee(ConcurrentHashMap<Employee, CopyOnWriteArrayList<CheckInOut>> listCheckPerEmployee) {
		this.listCheckPerEmployee = listCheckPerEmployee;
	}
	
	
	/********************* ListEmployeesPerDepartment ********************/
	
	/**
	 * @return
	 */
	public ConcurrentHashMap<String, CopyOnWriteArrayList<Employee>> getListEmployeesPerDepartment() {
		return listEmployeesPerDepartment;
	}

	/**
	 * @param listEmployeesPerDepartment
	 */
	private void setListEmployeesPerDepartment(ConcurrentHashMap<String, CopyOnWriteArrayList<Employee>> listEmployeesPerDepartment) {
		this.listEmployeesPerDepartment = listEmployeesPerDepartment;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	
	/**
	 * @param employee
	 */
	private void addEmployeeInListChecksPerEmployee(Employee employee) {
		//this.listCheckPerEmployee.put(employee, employee.getListChecks());
	}
	
	
	/**
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
		
		try {
			Department department1 = new Department("A");
			Department department2 = new Department("B");
			Department department3 = new Department("C");
			Employee employee1 = new Employee("Sarah", "DENIS");
			Employee employee2 = new Employee("Théo", "BOISSEAU");
			Employee employee3 = new Employee("Mohammed", "RMICH");
			Employee employee4 = new Employee("Chadi", "YASSIN");
			Employee employee5 = new Employee("Bernard", "LHERMITE");
			Employee employee6 = new Employee("Sylvie", "JEANNE");	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	
}
