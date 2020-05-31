package com.chessgame.main;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	public static Game game;
	
	private static final long serialVersionUID = 1L;
	private int  HEIGHT = 640, WIDTH = HEIGHT * 12 / 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	@SuppressWarnings("unused")
	private static Window window;
	@SuppressWarnings("unused")
	private static Board board;
	
	@SuppressWarnings("unused")
	private static LogicGate logicGate;
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop () {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Game()  {
		handler = new Handler();
		window = new Window(WIDTH, HEIGHT, "Chess", this);
		board = new Board(180, 530, null, handler);
		loadPieces(handler);
		this.addMouseListener(new MouseInput());
		logicGate = new LogicGate();
		logicGate.fill();
	}
	
	private void loadPieces(Handler handler) {
		for(int i = 0; i < 8; i++) {
			Pawn temp = new Pawn(180 + 60*i, 410, ID.WP, Faction.WHITE);
			handler.addObject(temp);
		}
		Rook wRook1 = new Rook(180, 470, ID.WR, Faction.WHITE);
		handler.addObject(wRook1);
		Knight wKnight1 = new Knight(240, 470, ID.WKN,  Faction.WHITE);
		handler.addObject(wKnight1);
		Bishop wBishop1 = new Bishop(300, 470, ID.WB,  Faction.WHITE);
		handler.addObject(wBishop1);
		Queen wQueen = new Queen(360, 470, ID.WQ,  Faction.WHITE);
		handler.addObject(wQueen);
		King wKing = new King(420, 470, ID.WK, Faction.WHITE);
		handler.addObject(wKing);
		Bishop wBishop2 = new Bishop(480, 470, ID.WB,  Faction.WHITE);
		handler.addObject(wBishop2);
		Knight wKnight2 = new Knight(540, 470, ID.WKN,  Faction.WHITE);
		handler.addObject(wKnight2);
		Rook wRook2 = new Rook(600, 470, ID.WR,  Faction.WHITE);
		handler.addObject(wRook2);
		
		for(int i = 0; i < 8; i++) {
			Pawn temp = new Pawn(180 + 60*i, 110, ID.BP, Faction.BLACK);
			handler.addObject(temp);
		}
		Rook bRook1 = new Rook(180, 50, ID.BR, Faction.BLACK);
		handler.addObject(bRook1);
		Knight bKnight1 = new Knight(240, 50, ID.BKN,  Faction.BLACK);
		handler.addObject(bKnight1);
		Bishop bBishop1 = new Bishop(300, 50, ID.BB,  Faction.BLACK);
		handler.addObject(bBishop1);
		Queen bQueen = new Queen(360, 50, ID.BQ,  Faction.BLACK);
		handler.addObject(bQueen);
		King bKing = new King(420, 50, ID.BK, Faction.BLACK);
		handler.addObject(bKing);
		Bishop bBishop2 = new Bishop(480, 50, ID.BB,  Faction.BLACK);
		handler.addObject(bBishop2);
		Knight bKnight2 = new Knight(540, 50, ID.BKN,  Faction.BLACK);
		handler.addObject(bKnight2);
		Rook bRook2 = new Rook(600, 50, ID.BR,  Faction.BLACK);
		handler.addObject(bRook2);
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		Graphics2D g2D = (Graphics2D)g;
		
		g.setColor(new Color(192, 192, 192));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(new Color(105, 105, 105));
		g.fillRect(130, 0, 580, 580);
		
		g.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(5));
		g.drawRect(130, 0, 580, 580);
		
		final String[] xLabel = {"A", "B", "C", "D", "E", "F", "G", "H"};
		final int[] yLabel = {1, 2, 3, 4, 5, 6, 7, 8};
		
		g.setFont(new Font("Arial", Font.BOLD, 25));
		
		for(int i = 0; i < xLabel.length; i ++) {
			g.drawString(xLabel[i], 200 + 60 * i, 560);
		}
		
		for(int i = 0; i < xLabel.length; i ++) {
			g.drawString(xLabel[i], 200 + 60 * i, 35);
		}
		
		for(int i = 0; i < yLabel.length; i ++) {
			g.drawString(String.valueOf(yLabel[i]), 150, 510 - 60 * i);
		}
		
		for(int i = 0; i < yLabel.length; i ++) {
			g.drawString(String.valueOf(yLabel[i]), 675, 510 - 60 * i);
		}
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void clamp(GameObject object){
		if (object.getX() > 600 || object.getX() < 180) object.setX(180);
		if (object.getY() > 470 || object.getY() < 50) object.setY(470);
	}
	
	public static void main(String[] args) {
		new Game();
	}

	
}
