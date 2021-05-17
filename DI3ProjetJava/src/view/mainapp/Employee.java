package view.mainapp;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Employee {

	/*********************************************************************/
	/***************************** ATTRIBUTS *****************************/
	/*********************************************************************/
	
	private static CopyOnWriteArrayList<Integer> listUsedID = new CopyOnWriteArrayList<>(new Integer[] {0});
	
	private int ID;
	private String firstName;
	private String lastName;
	private Object[] listChecks; //CheckInOut not defined yet


	/*********************************************************************/
	/******************** CONSTRUCTEURS ET DESTRUCTEUR *******************/
	/*********************************************************************/

	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param listChecks
	 */
	public Employee(String firstName, String lastName) {
		CopyOnWriteArrayList<Integer> listUsedID = getListUsedID();
		Integer availableID = listUsedID.get(listUsedID.size()-1) + 1;
		
		listUsedID.add(availableID);
		setID(availableID);
		setFirstName(firstName);
		setLastName(lastName);
		this.listChecks = null; //CheckInOut not defined yet
	}
	
	
	/*********************************************************************/
	/********************** ACCESSEURS ET MUTATEURS **********************/
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
	public void setID(int iD) {
		ID = iD;
	}

	/***************************** ListUsedID ****************************/
	
	/**
	 * @return the usedID
	 */
	private static CopyOnWriteArrayList<Integer> getListUsedID() {
		return listUsedID;
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
	public Object[] getListChecks() {
		return listChecks;
	}
	
	/**
	 * @param listChecks the listChecks to set
	 */
	public void setListChecks(Object[] listChecks) {
		this.listChecks = listChecks;
	}


	/*********************************************************************/
	/************************** AUTRES METHODES **************************/
	/*********************************************************************/
	
	@Override
	public String toString() {
		return "Employee [ID=" + getID() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", listChecks="
				+ Arrays.toString(getListChecks()) + "]";
	}
}
