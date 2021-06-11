package controller.emulator;

import java.net.ConnectException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import controller.shared.TCPClientEmulator;
import model.emulator.History;
import model.shared.CheckInOut;
import model.shared.EmployeeInfo;
import view.emulator.ViewEmulator;

public class Input {
	private CheckInOut checksFromEmulator;

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

		// Adding checks to history database
		History.addToHistory(checksFromEmulator, info, date);

	}

	/**
	 * @param emulator
	 * @throws Exception
	 * @brief Method to get employee id during a check in out and to send it.
	 */
	@SuppressWarnings("unlikely-arg-type")
	public void sendCheck(ViewEmulator emulator) throws Exception {

		EmulatorSettings settings = new EmulatorSettings();
		Input inputCheck = new Input();

		try {
			Integer ID = Integer.parseInt(emulator.getIDField().getText());

			// Employee in Emulator database
			if (settings.getListEmployeeID().contains(ID))
				;
			{
				CheckInOut checkInOutToSend = new CheckInOut(Integer.parseInt(emulator.getIDField().getText()),
						LocalDateTime.now(), true);

				// Creating and adding check to history
				inputCheck.addElmentToCheckInOut();
				try {
					new Thread(new TCPClientEmulator(checkInOutToSend, settings.getIPaddressClient(),
							settings.getNumPortClient())).start();
					// Creating and adding check to history if the operation is successful
					inputCheck.addElmentToCheckInOut();
				} catch (ConnectException ce) {
					System.out.println("Check in out could not be sent !");
					// Adding the check in out to the waiting list
					settings.addWaitingChecks(checkInOutToSend);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Unexpected argument");
		}

	}
}
