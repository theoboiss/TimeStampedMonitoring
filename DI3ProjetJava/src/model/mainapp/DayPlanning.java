package model.mainapp;

import java.time.LocalTime;

enum DayName {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
}

public class DayPlanning {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private LocalTime arrivalTime;
	private LocalTime leavingTime;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public DayPlanning() {
		setArrivalTime(LocalTime.of(8, 15));
		setLeavingTime(LocalTime.of(17, 0));
	}
	
	/**
	 * @param arrivalTime
	 * @param leavingTime
	 */
	public DayPlanning(LocalTime arrivalTime, LocalTime leavingTime) {
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
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	/**************************** LeavingTime ***************************/

	/**
	 * @return the leavingTime
	 */
	public LocalTime getLeavingTime() {
		return leavingTime;
	}

	/**
	 * @param leavingTime the leavingTime to set
	 */
	public void setLeavingTime(LocalTime leavingTime) {
		this.leavingTime = leavingTime;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {return "Arrival Time : " + this.arrivalTime + "\nLeaving Time : " + this.leavingTime;}
			
	public static void main(String[] args){
		LocalTime arrivalTime = LocalTime.of(9, 0);
		LocalTime leavingTime = LocalTime.of(17, 30);
		DayPlanning day = new DayPlanning(arrivalTime, leavingTime);
		DayPlanning day2 = new DayPlanning();
		System.out.println(day);
		System.out.println(day2);
	}

}


