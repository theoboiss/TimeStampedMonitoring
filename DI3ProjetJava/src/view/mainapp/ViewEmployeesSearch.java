package view.mainapp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class ViewEmployeesSearch implements ActionListener {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JPanel panel;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField ID;
	private JTextField department;
	private JButton searchButton;
	private HashMap<String, JTextField> researchMap;
	private JTable resultsEmployees;
			
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewEmployeesSearch () {
		
		resultsEmployees = new JTable();
		researchMap = new HashMap<String, JTextField>();		
		panel = buildContentPanel();
		
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/******************************** panel ******************************/
	
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
	public JTextField getlastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}
	
	/****************************** firstName ***************************/

	/**
	 * @return the firstName
	 */
	public JTextField getfirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}
	
	/******************************** ID *******************************/
	
	/**
	 * @return the ID
	 */
	public JTextField getID() {
		return ID;
	}


	/**
	 * @param ID the ID to set
	 */
	public void setID(JTextField ID) {
		this.ID = ID;
	}
	
	/*************************** department ***************************/
	
	/**
	 * @return the department
	 */
	public JTextField getdepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(JTextField department) {
		this.department = department;
	}
	
	/*************************** searchButton **************************/
	
	/**
	 * @return the searchButton
	 */
	public JButton getSearchButton() {
		return searchButton;
	}

	/**
	 * @param searchButton the searchButton to set
	 */
	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}
	
	/***************************** researchMap **************************/
	
	/**
	 * @return the researchMap
	 */
	public HashMap<String, JTextField> getResearchMap() {
		return researchMap;
	}


	/**
	 * @param researchMap the researchMap to set
	 */
	public void setResearchMap(HashMap<String, JTextField> researchMap) {
		this.researchMap = researchMap;
	}
	
	/************************** resultsEmployees ************************/
	
	/**
	 * @return the resultsEmployees
	 */
	public JTable getResultsEmployees() {
		return resultsEmployees;
	}

	/**
	 * @param resultsEmployees the resultsEmployees to set
	 */
	public void setResultsEmployees(JTable resultsEmployees) {
		this.resultsEmployees = resultsEmployees;
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
		
		//SEARCH BY FIRST NAME
		
		//Label
		JLabel labelFirstName = new JLabel("By First Name");
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
		
		
		//SEARCH BY LAST NAME
		
		//Label
		JLabel labelLastName = new JLabel("By Last Name");
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
		
		
		// SEARCH BY ID
		
		//Label
		JLabel labelID = new JLabel("By ID");
		GridBagConstraints constraintsLabelID = new GridBagConstraints();
		constraintsLabelID.gridx = 0;
		constraintsLabelID.gridy = 3;
		panel.add(labelID, constraintsLabelID);
		
		//TextField
		ID = new JTextField();
		GridBagConstraints constraintsID = new GridBagConstraints();
		constraintsID.gridx = 1;
		constraintsID.gridy = 3;
		ID.setColumns(10);
		panel.add(ID, constraintsID);
		
		
		// SEARCH BY ID
		
		//Label
		JLabel labelDepartment = new JLabel("By Department Name");
		GridBagConstraints constraintsLabelDepartment = new GridBagConstraints();
		constraintsLabelDepartment.gridx = 0;
		constraintsLabelDepartment.gridy = 4;
		panel.add(labelDepartment, constraintsLabelDepartment);
			
		//TextField
		department = new JTextField();
		GridBagConstraints constraintsDepartment = new GridBagConstraints();
		constraintsDepartment.gridx = 1;
		constraintsDepartment.gridy = 4;
		department.setColumns(10);
		panel.add(department, constraintsDepartment);
		
		
		// BUTTON
		
		searchButton = new JButton("Search");
		GridBagConstraints constraintsSearchButton = new GridBagConstraints();
		constraintsSearchButton.gridx = 3;
		constraintsSearchButton.gridy = 5;
		searchButton.addActionListener(this);
		panel.add(searchButton, constraintsSearchButton);

		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		 
		Object source = event.getSource();
		 
		if(source == searchButton){
			
			researchMap.put("firstname", firstName);
			researchMap.put("lastname", lastName);
			researchMap.put("id", ID);
			researchMap.put("department_name", department);
			
		} 
		
	}
		
}