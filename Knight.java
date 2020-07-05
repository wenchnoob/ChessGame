package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;
public class Knight extends ChessPiece {
	
	public Knight(int x, int y, ID id, Faction faction) {
		super(x, y, id, null, faction);
	}

	public void render(Graphics g) {
		if(selected) {
			makeSelected(g, "Kn");
			return;
		}
		
		if(faction == Faction.WHITE) {
			make(Color.white, g, "Kn");
		} else {
			make(Color.black, g, "Kn");
		}
	}
	
	public void possibleMoves() {
		possibleMoves.clear();
		calculateMags();
		findL(1,2);
		findL(2,1);
	}
	
	public void findL(int xMag, int yMag) {
		Handler.objects.forEach(i -> {
			if(Math.abs(i.getXMag()) == xMag  && Math.abs(i.getYMag()) == yMag)
				if(i.contains()) {
					if(i.getContains().getFaction() != faction) possibleMoves.add(i);
				}else{
					possibleMoves.add(i);
				}
		});
	}
}
