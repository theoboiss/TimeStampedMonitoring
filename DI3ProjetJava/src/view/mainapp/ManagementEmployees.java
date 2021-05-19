package view.mainapp;

import javax.swing.*;

public class ManagementEmployees extends JFrame {

	public ManagementEmployees () {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,300,500,500);
		JPanel panel = new JPanel();
		JButton buttonEmployees = new JButton("Employees");
		panel.add(buttonEmployees);
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ManagementEmployees();
	}
	
}
