package model.mainapp;

import java.time.LocalTime;

public class Hour {

	/*********************************************************************/
	/***************************** ATTRIBUTS *****************************/
	/*********************************************************************/
	
	private byte hours, minutes;
		
	
	/*********************************************************************/
	/*************************** CONSTRUCTEURS ***************************/
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
	/********************** ACCESSEURS ET MUTATEURS **********************/
	/*********************************************************************/
	
	/******************************* HOURS *******************************/
	
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
	
	/****************************** MINUTES ******************************/
	
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
	/************************** AUTRES METHODES **************************/
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
	public String toString() {return this.hours + ":" + this.minutes;}
	
	
}
