package model.mainapp;

public class Hour {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private byte hours, minutes;
		
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
		
	public Hour() { setHours(0); setMinutes(0); }
	
	/**
	 * @param heures
	 * @param minutes
	 */
	public Hour(int heures, int minutes) 
	{
		if (!isValidHour(heures, minutes)) 
		{
			throw new IllegalArgumentException("Invalid hour");
		}
		setHours(heures);
		setMinutes(minutes);
	}
		
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/******************************* Hours *******************************/
	
	/**
	 * @return the hours
	 */
	public int getHours() {return this.hours;}
	
	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) 
	{
		if (!isValidHour(hours, 0)) 
		{
			throw new IllegalArgumentException("Invalid hours");
		}
		this.hours = (byte) hours;
	}
	
	/****************************** Minutes ******************************/
	
	/**
	 * @return the minutes
	 */
	public int getMinutes() {return this.minutes;}
	
	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) 
	{
		if (!isValidHour(0, minutes)) 
		{
			throw new IllegalArgumentException("Invalid minutes");
		}
		this.minutes = (byte) minutes;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	/**
	 * @param hour
	 * @param minutes
	 * @return boolean
	 */
	public boolean isValidHour(int hour, int minutes)
	{
		if (0 <= hour && hour <= 23 && 0 <= minutes && minutes <= 59) {return true;}
		return false;
	}
		
	@Override	
	public String toString() {
		if ((int) this.minutes < 10) { return this.hours + ": 0" + this.minutes; }
		return this.hours + ":" + this.minutes;
	}
	
	
}
