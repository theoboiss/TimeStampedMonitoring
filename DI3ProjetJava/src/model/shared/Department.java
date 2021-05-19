/**
 * 
 */
package model.shared;

import java.util.concurrent.ConcurrentHashMap;

import model.mainapp.Employee;

/**
 * 
 */
public class Department {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private String name;
	//a map in which each employee can be directly obtained from his ID
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
		
		//create a list of a new employee
		ConcurrentHashMap<Integer,Employee> defaultListEmployees = new ConcurrentHashMap<>();
		Employee newEmployee = new Employee();
		defaultListEmployees.put(newEmployee.getID(), newEmployee);
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
	private Employee getEmployee(Integer ID) {
		return getListEmployees().get(ID);
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
		String msg = "Department\t[name=" + name + ",\n\t\t listEmployees=[\n\t\t\t ";
		for(Employee employeeTmp : listEmployees.values()) {
			msg += employeeTmp.toString() + "\n\t\t\t ";
		}
		msg = msg.substring(0,msg.length()-1);
		msg += "]\n\t\t";
		msg += "]";
		return msg;
	}
	
	
	public static void main(String[] args) {
		Department A = new Department();
		Department B = new Department("JavaTech");
		
		B.addEmployee(new Employee());
		B.addEmployee(new Employee());
		B.addEmployee(new Employee());
		
		
		
		B.getEmployee(2).setFirstName("Theo");
		B.getEmployee(2).setLastName("Boisseau");
		
		System.out.println(A.toString());
		System.out.println(B.toString());

		
		System.out.println(B.getEmployee(2));
	}
}
