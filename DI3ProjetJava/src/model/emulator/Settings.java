package model.emulator;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.EmployeeInfo;


public class Settings 
{

	/* ================================================================= */
	/************************* CLASS ATTRIBUTES **************************/
	/*********************************************************************/

	private CopyOnWriteArrayList<EmployeeInfo> listEmployeeID;
	private LocalDateTime dateTime;
	private Integer IPAdress;
	private Integer portNumber;
	
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/*************************** CONSTRUCTORS ****************************/
	/*********************************************************************/

	/**
	 * @brief Default Constructor
	 */
	public Settings() 
	{
		setListEmployeeID(listEmployeeID);
		dateTime = LocalDateTime.now();
		setIPadress(IPAdress);
		setPortNumber(portNumber);
	}

	/**
	 * @brief Copy Constructor
	 * @param departmentName
	 * @param listEmployeeID
	 * @param dateTime
	 * @param iPadress
	 * @param portNumber
	 */
	public Settings(String departmentName, CopyOnWriteArrayList<EmployeeInfo> listEmployeeID, LocalDateTime dateTime,
			Integer iPAdress, Integer portNumber) 
	{
		super();
		this.listEmployeeID = listEmployeeID;
		this.dateTime = dateTime;
		IPAdress = iPAdress;
		this.portNumber = portNumber;
	}

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/********************** GETTERS AND SETTERS **************************/
	/*********************************************************************/


	/**
	 * @brief
	 * @return the listEmployeeID
	 */
	public CopyOnWriteArrayList<EmployeeInfo> getListEmployeeID() 
	{
		return listEmployeeID;
	}

	/**
	 * @brief
	 * @param listEmployeeID the listEmployeeID to set
	 */
	public void setListEmployeeID(CopyOnWriteArrayList<EmployeeInfo> listEmployeeID) 
	{
		this.listEmployeeID = listEmployeeID;
	}

	/**
	 * @brief
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() 
	{
		return dateTime;
	}

	/**
	 * @brief
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) 
	{
		this.dateTime = dateTime;
	}

	/**
	 * @brief
	 * @return the iPadress
	 */
	public Integer getIPadress() 
	{
		return IPAdress;
	}

	/**
	 * @brief
	 * @param iPadress the iPadress to set
	 */
	public void setIPadress(Integer iPAdress) 
	{
		IPAdress = iPAdress;
	}

	/**
	 * @brief
	 * @return the portNumber
	 */
	public Integer getPortNumber() 
	{
		return portNumber;
	}

	/**
	 * @brief
	 * @param portNumber the portNumber to set
	 */
	public void setPortNumber(Integer portNumber) 
	{
		this.portNumber = portNumber;
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
		return "Settings [listEmployeeID=" + listEmployeeID + ", dateTime=" + dateTime + ", IPAdress=" + IPAdress
				+ ", portNumber=" + portNumber + "]";
	}
	
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

}
