package model.mainapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import model.shared.CheckInOut;

public class Department implements storesEmployee {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private String name;
	//a map in which each employee can be directly obtained from his ID
	private ConcurrentHashMap<Integer,Employee> listEmployees = new ConcurrentHashMap<>();


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @throws Exception 
	 */
	public Department() throws Exception {
		this("default");
	}
	
	/**
	 * @param name
	 * @throws Exception 
	 */
	public Department(String name) throws Exception {
		this(name, new Employee("default","default"));
	}
	
	/**
	 * @param name
	 * @param boss
	 */
	public Department(String name, Employee boss) {
		setName(name);
		addEmployee(boss);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/******************************** Name *******************************/
	
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*************************** ListEmployees ***************************/
	
	/**
	 * @return
	 */
	public ConcurrentHashMap<Integer,Employee> getListEmployees() {
		return listEmployees;
	}
	
	/**
	 * @param listEmployees
	 */
	protected void setListEmployees(ConcurrentHashMap<Integer,Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}
	
	/**
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		getListEmployees().put(employee.getID(), employee);
	}

	
	/*********************************************************************/
	/****************************** SEARCH *******************************/
	/*********************************************************************/
	
	/**
	 * @param ID
	 * @return
	 */
	public Employee searchEmployee(Integer ID) {
		return getListEmployees().get(ID);
	}
	
	/**
	 * @param name
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(String name) {
		CopyOnWriteArrayList<Employee> resultList = new CopyOnWriteArrayList<Employee>();
		for (Employee currentEmployee : getListEmployees().values()) {
			if (currentEmployee.getFirstName().equals(name) || currentEmployee.getLastName().equals(name)) {
				resultList.add(currentEmployee);
			}
		}
		return new CopyOnWriteArrayList<Employee>(resultList);
	}
	
	/**
	 * @param firstName
	 * @param LastName
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(String firstName, String LastName) {
		CopyOnWriteArrayList<Employee> resultList = new CopyOnWriteArrayList<Employee>();
		for (Employee currentEmployee : getListEmployees().values()) {
			if (currentEmployee.getFirstName().equals(firstName) && currentEmployee.getLastName().equals(LastName)) {
				resultList.add(currentEmployee);
			}
		}
		return new CopyOnWriteArrayList<Employee>(resultList);
	}
	
	/**
	 * @param beforeCheck
	 * @param afterCheck
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<Employee> resultList = new CopyOnWriteArrayList<Employee>();
		for (Employee currentEmployee : getListEmployees().values()) {
			if (!currentEmployee.searchCheckInOut(beforeCheck, afterCheck).isEmpty()) {
				resultList.add(currentEmployee);
			}
		}
		return new CopyOnWriteArrayList<Employee>(resultList);
	}

	/**
	 * @param beforeCheck
	 * @param afterCheck
	 * @return
	 */
	public CopyOnWriteArrayList<CheckInOut> searchCheckInOut(LocalDateTime beforeCheck, LocalDateTime afterCheck) {
		CopyOnWriteArrayList<CheckInOut> resultList = new CopyOnWriteArrayList<CheckInOut>();
		for (Employee currentEmployee : getListEmployees().values()) {
			resultList.addAll(currentEmployee.searchCheckInOut(beforeCheck, afterCheck));
		}
		return resultList;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {
		String msg = "Department\t[name=" + name + ",\n\t\t listEmployees=[\n\t\t\t\t";
		for(Employee employeeTmp : listEmployees.values()) {
			msg += employeeTmp.toString() + "\n\t\t\t\t";
		}
		msg = msg.substring(0,msg.length()-1);
		msg += "]\n\t\t]";
		return msg;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Department A = new Department("PolyGame");
			Department B = new Department("JavaTech", new Employee("default", "RH"));
			
			//add few employees to B
			B.addEmployee(new Employee());
			B.addEmployee(new Employee());
			
			//add few checks to A
			
			CheckInOut exempleCheck1 = new CheckInOut();
			exempleCheck1.setEmployeeID(1);
			A.searchEmployee(1).getListChecks().add(exempleCheck1);
			
			CheckInOut exempleCheck2 = new CheckInOut();
			A.searchEmployee(1).getListChecks().add(exempleCheck2);
			exempleCheck2.setEmployeeID(1);
			
			CheckInOut exempleCheck3 = new CheckInOut();
			A.searchEmployee(1).getListChecks().add(exempleCheck3);
			exempleCheck3.setEmployeeID(1);
			
			//a has 1 employee that made 3 checks
			
			System.out.println(A.toString() + System.lineSeparator()); //show A

			
			B.searchEmployee(3).setFirstName("Theo");
			B.searchEmployee(3).setLastName("Boisseau");
			
			System.out.println(B.toString() + System.lineSeparator()); //show B
			
			//the employee that have ID=3
			System.out.println(B.getName() + " : { (ID=3) }\n" + B.searchEmployee(3) + System.lineSeparator());
			//the employees that have "default" in their names
			System.out.println(B.getName() + " : { (name=\"default\") }\n" + B.searchEmployee("default") + System.lineSeparator());
			//the employees named "default" "default"
			System.out.println(B.getName() + " : { (firstName=\"default\")^(lastName=\"default\") }\n" + B.searchEmployee("default", "default")
				+ System.lineSeparator());
			//the employees who made checks today (until now)
			System.out.println(A.getName() + " : { (checkInOut<NOW) }\n"
				+ A.searchEmployee(LocalDateTime.of(LocalDate.now(), LocalTime.of(00,00)), LocalDateTime.now()) + System.lineSeparator());
		} catch (RuntimeException e) {
			System.out.println("\nError : Tried to access to an absent Employee in the list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
