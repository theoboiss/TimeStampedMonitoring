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
	
	private String view;
	private MainappData dataController;
	private Company model;
	private DateTimeFormatter formatter; 
	private String regexPattern;


	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	/**
	 * @param view
	 * @param request
	 * @throws Exception 
	 */
	public Mainapp(String view) throws Exception {
		if (view != "ViewResultsCheckInOuts"
		 && view != "ViewResultsEmployees"
		 && view != "ViewResultsEmployeeDetails")
		{
			throw new IllegalArgumentException("The requested result view is not available.");
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		Company modelTest = new Company();
		Department A = new Department("PolyGame");
		Department B = new Department("JavaTech", new Employee("default", "RH"));
		modelTest.addDepartment(A); modelTest.addDepartment(B);
		
		//add few employees to B
		B.addEmployee(new Employee());
		B.addEmployee(new Employee());
		
		//add few checks to A
		
		CheckInOut exempleCheck1 = new CheckInOut();
		exempleCheck1.setEmployeeID(1);
		SearchInMainapp.searchEmployee(A,1).getListChecks().add(exempleCheck1);
		
		CheckInOut exempleCheck2 = new CheckInOut();
		SearchInMainapp.searchEmployee(A,1).getListChecks().add(exempleCheck2);
		exempleCheck2.setEmployeeID(1);
		
		CheckInOut exempleCheck3 = new CheckInOut();
		SearchInMainapp.searchEmployee(A,1).getListChecks().add(exempleCheck3);
		exempleCheck3.setEmployeeID(1);
		
		//a has 1 employee that made 3 checks

		
		SearchInMainapp.searchEmployee(B,3).setFirstName("Theo");
		SearchInMainapp.searchEmployee(B,3).setLastName("Boisseau");
		///////////////////////////////////////////////////////////////////////////////////////////////////
		setView(view);
		setModel(modelTest);
		//setModel(getDataController().getCurrentModel()); //it will be available after the serialization step
		setFormatter(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));
		setRegexPattern("(,( ))");
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	/**
	 * @return the view
	 */
	public String getView() {
		return view;
	}


	/**
	 * @param view the view to set
	 */
	public void setView(String view) {
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
		if (searchedIDs.length == 1) {
			if (searchedIDs[0].isBlank()) { //we have to look for every employees by default
				for (Department currentDepartment : getModel().getListDepartment())
					selectedEmployees.addAll(currentDepartment.getListEmployees().values());
			}
			else
				selectedEmployees.add(SearchInMainapp.searchEmployee(getModel(), Integer.valueOf(searchedIDs[0])));
		}
		else for (String valueForID : searchedIDs) { //we look for the only employees that are concerned by their ID
			if (!valueForID.isBlank())
				selectedEmployees.add(SearchInMainapp.searchEmployee(getModel(), Integer.valueOf(valueForID)));
		}
		
		//Select employees by name
		if (searchedFirstnames.length == 1 && searchedLastnames.length == 1) {
			if (searchedFirstnames[0].isBlank() && searchedLastnames[0].isBlank()) {
				//we have to look for every employees by default
				for (Department currentDepartment : getModel().getListDepartment())
					selectedEmployees.addAll(currentDepartment.getListEmployees().values());
			}
			else if (searchedFirstnames[0].isBlank())
				selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(), searchedLastnames[0]));
			else
				selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(), searchedFirstnames[0]));
		}
		else for (String valueForFirstname : searchedFirstnames) { //we look for the only employees that are concerned by their ID
			if (valueForFirstname.isBlank()) {
				for (String valueForLastname : searchedLastnames)
					if (!valueForLastname.isBlank())
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
	 * |"after_date"		->	JTextField="01-01-2021 00:00"	|
	 * |----------------------------------------------------|
	 * |"before_date"	->	JTextField="01-01-2021 16:00"	|
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
		//add department_name
		String searchedAfterDate = request.get("after_date").getText();
		String searchedBeforeDate = request.get("before_date").getText();
		
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
		Object[][] data = new Object[rawResult.size()][];
		Integer iterator = 0;
		for (CheckInOut foundCheck : rawResult) {
			Employee correspondingEmployee = SearchInMainapp.searchEmployee(getModel(), foundCheck.getEmployeeID());
			Object[] line = {
				foundCheck.getEmployeeID().toString(),
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
		String[] titles = {"ID", "Firstname", "Lastname", "Department", "Date of last check"};
		
		//extract informations from the request
		String[] searchedIDs = request.get("id").getText().split(getRegexPattern());
		String[] searchedFirstnames = request.get("firstname").getText().split(getRegexPattern());
		String[] searchedLastnames = request.get("lastname").getText().split(getRegexPattern());
		String[] searchedDepartments = request.get("department_name").getText().split(getRegexPattern());
				
		
		//Select employees by ID
		HashSet<Employee> selectedEmployeesByID = new HashSet<>();
		if (searchedIDs.length == 1) {
			if (!searchedIDs[0].isBlank())
				selectedEmployeesByID.add(SearchInMainapp.searchEmployee(getModel(), Integer.valueOf(searchedIDs[0])));
		}
		else for (String valueForID : searchedIDs) { //we look for the only employees that are concerned by their ID
			if (!valueForID.isBlank())
				selectedEmployeesByID.add(SearchInMainapp.searchEmployee(getModel(), Integer.valueOf(valueForID)));
		}
		
		//Select employees by name
		HashSet<Employee> selectedEmployeesByName = new HashSet<>();
		if (searchedFirstnames.length == 1 && searchedLastnames.length == 1) {
			if (!searchedFirstnames[0].isBlank())
				selectedEmployeesByName.addAll(SearchInMainapp.searchEmployee(getModel(), searchedFirstnames[0]));
			if (!searchedLastnames[0].isBlank())
				selectedEmployeesByName.addAll(SearchInMainapp.searchEmployee(getModel(), searchedLastnames[0]));
		}
		else for (String valueForFirstname : searchedFirstnames) { //we look for the only employees that are concerned by their ID
			if (valueForFirstname.isBlank()) {
				for (String valueForLastname : searchedLastnames)
					if (!valueForLastname.isBlank())
						selectedEmployeesByName.addAll(SearchInMainapp.searchEmployee(getModel(), valueForLastname));
			}
			else for (String valueForLastname : searchedLastnames) {
				if (valueForLastname.isBlank())
					selectedEmployeesByName.addAll(SearchInMainapp.searchEmployee(getModel(), valueForFirstname));
				else
					selectedEmployeesByName.addAll(SearchInMainapp.searchEmployee(getModel(), valueForFirstname, valueForLastname));
			}
		}
		
		//Search the employees in the intersection of selectedEmployeesByName and selectedEmployeesByID
		ArrayList<Employee> rawResult = new ArrayList<>();
		for (Employee selectedEmployee : selectedEmployeesByID) {
			if (selectedEmployeesByName.contains(selectedEmployee)) {
				for (String currentSearchedDepartment : searchedDepartments) {
					Department currentDepartment;
					try {
						currentDepartment = getModel().getDepartment(currentSearchedDepartment);
						if (currentDepartment != null) {
							if (currentDepartment.getListEmployees().containsKey(selectedEmployee.getID()))
								rawResult.add(selectedEmployee);
						}
					} catch (Exception e) {
						//there is no such department but it's okay
					}
				}
			}
		}
		
		
		//format the data
		Object[][] data = new Object[rawResult.size()][];
		Integer iterator = 0;
		for (Employee foundEmployee : rawResult) {
			Object foundEmployeeLastCheckInOut = "";
			if (!foundEmployee.getListChecks().isEmpty()) { //then keep only the last element
				CheckInOut lastCheckInOut = foundEmployee.getListChecks().get(foundEmployee.getListChecks().size()-1);
				foundEmployeeLastCheckInOut = lastCheckInOut.getCheckTime().format(getFormatter());
			}
			Object[] line = {
				foundEmployee.getID().toString(),
				foundEmployee.getFirstName(),
				foundEmployee.getLastName(),
				foundEmployeeLastCheckInOut
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
