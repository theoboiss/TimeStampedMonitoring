package view.mainapp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**Gestion des employés (CRUD2
...), y compris gestion des plannings
F4.1. Création-ajout d’un employé
F4.2. Visualisation de la liste des employés
F4.3. Visualisation détaillée d’un employé
F4.4. Modification, suppression d’un employé*/

public class ViewEmployees extends JFrame {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JPanel panelSearch;
	private JTextField searchBySurname;
	private JButton searchBySurnameButton;
	private JTextField searchByFirstName;
	private JButton searchByFirstNameButton;
	
	private JPanel panelAdd;
	private JTextField addSurname;
	private JTextField addFirstName;
	private JButton addButton;
	
	private JTable resultsEmployees;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewEmployees () {
		panelSearch = buildContentPanelSearch();
		panelAdd = buildContentPanelAdd();
		setVisible(true);
		resultsEmployees = new JTable();
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
	
	/*************************** searchBySurname *************************/

	/**
	 * @return the searchBySurname
	 */
	public JTextField getSearchBySurname() {
		return searchBySurname;
	}


	/**
	 * @param searchBySurname the searchBySurname to set
	 */
	public void setSearchBySurname(JTextField searchBySurname) {
		this.searchBySurname = searchBySurname;
	}
	
	/************************ searchBySurnameButton **********************/
	
	/**
	 * @return the searchBySurnameButton
	 */
	public JButton getSearchBySurnameButton() {
		return searchBySurnameButton;
	}


	/**
	 * @param searchBySurnameButton the searchBySurnameButton to set
	 */
	public void setSearchBySurnameButton(JButton searchBySurnameButton) {
		this.searchBySurnameButton = searchBySurnameButton;
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
	
	/*********************** searchByFirstNameButton *********************/
	
	/**
	 * @return the searchByFirstNameButton
	 */
	public JButton getSearchByFirstNameButton() {
		return searchByFirstNameButton;
	}

	/**
	 * @param searchByFirstNameButton the searchByFirstNameButton to set
	 */
	public void setSearchByFirstNameButton(JButton searchByFirstNameButton) {
		this.searchByFirstNameButton = searchByFirstNameButton;
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
	
	/***************************** addSurname ****************************/
	
	/**
	 * @return the addSurname
	 */
	public JTextField getAddSurname() {
		return addSurname;
	}

	/**
	 * @param addSurname the addSurname to set
	 */
	public void setAddSurname(JTextField addSurname) {
		this.addSurname = addSurname;
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
		
		//Button
		searchByFirstNameButton = new JButton("Search");
		GridBagConstraints constraintsFirstNameButton = new GridBagConstraints();
		constraintsFirstNameButton.gridx = 2;
		constraintsFirstNameButton.gridy = 1;
		panel.add(searchByFirstNameButton, constraintsFirstNameButton);
		
		//SEARCH BY SURNAME
		
		//Label
		JLabel labelSurname = new JLabel("By Surname");
		GridBagConstraints constraintsLabelSurname = new GridBagConstraints();
		constraintsLabelSurname.gridx = 0;
		constraintsLabelSurname.gridy = 2;
		panel.add(labelSurname, constraintsLabelSurname);
		
		//TextField
		searchBySurname = new JTextField();
		GridBagConstraints constraintsSurname = new GridBagConstraints();
		constraintsSurname.gridx = 1;
		constraintsSurname.gridy = 2;
		searchBySurname.setColumns(10);
		searchBySurname.setText("Enter a surname");
		panel.add(searchBySurname, constraintsSurname);
		
		//Button
		searchBySurnameButton = new JButton("Search");
		GridBagConstraints constraintsSurnameButton = new GridBagConstraints();
		constraintsSurnameButton.gridx = 2;
		constraintsSurnameButton.gridy = 2;
		panel.add(searchBySurnameButton, constraintsSurnameButton);

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
		
		//SURNAME
		
		//Label
		JLabel labelSurname = new JLabel("Surname");
		GridBagConstraints constraintsLabelSurname = new GridBagConstraints();
		constraintsLabelSurname.gridx = 0;
		constraintsLabelSurname.gridy = 2;
		panel.add(labelSurname, constraintsLabelSurname);
		
		//TextField
		addSurname = new JTextField();
		GridBagConstraints constraintsSurname = new GridBagConstraints();
		constraintsSurname.gridx = 1;
		constraintsSurname.gridy = 2;
		addSurname.setColumns(10);
		addSurname.setText("Enter a surname");
		panel.add(addSurname, constraintsSurname);
		
		//BUTTON
		
		addButton = new JButton("Add");
		GridBagConstraints constraintsAddButton = new GridBagConstraints();
		constraintsAddButton.gridx = 3;
		constraintsAddButton.gridy = 3;
		panel.add(addButton, constraintsAddButton);

		return panel;
	}
		
}
