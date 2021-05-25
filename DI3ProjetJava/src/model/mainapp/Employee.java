package model.mainapp;

import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

public class Employee extends EmployeeInfo {


	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	//ID 0 is reserved for developers
	protected static CopyOnWriteArrayList<Integer> listUsedIDs = new CopyOnWriteArrayList<>(new Integer[] {0});
	protected Planning planning;
	protected CopyOnWriteArrayList<CheckInOut> listChecks;


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
	 * @param firstName
	 * @param lastName
	 * @throws Exception 
	 */
	public Employee(String firstName, String lastName) throws Exception {
		//generate a new ID
		CopyOnWriteArrayList<Integer> listUsedIDss = getlistUsedIDs();
		Integer availableID = listUsedIDss.get(listUsedIDss.size()-1) + 1;
		
		addUsedIDToList(availableID); //reserve availableID in listUsedIDs
		setID(availableID);
		setFirstName(firstName);
		setLastName(lastName);
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
	public static  CopyOnWriteArrayList<Integer> getlistUsedIDs() {
		return (CopyOnWriteArrayList<Integer>) listUsedIDs.clone();
	}

	/**
	 * @param ID
	 */
	protected static void addUsedIDToList(Integer ID) {
		Employee.listUsedIDs.add(ID);
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
	
	@Override
	public String toString() {
		return "Employee [ID=" + getID() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				//+ ", planning=\n" + getPlanning() + "\n\n"
				+ ", listChecks=" + getListChecks() + "]";
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CopyOnWriteArrayList<Employee> listEmployees = new CopyOnWriteArrayList<>();
		
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
