package controller.emulator;

import java.io.IOException;
import controller.emulator.Emulator;
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

		try {
			emulatorSaved = (EmulatorSettings) restorationProcess.restoreData(lastModifiedFileRelatedTo(target), 1);
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassCastException e) {
			System.out.println("Information : backup did not contain settings data.");
		}

		if (emulatorSaved != null)
			new Emulator(emulatorSaved, restorationProcess);
		else
			new Emulator(lastModifiedFileRelatedTo(target));

		new ViewEmulator();

		// TODO main function lance vue + serveur emulateur

	}
}