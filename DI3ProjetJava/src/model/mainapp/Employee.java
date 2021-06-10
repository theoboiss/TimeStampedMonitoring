package model.mainapp;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

public class Employee extends EmployeeInfo {


	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	//ID 0 is forbiden
	private static ArrayList<Integer> listUsedIDs = new ArrayList<>(Arrays.asList(0));
	private String department;
	private Planning planning;
	private CopyOnWriteArrayList<CheckInOut> listChecks;


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @throws Exception 
	 */
	public Employee() throws Exception {
		this("default","default");
	}
	
	/**
	 * @param firstname
	 * @param lastname
	 * @throws Exception 
	 */
	public Employee(String firstname, String lastname) throws Exception {
		//generate a new ID
		ArrayList<Integer> listUsedIDss = getlistUsedIDs();
		Integer availableID = listUsedIDss.get(listUsedIDss.size()-1) + 1;
		
		addUsedIDToList(availableID); //reserve availableID in listUsedIDs
		setID(availableID);
		setFirstname(firstname);
		setLastname(lastname);
		setDepartment("default");
		setPlanning(new Planning());
		setListChecks(new CopyOnWriteArrayList<CheckInOut>());
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/***************************** listUsedIDs ****************************/
	
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static  ArrayList<Integer> getlistUsedIDs() {
		return (ArrayList<Integer>) listUsedIDs.clone();
	}

	/**
	 * @param ID
	 */
	public static void addUsedIDToList(Integer ID) {
		Employee.listUsedIDs.add(ID);
	}

	/***************************** Department ****************************/
	
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/****************************** Planning *****************************/

	/**
	 * @return
	 */
	public Planning getPlanning() {
		return planning;
	}

	/**
	 * @param planning
	 */
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	/***************************** ListChecks ****************************/

	/**
	 * @return
	 */
	public CopyOnWriteArrayList<CheckInOut> getListChecks() {
		return listChecks;
	}
	
	/**
	 * @param listChecks
	 */
	protected void setListChecks(CopyOnWriteArrayList<CheckInOut> listChecks) {
		this.listChecks = listChecks;
	}

	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	
	public EmployeeInfo castInEmployeeInfo() throws Exception {
		EmployeeInfo employeeToReturn = new EmployeeInfo(this.getID(), this.getFirstname(), this.getLastname());
		return employeeToReturn;
	}
	
	
	@Override
	public String toString() {
		return "Employee [ID=" + getID() + ", firstname=" + getFirstname() + ", lastname=" + getLastname()
				+ ", department=" + getDepartment()
				//+ ", planning=\n" + getPlanning() + "\n\n"
				+ ", listChecks=" + getListChecks() + "]";
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Employee> listEmployees = new ArrayList<>();
		
		try {
			listEmployees.add(new Employee("Barney", "Stinson"));
			listEmployees.add(new Employee("Ted", "Mosby"));
			listEmployees.add(new Employee("Rachel", "Green"));
			listEmployees.add(new Employee("Joey", "Tribiani"));
			listEmployees.add(new Employee("Jesse", "Pinkman"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("UsedIDs " + Employee.getlistUsedIDs());
		for (Integer Iterator = 0; Iterator < 5; Iterator++)
		{
			System.out.println(listEmployees.get(Iterator).toString());
		}
	}
}
