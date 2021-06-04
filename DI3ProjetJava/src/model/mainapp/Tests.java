package model.mainapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.shared.CheckInOut;

public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Test from model.mainapp\n");

		Employee employeeToSave = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			employeeToSave = new Employee("prenom", "nom");
			employeeToSave.getListChecks().add(new CheckInOut());
			System.out.println("Serialisation");
			final FileOutputStream fichierOut = new FileOutputStream("myEmployee.ser");
			oos = new ObjectOutputStream(fichierOut);
			oos.writeObject(employeeToSave);
			oos.flush();

			System.out.println("Deserialisation");
			final FileInputStream fichierIn = new FileInputStream("myEmployee.ser");
			ois = new ObjectInputStream(fichierIn);
			Employee employeeSaved = (Employee) ois.readObject();
			System.out.println(employeeSaved);
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
