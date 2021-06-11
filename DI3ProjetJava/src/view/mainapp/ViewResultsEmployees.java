package view.mainapp;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

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
		sortDataByIDEmployees();
		setTitles(titles);
		setDataTable(new JTable(dataEntry, titles));
		
	}
	
	
	protected void build() {
		
		//create frame
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(300,300,600,400);
		setTitle("Results of the employee research");
		
		//create panel
		buildContentPanel();
		GridBagConstraints constraintsColumns = new GridBagConstraints();
		constraintsColumns.gridx = 1;
		constraintsColumns.gridy = 1;
		
		//add buttons for details and deleting
		Integer nbRows = getDataTable().getRowCount();
		JButton[] detailsArray = new JButton[nbRows];
		JButton[] deleteArray = new JButton[nbRows];
		for (Integer iterator = 0; iterator < nbRows; iterator++) {
			detailsArray[iterator] = new JButton("Details");
			detailsArray[iterator].setPreferredSize(new Dimension(50, 20));
			detailsArray[iterator].setMargin(new Insets(0,0,0,0));
			getPanel().add(detailsArray[iterator], constraintsColumns);

			constraintsColumns.gridx++;
			deleteArray[iterator] = new JButton("Delete");
			deleteArray[iterator].setPreferredSize(new Dimension(50, 20));
			deleteArray[iterator].setMargin(new Insets(0,0,0,0));
			getPanel().add(deleteArray[iterator], constraintsColumns);
			constraintsColumns.gridx--;
			
			constraintsColumns.gridy++;
		}

		add(panel);
		setVisible(true);
		
	}
	
	private void sortDataByIDEmployees() {
		
		for (int i = 0; i < dataEntry.length; i++) {
			for (int j = 0; j < dataEntry.length; j++) {
				if (Integer.parseInt((String) dataEntry[i][0]) < Integer.parseInt((String) dataEntry[j][0])) {
					Object[] temp = dataEntry[i];
					dataEntry[i] = dataEntry[j];
					dataEntry[j] = temp;
				}
			}
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
	}

}
