package com.chessgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Bishop extends ChessPiece {
	
	public Bishop(int x, int y, ID id, Faction faction) {
		super(x, y, id, null, faction);
	}

	public void render(Graphics g) {
		if(selected) {
			if(faction == Faction.WHITE) {
				g.setColor(Color.WHITE);
				g.fillOval(x, y, 60, 60);
				g.setColor(Color.BLUE);
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("B", x + 25, y + 40);
				super.clamp(this);
			}
			
			if(faction == Faction.BLACK) {
				g.setColor(Color.BLACK);
				g.fillOval(x, y, 60, 60);
				g.setColor(Color.BLUE);
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("B", x + 25, y + 40);
				super.clamp(this);
			}
		} else {
			if(faction == Faction.WHITE) {
				g.setColor(Color.WHITE);
				g.fillOval(x, y, 60, 60);
				g.setColor(new Color(0, 119, 204));
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("B", x + 25, y + 40);
				super.clamp(this);
			}
			
			if(faction == Faction.BLACK) {
				g.setColor(Color.BLACK);
				g.fillOval(x, y, 60, 60);
				g.setColor(new Color(0, 119, 204));
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("B", x + 25, y + 40);
				super.clamp(this);
			}
		}
		
	}

	@Override
	public GridSquare[] possibleMoves() {
		ArrayList<GridSquare> moves = new ArrayList<GridSquare>();
		
		for(int i = 0; i < Handler.objects.size(); i++) {					
			if(Math.abs((Handler.objects.get(i).getY() - y ) / 60) == Math.abs((Handler.objects.get(i).getX() - x ) / 60)) {
				moves.add((GridSquare) Handler.objects.get(i));
			}
		}
		
		GridSquare[] possibleMoves = new GridSquare[moves.size()];
		return moves.toArray(possibleMoves);
	}

	@Override
	public GridSquare[] possibleCaptures() {
		// TODO Auto-generated method stub
		return null;
	}
}
