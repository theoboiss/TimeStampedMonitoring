package controller.shared;


import controller.emulator.Emulator;
import controller.mainapp.Mainapp;


public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Shared controller\n");
		new Mainapp("backupMainapp/serializedData.ser");	
		new Emulator();
		
		new Thread(new TCPServerMainAppHello()).start(); 
		new Thread(new TCPClientMainAppHello()).start();
		
		new Thread(new TCPServerEmulatorHello()).start(); 
		new Thread(new TCPClientEmulatorHello()).start();
	}
}
