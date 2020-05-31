package com.chessgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Knight extends ChessPiece {
	
	public Knight(int x, int y, ID id, Faction faction) {
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
				g.drawString("Kn", x + 20, y + 40);
				super.clamp(this);
			}
			
			if(faction == Faction.BLACK) {
				g.setColor(Color.BLACK);
				g.fillOval(x, y, 60, 60);
				g.setColor(Color.BLUE);
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("Kn", x + 20, y + 40);
				super.clamp(this);
			}
		} else {
			if(faction == Faction.WHITE) {
				g.setColor(Color.WHITE);
				g.fillOval(x, y, 60, 60);
				g.setColor(new Color(0, 119, 204));
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("Kn", x + 20, y + 40);
				super.clamp(this);
			}
			
			if(faction == Faction.BLACK) {
				g.setColor(Color.BLACK);
				g.fillOval(x, y, 60, 60);
				g.setColor(new Color(0, 119, 204));
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("Kn", x + 20, y + 40);
				super.clamp(this);
			}
		}
		
	}
	
	public GridSquare[] possibleMoves() {
		 ArrayList<GridSquare> moves = new ArrayList<GridSquare>();
		
		for(int i = 0; i < Handler.objects.size(); i++) {					
			if(Handler.objects.get(i).getY() + 120 == y &&
					Handler.objects.get(i).getX() - 60 == x) {
				moves.add((GridSquare) Handler.objects.get(i));
			} else if(Handler.objects.get(i).getY() + 120 == y &&
					Handler.objects.get(i).getX() + 60 == x) {
				moves.add((GridSquare) Handler.objects.get(i));
			}
			if(Handler.objects.get(i).getY() - 120 == y &&
					Handler.objects.get(i).getX() - 60 == x) {
				moves.add((GridSquare) Handler.objects.get(i));
			} else if(Handler.objects.get(i).getY() - 120 == y &&
					Handler.objects.get(i).getX() + 60 == x) {
				moves.add((GridSquare) Handler.objects.get(i));
			}
			if(Handler.objects.get(i).getX() + 120 == x &&
					Handler.objects.get(i).getY() - 60 == y) {
				moves.add((GridSquare) Handler.objects.get(i));
			} else if(Handler.objects.get(i).getX() + 120 == x &&
					Handler.objects.get(i).getY() + 60 == y) {
				moves.add((GridSquare) Handler.objects.get(i));
			}
			if(Handler.objects.get(i).getX() - 120 == x &&
					Handler.objects.get(i).getY() - 60 == y) {
				moves.add((GridSquare) Handler.objects.get(i));
			} else if(Handler.objects.get(i).getX() - 120 == x &&
					Handler.objects.get(i).getY() + 60 == y) {
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
