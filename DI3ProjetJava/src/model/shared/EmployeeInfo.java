package model.shared;

import java.io.Serializable;

public class EmployeeInfo implements Serializable {

	private static final long serialVersionUID = -2361731577118015767L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private Integer ID;
	private String firstname;
	private String lastname;


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @throws Exception
	 */
	public EmployeeInfo() throws Exception {
		this(0, "default", "default");
	}
	
	/**
	 * @param ID
	 * @param firstname
	 * @param lastname
	 * @throws Exception 
	 */
	public EmployeeInfo(Integer ID, String firstname, String lastname) throws Exception {
		setID(ID);
		setNames(firstname, lastname);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/********************************* ID ********************************/
	
	/**
	 * @return
	 */
	public Integer getID() {
		return ID;
	}
	
	/**
	 * @param ID
	 * @throws Exception 
	 */
	public void setID(Integer ID) throws Exception {
		this.ID = ID;
	}

	/******************************** Names *******************************/

	/**
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * @param firstname
	 * @throws Exception 
	 */
	public void setFirstname(String firstname) throws Exception {
		if (firstname.isBlank())
			throw new Exception("Error in setFirstname : please specify a firstname.");
		
		this.firstname = firstname;
	}
	
	/**
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * @param lastname
	 * @throws Exception 
	 */
	public void setLastname(String lastname) throws Exception {
		if (lastname.isBlank())
			throw new Exception("Error in setFirstname : please specify a lastname.");
		this.lastname = lastname;
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @throws Exception 
	 */
	public void setNames(String firstname, String lastname) throws Exception {
		setFirstname(firstname);
		setLastname(lastname);
	}


	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {
		return "Employee [ID=" + getID() + ", firstname=" + getFirstname() + ", lastname=" + getLastname() + "]";
	}
	
	
}
