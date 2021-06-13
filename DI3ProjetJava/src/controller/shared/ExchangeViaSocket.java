package controller.shared;

import java.io.IOException;
import java.net.Socket;

public class ExchangeViaSocket extends SerializationProcess {

	/*********************************************************************/
	/*************************** OTHER METHODS ***************************/
	/*********************************************************************/

	/******************************* send ********************************/

	public void send(Socket thisMachine, Object dataToSave) throws IOException {
		initialize(thisMachine.getOutputStream());
		insert(dataToSave);
	}

	public void send(Socket thisMachine, Object dataToSave, int streamStatus) throws IOException {
		if (streamStatus > 0)
			initialize(thisMachine.getOutputStream());
		else
			initialize(getsOut());
		insert(dataToSave);
	}

	/****************************** receive ******************************/

	public Object receive(Socket remoteMachine) throws ClassNotFoundException, IOException {
		initialize(remoteMachine.getInputStream());
		return extract();
	}

	public Object receive(Socket remoteMachine, int streamStatus) throws ClassNotFoundException, IOException {
		if (streamStatus > 0)
			initialize(remoteMachine.getInputStream());
		else
			initialize(getsIn());
		return extract();
	}
}
