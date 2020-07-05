package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject implements Comparable<GameObject>{

	protected int x, y;
	protected ID id;
	protected Color color;
	protected boolean blocked;
	
	public GameObject() {
		this.x = Integer.MAX_VALUE;
		this.y = Integer.MAX_VALUE;
	}
	
	public GameObject(int x, int y, ID id, Color color) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.color = color;
	}
	
	public abstract void render(Graphics g);
	
	public static boolean comparePos(GameObject obj1, GameObject obj2) {
		if(obj1.getX() == obj2.getX() && obj1.getY() == obj2.getY())
			return true;	
		return false;
	}
	
	@Override
	public int compareTo(GameObject o) {
		boolean xIsSmaller = false;
		boolean yIsSmaller = false;
		boolean xIsSame = false;
		boolean yIsSame = false;
		
		if(x < o.getX()) xIsSmaller = true;
		if(y < o.getY()) yIsSmaller = true;
		if(x == o.getX()) xIsSame = true;
		if(y == o.getY()) yIsSame = true;
		
		if(xIsSame)
			if(yIsSmaller) {return -1;} else {return 1;}
		if(yIsSame)
			if(xIsSmaller) {return -1;} else {return 1;}
		
		if(xIsSmaller && yIsSmaller) return -1;
		if(!xIsSmaller && yIsSmaller) return -1;
		
		if(xIsSmaller && !yIsSmaller) return 1;
		if(!xIsSmaller && !yIsSmaller) return 1;
		
		return 0;
	}
	
	public String toString(){
		String string = "ID: " + id.toString() + "\t X: " + x + "\t Y: " + y;
		return string;
	}
	
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	public void setId(ID id) {this.id = id;}
	public ID getId() {return id;}
	public void setBlocked(boolean blocked) {this.blocked = blocked;}
	public boolean getBlocked() {return blocked;}
}
