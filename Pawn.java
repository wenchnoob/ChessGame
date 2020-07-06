package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class Pawn extends ChessPiece {
	
	public Pawn(int x, int y, ID id, Faction faction) {
		super(x, y, id, null, faction);
		
		if(faction == Faction.WHITE) {
			orientation = -1;
		} else {
			orientation = 1;
		}
	}

	public void render(Graphics g) {
		if(selected) {
			makeSelected(g, "P");
			return;
		}
		
		if(faction == Faction.WHITE) {
			make(Color.white, g, "P");
		} else {
			make(Color.black, g, "P");
		}
	}
	
	public void possibleMoves() {
		possibleMoves.clear();
		calculateMags();
		
		if(moveCount == 0) firstMoves();
		
		Handler.objects.forEach(i -> {
			if(i.getYMag() == 1 * orientation  && i.getXMag() == 0 && !i.contains()) possibleMoves.add(i);
		});
		captures();
	}
	
	public void firstMoves() {
		Handler.objects.forEach(i -> {
			if((i.getYMag() == 1 * orientation || i.getYMag() == 2 * orientation) && i.getXMag() == 0) possibleMoves.add(i);
		});
	}
	private void captures() {
		Handler.objects.forEach(i -> {
			if(i.getYMag() == 1 * orientation  && Math.abs(i.getXMag()) == 1)
				if(i.contains())
					if(i.getContains().getFaction() != faction) possibleMoves.add(i);
		});
	}
}
