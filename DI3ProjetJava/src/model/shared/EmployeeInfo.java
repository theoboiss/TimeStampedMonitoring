package model.shared;

/**
 * 
 */
public class EmployeeInfo {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private Integer ID;
	private String firstName;
	private String lastName;


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * 
	 */
	public EmployeeInfo() {
		this(0, "default", "default");
	}
	
	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 */
	public EmployeeInfo(Integer ID, String firstName, String lastName) {
		setID(ID);
		setNames(firstName, lastName);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/********************************* ID ********************************/
	
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	protected void setID(Integer iD) {
		ID = iD;
	}

	/******************************** Names *******************************/

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param firstName the firstName to set
	 * @param lastName the lastName to set
	 */
	public void setNames(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}


	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {
		return "Employee [ID=" + getID() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + "]";
	}
	
	
}
