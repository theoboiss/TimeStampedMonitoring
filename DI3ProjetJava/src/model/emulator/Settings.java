package model.emulator;

import java.time.LocalDateTime;
import model.mainapp.Employee;


public class Settings 
{

	/* ================================================================= */
	/************************* CLASS ATTRIBUTS ***************************/
	/*********************************************************************/

	static int EMPLOYEE_NUMBER;
	private Employee[] listEmployeeID;
	private LocalDateTime dateTime;
	private int IPAdress;
	private int portNumber;
	
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
		//listEmployeeID = new Employee[];
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
	public Settings(String departmentName, Employee[] listEmployeeID, LocalDateTime dateTime,
			int iPAdress, int portNumber) 
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
	public Employee[] getListEmployeeID() 
	{
		return listEmployeeID;
	}

	/**
	 * @brief
	 * @param listEmployeeID the listEmployeeID to set
	 */
	public void setListEmployeeID(Employee[] listEmployeeID) 
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
	public int getIPadress() 
	{
		return IPAdress;
	}

	/**
	 * @brief
	 * @param iPadress the iPadress to set
	 */
	public void setIPadress(int iPAdress) 
	{
		IPAdress = iPAdress;
	}

	/**
	 * @brief
	 * @return the portNumber
	 */
	public int getPortNumber() 
	{
		return portNumber;
	}

	/**
	 * @brief
	 * @param portNumber the portNumber to set
	 */
	public void setPortNumber(int portNumber) 
	{
		this.portNumber = portNumber;
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
