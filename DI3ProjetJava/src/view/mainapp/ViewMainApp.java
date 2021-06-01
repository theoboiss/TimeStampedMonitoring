package view.mainapp;

import javax.swing.*;

public class ViewMainApp extends JFrame {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JTabbedPane mainTabbedPane;
	private ViewEmployees frameEmployees;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewMainApp () {
		build();
	}
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/*************************** frameEmployees **************************/
	
	/**
	 * @return the frameEmployees
	 */
	public ViewEmployees getFrameEmployees() {
		return frameEmployees;
	}

	/**
	 * @param frameEmployees the frameEmployees to set
	 */
	public void setFrameEmployees(ViewEmployees frameEmployees) {
		this.frameEmployees = frameEmployees;
	}
	
	/*************************** mainTabbedPane **************************/
	
	/**
	 * @return the mainTabbedPane
	 */
	public JTabbedPane getMainTabbedPane() {
		return mainTabbedPane;
	}

	/**
	 * @param mainTabbedPane the mainTabbedPane to set
	 */
	public void setMainTabbedPane(JTabbedPane mainTabbedPane) {
		this.mainTabbedPane = mainTabbedPane;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	/**
	 * @brief Method which create main frame and panel.
	 */
	private void build() {
		
		//create frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,300,500,500);
		this.setTitle("Main application");
		
		//create panel	
		buildContentMainTabbedPane();

		this.add(mainTabbedPane);
		this.setVisible(true);
	}


	/**
	 * @brief Method which build main tabbedPane.
	 */
	private void buildContentMainTabbedPane(){
		mainTabbedPane = new JTabbedPane();
		
		//Employees
		frameEmployees = new ViewEmployees();
		JTabbedPane tabbedPaneEmployees = new JTabbedPane();
		tabbedPaneEmployees.addTab("Search", frameEmployees.getPanelSearch());
		tabbedPaneEmployees.addTab("Add", frameEmployees.getPanelAdd());
		mainTabbedPane.addTab("Employees", tabbedPaneEmployees);
		
		//CheckInOuts
		JComponent panelCheckInOuts = new JPanel();
		mainTabbedPane.addTab("CheckInOuts", null, panelCheckInOuts,
                null);
		
		//Settings
		JComponent panelSettings = new JPanel();
		mainTabbedPane.addTab("Settings", null, panelSettings,
                null);
		
	}

	
	public static void main(String[] args) {
		new ViewMainApp();
	}
	
}
