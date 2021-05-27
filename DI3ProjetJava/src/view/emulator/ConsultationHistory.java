package view.emulator;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
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
		
		// Size of the window
		this.setSize(500, 300);
		
		// Center the window on the screen
		this.setLocationRelativeTo(null);
		JFrame window = new JFrame();
		// Close window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		JLabel reelTimeClock = new JLabel();
		JLabel frontTitle = new JLabel();
		
		Date currentDate = new Date();
		reelTimeClock.setText("Today is : " + currentDate);
		//reelTimeClock.setBounds(10, 30, 400, 30);
		
		frontTitle.setText("Time Tracker Emulator");
		frontTitle.setVerticalAlignment(JLabel.TOP);
		//frontTitle.setVerticalTextPosition(20);
		//frontTitle.setLayout(null);
		
		this.setTitle("Time Tracker Emulator V.1.0");
		panel.setName("Time Tracker Emulator");
		JButton startButton = new JButton("Check in/out");
        startButton.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y );
        this.add(startButton);
		
		this.add(panel);
		// Add date
		panel.add(reelTimeClock);
		panel.add(frontTitle);
		
		panel.setBackground(new Color(160, 220, 230));
		//startButton.setBackground(new Color(160, 220, 230));
		
		//frame.add(new ClockPane());
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

