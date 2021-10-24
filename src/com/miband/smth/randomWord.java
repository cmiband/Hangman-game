package com.miband.smth;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;

public class randomWord {
	private File file;
	private BufferedReader reader;
	private String[] words;
	
	public randomWord(String fileName) throws IOException {
		file = new File(fileName);
		words = new String[50];
		reader = new BufferedReader(new FileReader(file));
		
		for(int i = 0; i < 50; i++) {
			words[i] = reader.readLine();
		}
		reader.close();
	}
	
	public String getRandomWord() {	
		Random rand = new Random();
		int x = rand.nextInt(50);
		
		String random = words[x];
		
		return random;
	}
}
