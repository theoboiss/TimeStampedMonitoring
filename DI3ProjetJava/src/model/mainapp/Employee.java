/**
 * 
 */
package model.mainapp;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

/**
 * @author 21804803t
 *
 */
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
	 * 
	 */
	public Employee() {
		this("default","default");
	}
	
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
		setPlanning(new Planning());
		setListChecks(new CopyOnWriteArrayList<CheckInOut>());
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
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
	protected static void addUsedIDToList(Integer ID) {
		Employee.listUsedIDs.add(ID);
	}

	/****************************** Planning *****************************/
	
	/**
	 * @return the planning
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
	 * @return the listChecks
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

	/**
	 * @return the listChecks
	 */
	public CopyOnWriteArrayList<CheckInOut> getCheck(LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<CheckInOut> resultList = new CopyOnWriteArrayList<CheckInOut>();
		for (CheckInOut currentCheck : getListChecks()) {
			if (currentCheck.getCheckTime().isAfter(beforeCheck) && currentCheck.getCheckTime().isBefore(afterCheck)) {
				resultList.add(currentCheck);
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
	
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<Employee> listEmployees = new CopyOnWriteArrayList<>();
		
		listEmployees.add(new Employee("Barney", "Stinson"));
		listEmployees.add(new Employee("Ted", "Mosby"));
		listEmployees.add(new Employee("Rachel", "Green"));
		listEmployees.add(new Employee("Joey", "Tribiani"));
		listEmployees.add(new Employee("Jesse", "Pinkman"));

		System.out.println("UsedIDs " + Employee.getlistUsedIDs());
		for (Integer Iterator = 0; Iterator < 5; Iterator++)
		{
			System.out.println(listEmployees.get(Iterator).toString());
		}
	}
}
