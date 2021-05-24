package model.mainapp;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

public class Employee extends EmployeeInfo implements storesCheckInOut {


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
		this("","");
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
	/****************************** SEARCH *******************************/
	/*********************************************************************/
	
	/**
	 * @param beforeCheck
	 * @param afterCheck
	 * @return
	 */
	public CopyOnWriteArrayList<CheckInOut> searchCheckInOut(LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<CheckInOut> resultList = new CopyOnWriteArrayList<CheckInOut>();
		CopyOnWriteArrayList<CheckInOut> listChecks = getListChecks();
		
		//the most recent checks are in the end of the array so we start searching from there
		for (Integer iterator = listChecks.size()-1; iterator > 0; iterator--) {
			CheckInOut checkTmp = listChecks.get(iterator);
			if (checkTmp.getCheckTime().isAfter(beforeCheck)
			 && checkTmp.getCheckTime().isBefore(afterCheck)) {
				resultList.add(checkTmp);
			}
		}
		
		return resultList;
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
