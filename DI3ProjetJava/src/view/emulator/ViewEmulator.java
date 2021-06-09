package view.emulator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
//import java.awt.Dimension;
//import java.awt.Toolkit;
import javax.swing.*;
import controller.emulator.Emulator;
import controller.mainapp.Mainapp;
import controller.shared.TCPClientEmulator;
import controller.shared.TCPServerMainApp;
import model.emulator.History.EventDuringCheck;
import model.shared.CheckInOut;

public class ViewEmulator extends JFrame  implements ActionListener
	{
		/* ================================================================= */
		/************************* CLASS ATTRIBUTES **************************/
		/*********************************************************************/
	
		private static final long serialVersionUID = 1L;
		
		// Main frame and panel
		private JFrame frame;
		private JPanel panel;
		
		// Labels
		private JLabel frontTitle;
		private JLabel reelTimeClock;
		private JLabel roundTime;
		private JLabel IDLabel;
		
		// Time and date
		private Date currentDate;
		private LocalTime time;
		private LocalTime lastQuarter;
		
		// Button
		private JButton startButton; // MODIFIE PAR SARAH
		
		// Text field
		private JTextField IDField; // MODIFIE PAR SARAH
		
		// Dimension
		private Dimension sizeTitle;
		private Dimension sizeIDLabel;
		
		/*************** Size and Location elements ***************/
		// Frame
		private static final int FRAME_SIZE_X = 500;
		private static final int FRAME_SIZE_Y = 300;
		
		// Button
		private static final int BUTTON_LOCATION_X = 330;  		 
		private static final int BUTTON_LOCATION_Y = 208;   	
		private static final int BUTTON_SIZE_X = 150;      		
		private static final int BUTTON_SIZE_Y = 50;       		
		
		// Text field
		private static final int ID_FIELD_X = 90;
		private static final int ID_FIELD_Y = 223;
		private static final int ID_FIELD_W = 200;
		private static final int ID_FIELD_H = 30;
		
		// Frame title
		private static final int FRONT_TITLE_X = 175;
		private static final int FRONT_TITLE_Y = 15;
		//private static final int FRONT_TITLE_W;
		//private static final int FRONT_TITLE_H;
		
		// Time
		private static final int TIME_X = 118;
		private static final int TIME_Y = 40;
		private static final int TIME_W = 400;
		private static final int TIME_H = 30;
		
		private static final int ROUNDED_TIME_X = 195;
		private static final int ROUNDED_TIME_Y = 40;
		private static final int ROUNDED_TIME_W = 100;
		private static final int ROUNDED_TIME_H = 100;
		
		// ID
		private static final int ID_LABEL_X = 10;
		private static final int ID_LABEL_Y = 230;
		//private static final int ID_LABEL_W;
		//private static final int ID_LABEL_H;
		
		/*************** Titles ***************/
		private static final String FRAME_TITLE = "JavaTech™ V.1.0";
		private static final String PANEL_NAME = "Time Tracker Emulator";
		private static final String BUTTON_NAME = "Check in/out";
		private static final String ID_LABEL = "Employee ID";
		
		// Data to be sent to the controller 
		private static LocalDate date; // Date sent with a check in out
		private static CheckInOut checks;
		private static EventDuringCheck event;
		
		
		/* ================================================================= */
		/*************************** BUILDER ****************************/
		/*********************************************************************/
		public ViewEmulator() 
		{	
			// Panel creation
			frame = new JFrame();
			panel = (JPanel) frame.getContentPane();
	        
			// Panel configuration
	        frame.setTitle(FRAME_TITLE);
			frame.setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			panel.setName(PANEL_NAME);
			panel.setLayout(null);
			
			// Check in/out button
			startButton = new JButton(BUTTON_NAME); //MODIFIE PAR SARAH
	        startButton.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y );
	        startButton.addActionListener(this); //MODIFIE PAR SARAH
	        
	        // Clock
			reelTimeClock = new JLabel();
			roundTime = new JLabel();
			
			currentDate = new Date();
	        time = LocalTime.now();
			lastQuarter = time.truncatedTo(ChronoUnit.HOURS)
			                                .plusMinutes(15 * (time.getMinute() / 15));
			date = LocalDate.now();
			
			// Other elements
			frontTitle = new JLabel();
			IDLabel = new JLabel(ID_LABEL);
			IDField = new JTextField(); // MODIFIE PAR SARAH
			
			frontTitle.setText(PANEL_NAME);
			
			reelTimeClock.setText("Today is : " + currentDate);
			reelTimeClock.setBounds(TIME_X, TIME_Y, TIME_W, TIME_H);
			roundTime.setText("Let's say : " + lastQuarter);
		    roundTime.setBounds(ROUNDED_TIME_X,ROUNDED_TIME_Y,ROUNDED_TIME_W,ROUNDED_TIME_H);
			
			sizeTitle = frontTitle.getPreferredSize();
			frontTitle.setBounds(FRONT_TITLE_X, FRONT_TITLE_Y, sizeTitle.width, sizeTitle.height);
			
			sizeIDLabel = IDLabel.getPreferredSize();
	        IDLabel.setBounds(ID_LABEL_X, ID_LABEL_Y, sizeIDLabel.width, sizeIDLabel.height);
	        IDField.setBounds(ID_FIELD_X, ID_FIELD_Y, ID_FIELD_W, ID_FIELD_H);
	       
			// Add previous element to panel
			frame.add(startButton);
			panel.add(IDLabel);
			panel.add(IDField);
			panel.add(reelTimeClock);
			panel.add(roundTime);
			panel.add(frontTitle);
			frame.setVisible(true);
				
		}

		/* ================================================================= */
		/********************** GETTERS AND SETTERS **************************/
		/*********************************************************************/
		/**
		 *
		 */
		@Override
		public String toString() 
		{
			return "ViewEmulator [checks=" + checks + "]";
		}
		
		/**
		 * @return the date
		 */
		public static LocalDate getDate() {
			return date;
		}

		/**
		 * @param date the date to set
		 */
		public static void setDate(LocalDate date) {
			ViewEmulator.date = date;
		}

		/**
		 * @return the checks
		 */
		public static CheckInOut getChecks() {
			return checks;
		}

		/**
		 * @param checks the checks to set
		 */
		public static void setChecks(CheckInOut checks) {
			ViewEmulator.checks = checks;
		}

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

		/*********************************************************************/
		/*********************************************************************/
		/* ================================================================= */
		
		
		
		public static void main(String[] args) //MODIFIE PAR SARAH
		{	
			new Emulator();
			new ViewEmulator();
			//new Thread(new TCPServerMainApp()).start(); 
		}
		
		
		@Override
		public void actionPerformed(ActionEvent event) { //AJOUTE PAR SARAH
		//TODO a mettre dans un controlleur afin de vérifier l'existence de l'employé, 
		// sauvegarder le check dans le fichier texte backupEmulator si ne peut être envoyé à l'application main
			Object source = event.getSource();
			 
			if (source == startButton) {
				CheckInOut checkInOutToSend = new CheckInOut(Integer.parseInt(IDField.getText()), LocalDateTime.now(), true );
				new Thread(new TCPClientEmulator(checkInOutToSend)).start();
			}
			
		}
		
	}
