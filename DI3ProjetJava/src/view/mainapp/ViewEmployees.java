package view.mainapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**Gestion des employés (CRUD2
...), y compris gestion des plannings
F4.1. Création-ajout d’un employé
F4.2. Visualisation de la liste des employés
F4.3. Visualisation détaillée d’un employé
F4.4. Modification, suppression d’un employé*/

public class ViewEmployees extends JFrame implements ActionListener {
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JPanel panelSearch;
	private JTextField searchBySurname;
	private JTextField searchByFirstName;
	private JPanel panelAdd;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewEmployees () {
		this.panelSearch = buildContentPanelSearch();
		this.panelAdd = buildContentPanelAdd();
		this.setVisible(true);
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

	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	private JPanel buildContentPanelSearch(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Search Employee");
		
		searchByFirstName = new JTextField();
		searchByFirstName.setColumns(10);
		
		searchBySurname = new JTextField();
		searchBySurname.setColumns(10);
		
		panel.add(label);
		panel.add(searchByFirstName);
		panel.add(searchBySurname);
		return panel;
	}

	private JPanel buildContentPanelAdd(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Add Employee");
		panel.add(label);
		return panel;
	}
		
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	}
		
}
