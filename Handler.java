package com.chessgame.main;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {
	
	static LinkedList <GridSquare> objects = new LinkedList<GridSquare>();
	static LinkedList <ChessPiece> pieces = new LinkedList<ChessPiece>();
	
	public Handler() {}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject tempObject = objects.get(i);
			tempObject.render(g);
		}
		for(int i = 0; i < pieces.size(); i++) {
			GameObject tempObject = pieces.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GridSquare object) {
		Handler.objects.add(object);
	}
	
	public void removeObject(GridSquare object) {
		Handler.objects.remove(object);
	}
	
	public void addObject(ChessPiece piece) {
		Handler.pieces.add(piece);
	}
	
	public void removeObject(ChessPiece piece) {
		Handler.pieces.remove(piece);
	}
	
	public void sortObjects() {
		for(int i = 0; i < objects.size() - 1; i++) {
			for(int j = 0; j < objects.size() - 1; j++) {
				if(objects.get(j).compareTo(objects.get(j+1)) == -1) {
					GridSquare temp = objects.get(j+1);
					objects.set((j+1), objects.get(j));
					objects.set((j+1), temp);
				}
			}
		}
		
	}
	
	public void sortPieces() {}
	
}
