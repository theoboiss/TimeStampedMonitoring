package view.emulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.*;

import model.shared.CheckInOut;

public class ViewEmulator extends JFrame 
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
		public ViewEmulator() 
		{		
			
			// Size of the window
			this.setSize(500, 300);
			
			// Center the window on the screen
			this.setLocationRelativeTo(null);
			JFrame window = new JFrame();
			// Close window
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel = (JPanel) window.getContentPane();;
			panel.setLayout(null);
			
			JLabel reelTimeClock = new JLabel();
			JLabel frontTitle = new JLabel();
			
			Date currentDate = new Date();
			reelTimeClock.setText("Today is : " + currentDate);
			//SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
			//dateFormat.updateClock();
			//new Timer(1000, dateFormat).start();

			reelTimeClock.setBounds(118, 40, 400, 30);
			
			frontTitle.setText("Time Tracker Emulator");
			Dimension sizeTitle = frontTitle.getPreferredSize();
			frontTitle.setBounds(175, 15, sizeTitle.width, sizeTitle.height);
			//frontTitle.setVerticalAlignment(JLabel.TOP);
			//frontTitle.setVerticalTextPosition(20);
			//frontTitle.setLayout(null);
			
			this.setTitle("Time Tracker Emulator V.1.0");
			panel.setName("Time Tracker Emulator");
			JButton startButton = new JButton("Check in/out");
	        startButton.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y );
	        this.add(startButton);
	        
	        //  Id section
	        JLabel IDLabel = new JLabel("Employee ID");
	        JTextField IDField = new JTextField();
	        Dimension sizeIDLabel = IDLabel.getPreferredSize();
	        IDLabel.setBounds(10, 230, sizeIDLabel.width, sizeIDLabel.height);
	        //Dimension sizeIDField = IDField.getPreferredSize();
	        IDField.setBounds(90, 223, 200, 30);

	        //frame.setSize(300, 200);
	        //frame.setVisible(true);
	        
			panel.add(IDLabel);
	        panel.add(IDField);
			
			this.add(panel);
			// Add date
			panel.add(reelTimeClock);
			panel.add(frontTitle);
			//panel.add(dateFormat);
			
			panel.setBackground(new Color(85, 250, 40));
			//startButton.setBackground(new Color(160, 220, 230));
			
			//frame.add(new ClockPane());
			this.setVisible(true);
			
			//TESTPUSH
			
		}

		/**
		 * @param checks
		 */
		public ViewEmulator(CopyOnWriteArrayList<CheckInOut> checks) 
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
			return "ViewEmulator [checks=" + checks + "]";
		}
		
		/*********************************************************************/
		/*********************************************************************/
		/* ================================================================= */
		
		
		
		public static void main(String[] args) 
		{
			new ViewEmulator();
		}
		
	}



