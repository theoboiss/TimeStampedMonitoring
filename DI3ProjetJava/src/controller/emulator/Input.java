package controller.emulator;


import java.time.LocalDate;

import model.emulator.History;
import model.emulator.History.EventDuringCheck;
import model.shared.CheckInOut;
import model.shared.EmployeeInfo;
import view.emulator.ViewEmulator;
public class Input 
{
	private CheckInOut checksFromEmulator;
	private EventDuringCheck event;
	
	/**
	 * @throws Exception
	 * @brief Method to add Employee ID and time of CheckInOut
	 */
	public void addElmentToCheckInOut() throws Exception {

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
}
