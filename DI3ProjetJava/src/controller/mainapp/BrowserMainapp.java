package controller.mainapp;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JTextField;

import controller.shared.TCPClientMainApp;
import model.mainapp.*;
import model.shared.CheckInOut;
import model.shared.EmployeeInfo;

public class BrowserMainapp {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	final static private List<String> viewsIndex = Arrays.asList("NoView", "ViewResultsCheckInOuts",
			"ViewResultsEmployees", "ViewResultsEmployeeDetails");
	private String view;
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
	public BrowserMainapp(String view) throws Exception {
		if (!getViewsIndex().contains(view)) {
			throw new IllegalArgumentException("The requested result view is not available.");
		}
		setView(view);
		setModel(Mainapp.getCurrentModel());
		setFormatter(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));
		setRegexPattern(", |,| ");
	}

	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/**
	 * @return the viewsIndex
	 */
	static public List<String> getViewsIndex() {
		return viewsIndex;
	}

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
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	/*
	 * protected HashSet<Employee> selectEmployees(String[] searchedIDs, String[]
	 * searchedFirstnames, String[] searchedLastnames) { //Will select the employees
	 * to look into HashSet<Employee> selectedEmployees = new HashSet<>();
	 * 
	 * //Select employees by ID if (searchedIDs.length == 1) { if
	 * (searchedIDs[0].isBlank()) { //we have to look for every employees by default
	 * for (Department currentDepartment : getModel().getListDepartment())
	 * selectedEmployees.addAll(currentDepartment.getListEmployees().values()); }
	 * else selectedEmployees.add(SearchInMainapp.searchEmployee(getModel(),
	 * Integer.valueOf(searchedIDs[0]))); } else for (String valueForID :
	 * searchedIDs) { //we look for the only employees that are concerned by their
	 * ID if (!valueForID.isBlank())
	 * selectedEmployees.add(SearchInMainapp.searchEmployee(getModel(),
	 * Integer.valueOf(valueForID))); }
	 * 
	 * //Select employees by name if (searchedFirstnames.length == 1 &&
	 * searchedLastnames.length == 1) { if (searchedFirstnames[0].isBlank() &&
	 * searchedLastnames[0].isBlank()) { //we have to look for every employees by
	 * default for (Department currentDepartment : getModel().getListDepartment())
	 * selectedEmployees.addAll(currentDepartment.getListEmployees().values()); }
	 * else if (searchedFirstnames[0].isBlank())
	 * selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(),
	 * searchedLastnames[0], 1)); else
	 * selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(),
	 * searchedFirstnames[0], 0)); } else for (String valueForFirstname :
	 * searchedFirstnames) { //we look for the only employees that are concerned by
	 * their ID if (valueForFirstname.isBlank()) { for (String valueForLastname :
	 * searchedLastnames) if (!valueForLastname.isBlank())
	 * selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(),
	 * valueForLastname, 1)); } else for (String valueForLastname :
	 * searchedLastnames) { if (valueForLastname.isBlank())
	 * selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(),
	 * valueForFirstname, 0)); else
	 * selectedEmployees.addAll(SearchInMainapp.searchEmployee(getModel(),
	 * valueForFirstname, valueForLastname)); } }
	 * 
	 * return selectedEmployees; }
	 */
	public void intersectionCollection(Collection<Employee> list1, Collection<Employee> list2) {
		if (!list1.isEmpty())
			list1.retainAll(list2);
		else
			list1.addAll(list2);
	}

	/*********************************************************************/
	/****************************** SEARCH *******************************/
	/*********************************************************************/

	/**
	 * @details A request should be a HashMap like this :
	 *          +----------------------------------------------------+ |"id" ->
	 *          JTextField="1, 2, 3" |
	 *          |----------------------------------------------------| |"firstname"
	 *          -> JTextField="Steven" |
	 *          |----------------------------------------------------| |"lastname"
	 *          -> JTextField="" |
	 *          |----------------------------------------------------| |"after_date"
	 *          -> JTextField="01-01-2021 00:00" |
	 *          |----------------------------------------------------|
	 *          |"before_date" -> JTextField="01-01-2021 16:00" |
	 *          +----------------------------------------------------+
	 * 
	 *          And we give the result of the intersection of these informations
	 * 
	 * @param request
	 * @return
	 */
	/*
	 * public Object[][] searchCheckInOut(HashMap<String,JTextField> request) {
	 * //String[] titles = {"ID", "Firstname", "Lastname", "Date", "Status"};
	 * 
	 * 
	 * //extract informations from the request String[] searchedIDs =
	 * request.get("id").getText().split(getRegexPattern()); String[]
	 * searchedFirstnames =
	 * request.get("firstname").getText().split(getRegexPattern()); String[]
	 * searchedLastnames =
	 * request.get("lastname").getText().split(getRegexPattern()); //add
	 * department_name String searchedAfterDate =
	 * request.get("after_date").getText(); String searchedBeforeDate =
	 * request.get("before_date").getText();
	 * 
	 * //select the searched employees HashSet<Employee> searchedEmployees =
	 * selectEmployees(searchedIDs, searchedFirstnames, searchedLastnames);
	 * 
	 * //Search by the couple of dates using only the selected employees
	 * ArrayList<CheckInOut> rawResult = new ArrayList<>(); for (Employee
	 * selectedEmployee : searchedEmployees) {
	 * rawResult.addAll(SearchInMainapp.searchCheckInOut( selectedEmployee,
	 * LocalDateTime.parse(searchedAfterDate, getFormatter()),
	 * LocalDateTime.parse(searchedBeforeDate, getFormatter()) ) ); }
	 * 
	 * 
	 * //format the data Object[][] data = new Object[rawResult.size()][]; Integer
	 * iterator = 0; for (CheckInOut foundCheck : rawResult) { Employee
	 * correspondingEmployee = SearchInMainapp.searchEmployee(getModel(),
	 * foundCheck.getEmployeeID()); Object[] line = {
	 * foundCheck.getEmployeeID().toString(), correspondingEmployee.getFirstname(),
	 * correspondingEmployee.getLastname(),
	 * foundCheck.getCheckTime().format(getFormatter()),
	 * Boolean.toString(foundCheck.isStatus()) }; data[iterator++] = line; }
	 * 
	 * return data; }
	 */

	public Object[][] searchEmployee(HashMap<String, JTextField> request) {
		// String[] titles = {"ID", "Firstname", "Lastname", "Department", "Date of last
		// check"};

		// extract informations from the request
		String[] searchedIDs = request.get("id").getText().split(getRegexPattern());
		String[] searchedFirstnames = request.get("firstname").getText().split(getRegexPattern());
		String[] searchedLastnames = request.get("lastname").getText().split(getRegexPattern());
		String[] searchedDepartments = request.get("department_name").getText().split(getRegexPattern());

		// Select employees by ID
		HashSet<Employee> selectedEmployeesByID = new HashSet<>();
		if (searchedIDs.length == 1) {
			if (!searchedIDs[0].isBlank())
				selectedEmployeesByID.add(SearchInMainapp.searchEmployee(getModel(), Integer.valueOf(searchedIDs[0])));
		} else
			for (String valueForID : searchedIDs) { // we look for the only employees that are concerned by their ID
				if (!valueForID.isBlank())
					selectedEmployeesByID.add(SearchInMainapp.searchEmployee(getModel(), Integer.valueOf(valueForID)));
			}

		// Select employees by name
		HashSet<Employee> selectedEmployeesByName = new HashSet<>();
		if (searchedFirstnames.length == 1 && searchedLastnames.length == 1) {
			if (!searchedFirstnames[0].isBlank() && !searchedLastnames[0].isBlank())
				intersectionCollection(selectedEmployeesByName,
						SearchInMainapp.searchEmployee(getModel(), searchedFirstnames[0], searchedLastnames[0]));
			else if (!searchedFirstnames[0].isBlank())
				intersectionCollection(selectedEmployeesByName,
						SearchInMainapp.searchEmployee(getModel(), searchedFirstnames[0], 0));
			else
				intersectionCollection(selectedEmployeesByName,
						SearchInMainapp.searchEmployee(getModel(), searchedLastnames[0], 1));
		} else
			for (String valueForFirstname : searchedFirstnames) { // we look for the only employees that are concerned
																	// by their ID
				if (valueForFirstname.isBlank()) {
					for (String valueForLastname : searchedLastnames)
						if (!valueForLastname.isBlank())
							intersectionCollection(selectedEmployeesByName,
									SearchInMainapp.searchEmployee(getModel(), valueForLastname, 1));
				} else
					for (String valueForLastname : searchedLastnames) {
						if (valueForLastname.isBlank())
							intersectionCollection(selectedEmployeesByName,
									SearchInMainapp.searchEmployee(getModel(), valueForFirstname, 0));
						else
							intersectionCollection(selectedEmployeesByName,
									SearchInMainapp.searchEmployee(getModel(), valueForFirstname, valueForLastname));
					}
			}

		// Search the employees in the intersection of selectedEmployeesByName and
		// selectedEmployeesByID
		CopyOnWriteArrayList<Employee> rawResult = new CopyOnWriteArrayList<>(selectedEmployeesByID);
		intersectionCollection(rawResult, selectedEmployeesByName);

		if (!rawResult.isEmpty()) {

			for (Employee selectedEmployee : rawResult) {
				boolean isInSearchedDepartments = false;
				for (Integer iterator = 0; (iterator < searchedDepartments.length)
						&& !isInSearchedDepartments; iterator++) {
					if (SearchInMainapp.areStringsMatching(selectedEmployee.getDepartment(),
							searchedDepartments[iterator]))
						isInSearchedDepartments = true;
				}
				if (!isInSearchedDepartments)
					rawResult.remove(selectedEmployee);
			}
		} else {
			for (String currentDepartmentName : searchedDepartments) {
				try {
					rawResult.addAll(getModel().getDepartment(currentDepartmentName).getListEmployees().values());
				} catch (Exception e) {
					// the company does not have the current department name but it is okay
				}
			}
		}

		// System.out.println(rawResult); //debug

		// format the data
		final Object[][] data = new Object[rawResult.size()][];
		Integer iterator = 0;
		for (Employee foundEmployee : rawResult) {
			Object foundEmployeeLastCheckInOut = "";
			if (!foundEmployee.getListChecks().isEmpty()) { // then keep only the last element
				CheckInOut lastCheckInOut = foundEmployee.getListChecks().get(foundEmployee.getListChecks().size() - 1);
				foundEmployeeLastCheckInOut = lastCheckInOut.getCheckTime().format(getFormatter());
			}
			final Object[] line = { foundEmployee.getID().toString(), foundEmployee.getFirstname(),
					foundEmployee.getLastname(), foundEmployee.getDepartment(), foundEmployeeLastCheckInOut };
			data[iterator++] = line;
		}

		return data;
	}

	public Object[][][] searchEmployeeDetails(String request) {
		Integer IDemployee = Integer.parseInt(request);
		Employee searchedEmployee = SearchInMainapp.searchEmployee(getModel(), IDemployee);

		String[][] tableInfo = new String[4][];
		for (String[] str : tableInfo)
			str = new String[1];
		tableInfo[0][0] = searchedEmployee.getID().toString();
		tableInfo[1][0] = searchedEmployee.getFirstname();
		tableInfo[2][0] = searchedEmployee.getLastname();
		tableInfo[3][0] = searchedEmployee.getDepartment();

		String[][] tablePlanning = new String[5][];
		HashMap<DayName, DayPlanning> searchedEmployeePlanning = new HashMap<>(
				searchedEmployee.getPlanning().getPlanning());
		Integer iteratorX = 0;
		for (DayName day : DayName.values()) {
			tablePlanning[iteratorX] = new String[2];
			tablePlanning[iteratorX][0] = searchedEmployeePlanning.get(day).getArrivalTime()
					.format(DateTimeFormatter.ofPattern("HH:mm"));
			tablePlanning[iteratorX][1] = searchedEmployeePlanning.get(day).getLeavingTime()
					.format(DateTimeFormatter.ofPattern("HH:mm"));
		}

		String[][] tableChecks = new String[1][];
		ArrayList<CheckInOut> listEmployeeChecks = SearchInMainapp.searchCheckInOut(searchedEmployee, LocalDateTime.MIN,
				LocalDateTime.MAX);
		tableChecks[0] = new String[listEmployeeChecks.size()];
		for (Integer iterator = 0; iterator < listEmployeeChecks.size(); iterator++) {
			tableChecks[0][iterator] = listEmployeeChecks.get(iterator).getCheckTime()
					.format(DateTimeFormatter.ofPattern("HH:mm"));
		}

		Object[][][] data = new Object[3][][];
		data[0] = tableInfo;
		data[1] = tablePlanning;
		data[2] = tableChecks;
		return data;
	}

	/*********************************************************************/
	/******************************** ADD ********************************/
	/*********************************************************************/

	public String addEmployee(HashMap<String, JTextField> request) {
		// extract informations from the request
		String firstnameNewEmployee = request.get("firstname").getText().split(getRegexPattern())[0];
		String lastnameNewEmployee = request.get("lastname").getText().split(getRegexPattern())[0];
		String departmentNewEmployee = request.get("department_name").getText().split(getRegexPattern())[0];

		try {
			Department correspondingDepartment = getModel().getDepartment(departmentNewEmployee);
			if (correspondingDepartment != null) {
				correspondingDepartment.addEmployee(new Employee(firstnameNewEmployee, lastnameNewEmployee));
				try {
					MainappSettings settings = new MainappSettings();
					new Thread(new TCPClientMainApp(
							MainappSettings.castInEmployeeInfo(
									SearchInMainapp.searchEmployee(MainappSettings.getCurrentModel())),
							settings.getIPaddressClient(), settings.getNumPortClient())).start();
				} catch (Exception e) {
					System.out.println("Exception in Mainapp main : " + e.getMessage());
				}
				return "Successful addition";
			} else
				throw new Exception("This department does not exist.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Addition failed          ";
		}
	}

	/*********************************************************************/
	/******************************** DEL ********************************/
	/*********************************************************************/

	public String delEmployee(String request) {
		Integer IDemployee = Integer.parseInt(request);

		for (Department currentDepartment : getModel().getListDepartment()) {
			HashMap<Integer, Employee> listEmployeesInCurrentDepartment = currentDepartment.getListEmployees();
			if (listEmployeesInCurrentDepartment.remove(IDemployee) != null) {
				Integer indexOfIDtoRemove = Employee.getlistUsedIDs().indexOf(IDemployee);
				for (Integer index = indexOfIDtoRemove; index < Employee.getlistUsedIDs().size() - 1; index++) {
					Employee.getlistUsedIDs().set(index, index + 1);
					Employee.getlistUsedIDs().remove(Employee.getlistUsedIDs().size() - 1);
				}
				return "Removed";
			}
		}

		return "Could not find the empoyee in the application";
	}
}
