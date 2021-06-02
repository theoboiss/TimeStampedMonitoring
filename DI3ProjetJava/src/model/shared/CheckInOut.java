package model.shared;


import java.time.LocalDateTime;

/**
 * @author RMICH Mohammed
 *
 */
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
		employeeID = 0;
		checkTime = LocalDateTime.now();
		status = true;
	}

	/**
	 * @brief Copy Constructor
	 * @param departmentName
	 * @param employeeID
	 * @param checkTime
	 * @param status
	 */
	public CheckInOut(Integer employeeID, LocalDateTime checkTime, boolean status) 
	{
		setEmployeeID(employeeID);
		setCheckTime(checkTime);
		setStatus(status);
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

	@Override
	public String toString() 
	{
		return "CheckInOut [employeeID=" + employeeID + ", checkTime=" + checkTime + ", status=" + status + "]";
	}
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */
}
