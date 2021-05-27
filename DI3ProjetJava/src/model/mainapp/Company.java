package model.mainapp;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import model.shared.CheckInOut;

import java.util.concurrent.CopyOnWriteArrayList;

public class Company {
	
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private ArrayList<Department> listDepartment;
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	public Company() {
		super();
		this.listDepartment = new ArrayList<Department>();
	}
	
	/**
	 * @param listDepartment
	 */
	public Company(ArrayList<Department> listDepartment) {
		setListDepartment(listDepartment);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	
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

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	
}
