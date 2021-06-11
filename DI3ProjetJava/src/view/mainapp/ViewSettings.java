package view.mainapp;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**Gestion des paramètres (param IP & port de l’application principale pour la pointeuse, etc.)*/

public class ViewSettings extends ViewModel{
	
	private Integer portNumber;
	private Integer IPAddress;
	
	private JTextField fieldPortNumber;
	private JTextField fieldIPAddress;
	
	private JLabel labelPortNumber;
	private JLabel labelIPAddress;

	
	public ViewSettings () {
		setArraySize(2);
		initializeAttributes();
		buildContentPanel();
	}
	
	
	
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


	

	@Override
	protected void initializeAttributes() {
		labelArray = new ArrayList<JLabel>();
		labelPortNumber = new JLabel("Port Number ");
		labelIPAddress = new JLabel("IP Address ");
		labelPortNumber.setBounds(20,20,20,20);
		labelIPAddress.setBounds(20,20,20,20);
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
		// TODO Auto-generated method stub
		
	}

}
