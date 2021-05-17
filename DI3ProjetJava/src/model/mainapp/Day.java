package model.mainapp;

public class Day {
	
	public enum Name {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
	}
	
	/*********************************************************************/
	/***************************** ATTRIBUTS *****************************/
	/*********************************************************************/
	
	private Name name;
	private Hour arrivalTime;
	private Hour leavingTime;
	
	
	/*********************************************************************/
	/*************************** CONSTRUCTEURS ***************************/
	/*********************************************************************/
	
	public Day() {
		Hour arrivalTime = new Hour();
		Hour leavingTime = new Hour();
		setName(name.MONDAY);
		setArrivalTime(arrivalTime);
		setLeavingTime(leavingTime);
	}
	
	/**
	 * @param name
	 * @param arrivalTime
	 * @param leavingTime
	 */
	public Day(Name name, Hour arrivalTime, Hour leavingTime) {
		setName(name);
		setArrivalTime(arrivalTime);
		setLeavingTime(leavingTime);
	}
	
	/**
	 * @param name
	 */
	public Day(Name name)
	{
		Hour arrivalTime = new Hour(8,30);
		Hour leavingTime = new Hour(17,0);
		setName(name);
		setArrivalTime(arrivalTime);
		setLeavingTime(leavingTime);
	}
	
	
	/*********************************************************************/
	/********************** ACCESSEURS ET MUTATEURS **********************/
	/*********************************************************************/
	
	/**************************** ARRIVALTIME ****************************/
	
	/**
	 * @return the arrivalTime
	 */
	public Hour getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(Hour arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	/**************************** LEAVINGTIME ***************************/

	/**
	 * @return the leavingTime
	 */
	public Hour getLeavingTime() {
		return leavingTime;
	}

	/**
	 * @param leavingTime the leavingTime to set
	 */
	public void setLeavingTime(Hour leavingTime) {
		this.leavingTime = leavingTime;
	}

	/****************************** NAME ******************************/
	
	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	
	/*********************************************************************/
	/************************** AUTRES METHODES **************************/
	/*********************************************************************/
	
	@Override
	public String toString() {return this.name + "\nArrival Time : " + this.arrivalTime + "\nLeaving Time : " + this.leavingTime;}
			

}
