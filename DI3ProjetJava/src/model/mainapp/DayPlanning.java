package model.mainapp;

enum DayName {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
}

public class DayPlanning {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
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
			
	public static void main(String[] args){
		Hour arrivalTime = new Hour(6, 15);
		Hour leavingTime = new Hour(17, 15);
		DayPlanning day = new DayPlanning(arrivalTime, leavingTime);
		DayPlanning day2 = new DayPlanning();
		System.out.println(day);
		System.out.println(day2);
	}

}


