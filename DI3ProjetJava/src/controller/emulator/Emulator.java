package controller.emulator;


import java.util.concurrent.CopyOnWriteArrayList;
import model.emulator.Settings;
import model.shared.CheckInOut;


/**
 * Class to get data from emulator
 *
 */
public class Emulator {
	
	private Settings settings;
	// CheckInOut list from emulator
	private static CopyOnWriteArrayList<CheckInOut> checkInOut;
	// Id list from emulator
	private static CopyOnWriteArrayList<Integer> IDList;
	
	
	/***************** Setter/getter*****************/
	/**
	 * @return the settings
	 */
	public Settings getSettings() {
		return settings;
	}
	/**
	 * @param settings the settings to set
	 */
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	/**
	 * @return the checkInOut
	 */
	public CopyOnWriteArrayList<CheckInOut> getCheckinout() {
		return checkInOut;
	}
	
	/**
	 * @return the iDList
	 */
	public CopyOnWriteArrayList<Integer> getIDList() {
		return IDList;
	}
	/**
	 * @param iDList the iDList to set
	 */
	public void setIDList(CopyOnWriteArrayList<Integer> iDList) {
		IDList = iDList;
	}
	/**********************************************************/
	
	/**
	 * @brief Method to add a list of IDList ID after check in/out
	 * @param iDList
	 */
	public static void addEmployeesID(CopyOnWriteArrayList<Integer> iDList) {
		if(IDList == null){
			IDList = iDList;
		}
		else{
			for(Integer item : iDList){
			   boolean test = false;
			   for(Integer e : IDList){
				   if(item == e){
					   test=true;
				   }
			   }
			   if(test == false){
				   IDList.add(item);
			   }
		   }
	   }
	}
	
	/**
	 * @brief Method to add a single Id
	 * @param ID
	 */
	public static void addEmployeeID(Integer ID){
		if(IDList == null){
			IDList = new CopyOnWriteArrayList<Integer>();
		}
		if(!IDList.contains(ID)){
			IDList.add(ID);
	   }
   }
	
	/**
	 * @brief Method to add checkinouts 
	 * @param checkInOuts
	 */
	public static void addCheckInOut(CopyOnWriteArrayList<CheckInOut> checkInOuts) {
		   if(checkInOut == null){
			   checkInOut = checkInOuts;
		   }
		   else{
			   for(CheckInOut item : checkInOuts){
				   if(!checkInOut.contains(item)) {
					   checkInOut.add(item);
				   }
			   }
		   }
	   }
	
	
	public static void removeCheckInOut() {
		   checkInOut = new CopyOnWriteArrayList<CheckInOut>();
	   }
}

