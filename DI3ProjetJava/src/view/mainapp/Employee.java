package view.mainapp;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Employee {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	//ID 0 is reserved for developers
	private static CopyOnWriteArrayList<Integer> listUsedIDs = new CopyOnWriteArrayList<>(new Integer[] {0});
	
	private int ID;
	private String firstName;
	private String lastName;
	private Object[] listChecks; //CheckInOut not defined yet


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param listChecks
	 */
	public Employee(String firstName, String lastName) {
		//generate a new ID
		CopyOnWriteArrayList<Integer> listUsedIDss = getlistUsedIDs();
		Integer availableID = listUsedIDss.get(listUsedIDss.size()-1) + 1;
		
		addUsedIDToList(availableID); //reserve availableID in listUsedIDs
		setID(availableID);
		setFirstName(firstName);
		setLastName(lastName);
		setListChecks(null); //CheckInOut not defined yet
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/********************************* ID ********************************/
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	private void setID(int iD) {
		ID = iD;
	}

	/***************************** listUsedIDs ****************************/
	
	/**
	 * @return a copy of the listUsedIDs
	 */
	@SuppressWarnings("unchecked")
	public static  CopyOnWriteArrayList<Integer> getlistUsedIDs() {
		return (CopyOnWriteArrayList<Integer>) listUsedIDs.clone();
	}

	/**
	 * @param listUsedIDs the listUsedIDs to set
	 */
	private static void addUsedIDToList(Integer ID) {
		Employee.listUsedIDs.add(ID);
	}

	/***************************** FirstName *****************************/

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/****************************** LastName *****************************/
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/***************************** ListChecks ****************************/
	
	/**
	 * @return the listChecks
	 */
	public Object[] getListChecks() { //will be modified
		return listChecks;
	}
	
	/**
	 * @param listChecks the listChecks to set
	 */
	public void setListChecks(Object[] listChecks) { //will be modified
		this.listChecks = listChecks;
	}


	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {
		return "Employee [ID=" + getID() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", listChecks="
				+ Arrays.toString(getListChecks()) + "]";
	}
}
