package com.miband.smth;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.io.IOException;
import java.awt.FlowLayout;
import java.util.*;
import javax.swing.JButton;

import javax.swing.JLabel;

public class MyFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private randomWord randomizer;
	private JPanel game;
	private JPanel image;
	private JLabel answer;
	private JLabel word;
	private JLabel winScreen;
	private JLabel loseScreen;
	private JLabel usedChars;
	private JLabel missesLabel;
	private String randomWord;
	private String hiddenWord;
	private String usedCharsString;
	private JPanel[] images;
	private int misses;
	private int timesPrinted;
	
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
		
		images = new JPanel[8];
		for(int i = 0; i<8; i++) {
			String fn = "hangman"+i+".png";
			JPanel j = new MyImage(fn);
			images[i] = j;
		}
		
		setBackground(Color.white);
		setResizable(false);
		setVisible(true);
		requestFocus();
		
		setLayout(new FlowLayout());
		gameStart();
	}
	
	private void gameStart() {
		game = new JPanel();
		answer = new JLabel("Word: ");
		image = images[0];
		word = new JLabel("");
		misses = 0;
		
		randomWord = randomizer.getRandomWord();
		hiddenWord = hide(randomWord);
		System.out.println(randomWord);
		word = new JLabel(hiddenWord);
		usedCharsString = "";
		usedChars = new JLabel(usedCharsString);
		timesPrinted = 0;
		missesLabel = new JLabel("Misses : " +misses);
			
		game.add(answer);
		game.add(word);
		game.add(usedChars);
		game.add(missesLabel);
		game.add(image);
		this.add(game);
	}
	
	String hide(String word) {
		String hidden = "";
		for(int i = 0; i<word.length(); i++) {
			hidden += "*";
		}
		return hidden;
	}
	
	String UnhideCharacter(char c, String word, String hidden) {		
		String r = "";
		for(int i = 0; i<word.length(); i++) {
			if(c == word.charAt(i)) {
				r+=c;
			}
			else if(hidden.charAt(i) != '*') {
				r += word.charAt(i);
			}
			else {
				r += '*';
			}
		}
		return r;
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
	
	boolean win(String word) {
		for(int i = 0; i<word.length(); i++) {
			if(word.charAt(i) == '*') {
				return false;
			}
		}
		return true;
	}
	
	boolean lose() {
		if(misses >= 7)
			return true;
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		System.out.println(c);
		boolean inWord = isInWord(c, randomWord);
		if(inWord) {
			String uc = UnhideCharacter(c, randomWord, hiddenWord);
			hiddenWord = uc;
			System.out.println(hiddenWord);
			word.setText(hiddenWord);
			if(win(uc)) {
				winScreen = new JLabel("You won!");
				this.add(winScreen);
			}
		}
		else {
			if(!lose()) {
				misses++;
				usedCharsString += c + ", ";
				usedChars.setText(usedCharsString);
				missesLabel.setText("Misses : " +misses);
				game.remove(image);
				image = images[misses];
				game.add(image);
				
			}
			if(lose() && timesPrinted == 0) {
				loseScreen = new JLabel("You lose!");
				this.add(loseScreen);
				timesPrinted++;
			}
			System.out.println(misses);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}	
