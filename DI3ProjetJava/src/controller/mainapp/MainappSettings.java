package controller.mainapp;

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

import model.mainapp.Company;
import model.mainapp.Employee;
import model.mainapp.SearchInMainapp;
import model.shared.EmployeeInfo;

public class MainappSettings extends TCPMainAppSettings implements Serializable {

	private static final long serialVersionUID = -786389681881788698L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	private static Company currentModel;
	private transient MainappBackup dataManagment;
	private String backupFileName;
	private long[] timersForBackup = {5*1000, 5*60*1000}; //in milliseconds
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public MainappSettings() {
		super();
	}

	public MainappSettings(String backupFileName) {
		setBackupFileName(backupFileName);
		setDataManagment(new MainappBackup());
		

		Scanner input = new Scanner(System.in);
		do {
			try {
				  setCurrentModel((Company) getDataManagment().restore(getBackupFileName()));
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
	    timer.schedule(new PeriodicSave(this), timersForBackup[0], timersForBackup[1]);
	}


	/**
	 * @brief Copy constructor
	 * @param mainappSettingsSaved
	 */
	public MainappSettings(MainappSettings mainappSettingsSaved, MainappBackup mainappRestorationProcess) {
		mainappSettingsSaved.copiesIn(this);
		setDataManagment(mainappRestorationProcess);		

		Scanner input = new Scanner(System.in);
		do {
			try {
				  setCurrentModel((Company) getDataManagment().restore(getBackupFileName(), -1));
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

	private class PeriodicSave extends TimerTask implements Serializable {
		private static final long serialVersionUID = 4275212943329005505L;
		
		public transient MainappSettings settingsData;
		
		public PeriodicSave(MainappSettings settingsData) {
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
					getDataManagment().save(getBackupFileName(), settingsData, 1);
					getDataManagment().save(getBackupFileName(), getCurrentModel(), -1);
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
	
	public void copiesIn(MainappSettings receiving) {
		receiving.setBackupFileName(this.getBackupFileName());
		//receiving.setBackupFileName("backupMainapp/serializedData.ser"); //to force the new destination
		receiving.setTimersForBackup(this.getTimersForBackup());
		//more settings to copy soon, including TCP settings
	}
	
	public ArrayList<EmployeeInfo> getEmployeeInfo() throws Exception {
		ArrayList<EmployeeInfo> arrayToReturn = new ArrayList<EmployeeInfo>();
		ArrayList<Employee> arrayToCast = SearchInMainapp.searchEmployee(getCurrentModel());
		for (int i = 0; i < arrayToCast.size() ; i++) {
			arrayToReturn.add((EmployeeInfo)arrayToCast.get(i));
		}
		return arrayToReturn;
	}
	
	public static ArrayList<EmployeeInfo> castInEmployeeInfo(ArrayList<Employee> arrayToCast) throws Exception {
		ArrayList<EmployeeInfo> arrayToReturn = new ArrayList<EmployeeInfo>();
		for (int i = 0; i < arrayToCast.size() ; i++) {
			arrayToReturn.add((EmployeeInfo)arrayToCast.get(i));
		}
		return arrayToReturn;
	}
}
