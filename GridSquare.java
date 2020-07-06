package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class GridSquare extends GameObject {
	
	private Color color;
	private ChessPiece contains;
	private int xMag;
	private int yMag;
	int magValue;
	
	public GridSquare() {
		super();
	}
	
	public GridSquare(int x, int y, ID id, Color color) {
		super(x, y, id, color);
		this.color = color;
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 60, 60);
	}
	
	public boolean equals(GridSquare square) {
		if(this.getX() == square.getX() && this.getY() == square.getY()) return true;
		return false;
	}
	
	public void setXMag(int xMag) {
		this.xMag = xMag;
	} 
	
	public void setYMag(int yMag) {
		this.yMag = yMag;
	}
	
	public void setContains() {
		for(int i = 0; i < Handler.pieces.size(); i++) {
			if(GameObject.comparePos(this, Handler.pieces.get(i))) {
				this.contains = Handler.pieces.get(i);
				break;
			} else {
				this.contains = null;
			}
		}
	}
	
	public int getXMag () {
		return xMag;
	}
	
	public int getYMag() {
		return yMag;
	}
	
	public int getMagValue() {
		return xMag + yMag;
	}
	
	public ChessPiece getContains() {
		return contains;
	}
	
	public boolean contains() {
		if(this.contains != null){
			return true;
		}
		return false;
	}
	
	public String toString(){
		String string = super.toString();
		
		if(contains()) {
			string += ("\t Contains: " + getContains().toString());
		}
		return string;
	}
}
