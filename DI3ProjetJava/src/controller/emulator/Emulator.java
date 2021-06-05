package controller.emulator;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;
import model.emulator.History;
import model.emulator.History.EventDuringCheck;
import model.shared.CheckInOut;
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
	 * @brief Method to add Employee ID and time of CheckInOut
	 */
	public void addElmentToCheckInOut(Integer empID) {
		History historyCheck = new History(empID);
		CopyOnWriteArrayList<CheckInOut> listChecks = new CopyOnWriteArrayList<CheckInOut>();
		listChecks = ViewEmulator.getChecks();
		
		LocalDateTime time;
		// Creating a check in out
		for (CheckInOut item : listChecks) {
			checksFromEmulator.setEmployeeID(item.getEmployeeID());
			checksFromEmulator.setCheckTime(item.getCheckTime());
			checksFromEmulator.setEvent(item.getEvent());
			// Adding checks to history database
			historyCheck.addToHistory(event, null, null, item);
		}
	}
}
