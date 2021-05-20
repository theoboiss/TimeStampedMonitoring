package model.emulator;

import java.time.LocalTime;
import java.util.Hashtable;
import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

public class History 
{
	/* ================================================================= */
	/************************* CLASS ATTRIBUTES **************************/
	/*********************************************************************/
	
	private Settings settings;
	// All CheckInOut per employee from the first day
	private Hashtable<EmployeeInfo, CheckInOut[]> checksPerEmployee;
	// All CheckInOut per employee during a day. The table is reset to 0 at the end of day.
	private Hashtable<LocalTime, Hashtable<EmployeeInfo, CheckInOut[]>> checksPerEmployeePerDay;
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
		checksPerEmployee = new Hashtable<EmployeeInfo, CheckInOut[]>();
		checksPerEmployeePerDay = new Hashtable<LocalTime, Hashtable<EmployeeInfo, CheckInOut[]>>();
	}

	/**
	 * @param settings
	 * @param checksPerEmployee
	 * @param checksPerEmployeePerDay
	 */
	public History(Settings settings, Hashtable<EmployeeInfo, CheckInOut[]> checksPerEmployee,
			Hashtable<LocalTime, Hashtable<EmployeeInfo, CheckInOut[]>> checksPerEmployeePerDay) {
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
	public Hashtable<EmployeeInfo, CheckInOut[]> getChecksPerEmployee() {
		return checksPerEmployee;
	}

	/**
	 * @param checksPerEmployee the checksPerEmployee to set
	 */
	public void setChecksPerEmployee(Hashtable<EmployeeInfo, CheckInOut[]> checksPerEmployee) {
		this.checksPerEmployee = checksPerEmployee;
	}

	/**
	 * @return the checksPerEmployeePerDay
	 */
	public Hashtable<LocalTime, Hashtable<EmployeeInfo, CheckInOut[]>> getChecksPerEmployeePerDay() {
		return checksPerEmployeePerDay;
	}

	/**
	 * @param checksPerEmployeePerDay the checksPerEmployeePerDay to set
	 */
	public void setChecksPerEmployeePerDay(
			Hashtable<LocalTime, Hashtable<EmployeeInfo, CheckInOut[]>> checksPerEmployeePerDay) {
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
