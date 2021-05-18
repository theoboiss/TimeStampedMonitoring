package model.mainapp;

import java.util.concurrent.ConcurrentHashMap;

public class Planning {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private ConcurrentHashMap <DayName, DayPlanning> planning;

	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	public Planning() {
		this.planning = new ConcurrentHashMap<DayName, DayPlanning>();
		for (DayName dayName : DayName.values()) {
			DayPlanning defaultDay = new DayPlanning();
			this.planning.put(dayName, defaultDay);
		}
	}
	
	/**
	 * @param planning
	 */
	public Planning(ConcurrentHashMap<DayName, DayPlanning> planning) {
		setPlanning(planning);
	}

	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/**
	 * @return the planning
	 */
	public ConcurrentHashMap<DayName, DayPlanning> getPlanning() {
		return planning;
	}

	/**
	 * @param planning the planning to set
	 */
	public void setPlanning(ConcurrentHashMap<DayName, DayPlanning> planning) {
		this.planning = new ConcurrentHashMap<DayName, DayPlanning>(planning);
	}
	
	/**
	 * @param name
	 * @return DayPlanning (null if name does not exist)
	 */
	public DayPlanning getDayPlanning(DayName name) {
		return this.planning.get(name);
	}
	
	@Override
	public String toString() {
		return this.planning.toString().replace("=", "\n").replace(",", "\n\n");
	}
	
	public static void main(String[] args){
		Planning planning = new Planning();
		Hour leavingTime = new Hour(12, 0);
		//System.out.println(planning);
		planning.getDayPlanning(DayName.FRIDAY).setLeavingTime(leavingTime);
		System.out.println(planning);
	}

	
}
