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


/**
 * 
 * @brief View which represents the results of Employee(s) research.
 *
 */
public class ViewResultsEmployees extends ViewResults {

	/**
	 * @brief serialVersionUID.
	 */
	private static final long serialVersionUID = 5485924175594067340L;
	
	
	/*********************************************************************/
	/**************************** INTERN CLASS ***************************/
	/*********************************************************************/

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
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
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
	}
	
	class ButtonDetailsEditor extends ButtonEditor {

		/**
		 * @brief serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		public ButtonDetailsEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public Object getCellEditorValue() {
			if (super.isPushed) {
				System.out.println(super.label + ": Boom!");
			}
			super.isPushed = false;
			return new String(super.label);
		}
	}
	
	class ButtonDeleteEditor extends ButtonEditor {

		/**
		 * @brief serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;

		public ButtonDeleteEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public Object getCellEditorValue() {
			if (super.isPushed) {
				System.out.println(super.label + ": Bim!");
			}
			super.isPushed = false;
			return new String(super.label);
		}
	}
	
	
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
