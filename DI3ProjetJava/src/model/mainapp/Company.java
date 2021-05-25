package model.mainapp;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import model.shared.CheckInOut;

import java.util.concurrent.CopyOnWriteArrayList;

public class Company {
	
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private ConcurrentHashMap <Employee, CopyOnWriteArrayList<CheckInOut>> listCheckPerEmployee;
	private ConcurrentHashMap <String, CopyOnWriteArrayList<Employee>> listEmployeesPerDepartment;
	private ArrayList<Department> listDepartment;
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	public Company() {
		super();
		this.listCheckPerEmployee = new ConcurrentHashMap <Employee, CopyOnWriteArrayList<CheckInOut>>();
		this.listEmployeesPerDepartment = new ConcurrentHashMap <String, CopyOnWriteArrayList<Employee>>();
		this.listDepartment = new ArrayList<Department>();
	}
	
	/**
	 * @param listCheckPerEmployee
	 * @param listEmployeesPerDepartment
	 * @param listDepartment
	 */
	public Company(ConcurrentHashMap<Employee, CopyOnWriteArrayList<CheckInOut>> listCheckPerEmployee,
		ConcurrentHashMap<String, CopyOnWriteArrayList<Employee>> listEmployeesPerDepartment, ArrayList<Department> listDepartment) {
		setListCheckPerEmployee(listCheckPerEmployee);
		setListEmployeesPerDepartment(listEmployeesPerDepartment);
		setListDepartment(listDepartment);
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
	
	
	/************************** listDepartment *************************/
	
	/**
	 * @return the listDepartment
	 */
	public ArrayList<Department> getListDepartment() {
		return listDepartment;
	}

	/**
	 * @param listDepartment the listDepartment to set
	 */
	public void setListDepartment(ArrayList<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}
	
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
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
