package model.shared;


import java.time.LocalDateTime;

public class CheckInOut 
{
	/* ================================================================= */
	/************************* CLASS ATTRIBUTES **************************/
	/*********************************************************************/

	private Integer employeeID;
	private LocalDateTime checkTime;
	private boolean status;

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/*************************** CONSTRUCTORS ****************************/
	/*********************************************************************/

	/**
	 * @brief Default Constructor
	 */
	public CheckInOut() 
	{
		setEmployeeID(employeeID);
		checkTime = LocalDateTime.now();
		status = true; // Default value
	}

	/**
	 * @brief Copy Constructor
	 * @param departmentName
	 * @param employeeID
	 * @param checkTime
	 * @param status
	 */
	public CheckInOut(String departmentName, Integer employeeID, LocalDateTime checkTime, boolean status) 
	{
		super();
		this.employeeID = employeeID;
		this.checkTime = checkTime;
		this.status = status;
	}

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/********************** GETTERS AND SETTERS **************************/
	/*********************************************************************/

	/**
	 * @return the employeeID
	 */
	public Integer getEmployeeID() 
	{
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(Integer employeeID) 
	{
		this.employeeID = employeeID;
	}

	/**
	 * @return the checkTime
	 */
	public LocalDateTime getCheckTime() 
	{
		return checkTime;
	}

	/**
	 * @param checkTime the checkTime to set
	 */
	public void setCheckTime(LocalDateTime checkTime) 
	{
		this.checkTime = checkTime;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() 
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) 
	{
		this.status = status;
	}

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */
	
	/* ================================================================= */
	/***************************** METHODS *******************************/
	/*********************************************************************/

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */
}
