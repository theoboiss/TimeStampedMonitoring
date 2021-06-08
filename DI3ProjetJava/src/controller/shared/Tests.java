package controller.shared;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import controller.emulator.Emulator;
import controller.mainapp.Mainapp;


public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Shared controller\n");
		Mainapp.main(null);	
		new Emulator();
		
		new Thread(new TCPServerMainApp()).start(); 
		//new Thread(new TCPClientMainApp()).start();
		
		//new Thread(new TCPServerEmulator()).start();	
		//new Thread(new TCPClientEmulator()).start();
	}
}
