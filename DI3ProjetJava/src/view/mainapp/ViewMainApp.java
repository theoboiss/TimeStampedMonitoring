package view.mainapp;

import javax.swing.*;

public class ViewMainApp extends JFrame {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JTabbedPane mainTabbedPane;
	private ViewEmployees frameEmployees;
	private ViewCheckInOuts frameCheckInOuts;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewMainApp () {
		build();
	}
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
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
	
	/************************* frameCheckInOuts *************************/
	
	/**
	 * @return the frameCheckInOuts
	 */
	public ViewCheckInOuts getFrameCheckInOuts() {
		return frameCheckInOuts;
	}

	/**
	 * @param frameCheckInOuts the frameCheckInOuts to set
	 */
	public void setFrameCheckInOuts(ViewCheckInOuts frameCheckInOuts) {
		this.frameCheckInOuts = frameCheckInOuts;
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
		frameCheckInOuts = new ViewCheckInOuts();
		JTabbedPane tabbedPaneCheckInOuts = new JTabbedPane();
		tabbedPaneCheckInOuts.addTab("Search", frameCheckInOuts.getPanel());
		mainTabbedPane.addTab("CheckInOuts", tabbedPaneCheckInOuts);
		
		//Settings
		JComponent panelSettings = new JPanel();
		mainTabbedPane.addTab("Settings", null, panelSettings,
                null);
		
	}

	
	public static void main(String[] args) {
		new ViewMainApp();
	}
	
}
