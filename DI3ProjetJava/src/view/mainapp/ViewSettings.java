package view.mainapp;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.mainapp.BrowserMainapp;

/**
 * @brief Class to manage and modify connection settings (port number and IP
 *        address for the main application).
 *
 */
public class ViewSettings extends ViewModel {

	/* ================================================================= */
	/**************************** ATTRIBUTES *****************************/
	/*********************************************************************/

	private Integer portNumber;
	private Integer IPAddress;

	private JTextField fieldPortNumber;
	private JTextField fieldIPAddress;

	private JLabel labelPortNumber;
	private JLabel labelIPAddress;

	/* ================================================================= */
	/**************************** BUILDER ********************************/
	/*********************************************************************/

	/**
	 * @brief Default constructor
	 */
	public ViewSettings() {
		setArraySize(2);
		initializeAttributes();
		buildContentPanel();
	}

	/* ================================================================= */
	/*************************** SETS/GETS *******************************/
	/*********************************************************************/

	/************************** portNumber *******************************/
	/**
	 * @return the portNumber
	 */
	public Integer getPortNumber() {
		return portNumber;
	}

	/**
	 * @param portNumber the portNumber to set
	 */
	public void setPortNumber(Integer portNumber) {
		this.portNumber = portNumber;
	}

	/*************************** iPAddress *******************************/
	/**
	 * @return the iPAddress
	 */
	public Integer getIPAddress() {
		return IPAddress;
	}

	/**
	 * @param iPAddress the iPAddress to set
	 */
	public void setIPAddress(Integer iPAddress) {
		IPAddress = iPAddress;
	}

	/************************ fieldPortNumber ****************************/
	/**
	 * @return the fieldPortNumber
	 */
	public JTextField getFieldPortNumber() {
		return fieldPortNumber;
	}

	/**
	 * @param fieldPortNumber the fieldPortNumber to set
	 */
	public void setFieldPortNumber(JTextField fieldPortNumber) {
		this.fieldPortNumber = fieldPortNumber;
	}

	/************************* fieldIPAddress ****************************/
	/**
	 * @return the fieldIPAddress
	 */
	public JTextField getFieldIPAddress() {
		return fieldIPAddress;
	}

	/**
	 * @param fieldIPAddress the fieldIPAddress to set
	 */
	public void setFieldIPAddress(JTextField fieldIPAddress) {
		this.fieldIPAddress = fieldIPAddress;
	}

	/************************* labelPortNumber ***************************/
	/**
	 * @return the labelPortNumber
	 */
	public JLabel getLabelPortNumber() {
		return labelPortNumber;
	}

	/**
	 * @param labelPortNumber the labelPortNumber to set
	 */
	public void setLabelPortNumber(JLabel labelPortNumber) {
		this.labelPortNumber = labelPortNumber;
	}

	/************************** labelIPAddress ***************************/
	/**
	 * @return the labelIPAddress
	 */
	public JLabel getLabelIPAddress() {
		return labelIPAddress;
	}

	/**
	 * @param labelIPAddress the labelIPAddress to set
	 */
	public void setLabelIPAddress(JLabel labelIPAddress) {
		this.labelIPAddress = labelIPAddress;
	}

	/* ================================================================= */
	/**************************** METHODS ********************************/
	/*********************************************************************/

	@Override
	protected void initializeAttributes() {
		labelArray = new ArrayList<JLabel>();
		labelPortNumber = new JLabel("Port Number ");
		labelIPAddress = new JLabel("IP Address ");
		labelArray.add(labelPortNumber);
		labelArray.add(labelIPAddress);
		textFieldArray = new ArrayList<JTextField>();
		fieldPortNumber = new JTextField();
		fieldIPAddress = new JTextField();
		textFieldArray.add(fieldPortNumber);
		textFieldArray.add(fieldIPAddress);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		if (source == submitButton) {
			submitMap = new HashMap<String, JTextField>();
			submitMap.put("portnumber", textFieldArray.get(0));
			submitMap.put("ipaddress", textFieldArray.get(1));
			System.out.println(submitMap);

		}

	}
}
