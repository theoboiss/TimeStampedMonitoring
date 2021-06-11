package controller.emulator;

import java.io.IOException;

import controller.emulator.Emulator;
import controller.shared.TCPClientEmulator;
import controller.shared.TCPServerEmulator;
import view.emulator.ViewEmulator;

/**
 * Class to collect data from emulator
 *
 */
public class Emulator extends EmulatorSettings {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	/****************************** BUILDERS *****************************/

	public Emulator()
	{
		super();
	}
	public Emulator(EmulatorSettings emulatorSettingsSaved, EmulatorBackup emulatorRestorationProcess) {
		super(emulatorSettingsSaved, emulatorRestorationProcess);
	}

	public Emulator(String backupFileName) {
		super(backupFileName);
	}

	/**************************** MAIN METHOD ****************************/

	public static void main(String[] args) {
		String target = "backupEmulator/serializedData.ser";
		EmulatorBackup restorationProcess = new EmulatorBackup();
		EmulatorSettings emulatorSaved = null;
		Emulator current =null;
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
		

		new ViewEmulator();
		new Thread(new TCPServerEmulator(current, current.getIPaddressServer(), current.getNumPortServer())).start(); 

		try {
			new Thread(new TCPClientEmulator(current, current.getWaitingChecks(), current.getIPaddressClient(), current.getNumPortClient())).start(); 
		} catch (Exception e) {
			System.out.println("Exception in Emulator main : " + e.getMessage());
		}
	}
}