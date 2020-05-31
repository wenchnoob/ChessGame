package com.chessgame.main;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {
	
	static LinkedList <GameObject> objects = new LinkedList<GameObject>();
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
	
	public void addObject(GameObject object) {
		Handler.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		Handler.objects.remove(object);
	}
	
	public void addObject(ChessPiece piece) {
		Handler.pieces.add(piece);
	}
	
	public void removeObject(ChessPiece piece) {
		Handler.pieces.remove(piece);
	}
	
}
