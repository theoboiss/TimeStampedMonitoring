/**
 * 
 */
package model.shared;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import model.mainapp.Employee;

/**
 * 
 */
public class Department {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private String name;
	private ConcurrentHashMap<Integer,Employee> listEmployees;


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @param name
	 */
	public Department() {
		this("default");
	}
	
	/**
	 * @param name
	 */
	public Department(String name) {
		setName(name);
		
		//create a list of one employee
		ConcurrentHashMap<Integer,Employee> defaultListEmployees = new ConcurrentHashMap<>();
		defaultListEmployees.put(1, new Employee());
		setListEmployees(defaultListEmployees); //give it to the class
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/******************************** Name *******************************/
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*************************** ListEmployees ***************************/
	
	/**
	 * @return the listEmployees
	 */
	public ConcurrentHashMap<Integer,Employee> getListEmployees() {
		return listEmployees;
	}
	
	/**
	 * @param listEmployees the listEmployees to set
	 */
	private void setListEmployees(ConcurrentHashMap<Integer,Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}
	
	/**
	 * @param listEmployees the listEmployees to set
	 */
	private void addEmployee(Employee employee) {
		getListEmployees().put(employee.getID(), employee);
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {
		return "Department [name=" + name + ", listEmployees=\n\t" + listEmployees + "\n\t]";
	}
	
	
	public static void main(String[] args) {
		Department A = new Department();
		Department B = new Department("JavaTech");

		System.out.println(A.toString());
		System.out.println(B.toString());
	}
}
