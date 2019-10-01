package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
		
	public static int WIDHT = 300;
	public static int HEIGHT = WIDHT / 16 * 9;
	public static int SCALE = 3;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	public Game() {
		Dimension size = new Dimension(WIDHT * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		
		frame = new JFrame();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (running) {
			System.out.println("Runing....");
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Rain");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		
		game.start();
		
		
	}

}
