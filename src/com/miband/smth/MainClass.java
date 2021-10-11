package com.miband.smth;

import javax.swing.*;

public class MainClass {	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		
		JButton button = new JButton("Button");
		button.setBounds(200,250,100,100);
		
		frame.add(button);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
