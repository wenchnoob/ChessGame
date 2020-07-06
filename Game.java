package com.chessgame.main;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game extends Canvas implements Runnable {
	
	public static Game game;
	
	private static final long serialVersionUID = 1L;
	private int  HEIGHT = 640, WIDTH = HEIGHT * 12 / 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
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
		//new Saver();
		
		handler = new Handler();
		
		new Window(WIDTH, HEIGHT, "Chess", this);
		new Board(180, 530, null, handler);
		new PiecesManager(handler);
		new LogicGate();
		
		this.addMouseListener(new MouseInput());
		
		try {
			new Util();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		this.requestFocus();
		while(running) {
			render();
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
		drawBackOfBoards(g);
		g.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(5));
		drawLabels(g);
		g2D.setStroke(new BasicStroke(2));
		handler.render(g);
		g.dispose();
		bs.show();
	}
	
	private void drawBackOfBoards(Graphics g) {
		g.setColor(new Color(105, 105, 105));
		g.fillRect(130, 0, 580, 580);
	}
	
	private void drawLabels(Graphics g) {
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
	}
	
	public static void clamp(GameObject object){
		if (object.getX() > 600 || object.getX() < 180) object.setX(180);
		if (object.getY() > 470 || object.getY() < 50) object.setY(470);
	}
	
	public static void main(String[] args) {
		new Game();
	}	
}
