package controller.mainapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class SerializationProcess {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/

	private InputStream sIn;
	private OutputStream sOut;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/

	/**
	 * @return the sIn
	 */
	public InputStream getsIn() {
		return sIn;
	}

	/**
	 * @param sIn the sIn to set
	 */
	public void setsIn(InputStream sIn) {
		this.sIn = sIn;
	}

	/**
	 * @return the sOut
	 */
	public OutputStream getsOut() {
		return sOut;
	}

	/**
	 * @param sOut the sOut to set
	 */
	public void setsOut(OutputStream sOut) {
		this.sOut = sOut;
	}

	/**
	 * @return the ois
	 */
	public ObjectInputStream getOis() {
		return ois;
	}

	/**
	 * @param ois the ois to set
	 */
	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	/**
	 * @return the oos
	 */
	public ObjectOutputStream getOos() {
		return oos;
	}

	/**
	 * @param oos the oos to set
	 */
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	

	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/

	public void initialize(InputStream sIn) throws IOException {
		setsIn(sIn);
		setOis(new ObjectInputStream(sIn));
	}
	
	public void initialize(OutputStream sOut) throws IOException {
		setsOut(sOut);
		setOos(new ObjectOutputStream(sOut));
	}
	
	/**
	 * @param objectToInsert
	 * @throws IOException 
	 */
	public void insert(Object objectToInsert) throws IOException {
		if (getsOut() == null || getOos() == null) {
			throw new IllegalArgumentException("SerializationProcess have been initialized to extract data from a stream");
		}
		
		getOos().writeObject(objectToInsert); //serialize Object
		getOos().close();
	}
	
	/**
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object extract() throws IOException, ClassNotFoundException {
		if (getsIn() == null || getOis() == null) {
			throw new IllegalArgumentException("SerializationProcess have been initialized to extract data from a stream");
		}
		
		Object deserializedObject = (Object) getOis().readObject();
		getOis().close();
		return deserializedObject;
	}
}
