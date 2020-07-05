package com.chessgame.main;

public class LogicGate {
	private ChessPiece selectedPiece = null;
	
	public LogicGate() {
		update();
	}
	
	public void setSelected(ChessPiece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
	public ChessPiece getSelected() {
		return selectedPiece;
	}
	
	public static void update() {
		for(int i = 0; i < Handler.objects.size(); i++) {
			((GridSquare) Handler.objects.get(i)).setContains();
		}
	}
	
	public static void reset() {
		for(int i = 0; i < Handler.objects.size(); i++) {
			Handler.objects.get(i).setBlocked(false);
		}
	}
	
	public boolean isMoveValid(GridSquare move) {
		selectedPiece.findDirectedPath(move);
		
		determineAndModifyIfBlocked();
		
		if(selectedPiece.getDirectedMoves().contains(move)) return true;
		
		return false;
	}
	
	public void determineAndModifyIfBlocked() {
		boolean blocked= false;
		
		int occupiedSquare = 0;
		for(GridSquare square : selectedPiece.getDirectedMoves()) {
			occupiedSquare++;
			if(square.contains()) {
					blocked = true;
			}
			
		}
		
		if(blocked) {
			for(int i = 0; i < selectedPiece.getDirectedMoves().size(); i++) {
				
			}
			System.out.println(occupiedSquare);
			for(int i = occupiedSquare; i < selectedPiece.getDirectedMoves().size(); i++) {
				selectedPiece.getDirectedMoves().remove(occupiedSquare);
			}
		}
	}
	
	public boolean isMoveable() {
		selectedPiece.possibleMoves();
		if(selectedPiece.getPossibleMoves().size() == 0) return false;
		return true;
	}
	
	//private void checkBlocked() {}
}
