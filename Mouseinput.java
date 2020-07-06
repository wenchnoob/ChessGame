package com.chessgame.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
		
		private int curX;
		private int curY;
		
		private int nextX;
		private int nextY;
		
		private boolean pieceSelected = false;
		
		private ChessPiece selectedPiece;
		
		private LogicGate logic = new LogicGate();
		
		public MouseInput() {}
		
	@Override
		public void mouseClicked(MouseEvent e) {
			if(!pieceSelected) {
				curX = e.getX();
				curY = e.getY();
				for(int i = 0; i < Handler.pieces.size(); i++) {
					if( withinBounds(curX, curY, Handler.pieces.get(i))) {
						pieceSelected = true;
						selectedPiece = Handler.pieces.get(i);
						Handler.pieces.get(i).setSelected(true);
						break;
					}
				}
				
			} else {
				LogicGate.update();
				selectedPiece.possibleMoves();
				logic.setSelected(selectedPiece);
				if(logic.isMoveable()) {
					GridSquare move = null;
					
					nextX = e.getX();
					nextY = e.getY();
					nextX = clampXToGrid(nextX);
					nextY = clampYToGrid(nextY);
					
					for(int i = 0; i < Handler.objects.size(); i++) {
						if(Handler.objects.get(i).getX() == nextX &&
								Handler.objects.get(i).getY() == nextY) {
							move = (GridSquare) Handler.objects.get(i);
						}
					}
					
					if(logic.isMoveValid(move)) {
						selectedPiece.setMoveCount(selectedPiece.getMoveCount() + 1);
						
						for(int i = 0; i < Handler.pieces.size(); i++) {
							if(Handler.pieces.get(i).isSelected()) {
								Handler.pieces.get(i).setX(nextX);
								Handler.pieces.get(i).setY(nextY);
							}
						}
						
						for(int i = 0; i < Handler.objects.size(); i++) {
							if(Handler.objects.get(i).getX() == nextX &&
									Handler.objects.get(i).getY() == nextY) {
								LogicGate.update();
							}
						}
						
						for(int i = 0; i < Handler.pieces.size(); i++){
							if(Handler.pieces.get(i).isSelected()) {
								continue;
							} else if(selectedPiece.getX() == Handler.pieces.get(i).getX() &&
								selectedPiece.getY() == Handler.pieces.get(i).getY()) {
								Handler.pieces.remove(i);
							}
						}
						Saver.saveMove();
						selectedPiece.setSelected(false);
						pieceSelected = false;
					} else {
						selectedPiece.setSelected(false);
						pieceSelected = false;
					}
					
				} else {
					selectedPiece.setSelected(false);
					pieceSelected = false;
				}
			}
		}
			
		@Override public void mouseReleased(MouseEvent e) {}
		@Override public void mouseEntered(MouseEvent e) {}
		@Override public void mouseExited(MouseEvent e) {} 
		@Override public void mousePressed(MouseEvent e) {}
		
		public boolean withinBounds(int x, int y, GameObject object) {
			if(x >= object.getX() && x <= object.getX() + 60) {
				if(y >= object.getY() && y <= object.getY() + 60) {
					return true;
				}
			}
			return false;
		}
		
		public int clampXToGrid(int x) {
			for(int i = 0; i < Handler.objects.size(); i ++) {
				if(x >= Handler.objects.get(i).getX() && x <= Handler.objects.get(i).getX() + 60) {
					return Handler.objects.get(i).getX();
				} else {}
			}
			return 0;
		}
		public int clampYToGrid(int y) {
			for(int i = 0; i < Handler.objects.size(); i ++) {
				if(y >= Handler.objects.get(i).getY() && y <= Handler.objects.get(i).getY() + 60) {
					return Handler.objects.get(i).getY();
				} else {}
			}
			return 0;
		}
		
		public int getCurX() {return curX;}
		public int getCurY() {return curY;}
		public int getNextX() {return nextX;}
		public int getNextY() {return nextY;}
}
