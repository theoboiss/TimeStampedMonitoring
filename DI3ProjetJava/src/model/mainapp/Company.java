package model.mainapp;

import java.util.ArrayList;

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
		/*
		try {
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		*/
	}
	
}
