package com.chessgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class Board extends GameObject {
	
	
	public Board(int x, int y, ID id, Handler handler) {
		super(x, y, id, null);
		
		for(int i = 1 ; i < 9; i++) {
			
			if(i == 1) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A1,  Color.BLACK));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C1,  Color.BLACK));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E1,  Color.BLACK));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G1,  Color.BLACK));
			}
			if(i == 2) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.B2,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.D2,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.F2,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.H2,  Color.BLACK));
			}

			if(i == 3) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A3,  Color.BLACK));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C3,  Color.BLACK));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E3,  Color.BLACK));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G3,  Color.BLACK));
			}
			if(i == 4) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.B4,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.D4,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.F4,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.H4,  Color.BLACK));
			}

			if(i == 5) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A5,  Color.BLACK));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C5,  Color.BLACK));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E5,  Color.BLACK));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G5,  Color.BLACK));
			}
			if(i == 6) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.B6,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.D6,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.F6,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.H6,  Color.BLACK));
			}

			if(i == 7) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A7,  Color.BLACK));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C7,  Color.BLACK));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E7,  Color.BLACK));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G7,  Color.BLACK));
			}
			if(i == 8) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.A8,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.C8,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.E8,  Color.BLACK));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.G8,  Color.BLACK));
			}
			
		}
		for(int i = 1 ; i < 9; i++) {
			
			if(i == 1) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.B1,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.D1,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.F1,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.H1,  Color.WHITE));
			}
			if(i == 2) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A2,  Color.WHITE));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C2,  Color.WHITE));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E2,  Color.WHITE));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G2,  Color.WHITE));
			}
			if(i == 3) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.B3,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.D3,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.F3,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.H3,  Color.WHITE));
			}
			if(i == 4) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A4,  Color.WHITE));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C4,  Color.WHITE));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E4,  Color.WHITE));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G4,  Color.WHITE));
			}
			if(i == 5) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.B5,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.D5,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.F5,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.H5,  Color.WHITE));
			}
			if(i == 6) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A6,  Color.WHITE));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C6,  Color.WHITE));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E6,  Color.WHITE));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G6,  Color.WHITE));
			}
			if(i == 7) {
				handler.addObject(new GridSquare((x + 60), y - 60 * i, ID.B7,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 120, y - 60 * i, ID.D7,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 240, y - 60 * i, ID.F7,  Color.WHITE));
				handler.addObject(new GridSquare((x + 60) + 360, y - 60 * i, ID.H7,  Color.WHITE));
			}
			if(i == 8) {
				handler.addObject(new GridSquare(x, y - 60 * i, ID.A8,  Color.WHITE));
				handler.addObject(new GridSquare(x + 120, y - 60 * i, ID.C8,  Color.WHITE));
				handler.addObject(new GridSquare(x + 240, y - 60 * i, ID.E8,  Color.WHITE));
				handler.addObject(new GridSquare(x + 360, y - 60 * i, ID.G8,  Color.WHITE));
			}
		}
		
		
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 60, 60);
	}

	@Override
	protected void setContains(ChessPiece chessPiece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ChessPiece getContains() {
		// TODO Auto-generated method stub
		return null;
	}
}
