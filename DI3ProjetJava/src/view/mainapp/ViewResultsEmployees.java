package view.mainapp;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;

public class ViewResultsEmployees extends ViewResults {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5485924175594067340L;

	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @brief Constructor.
	 */
	public ViewResultsEmployees (Object[][] dataEntry, String[] titles) {
		initializeAttributes(dataEntry, titles);
		build();
	}

	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	protected void initializeAttributes(Object[][] dataEntry, String[] titles) {
		
		setDataEntry(dataEntry);
		setTitles(titles);
		dataTable = new JTable(dataEntry, titles);
		
	}
	
	
	protected void build() {
		
		//create frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300,300,600,400);
		setTitle("Results of the employee research");
				
		//create panel	
		buildContentPanel();

		add(panel);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
	}

}
