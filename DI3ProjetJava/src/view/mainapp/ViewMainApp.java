package view.mainapp;

import javax.swing.*;

public class ViewMainApp extends JFrame {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JTabbedPane mainTabbedPane;
	private ViewEmployeesSearch frameEmployeesSearch;
	private ViewEmployeeAdd frameEmployeeAdd;
	private ViewCheckInOutsSearch frameCheckInOuts;
	
	
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
	
	/*********************** frameEmployeesSearch ***********************/
	
	/**
	 * @return the frameEmployeesSearch
	 */
	public ViewEmployeesSearch getFrameEmployeesSearch() {
		return frameEmployeesSearch;
	}

	/**
	 * @param frameEmployees the frameEmployeesSearch to set
	 */
	public void setFrameEmployeesSearch(ViewEmployeesSearch frameEmployeesSearch) {
		this.frameEmployeesSearch = frameEmployeesSearch;
	}
	
	/************************ frameEmployeesAdd *************************/
	
	/**
	 * @return the frameEmployeeAdd
	 */
	public ViewEmployeeAdd getFrameEmployeeAdd() {
		return frameEmployeeAdd;
	}

	/**
	 * @param frameEmployeeAdd the frameEmployeeAdd to set
	 */
	public void setFrameEmployeeAdd(ViewEmployeeAdd frameEmployeeAdd) {
		this.frameEmployeeAdd = frameEmployeeAdd;
	}

	
	/************************* frameCheckInOuts *************************/
	
	/**
	 * @return the frameCheckInOuts
	 */
	public ViewCheckInOutsSearch getFrameCheckInOuts() {
		return frameCheckInOuts;
	}

	/**
	 * @param frameCheckInOuts the frameCheckInOuts to set
	 */
	public void setFrameCheckInOuts(ViewCheckInOutsSearch frameCheckInOuts) {
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
		frameEmployeesSearch = new ViewEmployeesSearch();
		frameEmployeeAdd = new ViewEmployeeAdd();
		JTabbedPane tabbedPaneEmployees = new JTabbedPane();
		tabbedPaneEmployees.addTab("Search", frameEmployeesSearch.getPanel());
		tabbedPaneEmployees.addTab("Add", frameEmployeeAdd.getPanel());
		mainTabbedPane.addTab("Employees", tabbedPaneEmployees);
		
		//CheckInOuts
		frameCheckInOuts = new ViewCheckInOutsSearch();
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
