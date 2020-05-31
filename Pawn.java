package com.chessgame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Pawn extends ChessPiece {
	
	public Pawn(int x, int y, ID id, Faction faction) {
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
				g.drawString("P", x + 25, y + 40);
				super.clamp(this);
			}
			
			if(faction == Faction.BLACK) {
				g.setColor(Color.BLACK);
				g.fillOval(x, y, 60, 60);
				g.setColor(Color.BLUE);
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("P", x + 25, y + 40);
				super.clamp(this);
			}
		} else {
			if(faction == Faction.WHITE) {
				g.setColor(Color.WHITE);
				g.fillOval(x, y, 60, 60);
				g.setColor(new Color(0, 119, 204));
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("P", x + 25, y + 40);
				super.clamp(this);
			}
			
			if(faction == Faction.BLACK) {
				g.setColor(Color.BLACK);
				g.fillOval(x, y, 60, 60);
				g.setColor(new Color(0, 119, 204));
				g.drawOval(x, y, 60, 60);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("P", x + 25, y + 40);
				super.clamp(this);
			}
		}
	}

	
	public GridSquare[] possibleMoves() {
		ArrayList<GridSquare> moves = new ArrayList<GridSquare>();
		
		if(faction == Faction.WHITE) {
			if(moveCount == 0) {
				for(int i = 0; i < Handler.objects.size(); i++) {
					if(Handler.objects.get(i).getY() + 60 == y &&
							Handler.objects.get(i).getX() == x) {
						moves.add((GridSquare) Handler.objects.get(i));
					} else if(Handler.objects.get(i).getY() + 120 == y &&
							Handler.objects.get(i).getX() == x) {
						moves.add((GridSquare) Handler.objects.get(i));
					}
				}
			} else {
				for(int i = 0; i < Handler.objects.size(); i++) {
					if(Handler.objects.get(i).getY() + 60 == y &&
							Handler.objects.get(i).getX() == x) {
						moves.add((GridSquare) Handler.objects.get(i));
					}
				}
			}
		}
		
		if(faction == Faction.BLACK) {
			if(moveCount == 0) {
				for(int i = 0; i < Handler.objects.size(); i++) {
					if(Handler.objects.get(i).getY() - 60 == y &&
							Handler.objects.get(i).getX() == x) {
						moves.add((GridSquare) Handler.objects.get(i));
					} else if(Handler.objects.get(i).getY() - 120 == y &&
							Handler.objects.get(i).getX() == x) {
						moves.add((GridSquare) Handler.objects.get(i));
					}
				}
			} else {
				for(int i = 0; i < Handler.objects.size(); i++) {
					if(Handler.objects.get(i).getY() - 60 == y &&
							Handler.objects.get(i).getX() == x) {
						moves.add((GridSquare) Handler.objects.get(i));
					}
				}
			}
		}
		
		GridSquare[] possibleMoves = new GridSquare[moves.size()];
		return moves.toArray(possibleMoves);
	}

	
	public GridSquare[] possibleCaptures() {
		return null;
	}

}
