package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class Queen extends ChessPiece {
	
	public Queen(int x, int y, ID id, Faction faction) {
		super(x, y, id, null, faction);
	}

	public void render(Graphics g) {
		if(selected) {
			makeSelected(g, "Q");
			return;
		}
		
		if(faction == Faction.WHITE) {
			make(Color.white, g, "Q");
		} else {
			make(Color.black, g, "Q");
		}
	}

	public void possibleMoves() {
		possibleMoves.clear();
		calculateMags();
		makeRowAndColumn();
		findDiagonals();
	}
	
	public void makeRowAndColumn() {
		Handler.objects.forEach(i -> {
			if(i.getXMag() == 0 || i.getYMag() == 0) possibleMoves.add(i);
		});
	}
	
	public void findDiagonals() {
		Handler.objects.forEach(i -> {
			if(i.getYMag() - i.getXMag() == 0 || i.getYMag() + i.getXMag() == 0) possibleMoves.add(i);
				
		});
	}
}
