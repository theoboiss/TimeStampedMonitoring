package model.shared;

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
	 * @throws Exception
	 */
	public EmployeeInfo() throws Exception {
		this(0, "", "");
	}
	
	/**
	 * @param ID
	 * @param firstName
	 * @param lastName
	 * @throws Exception 
	 */
	public EmployeeInfo(Integer ID, String firstName, String lastName) throws Exception {
		setID(ID);
		setNames(firstName, lastName);
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
	protected void setID(Integer ID) throws Exception {
		if (ID <= 0)
			throw new Exception("Error in setID : please use an ID > 0.");
		
		this.ID = ID;
	}

	/******************************** Names *******************************/

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName
	 * @throws Exception 
	 */
	public void setFirstName(String firstName) throws Exception {
		if (firstName.isBlank())
			throw new Exception("Error in setFirstName : please specify a firstName.");
		
		this.firstName = firstName;
	}
	
	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName
	 * @throws Exception 
	 */
	public void setLastName(String lastName) throws Exception {
		if (lastName.isBlank())
			throw new Exception("Error in setFirstName : please specify a lastName.");
		this.lastName = lastName;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @throws Exception 
	 */
	public void setNames(String firstName, String lastName) throws Exception {
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
