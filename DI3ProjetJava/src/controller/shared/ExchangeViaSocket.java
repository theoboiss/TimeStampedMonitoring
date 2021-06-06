package controller.shared;

import java.io.IOException;
import java.net.Socket;

public class ExchangeViaSocket extends SerializationProcess {
	
	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/

	public void send(Socket thisMachine, Object dataToSave) throws IOException {
		initialize(thisMachine.getOutputStream());
		insert(dataToSave);
	}
	
	public Object receive(Socket remoteMachine) throws ClassNotFoundException, IOException {
		initialize(remoteMachine.getInputStream());
		return extract();
	}
}
