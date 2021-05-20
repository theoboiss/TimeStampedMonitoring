package model.emulator;

import java.time.LocalTime;
import java.util.Hashtable;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

public class History 
{
	/* ================================================================= */
	/************************* CLASS ATTRIBUTES **************************/
	/*********************************************************************/
	
	private Settings settings;
	// All CheckInOut per employee from the first day

	private Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> checksPerEmployee;

	// All CheckInOut per employee during a day. The table is reset to 0 at the end of day.

	private Hashtable<LocalTime, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> checksPerEmployeePerDay;

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/*************************** CONSTRUCTORS ****************************/
	/*********************************************************************/
	
	/**
	 * @brief Default Constructor
	 */
	public History() {
		settings = new Settings();

		checksPerEmployee = new Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>();
		checksPerEmployeePerDay = new Hashtable<LocalTime, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>>();

		checksPerEmployee = new Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>();
		checksPerEmployeePerDay = new Hashtable<LocalTime, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>>();

	}

	/**
	 * @param settings
	 * @param checksPerEmployee
	 * @param checksPerEmployeePerDay
	 */
	public History(Settings settings, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> checksPerEmployee,
			Hashtable<LocalTime, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> checksPerEmployeePerDay) {

		super();
		this.settings = settings;
		this.checksPerEmployee = checksPerEmployee;
		this.checksPerEmployeePerDay = checksPerEmployeePerDay;
	}
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/********************** GETTERS AND SETTERS **************************/
	/*********************************************************************/

	/**
	 * @return the settings
	 */
	public Settings getSettings() {
		return settings;
	}

	/**
	 * @param settings the settings to set
	 */
	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	/**
	 * @return the checksPerEmployee
	 */

	public Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> getChecksPerEmployee() {

		return checksPerEmployee;
	}

	/**
	 * @param checksPerEmployee the checksPerEmployee to set
	 */

	public void setChecksPerEmployee(Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>> checksPerEmployee) {

		this.checksPerEmployee = checksPerEmployee;
	}

	/**
	 * @return the checksPerEmployeePerDay
	 */

	public Hashtable<LocalTime, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> getChecksPerEmployeePerDay() {

		return checksPerEmployeePerDay;
	}

	/**
	 * @param checksPerEmployeePerDay the checksPerEmployeePerDay to set
	 */
	public void setChecksPerEmployeePerDay(Hashtable<LocalTime, Hashtable<EmployeeInfo, CopyOnWriteArrayList<CheckInOut>>> checksPerEmployeePerDay) {

		this.checksPerEmployeePerDay = checksPerEmployeePerDay;
	}
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
