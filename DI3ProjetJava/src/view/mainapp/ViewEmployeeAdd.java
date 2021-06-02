package view.mainapp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ViewEmployeeAdd implements ActionListener {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JPanel panel;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField department;
	private JButton addButton;
	private HashMap<String, JTextField> addMap;
		
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewEmployeeAdd () {

		addMap = new HashMap<String, JTextField>();
		panel = buildContentPanel();
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/****************************** panelAdd *****************************/

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return this.panel;
	}
	
	/**
	 * @param panel the panel to set
	 */
	private void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	/****************************** lastName *****************************/
	
	/**
	 * @return the lastName
	 */
	public JTextField getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setAddLastName(JTextField lastName) {
		this.lastName = lastName;
	}

	/***************************** firstName ****************************/

	/**
	 * @return the firstName
	 */
	public JTextField getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}
	
	/**************************** department ***************************/
	
	/**
	 * @return the department
	 */
	public JTextField getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(JTextField department) {
		this.department = department;
	}
	
	/***************************** addButton ****************************/
	
	/**
	 * @return the addButton
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * @param addButton the addButton to set
	 */
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	/******************************* addMap ******************************/
	
	/**
	 * @return the addMap
	 */
	public HashMap<String, JTextField> getAddMap() {
		return addMap;
	}


	/**
	 * @param addMap the addMap to set
	 */
	public void setAddMap(HashMap<String, JTextField> addMap) {
		this.addMap = addMap;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/


	/**
	 * @brief Method used to build panel.
	 * 
	 * @return JPanel
	 */
	private JPanel buildContentPanel(){
		JPanel panel = new JPanel(new GridBagLayout());
		
		//FISRTNAME
		
		//Label
		JLabel labelFirstName = new JLabel("First Name");
		GridBagConstraints constraintsLabelFirstName = new GridBagConstraints();
		constraintsLabelFirstName.gridx = 0;
		constraintsLabelFirstName.gridy = 1;
		panel.add(labelFirstName, constraintsLabelFirstName);
		
		//TextField
		firstName = new JTextField();
		GridBagConstraints constraintsFirstName = new GridBagConstraints();
		constraintsFirstName.gridx = 1;
		constraintsFirstName.gridy = 1;
		firstName.setColumns(10);
		panel.add(firstName, constraintsFirstName);
		
		//LASTNAME
		
		//Label
		JLabel labelLastName = new JLabel("Last Name");
		GridBagConstraints constraintsLabelLastName = new GridBagConstraints();
		constraintsLabelLastName.gridx = 0;
		constraintsLabelLastName.gridy = 2;
		panel.add(labelLastName, constraintsLabelLastName);
		
		//TextField
		lastName = new JTextField();
		GridBagConstraints constraintsLastName = new GridBagConstraints();
		constraintsLastName.gridx = 1;
		constraintsLastName.gridy = 2;
		lastName.setColumns(10);
		panel.add(lastName, constraintsLastName);
		
		
		//DEPARTMENT
		
		//Label
		JLabel labelDepartment = new JLabel("Department Name");
		GridBagConstraints constraintsLabelDepartment = new GridBagConstraints();
		constraintsLabelDepartment.gridx = 0;
		constraintsLabelDepartment.gridy = 3;
		panel.add(labelDepartment, constraintsLabelDepartment);
				
		//TextField
		department = new JTextField();
		GridBagConstraints constraintsDepartment = new GridBagConstraints();
		constraintsDepartment.gridx = 1;
		constraintsDepartment.gridy = 3;
		department.setColumns(10);
		panel.add(department, constraintsDepartment);
		
		
		//BUTTON
		
		addButton = new JButton("Add");
		GridBagConstraints constraintsAddButton = new GridBagConstraints();
		constraintsAddButton.gridx = 3;
		constraintsAddButton.gridy = 4;
		addButton.addActionListener(this);
		panel.add(addButton, constraintsAddButton);

		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		 
		Object source = event.getSource();
		 
		if (source == addButton) {
			
			addMap.put("firstname", firstName);
			addMap.put("lastname", lastName);
			addMap.put("department_name", department);
		}
		
	}
		
}
