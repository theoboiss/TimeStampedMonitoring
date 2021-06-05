package view.emulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.*;

import model.emulator.History.EventDuringCheck;
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
		private static CopyOnWriteArrayList<CheckInOut> checks;
		private static EventDuringCheck event;
		/*********************************************************************/
		/*********************************************************************/
		/* ================================================================= */

		/**
		 * @return the event
		 */
		public static EventDuringCheck getEvent() {
			return event;
		}

		/**
		 * @param event the event to set
		 */
		public static void setEvent(EventDuringCheck event) {
			ViewEmulator.event = event;
		}

		/* ================================================================= */
		/*************************** CONSTRUCTORS ****************************/
		/*********************************************************************/
		public ViewEmulator() 
		{	
			// Panel creation
			JFrame window = new JFrame();
			JPanel panel = (JPanel) window.getContentPane();
			
			String imagePath = "view/images/JavaIcons/javatech.png";
			ImageIcon icon = new ImageIcon(imagePath);
			JLabel logo = new JLabel(icon, JLabel.CENTER);
		    window.add(logo);
			
	        
	        
	        
			// Panel configuration
	        window.setTitle("JavaTech™ V.1.0");
	        panel.setName("Time Tracker Emulator");
			window.setSize(500, 300);
			window.setLocationRelativeTo(null);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			panel.setLayout(null);
			
			// Check in/out button
			JButton startButton = new JButton("Check in/out");
	        startButton.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y );
	        
	        // Clock and other fields
			JLabel reelTimeClock = new JLabel();
			JLabel frontTitle = new JLabel();
			JLabel IDLabel = new JLabel("Employee ID");
			JTextField IDField = new JTextField();
			Date currentDate = new Date();
			
			frontTitle.setText("Time Tracker Emulator");
			reelTimeClock.setText("Today is : " + currentDate);
			reelTimeClock.setBounds(118, 40, 400, 30);
			Dimension sizeTitle = frontTitle.getPreferredSize();
			frontTitle.setBounds(175, 15, sizeTitle.width, sizeTitle.height);
			Dimension sizeIDLabel = IDLabel.getPreferredSize();
	        IDLabel.setBounds(10, 230, sizeIDLabel.width, sizeIDLabel.height);
	        IDField.setBounds(90, 223, 200, 30);

			// Add previous element to panel
			window.add(startButton);
			panel.add(IDLabel);
			panel.add(IDField);
			panel.add(reelTimeClock);
			panel.add(frontTitle);
			window.setVisible(true);
			
			
			
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
		public static CopyOnWriteArrayList<CheckInOut> getChecks() 
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



