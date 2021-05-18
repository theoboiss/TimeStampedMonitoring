package model.mainapp;

public class DayPlanning {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private DayName name;
	private Hour arrivalTime;
	private Hour leavingTime;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public DayPlanning() {
		Hour arrivalTime = new Hour(8,15);
		Hour leavingTime = new Hour(17,0);
		setArrivalTime(arrivalTime);
		setLeavingTime(leavingTime);
	}
	
	/**
	 * @param arrivalTime
	 * @param leavingTime
	 */
	public DayPlanning(Hour arrivalTime, Hour leavingTime) {
		setArrivalTime(arrivalTime);
		setLeavingTime(leavingTime);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/**************************** ArrivalTime ****************************/
	
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
	
	/**************************** LeavingTime ***************************/

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
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {return "Arrival Time : " + this.arrivalTime + "\nLeaving Time : " + this.leavingTime;}
			

}
