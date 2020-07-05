package com.chessgame.main;

import java.io.FileWriter;
import java.io.IOException;

public class Util {
	
	public Util() throws IOException {
		printBoard();
	}
	
	public void printBoard() throws IOException {
		String toWrite = "";
		
		for(GameObject obj: Handler.objects) {
			toWrite += obj.toString() + "\n";
		}
		
		writeToFile(toWrite);
	}
	
	public void writeToFile(String fileContent) throws IOException {
		FileWriter writer = new FileWriter("/Users/Student/Desktop/debug.txt");
		writer.write(fileContent);
		writer.close();
	}
	
}