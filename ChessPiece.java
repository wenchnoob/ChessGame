package com.chessgame.main;

import java.awt.Color;

public abstract class ChessPiece extends GameObject implements Operations {

	protected Faction faction;
	protected boolean moveable;
	protected boolean selected = false;
	protected int moveCount = 0;
	protected GridSquare[] possibleMoves;
	
	public ChessPiece(int x, int y, ID id, Color color, Faction faction) {
		super(x, y, id, color);
		this.faction = faction;
	}
	
	public boolean collision(GameObject object) {
		if(this.x == object.getX() && this.y == object.getY()) {
			return true;
		}
		return false;
	}
	
	public void clamp(GameObject object) {
		Game.clamp(object);
	}
	
	public boolean isMoveable() {
		return moveable;
	}
	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
	public Faction getFaction() {
		return faction;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	public int getMoveCount() {
		return moveCount;
	}
	public GridSquare[] getPossibleMoves() {
		return possibleMoves;
	}
	
	protected void setContains(ChessPiece contains) {}
	protected ChessPiece getContains() {return null;}

}
