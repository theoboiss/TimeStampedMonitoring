package view.mainapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewMainApp extends JFrame implements ActionListener {
	
	private JButton buttonEmployees;
	private JButton buttonCheckInOuts;
	private JButton buttonSettings;

	public ViewMainApp () {
		
		build();
	}
	
	private void build() {
		//create frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,300,500,500);
		//create panel
		JPanel panel = buildContentPanel();

		this.add(panel);
		this.setVisible(true);
	}
	
	private JPanel buildContentPanel(){
		JPanel panel = new JPanel();
		
		//create view buttons
		buttonEmployees = new JButton("Employees");
		buttonEmployees.addActionListener(this);
		buttonCheckInOuts = new JButton("CheckInOuts");
		buttonCheckInOuts.addActionListener(this);
		buttonSettings = new JButton("Settings");
		buttonSettings.addActionListener(this);
			
		//add view buttons to panel
		panel.add(buttonEmployees);
		panel.add(buttonCheckInOuts);
		panel.add(buttonSettings);
		return panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
 
		if(source == buttonEmployees){
			System.out.println("Vous avez cliqué ici.");
		} else if(source == buttonCheckInOuts){
			System.out.println("Vous avez cliqué là.");	
		}
	}
	
	public static void main(String[] args) {
		new ViewMainApp();
	}
	
}
