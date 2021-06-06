package controller.mainapp;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import model.mainapp.Company;

public abstract class MainappSettings {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	private static Company currentModel;
	private String backupFileName;
	private MainappBackup dataManagment;
	private long[] timersForBackup = {5*1000, 30*60*1000}; //in milliseconds
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	public MainappSettings(String backupFileName) {
		if (backupFileName.contains("-"))
			throw new IllegalArgumentException("The backup file name must not contain '-'");
		
		setBackupFileName(backupFileName);
		setDataManagment(new MainappBackup());
		

		Scanner input = new Scanner(System.in);
		do {
			try {
				setCurrentModel((Company) getDataManagment().restore(getBackupFileName()));
				//settings_data = getDataManagment().restore(getBackupFileName());
				//...
			}
			catch (FileNotFoundException e) {
				try {
					handleInvalidFileName(getBackupFileName(), input);
				}
				catch (IOException | ClassNotFoundException e1) { System.out.println(e1.getMessage()); }
			}
			catch (EOFException e) {
				try {
					setCurrentModel(new Company());
				}
				catch (Exception e1) { e1.printStackTrace(); }
			}
			catch (Exception e) { e.printStackTrace(); }
		} while (getCurrentModel() == null);
		if (input != null)
			input.close();

		Timer timer = new Timer();
	    timer.schedule(new PeriodicSave(), timersForBackup[0], timersForBackup[1]);
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
	public static Company getCurrentModel() {
		return MainappSettings.currentModel;
	}

	/**
	 * @param currentModel the currentModel to set
	 * @throws Exception
	 */
	public static void setCurrentModel(Company currentModel) {
		MainappSettings.currentModel = currentModel;
	}

	/**
	 * @return the dataManagment
	 */
	public MainappBackup getDataManagment() {
		return this.dataManagment;
	}

	/**
	 * @param dataManagment the dataManagment to set
	 */
	public  void setDataManagment(MainappBackup dataManagment) {
		this.dataManagment = dataManagment;
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
	
	
	/*********************************************************************/
	/**************************** INTERN CLASS ***************************/
	/*********************************************************************/

	private class PeriodicSave extends TimerTask { //it will be defined in the settings
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
					getDataManagment().save(getBackupFileName(), getCurrentModel());
					//getDataManagment().save(getBackupFileName(), settings_data);
					//...
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
}
