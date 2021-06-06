package controller.mainapp;

import view.mainapp.ViewMainApp;


public class Mainapp extends MainappSettings {
	
	/****************************** BUILDERS *****************************/

	public Mainapp() {
		super(lastModifiedFileRelatedTo("backup/serializedData.ser")); //by default
	}

	public Mainapp(String backupFileName) {
		super(backupFileName);
	}

	
	/**************************** MAIN METHOD ****************************/
	
	public static void main(String[] args) {
		new Mainapp();
		
		new ViewMainApp();
	}
}
