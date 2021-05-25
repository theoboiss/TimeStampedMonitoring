package view.emulator;

import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.*;


import model.shared.CheckInOut;


public class ConsultationHistory extends JFrame 
{
	/* ================================================================= */
	/************************* CLASS ATTRIBUTES **************************/
	/*********************************************************************/
	private static final long serialVersionUID = 1L;
	private static final int BUTTON_LOCATION_X = 330;  		// location x 
	private static final int BUTTON_LOCATION_Y = 208;   	// location y 
	private static final int BUTTON_SIZE_X = 150;      		// size height
	private static final int BUTTON_SIZE_Y = 50;       		// size width
	private CopyOnWriteArrayList<CheckInOut> checks;
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/*************************** CONSTRUCTORS ****************************/
	/*********************************************************************/
	public ConsultationHistory() 
	{		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Size of the window
		this.setSize(500, 300);
		
		// Center the window on the screen
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		JButton startButton = new JButton("Check in/out");
        startButton.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y );
        this.add(startButton);
		
		this.add(panel);
		this.setTitle("Time Tracker Emulator");
		//panel.getRootPane().setBackground(Color.YELLOW);
		this.setVisible(true);
		
	
	}

	/**
	 * @param checks
	 */
	public ConsultationHistory(CopyOnWriteArrayList<CheckInOut> checks) 
	{
		super();
		this.checks = checks;
	}

	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */

	/* ================================================================= */
	/********************** GETTERS AND SETTERS **************************/
	/*********************************************************************/
	
	/**
	 * @return the checks
	 */
	public CopyOnWriteArrayList<CheckInOut> getChecks() 
	{
		return checks;
	}

	/**
	 * @param checks the checks to set
	 */
	public void setChecks(CopyOnWriteArrayList<CheckInOut> checks) 
	{
		this.checks = checks;
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
		return "ConsultationHistory [checks=" + checks + "]";
	}
	
	/*********************************************************************/
	/*********************************************************************/
	/* ================================================================= */
	
	
	
	public static void main(String[] args) 
	{
		new ConsultationHistory();
	}
	
}

