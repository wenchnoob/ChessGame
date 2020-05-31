package com.chessgame.main;

public class LogicGate {
	
	public LogicGate() {}
	
	public void fill() {
		for(int i = 0; i < Handler.objects.size(); i++) {
			for(int j = 0; j < Handler.pieces.size(); j++) {
				if(Handler.objects.get(i).getX() == Handler.pieces.get(j).getX() &&
					Handler.objects.get(i).getY() == Handler.pieces.get(j).getY()) {
					Handler.objects.get(i).setContains(Handler.pieces.get(j));
				}
			}
		}
	}
	
	public void update(ChessPiece piece, GameObject gridSquare) {
		for(int i = 0; i < Handler.objects.size(); i++) {
			if(Handler.objects.get(i).getContains() == piece) {
				Handler.objects.get(i).setContains(null);
			}
		}
		gridSquare.setContains(piece);
	}
	
	public boolean isMoveValid(GridSquare[] possibleMoves, GridSquare move) {
		for(int i = 0; i< possibleMoves.length; i++) {
			if(possibleMoves[i].equals(move)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMoveable(ChessPiece piece) {
		return true;
	}
	
	@SuppressWarnings("unused")
	private boolean isBlocked(ChessPiece piece) {
		return false;
	}

	public GridSquare[] possibleMoves(ChessPiece piece) {
		return piece.possibleMoves();
	}
	
	
	public GridSquare[] possibleCaptures() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
