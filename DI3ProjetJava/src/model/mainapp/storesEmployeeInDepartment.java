package model.mainapp;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;

public interface storesEmployeeInDepartment extends storesEmployee {
	/**
	 * @param department
	 * @param ID
	 * @return
	 */
	public Employee searchEmployee(String department, Integer ID);
	
	/**
	 * @param department
	 * @param name
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(String department, String name);
	
	/**
	 * @param department
	 * @param firstName
	 * @param LastName
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(String department, String firstName, String LastName);
	
	/**
	 * @param department
	 * @param beforeCheck
	 * @param afterCheck
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(String department, LocalDateTime beforeCheck, LocalDateTime afterCheck);
	
	/**
	 * @param department
	 * @param beforeCheck
	 * @param afterCheck
	 * @return
	 */
	public CopyOnWriteArrayList<CheckInOut> searchCheckInOut(String department, LocalDateTime beforeCheck, LocalDateTime afterCheck);
}
