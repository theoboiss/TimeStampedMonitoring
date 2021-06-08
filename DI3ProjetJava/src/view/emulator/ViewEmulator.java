package view.emulator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.util.concurrent.CopyOnWriteArrayList;
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
		private static final int BUTTON_LOCATION_X = 330;  		// location x 
		private static final int BUTTON_LOCATION_Y = 208;   	// location y 
		private static final int BUTTON_SIZE_X = 150;      		// size height
		private static final int BUTTON_SIZE_Y = 50;       		// size width
		private static CheckInOut checks;
		private static EventDuringCheck event;
		private static LocalDate date;
		private JButton startButton; // MODIFIE PAR SARAH
		private JTextField IDField; // MODIFIE PAR SARAH
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
			/*
			String imagePath = "view/images/JavaIcons/javatech.png";
			//ImageIcon icon = new ImageIcon(imagePath);
			//JLabel logo = new JLabel(icon, JLabel.CENTER);
			JLabel img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imagePath)));
			Dimension sizeImg = img.getPreferredSize();
			img.setBounds(10, -200, sizeImg.width-250, sizeImg.height+50);
		    window.add(img);*/
			
	        
	        
	        
			// Panel configuration
	        window.setTitle("JavaTech™ V.1.0");
	        panel.setName("Time Tracker Emulator");
			window.setSize(500, 300);
			window.setLocationRelativeTo(null);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			panel.setLayout(null);
			
			// Check in/out button
			startButton = new JButton("Check in/out"); //MODIFIE PAR SARAH
	        startButton.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y );
	        startButton.addActionListener(this); //MODIFIE PAR SARAH
	        
	        // Clock and other fields
			JLabel reelTimeClock = new JLabel();
			JLabel frontTitle = new JLabel();
			JLabel IDLabel = new JLabel("Employee ID");
			IDField = new JTextField(); // MODIFIE PAR SARAH
			Date currentDate = new Date();
			date = LocalDate.now();
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
		 * @param checks
		 */
		public ViewEmulator(CheckInOut checks) 
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
		public static CheckInOut getChecks() 
		{
			return checks;
		}

		/**
		 * @param checks the checks to set
		 */
		public void setChecks(CheckInOut checks) 
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
		
		
		
		public static void main(String[] args) //MODIFIE PAR SARAH
		{	
			//new Emulator();
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
