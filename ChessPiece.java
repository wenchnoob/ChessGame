package com.chessgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class ChessPiece extends GameObject implements Operations {

	protected Faction faction;
	protected boolean moveable;
	protected boolean selected = false;
	protected int moveCount = 0;
	protected int orientation;
	protected ArrayList<GridSquare> possibleMoves = new ArrayList<GridSquare>();
	protected ArrayList<GridSquare> directedMoves = new ArrayList<GridSquare>();
	
	public ChessPiece(int x, int y, ID id, Color color, Faction faction) {
		super(x, y, id, color);
		this.faction = faction;
		this.blocked = false;
	}
	
	public boolean collision(GameObject object) {
		if(this.x == object.getX() && this.y == object.getY()) {
			return true;
		}
		return false;
	}
	
	protected void make(Color color, Graphics g, String name) {
		if(color == Color.WHITE) {
			g.setColor(Color.WHITE);
			g.fillOval(x, y, 60, 60);
			g.setColor(new Color(0, 119, 204));
			g.drawOval(x, y, 60, 60);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(name, x + 25, y + 40);
			clamp(this);
		} else {
			g.setColor(Color.BLACK);
			g.fillOval(x, y, 60, 60);
			g.setColor(new Color(0, 119, 204));
			g.drawOval(x, y, 60, 60);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(name, x + 25, y + 40);
			clamp(this);
		}
	}
	
	protected void makeSelected(Graphics g, String name){
		g.setColor(new Color(125, 125, 125));
		g.fillOval(x, y, 60, 60);
		g.setColor(Color.YELLOW);
		g.drawOval(x, y, 60, 60);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(name, x + 25, y + 40);
		clamp(this);
	}
	
	protected int xMag(GridSquare square) {
		return (square.getX() - this.x)/60;
	}
	
	protected int yMag(GridSquare square) {
		return (square.getY() - this.y)/60;
	}
	
	protected void calculateMags() {
		Handler.objects.forEach(i -> {
			i.setXMag(xMag(i));
			i.setYMag(yMag(i));
		});
	}
	
	
	public void clamp(GameObject object) {
		Game.clamp(object);
	}
	
	private int determineOrientation(GridSquare move) {
		int xMag = xMag(move); int yMag = yMag(move);
		int magValue = move.getMagValue();
		
		if(xMag == 0 && yMag != Math.abs(yMag)) return 0;
		if(magValue == 0 && yMag != Math.abs(yMag)) return 45;
		if(yMag == 0 && xMag == Math.abs(xMag)) return 90;
		if(yMag == xMag && xMag == Math.abs(xMag)) return 135;
		if(xMag == 0 && yMag == Math.abs(yMag)) return 180;
		if(magValue == 0 && yMag == Math.abs(yMag)) return 225;
		if(yMag == 0 && xMag != Math.abs(xMag)) return 270;
		if(yMag == xMag && xMag != Math.abs(xMag)) return 315;
		
		return 0;
	}
	
	public void findDirectedPath(GridSquare move) {
		directedMoves.clear();
		int orientation = determineOrientation(move);
		possibleMoves.forEach(i -> {
			if(orientation == determineOrientation(i)) directedMoves.add(i);
		});
		
	}
	
	
	public String toString(){
		return super.toString();
		
	}
	
	public boolean isMoveable() {return moveable;}
	public void setMoveable(boolean moveable) {this.moveable = moveable;}
	public Faction getFaction() {return faction;}
	public void setSelected(boolean selected) {this.selected = selected;}
	public boolean isSelected() {return selected;}
	public void setMoveCount(int moveCount) {this.moveCount = moveCount;}
	public int getMoveCount() {return moveCount;}
	public ArrayList<GridSquare> getPossibleMoves() {return possibleMoves;}
	public ArrayList<GridSquare> getDirectedMoves() {return directedMoves;}
}
