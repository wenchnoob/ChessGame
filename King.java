package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class King extends ChessPiece {
	
	public King(int x, int y, ID id, Faction faction) {
		super(x, y, id, null, faction);
	}

	public void render(Graphics g) {
		if(selected) {
			makeSelected(g, "K");
			return;
		}
		
		if(faction == Faction.WHITE) {
			make(Color.white, g, "K");
		} else {
			make(Color.black, g, "K");
		}
		
	}

	public void possibleMoves() {
		possibleMoves.clear();
		calculateMags();
		Handler.objects.forEach(i -> {
			if(-1 <= i.getYMag() && i.getYMag() <= 1) 
				if(-1 <= i.getXMag() && i.getXMag() <= 1)
					if(!i.contains())possibleMoves.add(i);
		});
	}
}
