package view.mainapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewMainApp extends JFrame {
	

	public ViewMainApp () {
		build();
	}
	
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
	
	private JTabbedPane buildContentTabbedPane(){
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//Employees
		ViewEmployees frameEmployees = new ViewEmployees();
		JTabbedPane tabbedPaneEmployees = new JTabbedPane();
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

	
	public static void main(String[] args) {
		new ViewMainApp();
	}
	
}
