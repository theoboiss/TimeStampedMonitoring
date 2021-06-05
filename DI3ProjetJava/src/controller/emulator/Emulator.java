package controller.emulator;


import java.time.LocalDate;
import java.util.concurrent.CopyOnWriteArrayList;
import model.emulator.History;
import model.emulator.History.EventDuringCheck;
import model.shared.CheckInOut;
import model.shared.EmployeeInfo;
import view.emulator.ViewEmulator;

/**
 * Class to collect data from emulator
 *
 */
public class Emulator {

	// Attribute to gather CheckInOuts from Emulator once an employee has entered
	// his ID
	private CheckInOut checksFromEmulator;
	private EventDuringCheck event;

	/***************** Setter/getter *****************/
	/**
	 * @return the checksFromEmulator
	 */
	public CheckInOut getChecksFromEmulator() {
		return checksFromEmulator;
	}

	/**
	 * @param checksFromEmulator the checksFromEmulator to set
	 */
	public void setChecksFromEmulator(CheckInOut checksFromEmulator) {
		this.checksFromEmulator = checksFromEmulator;
	}

	/***************** Methods *****************/
	/**
	 * @throws Exception 
	 * @brief Method to add Employee ID and time of CheckInOut
	 */
	public void addElmentToCheckInOut() throws Exception {
		//History historyCheck = new History(empID);
		
		EmployeeInfo info = new EmployeeInfo();
		LocalDate date = LocalDate.now();
		date = ViewEmulator.getDate();
		CheckInOut checks = new CheckInOut();
		checks = ViewEmulator.getChecks();
		info.setID(checks.getEmployeeID());
		// Creating a check in out
		checksFromEmulator.setEmployeeID(checks.getEmployeeID());
		checksFromEmulator.setCheckTime(checks.getCheckTime());
		checksFromEmulator.setEvent(checks.getEvent());
		// Adding checks to history database
		History.addToHistory(checksFromEmulator, info, date);
		
	}
	
	/**
	 * @brief Method to remove a check
	 */
	public void removeCheckInOut() {
		   this.checksFromEmulator = new CheckInOut();
		   this.event = null;
	   }
}
