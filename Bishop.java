package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class Bishop extends ChessPiece {
	
	public Bishop(int x, int y, ID id, Faction faction) {
		super(x, y, id, null, faction);
	}

	public void render(Graphics g) {
		if(selected) {
			makeSelected(g, "B");
			return;
		}
		
		if(faction == Faction.WHITE) {
			make(Color.white, g, "B");
		} else {
			make(Color.black, g, "B");
		}
	}

	public void possibleMoves() {
		possibleMoves.clear();
		calculateMags();
		findDiagonals();
		
	}
	
	public void findDiagonals() {
		Handler.objects.forEach(i -> {
			if(i.getYMag() - i.getXMag() == 0 || i.getYMag() + i.getXMag() == 0) possibleMoves.add(i);
				
		});
	}
}
