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


public class ViewCheckInOutsSearch implements ActionListener {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JPanel panel;
	
	private JTextField employeeFirstName;
	private JTextField employeeLastName;
	private JTextField employeeID;
	
	private JTextField departmentName;
	
	private JTextField startDate;
	private JTextField endDate;
	
	private JButton searchButton;
	
	private HashMap<String, JTextField> researchMap;
	
	private JTable resultsCheckInOuts;
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewCheckInOutsSearch() {
		
		resultsCheckInOuts = new JTable();
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
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	/************************** employeeFirstName ************************/

	/**
	 * @return the employeeFirstName
	 */
	public JTextField getEmployeeFirstName() {
		return employeeFirstName;
	}

	/**
	 * @param employeeFirstName the employeeFirstName to set
	 */
	public void setEmployeeFirstName(JTextField employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	/*************************** employeeLastName ************************/
	
	/**
	 * @return the employeeLastName
	 */
	public JTextField getEmployeeLastName() {
		return employeeLastName;
	}

	/**
	 * @param employeeLastName the employeeLastName to set
	 */
	public void setEmployeeLastName(JTextField employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	
	/***************************** employeeID ****************************/

	/**
	 * @return the employeeID
	 */
	public JTextField getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(JTextField employeeID) {
		this.employeeID = employeeID;
	}
	
	/**************************** departmentName **************************/

	/**
	 * @return the departmentName
	 */
	public JTextField getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(JTextField departmentName) {
		this.departmentName = departmentName;
	}
	
	/******************************* startDate ****************************/

	/**
	 * @return the startDate
	 */
	public JTextField getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(JTextField startDate) {
		this.startDate = startDate;
	}
	
	/******************************* endDate *****************************/

	/**
	 * @return the endDate
	 */
	public JTextField getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(JTextField endDate) {
		this.endDate = endDate;
	}
	
	/**************************** searchButton ***************************/
	
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
	
	/**************************** researchMap ***************************/
	
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
	
	/************************* resultsCheckInOuts ************************/

	/**
	 * @return the resultsCheckInOuts
	 */
	public JTable getResultsCheckInOuts() {
		return resultsCheckInOuts;
	}


	/**
	 * @param resultsCheckInOuts the resultsCheckInOuts to set
	 */
	public void setResultsCheckInOuts(JTable resultsCheckInOuts) {
		this.resultsCheckInOuts = resultsCheckInOuts;
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
		
		//EMPLOYEE FIRST NAME
		
		//Label
		JLabel labelFirstName = new JLabel("By Employee First Name");
		GridBagConstraints constraintsLabelFirstName = new GridBagConstraints();
		constraintsLabelFirstName.gridx = 0;
		constraintsLabelFirstName.gridy = 1;
		panel.add(labelFirstName, constraintsLabelFirstName);
			
		//TextField
		employeeFirstName = new JTextField();
		GridBagConstraints constraintsFirstName = new GridBagConstraints();
		constraintsFirstName.gridx = 1;
		constraintsFirstName.gridy = 1;
		employeeFirstName.setColumns(10);
		panel.add(employeeFirstName, constraintsFirstName);

		
		//EMPLOYEE LAST NAME
		
		//Label
		JLabel labelLastName = new JLabel("By Employee Last Name");
		GridBagConstraints constraintsLabelLastName = new GridBagConstraints();
		constraintsLabelLastName.gridx = 0;
		constraintsLabelLastName.gridy = 2;
		panel.add(labelLastName, constraintsLabelLastName);
					
		//TextField
		employeeLastName = new JTextField();
		GridBagConstraints constraintsLastName = new GridBagConstraints();
		constraintsLastName.gridx = 1;
		constraintsLastName.gridy = 2;
		employeeLastName.setColumns(10);
		panel.add(employeeLastName, constraintsLastName);
		
		//EMPLOYEE ID
		
		//Label
		JLabel labelID = new JLabel("By Employee ID");
		GridBagConstraints constraintsLabelID = new GridBagConstraints();
		constraintsLabelID.gridx = 0;
		constraintsLabelID.gridy = 3;
		panel.add(labelID, constraintsLabelID);
							
		//TextField
		employeeID = new JTextField();
		GridBagConstraints constraintsID = new GridBagConstraints();
		constraintsID.gridx = 1;
		constraintsID.gridy = 3;
		employeeID.setColumns(10);
		panel.add(employeeID, constraintsID);
		
		
		//DEPARTMENT NAME
		
		//Label
		JLabel labelDepartmentName = new JLabel("By Department Name");
		GridBagConstraints constraintsLabelDepartmentName = new GridBagConstraints();
		constraintsLabelDepartmentName.gridx = 0;
		constraintsLabelDepartmentName.gridy = 4;
		panel.add(labelDepartmentName, constraintsLabelDepartmentName);
							
		//TextField
		departmentName = new JTextField();
		GridBagConstraints constraintsDepartmentName = new GridBagConstraints();
		constraintsDepartmentName.gridx = 1;
		constraintsDepartmentName.gridy = 4;
		departmentName.setColumns(10);
		panel.add(departmentName, constraintsDepartmentName);
		
		
		//START DATE
		
		//Label
		JLabel labelStartDate = new JLabel("By start DateTime (MM-dd-yyyy HH:mm)");
		GridBagConstraints constraintsLabelStartDate = new GridBagConstraints();
		constraintsLabelStartDate.gridx = 0;
		constraintsLabelStartDate.gridy = 5;
		panel.add(labelStartDate, constraintsLabelStartDate);
									
		//TextField
		startDate = new JTextField();
		GridBagConstraints constraintsStartDate = new GridBagConstraints();
		constraintsStartDate.gridx = 1;
		constraintsStartDate.gridy = 5;
		startDate.setColumns(10);
		panel.add(startDate, constraintsStartDate);
		
		
		//END DATE
		
		//Label
		JLabel labelEndDate = new JLabel("By end DateTime (MM-dd-yyyy HH:mm)");
		GridBagConstraints constraintsLabelEndDate = new GridBagConstraints();
		constraintsLabelEndDate.gridx = 0;
		constraintsLabelEndDate.gridy = 6;
		panel.add(labelEndDate, constraintsLabelEndDate);
											
		//TextField
		endDate = new JTextField();
		GridBagConstraints constraintsEndDate = new GridBagConstraints();
		constraintsEndDate.gridx = 1;
		constraintsEndDate.gridy = 6;
		endDate.setColumns(10);
		panel.add(endDate, constraintsEndDate);
		
		
		// BUTTON
		
		searchButton = new JButton("Search");
		GridBagConstraints constraintsSearchButton = new GridBagConstraints();
		constraintsSearchButton.gridx = 3;
		constraintsSearchButton.gridy = 7;
		searchButton.addActionListener(this);
		panel.add(searchButton, constraintsSearchButton);


		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		 
		Object source = event.getSource();
		
		if(source == searchButton){
			
			researchMap.put("firstname", employeeFirstName);
			researchMap.put("lastname", employeeLastName);
			researchMap.put("id", employeeID);
			researchMap.put("department_name", departmentName);
			researchMap.put("before_date", startDate);
			researchMap.put("after_date", endDate);
			
		}
		
	}

}
