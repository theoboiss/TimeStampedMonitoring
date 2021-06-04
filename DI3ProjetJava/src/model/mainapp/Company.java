package model.mainapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.shared.CheckInOut;

public class Company implements Serializable {
	
	private static final long serialVersionUID = -5385628284286557836L;
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private ArrayList<Department> listDepartment;
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/

	public Company() {
		super();
		this.listDepartment = new ArrayList<Department>();
	}
	
	/**
	 * @param listDepartment
	 */
	public Company(ArrayList<Department> listDepartment) {
		setListDepartment(listDepartment);
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	
	/************************** listDepartment *************************/
	
	/**
	 * @return the listDepartment
	 */
	public ArrayList<Department> getListDepartment() {
		return listDepartment;
	}

	/**
	 * @param listDepartment the listDepartment to set
	 */
	public void setListDepartment(ArrayList<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}
	
	/**
	 * @param department the department to add
	 * @throws Exception
	 * @return Department
	 */
	public Department getDepartment(String departmentName) throws Exception {
		for (Department currentDepartment : getListDepartment()) {
			if (currentDepartment.getName() == departmentName)
				return currentDepartment;
		}
		return null;
	}

	/**
	 * @param department the department to add
	 * @throws Exception 
	 */
	public void addDepartment(Department department) throws Exception {
		for (Department currentDepartment : getListDepartment()) {
			if (currentDepartment == department || currentDepartment.getName() == department.getName())
				throw new Exception("This department exists in this company already");
		}
		getListDepartment().add(department);
	}
	

	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/
	
	@Override
	public String toString() {
		String msg = "Company[\n";
		for(Department departmentTmp : getListDepartment()) {
			msg += "    " + departmentTmp.toString() + ",\n";
		}
		msg = msg.substring(0,msg.length()-2);
		msg += "\n]";
		return msg;
	}
	
	public static void main(String[] args){
		Company companyToSave = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			companyToSave = new Company();
			Department A = new Department("PolyGame");
			Department B = new Department("JavaTech", new Employee("default", "RH"));
			companyToSave.addDepartment(A); companyToSave.addDepartment(B);

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
			
			//add few employees to B
			B.addEmployee(new Employee("test","default"));
			B.addEmployee(new Employee("default3","test"));
	
			SearchInMainapp.searchEmployee(B,"default",1).get(0).setFirstname("Theo");
			SearchInMainapp.searchEmployee(B,"Theo","default").get(0).setLastname("Boisseau");
			
			
			
			System.out.println("Serialisation");
			final FileOutputStream fichierOut = new FileOutputStream("myData.ser");
			oos = new ObjectOutputStream(fichierOut);
			oos.writeObject(companyToSave);
			oos.flush();
			 
			System.out.println("Deserialisation");
			final FileInputStream fichierIn = new FileInputStream("myData.ser");
			ois = new ObjectInputStream(fichierIn);
			Company companySaved = (Company) ois.readObject();
			System.out.println(companySaved);
			
			System.out.println(Employee.getlistUsedIDs());
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
}
