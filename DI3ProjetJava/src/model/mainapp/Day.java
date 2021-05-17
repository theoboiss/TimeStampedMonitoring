package model.mainapp;

public class Day {
	
	public enum Name {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
	}
	
	private Name name;
	private Hour arrivalTime;
	private Hour leavingTime;
	
	public Day() {
		Hour arrivalTime = new Hour();
		Hour leavingTime = new Hour();
		setAll(Name.MONDAY, arrivalTime, leavingTime);
	}
	
	/**
	 * @param name
	 * @param arrivalTime
	 * @param leavingTime
	 */
	public Day(Name name, Hour arrivalTime, Hour leavingTime) {
		setAll(name, arrivalTime, leavingTime);
	}
	
	//GETTERS ET SETTERS
	
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

	/**
	 * @return the Name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param Name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	/**
	 * @param name
	 * @param arrivalTime
	 * @param leavingTime 
	 */
	public void setAll(Name name, Hour arrivalTime, Hour leavingTime) {
		setName(name);
		setArrivalTime(arrivalTime);
		setLeavingTime(leavingTime);
	}
	
	//redefinition methode toString
	public String toString() {return this.name + "\nArrival Time : " + this.arrivalTime + "\nLeaving Time : " + this.leavingTime;}
			

}
