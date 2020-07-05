package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class Rook extends ChessPiece {
	
	public Rook(int x, int y, ID id, Faction faction) {
		super(x, y, id, null, faction);
	}

	public void render(Graphics g) {
		if(selected) {
			makeSelected(g, "R");
			return;
		}
		
		if(faction == Faction.WHITE) {
			make(Color.white, g, "R");
		} else {
			make(Color.black, g, "R");
		}
	}

	public void possibleMoves() {
		possibleMoves.clear();
		calculateMags();
		makeRowAndColumn();
	}
	
	public void makeRowAndColumn() {
		Handler.objects.forEach(i -> {
			if(i.getXMag() == 0 || i.getYMag() == 0) possibleMoves.add(i);
		});
	}
}
