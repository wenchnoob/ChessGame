package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject{

	protected int x;
	protected int y;
	
	protected ID id;
	protected Color color;
	
	public GameObject(int x, int y, ID id, Color color) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.color = color;
	}
	
	public abstract void render(Graphics g);
	protected abstract void setContains(ChessPiece chessPiece);
	protected abstract ChessPiece getContains();
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public String toString() {
		return this.id + " X: " + this.x + " Y: " + this.y;
	}
	
	
	
}
