package view.mainapp;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Color;

public class ViewResultsEmployees extends ViewResults {

	public class ButtonDetailsRenderer extends JButton implements TableCellRenderer {

		/**
		 * @brief serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		public ButtonDetailsRenderer() {
			super("Details");
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				setBackground(Color.lightGray);
			} else {
				setBackground(table.getBackground());
			}
			return this;
		}
	}

	public class ButtonDeleteRenderer extends JButton implements TableCellRenderer {

		/**
		 * @brief serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		public ButtonDeleteRenderer() {
			super("Delete");
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				setBackground(Color.lightGray);
			} else {
				setBackground(table.getBackground());
			}
			return this;
		}
	}

	class ButtonEditor extends DefaultCellEditor {

		/**
		 * @brief serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		protected JButton button;

		private String label;

		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText(button.getName());
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
				System.out.println(label + ": Ouch!");
			}
			isPushed = false;
			return new String(label);
		}
	}
	
	class ButtonDetailsEditor extends ButtonEditor {

		/**
		 * @brief serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		public ButtonDetailsEditor(JCheckBox checkBox) {
			super(checkBox);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}
		
	}
	
	class ButtonDeleteEditor extends ButtonEditor {

		/**
		 * @brief serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		public ButtonDeleteEditor(JCheckBox checkBox) {
			super(checkBox);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}
		
	}
	

	/**
	 * @brief serialVersionUID.
	 */
	private static final long serialVersionUID = 5485924175594067340L;

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	private TableColumn buttonsDetails;
	private TableColumn buttonsDelete;

	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @brief Constructor.
	 */
	public ViewResultsEmployees(Object[][] dataEntry, String[] titles) {
		initializeAttributes(dataEntry, titles);
		build();
	}

	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/*************************** buttonsDetails **************************/

	/**
	 * @return the buttonsDetails
	 */
	public TableColumn getButtonsDetails() {
		return buttonsDetails;
	}

	/**
	 * @param buttonsDetails the buttonsDetails to set
	 */
	public void setButtonsDetails(TableColumn buttonsDetails) {
		this.buttonsDetails = buttonsDetails;
	}

	/**************************** buttonsDelete **************************/

	/**
	 * @return the buttonsDelete
	 */
	public TableColumn getButtonsDelete() {
		return buttonsDelete;
	}

	/**
	 * @param buttonsDelete the buttonsDelete to set
	 */
	public void setButtonsDelete(TableColumn buttonsDelete) {
		this.buttonsDelete = buttonsDelete;
	}

	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/

	protected void initializeAttributes(Object[][] dataEntry, String[] titles) {

		setDataEntry(dataEntry);
		sortDataByIDEmployees();
		setTitles(titles);
		setDataTable(new JTable(dataEntry, titles));

		buttonsDetails = new TableColumn();
		buttonsDelete = new TableColumn();

		buttonsDetails.setCellRenderer(new ButtonDetailsRenderer());
		buttonsDelete.setCellRenderer(new ButtonDeleteRenderer());

		buttonsDetails.setCellEditor(new ButtonDetailsEditor(new JCheckBox()));
		buttonsDelete.setCellEditor(new ButtonDeleteEditor(new JCheckBox()));

		dataTable.addColumn(buttonsDetails);
		dataTable.addColumn(buttonsDelete);
	}

	protected void build() {

		// create frame
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(300, 300, 600, 400);
		setTitle("Results of the employee research");

		// create panel
		buildContentPanel();

		// add buttons details and delete
		/*
		 * for (int i = 0; i < getDataTable().getRowCount(); i++) { GridBagConstraints
		 * constraintsButtonDetails = new GridBagConstraints();
		 * constraintsButtonDetails.gridx = 1; constraintsButtonDetails.gridy =
		 * (i+1)*dataTable.getRowHeight(0); //constraintsButtonDetails.gridheight =
		 * dataTable.getHeight()/(dataTable.getRowCount()+1);
		 * panel.add(buttonsDetails.get(i), constraintsButtonDetails); }
		 */

		/*
		 * //add buttons for details and deleting Integer nbRows =
		 * getDataTable().getRowCount(); JButton[] detailsArray = new JButton[nbRows];
		 * JButton[] deleteArray = new JButton[nbRows]; for (Integer iterator = 0;
		 * iterator < nbRows; iterator++) { detailsArray[iterator] = new
		 * JButton("Details"); detailsArray[iterator].setPreferredSize(new Dimension(50,
		 * 20)); detailsArray[iterator].setMargin(new Insets(0,0,0,0));
		 * getPanel().add(detailsArray[iterator], constraintsColumns);
		 * 
		 * constraintsColumns.gridx++; deleteArray[iterator] = new JButton("Delete");
		 * deleteArray[iterator].setPreferredSize(new Dimension(50, 20));
		 * deleteArray[iterator].setMargin(new Insets(0,0,0,0));
		 * getPanel().add(deleteArray[iterator], constraintsColumns);
		 * constraintsColumns.gridx--;
		 * 
		 * constraintsColumns.gridy++; }
		 */

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
