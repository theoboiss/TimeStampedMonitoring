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


public class ViewEmployees extends JFrame implements ActionListener {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JPanel panelSearch;
	private JTextField searchByLastName;
	private JTextField searchByFirstName;
	private JTextField searchByID;
	private JButton searchButton;
	private HashMap<String, JTextField> researchMap;
	private JTable resultsEmployees;
	
	private JPanel panelAdd;
	private JTextField addLastName;
	private JTextField addFirstName;
	private JButton addButton;
	private HashMap<String, JTextField> addMap;
		
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewEmployees () {
		resultsEmployees = new JTable();
		researchMap = new HashMap<String, JTextField>();
		addMap = new HashMap<String, JTextField>();
		
		panelSearch = buildContentPanelSearch();
		panelAdd = buildContentPanelAdd();
		setVisible(true);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/***************************** panelSearch ***************************/
	
	/**
	 * @return the panelSearch
	 */
	public JPanel getPanelSearch() {
		return this.panelSearch;
	}
	
	/**
	 * @param panel the panelAdd to set
	 */
	private void setPanelSearch(JPanel panel) {
		this.panelSearch = panel;
	}
	
	/*************************** searchByLastName *************************/

	/**
	 * @return the searchByLastName
	 */
	public JTextField getSearchByLastName() {
		return searchByLastName;
	}


	/**
	 * @param searchBylastName the searchByLastName to set
	 */
	public void setSearchByLastName(JTextField searchByLastName) {
		this.searchByLastName = searchByLastName;
	}
	
	/************************** searchByFirstName ************************/

	/**
	 * @return the searchByFirstName
	 */
	public JTextField getSearchByFirstName() {
		return searchByFirstName;
	}


	/**
	 * @param searchByFirstName the searchByFirstName to set
	 */
	public void setSearchByFirstName(JTextField searchByFirstName) {
		this.searchByFirstName = searchByFirstName;
	}
	
	/**************************** searchByID ***************************/
	
	/**
	 * @return the searchByID
	 */
	public JTextField getSearchByID() {
		return searchByID;
	}


	/**
	 * @param searchByID the searchByID to set
	 */
	public void setSearchByID(JTextField searchByID) {
		this.searchByID = searchByID;
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

	
	/****************************** panelAdd *****************************/

	/**
	 * @return the panelAdd
	 */
	public JPanel getPanelAdd() {
		return this.panelAdd;
	}
	
	/**
	 * @param panel the panelAdd to set
	 */
	private void setPanelAdd(JPanel panel) {
		this.panelAdd = panel;
	}
	
	/***************************** addLastName ****************************/
	
	/**
	 * @return the addLastName
	 */
	public JTextField getAddLastName() {
		return addLastName;
	}

	/**
	 * @param addlastName the addLastName to set
	 */
	public void setAddLastName(JTextField addLastName) {
		this.addLastName = addLastName;
	}

	/**************************** addFirstName ***************************/

	/**
	 * @return the addFirstName
	 */
	public JTextField getAddFirstName() {
		return addFirstName;
	}


	/**
	 * @param addFirstName the addFirstName to set
	 */
	public void setAddFirstName(JTextField addFirstName) {
		this.addFirstName = addFirstName;
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
	 * @brief Method used to build panelSearch.
	 * 
	 * @return JPanel
	 */
	private JPanel buildContentPanelSearch(){
		JPanel panel = new JPanel(new GridBagLayout());
		
		//SEARCH BY FIRST NAME
		
		//Label
		JLabel labelFirstName = new JLabel("By First Name");
		GridBagConstraints constraintsLabelFirstName = new GridBagConstraints();
		constraintsLabelFirstName.gridx = 0;
		constraintsLabelFirstName.gridy = 1;
		panel.add(labelFirstName, constraintsLabelFirstName);
		
		//TextField
		searchByFirstName = new JTextField();
		GridBagConstraints constraintsFirstName = new GridBagConstraints();
		constraintsFirstName.gridx = 1;
		constraintsFirstName.gridy = 1;
		searchByFirstName.setColumns(10);
		searchByFirstName.setText("Enter a first name");
		panel.add(searchByFirstName, constraintsFirstName);
		
		
		//SEARCH BY LAST NAME
		
		//Label
		JLabel labelLastName = new JLabel("By Last Name");
		GridBagConstraints constraintsLabelLastName = new GridBagConstraints();
		constraintsLabelLastName.gridx = 0;
		constraintsLabelLastName.gridy = 2;
		panel.add(labelLastName, constraintsLabelLastName);
		
		//TextField
		searchByLastName = new JTextField();
		GridBagConstraints constraintsLastName = new GridBagConstraints();
		constraintsLastName.gridx = 1;
		constraintsLastName.gridy = 2;
		searchByLastName.setColumns(10);
		searchByLastName.setText("Enter a lastName");
		panel.add(searchByLastName, constraintsLastName);
		
		
		// SEARCH BY ID
		
		//Label
		JLabel labelID = new JLabel("By ID");
		GridBagConstraints constraintsLabelID = new GridBagConstraints();
		constraintsLabelID.gridx = 0;
		constraintsLabelID.gridy = 3;
		panel.add(labelID, constraintsLabelID);
		
		//TextField
		searchByID = new JTextField();
		GridBagConstraints constraintsID = new GridBagConstraints();
		constraintsID.gridx = 1;
		constraintsID.gridy = 3;
		searchByID.setColumns(10);
		searchByID.setText("Enter an ID");
		panel.add(searchByID, constraintsID);
		
		
		// BUTTON
		
		searchButton = new JButton("Search");
		GridBagConstraints constraintsSearchButton = new GridBagConstraints();
		constraintsSearchButton.gridx = 3;
		constraintsSearchButton.gridy = 4;
		searchButton.addActionListener(this);
		panel.add(searchButton, constraintsSearchButton);

		return panel;
	}

	/**
	 * @brief Method used to build panelAdd.
	 * 
	 * @return JPanel
	 */
	private JPanel buildContentPanelAdd(){
		JPanel panel = new JPanel(new GridBagLayout());
		
		//FISRTNAME
		
		//Label
		JLabel labelFirstName = new JLabel("First Name");
		GridBagConstraints constraintsLabelFirstName = new GridBagConstraints();
		constraintsLabelFirstName.gridx = 0;
		constraintsLabelFirstName.gridy = 1;
		panel.add(labelFirstName, constraintsLabelFirstName);
		
		//TextField
		addFirstName = new JTextField();
		GridBagConstraints constraintsFirstName = new GridBagConstraints();
		constraintsFirstName.gridx = 1;
		constraintsFirstName.gridy = 1;
		addFirstName.setColumns(10);
		addFirstName.setText("Enter a first name");
		panel.add(addFirstName, constraintsFirstName);
		
		//lastName
		
		//Label
		JLabel labelLastName = new JLabel("Last Name");
		GridBagConstraints constraintsLabelLastName = new GridBagConstraints();
		constraintsLabelLastName.gridx = 0;
		constraintsLabelLastName.gridy = 2;
		panel.add(labelLastName, constraintsLabelLastName);
		
		//TextField
		addLastName = new JTextField();
		GridBagConstraints constraintsLastName = new GridBagConstraints();
		constraintsLastName.gridx = 1;
		constraintsLastName.gridy = 2;
		addLastName.setColumns(10);
		addLastName.setText("Enter a lastName");
		panel.add(addLastName, constraintsLastName);
		
		//BUTTON
		
		addButton = new JButton("Add");
		GridBagConstraints constraintsAddButton = new GridBagConstraints();
		constraintsAddButton.gridx = 3;
		constraintsAddButton.gridy = 3;
		addButton.addActionListener(this);
		panel.add(addButton, constraintsAddButton);

		return panel;
	}
	
	public void actionPerformed(ActionEvent event) {
		 
		Object source = event.getSource();
		 
		if(source == searchButton){
			researchMap.put("firstName", searchByFirstName);
			researchMap.put("lastName", addLastName);
			researchMap.put("ID", searchByID);
		} else if (source == addButton) {
			addMap.put("firstName", addFirstName);
			addMap.put("lastName", addLastName);
		}
		
	}
		
}
