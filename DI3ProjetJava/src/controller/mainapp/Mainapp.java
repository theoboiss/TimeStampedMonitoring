package controller.mainapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.JTextField;

import view.mainapp.ViewResults;

import model.mainapp.*;
import model.shared.CheckInOut;

public class Mainapp {


	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private ViewResults view;
	private Company model;
	private DateTimeFormatter formatter; 
	private String regexPattern;


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @param view
	 * @param request
	 */
	public Mainapp(ViewResults view) {
		setView(view);
		setFormatter(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));
		setRegexPattern("(,( ))");
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/**
	 * @return the view
	 */
	public ViewResults getView() {
		return view;
	}


	/**
	 * @param view the view to set
	 */
	public void setView(ViewResults view) {
		this.view = view;
	}


	/**
	 * @return the model
	 */
	public Company getModel() {
		return model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(Company model) {
		this.model = model;
	}

	
	/**
	 * @return the formatter
	 */
	public DateTimeFormatter getFormatter() {
		return formatter;
	}


	/**
	 * @param formatter the formatter to set
	 */
	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}


	/**
	 * @return the regexPattern
	 */
	public String getRegexPattern() {
		return regexPattern;
	}


	/**
	 * @param regexPattern the regexPattern to set
	 */
	public void setRegexPattern(String regexPattern) {
		this.regexPattern = regexPattern;
	}


	/*********************************************************************/
	/****************************** SEARCH *******************************/
	/*********************************************************************/
	
	protected HashSet<Employee> selectEmployees(String[] searchedIDs, String[] searchedFirstnames, String[] searchedLastnames) {
		//Will select the employees to look into
		HashSet<Employee> selectedEmployees = new HashSet<>();
		
		//Select employees by ID
		if (searchedIDs.length == 1 && searchedIDs[0].isBlank()) { //we have to look for every employees by default
			for (Department currentDepartment : getModel().getListDepartment())
				selectedEmployees.addAll(currentDepartment.getListEmployees().values());
		}
		else for (String valueForID : searchedIDs) { //we look for the only employees that are concerned by their ID
			if (!valueForID.isBlank())
				selectedEmployees.add(SearchInMainapp.searchEmployee(getModel(), Integer.valueOf(valueForID)));
		}
		
		//Select employees by name
		if (searchedFirstnames.length == 1 && searchedFirstnames[0].isBlank()
		 && searchedLastnames.length == 1 && searchedLastnames[0].isBlank())
		{
			//we have to look for every employees by default
			for (Department currentDepartment : getModel().getListDepartment())
				selectedEmployees.addAll(currentDepartment.getListEmployees().values());
		}
		else for (String valueForFirstname : searchedFirstnames) { //we look for the only employees that are concerned by their ID
			if (valueForFirstname.isBlank()) {
				for (String valueForLastname : searchedLastnames)
					selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(), valueForLastname));
			}
			else for (String valueForLastname : searchedLastnames) {
				if (valueForLastname.isBlank())
					selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(), valueForFirstname));
				else
					selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(), valueForFirstname, valueForLastname));
			}
		}
		
		return selectedEmployees;
	}
	
	/**
	 * @details A request should be a HashMap like this :
	 * +----------------------------------------------------+
	 * |"id"			->	JTextField="1, 2, 3"			|
	 * |----------------------------------------------------|
	 * |"firstname"		->	JTextField="Steven"				|
	 * |----------------------------------------------------|
	 * |"lastname"		->	JTextField=""					|
	 * |----------------------------------------------------|
	 * |"afterDate"		->	JTextField="01-01-2021 00:00"	|
	 * |----------------------------------------------------|
	 * |"beforeDate"	->	JTextField="01-01-2021 16:00"	|
	 * +----------------------------------------------------+
	 * 
	 * And we give the result of the intersection of these informations
	 * 
	 * @param request
	 * @return
	 */
	public JTable searchCheckInOut(HashMap<String,JTextField> request) {
		String[] titles = {"ID", "Firstname", "Lastname", "Date", "Status"};
		
		
		//extract informations from the request
		String[] searchedIDs = request.get("id").getText().split(getRegexPattern());
		String[] searchedFirstnames = request.get("firstname").getText().split(getRegexPattern());
		String[] searchedLastnames = request.get("lastname").getText().split(getRegexPattern());
		String searchedAfterDate = request.get("afterDate").getText();
		String searchedBeforeDate = request.get("beforeDate").getText();
		
		//select the searched employees
		HashSet<Employee> searchedEmployees = selectEmployees(searchedIDs, searchedFirstnames, searchedLastnames);
		
		//Search by the couple of dates using only the selected employees
		ArrayList<CheckInOut> rawResult = new ArrayList<>();
		for (Employee selectedEmployee : searchedEmployees) {
			rawResult.addAll(SearchInMainapp.searchCheckInOut(
					selectedEmployee,
					LocalDateTime.parse(searchedAfterDate, getFormatter()),
					LocalDateTime.parse(searchedBeforeDate, getFormatter())
				)
			);
		}
		
		
		//format the data
		Object[][] data = new Object[searchedEmployees.size()][];
		Integer iterator = 0;
		for (CheckInOut foundCheck : rawResult) {
			Employee correspondingEmployee = SearchInMainapp.searchEmployee(getModel(), foundCheck.getEmployeeID());
			Object[] line = {
				foundCheck.getEmployeeID(),
				correspondingEmployee.getFirstName(),
				correspondingEmployee.getLastName(),
				foundCheck.getCheckTime().format(getFormatter()),
				Boolean.toString(foundCheck.isStatus())
			};
			data[iterator++] = line;
		}
		
		JTable result = new JTable(data,titles);
		return result;
	}
	
	public JTable searchEmployee(HashMap<String,JTextField> request) {
		String[] titles = {"ID", "Firstname", "Lastname", "Date of last check"};
		
		//extract informations from the request
		String[] searchedIDs = request.get("id").getText().split(getRegexPattern());
		String[] searchedFirstnames = request.get("firstname").getText().split(getRegexPattern());
		String[] searchedLastnames = request.get("lastname").getText().split(getRegexPattern());
		
		//select the searched employees
		HashSet<Employee> searchedEmployees = selectEmployees(searchedIDs, searchedFirstnames, searchedLastnames);
		
		
		//format the data
		Object[][] data = new Object[searchedEmployees.size()][];
		Integer iterator = 0;
		for (Employee foundEmployee : searchedEmployees) {
			Object[] line = {
				foundEmployee.getID(),
				foundEmployee.getFirstName(),
				foundEmployee.getLastName(),
			};
			data[iterator++] = line;
		}

		JTable result = new JTable(data,titles);
		return result;
	}
	/* 	NOT AVAILABLE YET
	public JTable searchEmployeeDetails(HashMap<String,JTextField> request) {
		String[] titles;
		
		
		Object[][] data;
		JTable result = new JTable(data,titles);
	}
	*/
	public static void main(String[] args) {
		
	}

}