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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum EventDuringCheck {
		enter, leave
	};

	private EventDuringCheck eventDuringCheck;

	
	private Settings settings; // All CheckInOut per employee from the first day
	private static Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> checksPerEmployee; // All CheckInOut per employee during a day. The table is reset to 0 at the end of day. 
	private static Hashtable<LocalDate, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> checksPerEmployeePerDay;
	 
	private Integer employeeID;
	private LocalDateTime dateTime;
	private CheckInOut checkInOut;

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
	 * @brief Method to create an event when an employee arrives or leaves the
	 *        company
	 * @param event
	 * @param empID
	 * @param time
	 * @param check
	 */
	/*public void addToHistory(EventDuringCheck event, Integer empID, LocalDateTime time, CheckInOut check) {
		eventDuringCheck = event;
		employeeID = empID;
		dateTime = time;
		checkInOut = check;
	}*/
	/**
	 * @brief Delete an event from history
	 */
	public void deleteElementFromHistory()
	{
		eventDuringCheck = null;
		employeeID = 0;
		dateTime = null;
		checkInOut = null;
	}
	
	public static void addToHistory(CheckInOut check, EmployeeInfo info, LocalDate date)
	{
		CopyOnWriteArrayList<CheckInOut> list = new CopyOnWriteArrayList<CheckInOut>();
		list = checksPerEmployee.get(info);
		checksPerEmployee.put(info, list);
		checksPerEmployeePerDay.put(date, checksPerEmployee);
		
		

	}
	/**
	 * @return the employeeID
	 */
	public Integer getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the checkInOut
	 */
	public CheckInOut getCheckInOut() {
		return checkInOut;
	}

	/**
	 * @param checkInOut the checkInOut to set
	 */
	public void setCheckInOut(CheckInOut checkInOut) {
		this.checkInOut = checkInOut;
	}

	/**
	 * @return the eventDuringCheck
	 */
	public EventDuringCheck getEventDuringCheck() {
		return eventDuringCheck;
	}

	/**
	 * @param eventDuringCheck the eventDuringCheck to set
	 */
	public void setEventDuringCheck(EventDuringCheck eventDuringCheck) {
		this.eventDuringCheck = eventDuringCheck;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	/* ================================================================= */
	/************************* CLASS ATTRIBUTES **************************/
	/*********************************************************************/

	/*
	 * private Settings settings; // All CheckInOut per employee from the first day
	 * private Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>
	 * checksPerEmployee; // All CheckInOut per employee during a day. The table is
	 * reset to 0 at the end of day. private Hashtable<LocalDate,
	 * Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>>
	 * checksPerEmployeePerDay;
	 */
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/*************************** CONSTRUCTORS ****************************/
	/*********************************************************************/

	/**
	 * @brief Default Constructor
	 */
	/*
	 * public History() { settings = new Settings();
	 * 
	 * checksPerEmployee = new Hashtable<EmployeeInfo,
	 * CopyOnWriteArrayList<CheckInOut>>(); checksPerEmployeePerDay = new
	 * Hashtable<LocalTime, Hashtable<EmployeeInfo,
	 * CopyOnWriteArrayList<CheckInOut>>>();
	 * 
	 * checksPerEmployee = new Hashtable<EmployeeInfo,
	 * CopyOnWriteArrayList<CheckInOut>>(); checksPerEmployeePerDay = new
	 * Hashtable<LocalTime, Hashtable<EmployeeInfo,
	 * CopyOnWriteArrayList<CheckInOut>>>();
	 * 
	 * }
	 */

	/**
	 * @param settings
	 * @param checksPerEmployee
	 * @param checksPerEmployeePerDay
	 */
	/*
	 * public History(Settings settings, Hashtable<EmployeeInfo,
	 * CopyOnWriteArrayList<CheckInOut>> checksPerEmployee, Hashtable<LocalTime,
	 * Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>>
	 * checksPerEmployeePerDay) {
	 * 
	 * super(); this.settings = settings; this.checksPerEmployee =
	 * checksPerEmployee; this.checksPerEmployeePerDay = checksPerEmployeePerDay; }
	 */
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/********************** GETTERS AND SETTERS **************************/
	/*********************************************************************/

	/**
	 * @return the settings
	 */
	/*
	 * public Settings getSettings() { return settings; }
	 */

	/**
	 * @param settings the settings to set
	 */
	/*
	 * public void setSettings(Settings settings) { this.settings = settings; }
	 */

	/**
	 * @return the checksPerEmployee
	 */

	/*
	 * public Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>
	 * getChecksPerEmployee() {
	 * 
	 * return checksPerEmployee; }
	 */

	/**
	 * @param checksPerEmployee the checksPerEmployee to set
	 */

	/*
	 * public void setChecksPerEmployee(Hashtable<EmployeeInfo,
	 * CopyOnWriteArrayList<CheckInOut>> checksPerEmployee) {
	 * 
	 * this.checksPerEmployee = checksPerEmployee; }
	 */

	/**
	 * @return the checksPerEmployeePerDay
	 */

	/*
	 * public Hashtable<LocalTime, Hashtable<EmployeeInfo,
	 * CopyOnWriteArrayList<CheckInOut>>> getChecksPerEmployeePerDay() {
	 * 
	 * return checksPerEmployeePerDay; }
	 */

	/**
	 * @param checksPerEmployeePerDay the checksPerEmployeePerDay to set
	 */
	/*
	 * public void setChecksPerEmployeePerDay(Hashtable<LocalTime,
	 * Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>>
	 * checksPerEmployeePerDay) {
	 * 
	 * this.checksPerEmployeePerDay = checksPerEmployeePerDay; }
	 */
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/***************************** METHODS *******************************/
	/*********************************************************************/

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

}
