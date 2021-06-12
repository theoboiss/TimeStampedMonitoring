package view.mainapp;

import java.awt.event.ActionEvent;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.mainapp.BrowserMainapp;
import controller.mainapp.MainappSettings;
import controller.mainapp.ModifyTCPSettings;
import controller.mainapp.TCPMainAppSettings;

/**
 * @brief Class to manage and modify connection settings (port number and IP
 *        address for the main application).
 *
 */
public class ViewSettings extends ViewModel {

	/* ================================================================= */
	/**************************** ATTRIBUTES *****************************/
	/*********************************************************************/

	private JTextField fieldPortNumber;
	private JTextField fieldIPAddress;

	private JLabel labelPortNumber;
	private JLabel labelIPAddress;
	
	private TCPMainAppSettings settings;

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

	public ViewSettings(TCPMainAppSettings settings)
	{
		this.settings = settings;
		setArraySize(2);
		initializeAttributes();
		buildContentPanel();
	}
	/* ================================================================= */
	/*************************** SETS/GETS *******************************/
	/*********************************************************************/

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
			submitMap.put("portnumber_server", textFieldArray.get(0));
			submitMap.put("ipaddress_server", textFieldArray.get(1));
			System.out.println(submitMap);

			ModifyTCPSettings settingsToModify = new ModifyTCPSettings(settings);
			try {
				settingsToModify.ModifyConnectionSettings(submitMap);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}

	}
}
