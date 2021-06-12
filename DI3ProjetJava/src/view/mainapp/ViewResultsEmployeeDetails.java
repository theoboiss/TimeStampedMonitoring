package view.mainapp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 * 
 * @brief View which represents the results of an Employee research.
 *
 */
public class ViewResultsEmployeeDetails extends JFrame {

	/**
	 * @brief serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private JTabbedPane mainTabbedPane;
	private JLabel employeeMainInfo;
	
	private JPanel framePlanning;
	private JTable planningTable;
	
	private JPanel frameChecks;
	private JTable checksTable;

	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public ViewResultsEmployeeDetails(Object[][][] dataEntry, String[][] titles) {
		build(dataEntry, titles);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/*************************** mainTabbedPane **************************/
	
	/**
	 * @return the mainTabbedPane
	 */
	public JTabbedPane getMainTabbedPane() {
		return mainTabbedPane;
	}
	/**
	 * @param mainTabbedPane the mainTabbedPane to set
	 */
	public void setMainTabbedPane(JTabbedPane mainTabbedPane) {
		this.mainTabbedPane = mainTabbedPane;
	}
	
	/*************************** employeeMainInfo ************************/
	
	/**
	 * @return the employeeMainInfo
	 */
	public JLabel getEmployeeMainInfo() {
		return employeeMainInfo;
	}
	/**
	 * @param employeeMainInfo the employeeMainInfo to set
	 */
	public void setEmployeeMainInfo(JLabel employeeMainInfo) {
		this.employeeMainInfo = employeeMainInfo;
	}
	
	/**************************** framePlanning **************************/
	
	/**
	 * @return the framePlanning
	 */
	public JPanel getFramePlanning() {
		return framePlanning;
	}
	/**
	 * @param framePlanning the framePlanning to set
	 */
	public void setFramePlanning(JPanel framePlanning) {
		this.framePlanning = framePlanning;
	}
	
	/**************************** planningTable **************************/
	
	/**
	 * @return the planningTable
	 */
	public JTable getPlanningTable() {
		return planningTable;
	}
	/**
	 * @param planningTable the planningTable to set
	 */
	public void setPlanningTable(JTable planningTable) {
		this.planningTable = planningTable;
	}
	
	/***************************** frameChecks ***************************/
	
	/**
	 * @return the frameChecks
	 */
	public JPanel getFrameChecks() {
		return frameChecks;
	}
	/**
	 * @param frameChecks the frameChecks to set
	 */
	public void setFrameChecks(JPanel frameChecks) {
		this.frameChecks = frameChecks;
	}
	
	/***************************** checksTable ***************************/
	
	/**
	 * @return the checksTable
	 */
	public JTable getChecksTable() {
		return checksTable;
	}
	/**
	 * @param checksTable the checksTable to set
	 */
	public void setChecksTable(JTable checksTable) {
		this.checksTable = checksTable;
	}
	
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	/**
	 * @brief Method which create main frame and panel.
	 */
	private void build(Object[][][] dataEntry, String[][] titles) {
		
		//create frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,300,500,500);
		this.setTitle("Employee Details");
		
		//create panel	
		buildContentMainTabbedPane(dataEntry, titles);

		this.add(mainTabbedPane);
		this.setVisible(true);
	}

	/**
	 * @brief Method which build main tabbedPane.
	 */
	private void buildContentMainTabbedPane(Object[][][] dataEntry, String[][] titles){
		initializeAttributes(dataEntry, titles);
		mainTabbedPane = new JTabbedPane();
		
		//Planning
		mainTabbedPane.addTab("Planning", planningTable);
		
		//CheckInOuts
		mainTabbedPane.addTab("CheckInOuts", checksTable);
	
	}
	
	/**
	 * @brief Method used to initialize attributes.
	 * 
	 * @param dataEntry the dataEntry to set
	 * @param titles the titles to set
	 */
	private void initializeAttributes(Object[][][] dataEntry, String[][] titles) {
		
		employeeMainInfo = new JLabel("ID : " + dataEntry[0][1].toString()
									+"\nFirst Name : " + dataEntry[0][2].toString()
									+"\nLast Name : " + dataEntry[0][3].toString()
									+"\nDepartment : " + dataEntry[0][4].toString());
		
		//Frame planning
		framePlanning = new JPanel();
		planningTable = new JTable(dataEntry[1], titles[1]);
		framePlanning.add(employeeMainInfo);
		framePlanning.add(planningTable);
		
		//Frame Checks
		frameChecks = new JPanel();
		planningTable = new JTable(dataEntry[2], titles[2]);
		frameChecks.add(employeeMainInfo);
		frameChecks.add(checksTable);
		
	}
}
