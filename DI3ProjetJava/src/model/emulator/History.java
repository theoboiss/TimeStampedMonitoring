package model.emulator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

import java.util.Hashtable;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @brief Class to represent events that occur during CheckInOut from the
 *        emulator
 *
 */
public class History implements Serializable {

	/* ================================================================= */
	/************************* CLASS ATTRIBUTES **************************/
	/*********************************************************************/
	private static final long serialVersionUID = 1L;

	public static enum EventDuringCheck {
		enter, leave
	}

	// All CheckInOut per employee from the first day
	private static Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> checksPerEmployee;
	// All CheckInOut per employee during a day. The table is reset to 0 at the end
	// of day
	private static Hashtable<LocalDate, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> checksPerEmployeePerDay;
	private CheckInOut checkInOut;
	private LocalDateTime dateTime;
	private Integer employeeID;
	private EventDuringCheck eventDuringCheck;

	/* ================================================================= */
	/*************************** BUILDERS ********************************/
	/*********************************************************************/
	public History() {

		checksPerEmployee = new Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>();
		checksPerEmployeePerDay = new Hashtable<LocalDate, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>>();
	}

	/**
	 * @brief Constructor with an employee ID
	 * @param ID
	 */
	public History(Integer ID) {
		eventDuringCheck = null;
		employeeID = ID;
		dateTime = null;
		checkInOut = null;
	}

	/**
	 * @param employeeID
	 * @param dateTime
	 * @param checkInOut
	 */
	public History(Integer employeeID, LocalDateTime dateTime, CheckInOut checkInOut) {
		super();
		this.employeeID = employeeID;
		this.dateTime = dateTime;
		this.checkInOut = checkInOut;
	}

	/* ================================================================= */
	/*************************** GETTERS/SETTERS *************************/
	/*********************************************************************/
	
	/**
	 * @return the checksPerEmployee
	 */
	public static Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> getChecksPerEmployee() {
		return checksPerEmployee;
	}

	/**
	 * @return the checksPerEmployeePerDay
	 */
	public static Hashtable<LocalDate, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> getChecksPerEmployeePerDay() {
		return checksPerEmployeePerDay;
	}

	/**
	 * @return the checkInOut
	 */
	public CheckInOut getCheckInOut() {
		return checkInOut;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @return the employeeID
	 */
	public Integer getEmployeeID() {
		return employeeID;
	}

	/**
	 * @return the eventDuringCheck
	 */
	public EventDuringCheck getEventDuringCheck() {
		return eventDuringCheck;
	}

	/**
	 * @param checksPerEmployee the checksPerEmployee to set
	 */
	public static void setChecksPerEmployee(Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> checksPerEmployee) {
		History.checksPerEmployee = checksPerEmployee;
	}

	/**
	 * @param checksPerEmployeePerDay the checksPerEmployeePerDay to set
	 */
	public static void setChecksPerEmployeePerDay(
			Hashtable<LocalDate, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> checksPerEmployeePerDay) {
		History.checksPerEmployeePerDay = checksPerEmployeePerDay;
	}

	/**
	 * @param checkInOut the checkInOut to set
	 */
	public void setCheckInOut(CheckInOut checkInOut) {
		this.checkInOut = checkInOut;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @param eventDuringCheck the eventDuringCheck to set
	 */
	public void setEventDuringCheck(EventDuringCheck eventDuringCheck) {
		this.eventDuringCheck = eventDuringCheck;
	}

	/* ================================================================= */
	/***************************** METHODS *******************************/
	/*********************************************************************/

	public static void addToHistory(CheckInOut check, EmployeeInfo info) {
		CopyOnWriteArrayList<CheckInOut> list = new CopyOnWriteArrayList<CheckInOut>();
		list = checksPerEmployee.get(info);
		checksPerEmployee.put(info, list);
	}

	public static void addToHistory(CheckInOut check, EmployeeInfo info, LocalDate date) {
		CopyOnWriteArrayList<CheckInOut> list = new CopyOnWriteArrayList<CheckInOut>();
		list = checksPerEmployee.get(info);
		checksPerEmployee.put(info, list);
		checksPerEmployeePerDay.put(date, checksPerEmployee);

	}

	/**
	 * @brief Method to create an event when an employee arrives or leaves the
	 *        company
	 * @param event
	 * @param empID
	 * @param time
	 * @param check
	 */
	/*
	 * public void addToHistory(EventDuringCheck event, Integer empID, LocalDateTime
	 * time, CheckInOut check) { eventDuringCheck = event; employeeID = empID;
	 * dateTime = time; checkInOut = check; }
	 */
	
	/**
	 * @brief Delete an event from history
	 */
	public void deleteElementFromHistory() {
		eventDuringCheck = null;
		employeeID = 0;
		dateTime = null;
		checkInOut = null;
	}

	/**
	 * @brief toString method to show events when a CheckInOut takes place
	 */
	public String toString() {

		String event = "Unusual event";
		switch (eventDuringCheck) {
		case enter:
			event = "Employee arrived";
			break;
		case leave:
			event = "Employee left";
			break;
		default:
			event = "Unusual event";
			break;
		}
		return event;
	}

}
