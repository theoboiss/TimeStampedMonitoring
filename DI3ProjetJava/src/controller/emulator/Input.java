package controller.emulator;

import java.net.ConnectException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JTextField;

import controller.mainapp.TCPMainAppSettings;
import controller.shared.TCPClientEmulator;
import model.emulator.History;
import model.shared.CheckInOut;
import model.shared.EmployeeInfo;
import view.emulator.ViewEmulator;

/**
 * @brief Class for emulator inputs and checks
 *
 */
public class Input {

	/* ================================================================= */
	/*************************** ATTRIBUTES ******************************/
	/*********************************************************************/
	
	private EmulatorSettings settings;

	/* ================================================================= */
	/**************************** BUILDERS *******************************/
	/*********************************************************************/

	/**
	 * @brief One argument copy constructor
	 * @param settings2
	 */
	public Input(EmulatorSettings settings) {
		this.settings = settings;
	}

	
	
	/*********************************************************************/
	/***************************** METHODS *******************************/
	/*********************************************************************/

	/**
	 * @brief Method to send the check in out when an employee enters his id
	 * @param emulator
	 * @throws Exception
	 * @brief Method to get employee id during a check in out and to send it.
	 */
	public void sendCheck(JTextField request) throws Exception {
		CheckInOut checkInOutToSend = null;
		try {
			Integer ID = Integer.parseInt(request.getText());
			checkInOutToSend = new CheckInOut(Integer.parseInt(request.getText()),
						LocalDateTime.now(), false);
			
			// Employee in Emulator database
			boolean found = false;
			for (EmployeeInfo employeeTemp : EmulatorSettings.getListEmployeeInfo()) {
				if (employeeTemp.getID().equals(ID)) {
					found = true;
					EmulatorSettings.getWaitingChecks().add(checkInOutToSend);
					
					new Thread(new TCPClientEmulator(checkInOutToSend, settings.getIPaddressClient(),
							settings.getNumPortClient())).start();
					//System.out.println("->" + Emulator.getCurrentModel().getChecksPerEmployee());
				}
			}
			if (!found)
				System.out.println("Error : ID does not exist in the list !");
			
		} catch (NumberFormatException e) {
			System.out.println("Unexpected argument");
		}
	}
}
