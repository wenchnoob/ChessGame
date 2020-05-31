package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class GridSquare extends GameObject {
	
	private Color color;
	private ChessPiece contains;
	
	public GridSquare(int x, int y, ID id, Color color) {
		super(x, y, id, color);
		this.color = color;
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 60, 60);
	}
	
	public void setContains(ChessPiece contains) {
		this.contains = contains;
	}
	
	public ChessPiece getContains() {
		return contains;
	}
	public String toString() {
		try {
			return this.id + " X: " + this.x + " Y: " + this.y + "\n    " + contains.toString();
		} catch(Exception e) {
			return this.id + " X: " + this.x + " Y: " + this.y;
		}
	}
}
