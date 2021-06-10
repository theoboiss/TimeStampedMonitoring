package model.mainapp;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

/**
 * @brief Class which represents an Employee in the company.
 */
public class Employee extends EmployeeInfo {


	private static final long serialVersionUID = 1L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	//ID 0 is forbidden
	private static ArrayList<Integer> listUsedIDs = new ArrayList<>(Arrays.asList(0));
	private String department;
	private Planning planning;
	private CopyOnWriteArrayList<CheckInOut> listChecks;


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @brief Default constructor.
	 * @throws Exception 
	 */
	public Employee() throws Exception {
		this("default","default");
	}
	
	/**
	 * @brief Constructor.
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
	 * @return listUsedIDs
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> getlistUsedIDs() {
		return (ArrayList<Integer>) listUsedIDs.clone();
	}

	/**
	 * @param ID the ID to add
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
	 * @return planning
	 */
	public Planning getPlanning() {
		return planning;
	}

	/**
	 * @param planning the planning to set
	 */
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	/***************************** ListChecks ****************************/

	/**
	 * @return listChecks
	 */
	public CopyOnWriteArrayList<CheckInOut> getListChecks() {
		return listChecks;
	}
	
	/**
	 * @param listChecks the listChecks to set
	 */
	protected void setListChecks(CopyOnWriteArrayList<CheckInOut> listChecks) {
		this.listChecks = listChecks;
	}

	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	/**
	 * @brief Method which cast an Employee in an EmployeeInfo.
	 * @return EmployeeInfo
	 * @throws Exception
	 */
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
	
}
