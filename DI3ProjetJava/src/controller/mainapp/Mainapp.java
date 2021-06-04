package controller.mainapp;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import model.mainapp.*;
import view.mainapp.ViewMainApp;

public abstract class Mainapp {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	private static String fileName = "backup/serializedData"; //it should be chosen in the settings
	private static Company currentModel;
	
	private static class PeriodicSave extends TimerTask {
		@Override
		public void run() {
			LocalDateTime now = LocalDateTime.now();
			String saveFileName = fileName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("-HH.mm-MM.dd.yyyy"));
			try {
				File newFile = new File(saveFileName + ".ser");
				try {
					newFile.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				MainappData.save(saveFileName + ".ser", getCurrentModel());
				System.out.println("(Backup done at " + now.format(DateTimeFormatter.ofPattern("dd-HH:mm")) + ")");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/**
	 * @return the currentModel
	 */
	public static Company getCurrentModel() {
		return Mainapp.currentModel;
	}

	/**
	 * @param currentModel the currentModel to set
	 * @throws Exception
	 */
	public static void setCurrentModel(Company currentModel) {
		Mainapp.currentModel = currentModel;
	}

	/*********************************************************************/
	/******************************** MAIN *******************************/
	/*********************************************************************/

	public static void main(String[] args) {
		java.util.Scanner entree = null;
		do {
			try {
				setCurrentModel(MainappData.restore(fileName+".ser"));

			} catch (FileNotFoundException e) {
				e.getMessage();
				System.out.print("This file does not exist, are you sure you want to use " + fileName + "(.ser) (y/n) ? ");
				entree = new java.util.Scanner(System.in);
				String answer = entree.next();
				if (answer.equals("y")) {
					File newFile = new File(fileName+".ser");
					try {
						newFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (answer.equals("n")) {
					System.out.print("Enter the name of the file you want (.ser) : ");
					fileName = entree.next();
				}

			} catch (EOFException e) {
				try {
					setCurrentModel(new Company());

				} catch (Exception e1) {
					entree.close();
					e1.printStackTrace();
				}
			} catch (Exception e) {
				entree.close();
				e.printStackTrace();
			}
		} while (getCurrentModel() == null);
		if (entree != null)
			entree.close();

		
		Timer timer = new Timer();
	    timer.schedule(new PeriodicSave(), 5000, 30*60000); //save 5s for testing after the oppening, then every 30m
	    
	    
		new ViewMainApp();
	}
}
