package model.mainapp;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public interface storesEmployee extends storesCheckInOut {
	/**
	 * @param ID
	 * @return
	 */
	public Employee searchEmployee(Integer ID);
	
	/**
	 * @param name
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(String name);
	
	/**
	 * @param firstName
	 * @param LastName
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(String firstName, String LastName);
	
	/**
	 * @param beforeCheck
	 * @param afterCheck
	 * @return
	 */
	public CopyOnWriteArrayList<Employee> searchEmployee(LocalDateTime beforeCheck, LocalDateTime afterCheck);
}
