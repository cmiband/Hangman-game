package com.miband.smth;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;

public class MyFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private String fileName = "hangman0.png";
	private randomWord randomizer;
	private JPanel game;
	private JPanel image;
	private JLabel answer;
	private JLabel word;
	
	public MyFrame() {
		super("Hangman");
		try {
			randomizer = new randomWord("words.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
		setBackground(Color.white);
		setResizable(false);
		setVisible(true);
		
		gameLoop();
	}
	
	private void gameLoop() {
		game = new JPanel();
		answer = new JLabel("Word: ");
		image = new MyImage("hangman0.png");
		word = new JLabel("");
		
		String randomWord = randomizer.getRandomWord();
		word = new JLabel(randomWord);
			
		game.add(image);
		game.add(answer);
		game.add(word);
		this.add(game);
	}
}	
