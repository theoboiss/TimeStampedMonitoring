package controller.emulator;

import java.io.IOException;
import java.time.LocalDateTime;

import controller.emulator.Emulator;
import controller.shared.TCPClientEmulator;
import controller.shared.TCPServerEmulator;
import model.shared.CheckInOut;
import view.emulator.ViewEmulator;

/**
 * @brief Principal Class to control the emulator
 *
 */
public class Emulator extends EmulatorSettings {

	private static final long serialVersionUID = 1L;

	/* ================================================================= */
	/**************************** BUILDERS *******************************/
	/*********************************************************************/

	/**
	 * @brief Default constructor
	 */
	public Emulator() {
		super();
	}

	/**
	 * @brief Two arguments constructor
	 * @param emulatorSettingsSaved
	 * @param emulatorRestorationProcess
	 */
	public Emulator(EmulatorSettings emulatorSettingsSaved, EmulatorBackup emulatorRestorationProcess) {
		super(emulatorSettingsSaved, emulatorRestorationProcess);
	}

	/**
	 * @brief One argument constructor
	 * @param backupFileName
	 */
	public Emulator(String backupFileName) {
		super(backupFileName);
	}

	/* ================================================================= */
	/*************************** MAIN METHOD *****************************/
	/*********************************************************************/
	/**
	 * @brief Main method to launch emulator
	 * @param args
	 */
	public static void main(String[] args) {
		String target = "backupEmulator/serializedData.ser";
		EmulatorBackup restorationProcess = new EmulatorBackup();
		EmulatorSettings emulatorSaved = null;
		Emulator current = null;
		try {
			emulatorSaved = (EmulatorSettings) restorationProcess.restoreData(lastModifiedFileRelatedTo(target), 1);
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassCastException e) {
			System.out.println("Information : backup did not contain settings data.");
		}

		if (emulatorSaved != null)
			current = new Emulator(emulatorSaved, restorationProcess);
		else
			current = new Emulator(lastModifiedFileRelatedTo(target));

		new ViewEmulator(current);
		new Thread(new TCPServerEmulator(current, current.getIPaddressServer(), current.getNumPortServer())).start();

		try {
			new Thread(new TCPClientEmulator(current, EmulatorSettings.getWaitingChecks(), current.getIPaddressClient(),
					current.getNumPortClient())).start();
		} catch (Exception e) {
			System.out.println("Exception in Emulator main : " + e.getMessage());
		}
	}
}