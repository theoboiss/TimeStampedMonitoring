package controller.emulator;

import model.emulator.Settings;

public class Input 
{
	/* ================================================================= */
	/************************* CLASS ATTRIBUTS ***************************/
	/*********************************************************************/

	private Settings settings;
	private CheckInOut checks;

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/*************************** CONSTRUCTORS ****************************/
	/*********************************************************************/

	/**
	 * @brief Default Constructor
	 */
	public Input() 
	{
		settings = new Settings();
		checks = new CheckInOut();
	}

	/**
	 * @brief Copy Constructor
	 * @param settings
	 * @param checks
	 */
	public Input(Settings settings, CheckInOut checks) 
	{
		super();
		this.settings = settings;
		this.checks = checks;
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
	public Settings getSettings() 
	{
		return settings;
	}

	/**
	 * @param settings the settings to set
	 */
	public void setSettings(Settings settings) 
	{
		this.settings = settings;
	}

	/**
	 * @return the checks
	 */
	public CheckInOut getChecks() 
	{
		return checks;
	}

	/**
	 * @param checks the checks to set
	 */
	public void setChecks(CheckInOut checks) 
	{
		this.checks = checks;
	}

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */
}
