package controller.emulator;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import model.emulator.History;
import model.shared.EmployeeInfo;

public class EmulatorSettings extends TCPEmulatorSettings {

@SuppressWarnings("unused")
private static final long serialVersionUID = -786389681881788698L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	private static History currentModel;
	private transient EmulatorBackup backupData;
	private ArrayList<EmployeeInfo> listEmployeeID;
	private LocalDateTime dateTime;
	private String backupFileName;
	private long[] timersForBackup = {5*1000, 30*60*1000}; //in milliseconds
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	public EmulatorSettings()
	{
		super();
	}
	
	public EmulatorSettings(String backupFileName) {
		setBackupFileName(backupFileName);
		setDataManagment(new EmulatorBackup());
		

		Scanner input = new Scanner(System.in);
		do {
			try {
				  setCurrentModel((History) getDataManagment().restoreData(getBackupFileName()));
			}
			catch (FileNotFoundException e) {
				try {
					handleInvalidFileName(getBackupFileName(), input);
				}
				catch (IOException | ClassNotFoundException e1) { System.out.println(e1.getMessage()); }
			}
			catch (EOFException e) {
				try {
					setCurrentModel(new History());
				}
				catch (Exception e1) { e1.printStackTrace(); }
			}
			catch (Exception e) { e.printStackTrace(); }
		} while (getCurrentModel() == null);
		if (input != null)
			input.close();

		Timer timer = new Timer();
	    timer.schedule(new PeriodicSave(this), timersForBackup[0], timersForBackup[1]);
	}


