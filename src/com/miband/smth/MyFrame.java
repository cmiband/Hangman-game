package com.miband.smth;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.io.IOException;
import java.awt.FlowLayout;
import java.util.*;

import javax.swing.JLabel;

public class MyFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private String fileName = "hangman0.png";
	private randomWord randomizer;
	private JPanel game;
	private JPanel image;
	private JLabel answer;
	private JLabel word;
	private String randomWord;
	
	public MyFrame() {
		super("Hangman");
		try {
			randomizer = new randomWord("words.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		addKeyListener(this);
		
		setBackground(Color.white);
		setResizable(false);
		setVisible(true);
		
		setLayout(new FlowLayout());
		gameStart();
	}
	
	private void gameStart() {
		game = new JPanel();
		answer = new JLabel("Word: ");
		image = new MyImage(fileName);
		word = new JLabel("");
		
		randomWord = randomizer.getRandomWord();
		String hiddenWord = hide(randomWord);
		word = new JLabel(hiddenWord);
			
		game.add(image);
		game.add(answer);
		game.add(word);
		this.add(game);
	}
	
	String hide(String word) {
		String hidden = "";
		for(int i = 0; i<word.length(); i++) {
			hidden += "*";
		}
		return hidden;
	}
	
	void unHideCharacter(char c, String word, String hiddenWord) {
		char[] signs = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			signs[i] = word.charAt(i);
		}
		
		for(int i = 0; i<word.length(); i++) {
			if(c == signs[i]) {
				
			}
		}
	}
	
	boolean isInWord(char c, String word) {
		char[] signs = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			signs[i] = word.charAt(i);
		}
		
		for(int i = 0; i<word.length(); i++) {
			if(c == signs[i]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		boolean inWord = isInWord(c, randomWord);
		if(inWord) {
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}	
