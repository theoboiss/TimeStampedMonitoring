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

	
}
