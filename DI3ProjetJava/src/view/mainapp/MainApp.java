package view.mainapp;

import javax.swing.*;

public class MainApp extends JFrame {

	public MainApp () {
		//create frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,300,500,500);
		
		//create panel
		JPanel panel = new JPanel();
		
		//create view buttons
		JButton buttonEmployees = new JButton("Employees");
		JButton buttonConsultation = new JButton("Consultation");
		JButton buttonInput = new JButton("Input");
		JButton buttonSafeguarding = new JButton("Safeguarding");
		JButton buttonSettings = new JButton("Settings");
		
		//add view buttons to panel
		panel.add(buttonEmployees);
		panel.add(buttonConsultation);
		panel.add(buttonInput);
		panel.add(buttonSafeguarding);
		panel.add(buttonSettings);
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainApp();
	}
	
}
