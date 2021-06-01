package view.mainapp;


import java.awt.event.ActionEvent;

import javax.swing.*;

public class ViewMainApp extends JFrame {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JTabbedPane tabbedPaneEmployees;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewMainApp () {
		build();
	}
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/************************* tabbedPaneEmployees ***********************/
	
	/**
	 * @return the tabbedPaneEmployees
	 */
	public JTabbedPane getTabbedPaneEmployees() {
		return tabbedPaneEmployees;
	}

	/**
	 * @param tabbedPaneEmployees the tabbedPaneEmployees to set
	 */
	public void setTabbedPaneEmployees(JTabbedPane tabbedPaneEmployees) {
		this.tabbedPaneEmployees = tabbedPaneEmployees;
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
		JTabbedPane tabbedPane = buildContentTabbedPane();

		this.add(tabbedPane);
		this.setVisible(true);
	}

	/**
	 * @brief Method which build main tabbedPane.
	 * 
	 * @return JTabbedPane
	 */
	private JTabbedPane buildContentTabbedPane(){
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//Employees
		ViewEmployees frameEmployees = new ViewEmployees();
		tabbedPaneEmployees = new JTabbedPane();
		tabbedPaneEmployees.addTab("Search", frameEmployees.getPanelSearch());
		tabbedPaneEmployees.addTab("Add", frameEmployees.getPanelAdd());
		tabbedPane.addTab("Employees", tabbedPaneEmployees);
		
		//CheckInOuts
		JComponent panelCheckInOuts = new JPanel();
		tabbedPane.addTab("CheckInOuts", null, panelCheckInOuts,
                null);
		
		//Settings
		JComponent panelSettings = new JPanel();
		tabbedPane.addTab("Settings", null, panelSettings,
                null);
		
		return tabbedPane;
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		/*
		if(source == getTabbedPaneEmployees().frameEmployees.getSearchBySurnameButton()) {
			System.out.println("Ok");
		}*/
		
	}

	
	public static void main(String[] args) {
		new ViewMainApp();
	}
	
}