	/**
	 * @brief Copy constructor
	 * @param mainappSettingsSaved
	 */
	public EmulatorSettings(EmulatorSettings mainappSettingsSaved, EmulatorBackup mainappRestorationProcess) {
		mainappSettingsSaved.copiesIn(this);
		setDataManagment(mainappRestorationProcess);		

		Scanner input = new Scanner(System.in);
		do {
			try {
				  setCurrentModel((History) getDataManagment().restoreData(getBackupFileName(), -1));
			}
			catch (FileNotFoundException e) {
				try {
					handleInvalidFileName(getBackupFileName(), input);
				}
				catch (IOException | ClassNotFoundException e1) { System.out.println(e1.getMessage()); }
			}
			catch (EOFException e) {
				try {
					setCurrentModel(new History());
				}
				catch (Exception e1) { e1.printStackTrace(); }
			}
			catch (Exception e) { e.printStackTrace(); }
		} while (getCurrentModel() == null);
		if (input != null)
			input.close();

		Timer timer = new Timer();
	    timer.schedule(new PeriodicSave(this), timersForBackup[0], timersForBackup[1]);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/**
	 * @return the fileName
	 */
	public String getBackupFileName() {
		return backupFileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setBackupFileName(String backupFileName) {
		if (!backupFileName.substring(backupFileName.length()-4, backupFileName.length()).equals(".ser"))
			throw new IllegalArgumentException("The backup file name must end by .ser");
		
		this.backupFileName = backupFileName;
	}

	/**
	 * @return the currentModel
	 */
	public static History getCurrentModel() {
		return EmulatorSettings.currentModel;
	}

	/**
	 * @param currentModel the currentModel to set
	 * @throws Exception
	 */
	public static void setCurrentModel(History currentModel) {
		EmulatorSettings.currentModel = currentModel;
	}

	/**
	 * @return the backupData
	 */
	public EmulatorBackup getDataManagment() {
		return this.backupData;
	}

	/**
	 * @param backupData the backupData to set
	 */
	public  void setDataManagment(EmulatorBackup backupData) {
		this.backupData = backupData;
	}
	
	/**
	 * @return the timersForBackup
	 */
	public long[] getTimersForBackup() {
		return timersForBackup;
	}

	/**
	 * @param timersForBackup the timersForBackup to set
	 */
	public void setTimersForBackup(long[] timersForBackup) {
		this.timersForBackup = timersForBackup;
	}
	
	
	/**
	 * @return the backupData
	 */
	public EmulatorBackup getBackupData() {
		return backupData;
	}

	/**
	 * @param backupData the backupData to set
	 */
	public void setBackupData(EmulatorBackup backupData) {
		this.backupData = backupData;
	}

	/**
	 * @return the listEmployeeID
	 */
	public ArrayList<EmployeeInfo> getListEmployeeID() {
		return listEmployeeID;
	}

	/**
	 * @param listEmployeeID the listEmployeeID to set
	 */
	public void setListEmployeeID(ArrayList<EmployeeInfo> listEmployeeID) {
		this.listEmployeeID = listEmployeeID;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	/*********************************************************************/
	/**************************** INTERN CLASS ***************************/
	/*********************************************************************/

	private class PeriodicSave extends TimerTask implements Serializable {
		private static final long serialVersionUID = 4275212943329005505L;
		
		public EmulatorSettings settingsData;
		
		public PeriodicSave(EmulatorSettings settingsData) {
			this.settingsData = settingsData;
		}
		
		@Override
		public void run() {
			if (getCurrentModel() != null) {
				LocalDateTime nowTime = LocalDateTime.now();
				File file = new File(getBackupFileName());
				
				if (file.length() > 0) {
					//create the new backup file name
					String newBackupFileName = getBackupFileName();
					
					int evidenceRecentBackup = newBackupFileName.indexOf("-");
					if (evidenceRecentBackup >= 0)
						newBackupFileName = newBackupFileName.substring(0, evidenceRecentBackup);
					else
						newBackupFileName = newBackupFileName.substring(0, newBackupFileName.length()-4);
					
					newBackupFileName += nowTime.format(DateTimeFormatter.ofPattern("-HH.mm-yyyy.MM.dd")) + ".ser";
					setBackupFileName(newBackupFileName);
					
					//create the new backup file
					try {
						File newFile = new File(getBackupFileName());
						newFile.createNewFile();
					}
					catch (IOException e1) { e1.printStackTrace(); }
				}
				
				try {
					getDataManagment().saveData(getBackupFileName(), settingsData, 1);
					getDataManagment().saveData(getBackupFileName(), getCurrentModel(), -1);
					System.out.println("(Backup made on "
							+ nowTime.format(DateTimeFormatter.ISO_LOCAL_DATE) + " at "
							+ nowTime.format(DateTimeFormatter.ofPattern("HH:mm")) + ")");
				}
				catch (IOException e) { e.printStackTrace(); }
			}
		}
	}
	

	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	/**
	 * @param fileName
	 * @param input
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void handleInvalidFileName(String fileName, Scanner input) throws IOException, ClassNotFoundException {
		System.out.print("This file does not exist, are you sure you want to use " + fileName + " (y/n) ? ");
		String answer = input.next();
		if (answer.equals("y")) {
			File newFile = new File(fileName);
			newFile.createNewFile();
		} else if (answer.equals("n")) {
			System.out.print("Enter the name of the file you want : ");
			setBackupFileName(input.next());
		}
	}
	
	public static String lastModifiedFileRelatedTo(String fileName) {
		if (new File(fileName).exists()) {
			File directory = new File(fileName).getParentFile();
			File[] listFiles = directory.listFiles();
			if (listFiles.length > 0) {
				for (Integer iterator1 = 0; iterator1 < listFiles.length; iterator1++) {
					//eliminate the files that does not end by ".ser"
					String currentFileName = listFiles[iterator1].getName();
					if (!currentFileName.substring(currentFileName.length()-4, currentFileName.length()).equals(".ser")) {
						for (Integer iteratorDel = iterator1+1; iteratorDel < listFiles.length; iteratorDel++)
							listFiles[iteratorDel-1] = listFiles[iteratorDel];
					}
					
					//sort by last modified
					for (Integer iterator2 = iterator1; iterator2 < listFiles.length; iterator2++) {
						if (listFiles[iterator1].lastModified() < listFiles[iterator2].lastModified()) {
							File fileTemp = listFiles[iterator1];
							listFiles[iterator1] = listFiles[iterator2];
							listFiles[iterator2] = fileTemp;
						}
					}
				}
				return directory.getName() + "/" + listFiles[0].getName();
			}
		}
		return fileName;
	}
	
	public void copiesIn(EmulatorSettings receiving) {
		receiving.setBackupFileName(this.getBackupFileName());
		//receiving.setBackupFileName("backupMainapp/serializedData.ser"); //to force the new destination
		receiving.setTimersForBackup(this.getTimersForBackup());
		//more settings to copy soon, including TCP settings
	}

}
