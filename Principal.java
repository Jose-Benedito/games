package com.bene.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import objetos.Corrente;
import objetos.Letras;
import objetos.Spritesheet;

public class Principal extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private JFrame janela;
	public static final int WIDTH = 750;
	public static final int HEIGHT = 380;
	public static final int SCALE = 2;
	private boolean isRunning = true;
	private Thread  thread;
	private BufferedImage image;
	public static Spritesheet spritesheet;

	public static List<Corrente> correnteDeLetras;
	
	public Principal() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		initComponentes();

		spritesheet = new Spritesheet("/spritesheet.png");
		
		correnteDeLetras = new ArrayList<Corrente>();
		for(int i = 0; i <= (WIDTH*SCALE )/ 26; i++ ) {
			Corrente corrente = new Corrente();
			correnteDeLetras.add(corrente);
		
		}
		
	}
	
	public void initComponentes() {
		janela = new JFrame("Matrix");
		janela.add(this);
		janela.setResizable(false);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WIDTH,HEIGHT);
		
		
		for(int i = 0; i< correnteDeLetras.size(); i++ ) {
			Corrente corrente = correnteDeLetras.get(i);
			corrente.render(g);
		}
		
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0,WIDTH*SCALE,HEIGHT*SCALE, null);
		bs.show();
		
	}
	public void tick() {
		//letra.tick();
		for(int i = 0; i< correnteDeLetras.size(); i++) {
			Corrente corrente = correnteDeLetras.get(i);
			corrente.tick();
		}
		
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
				
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: "+frames);
				frames = 0;
				timer+= 1000;
			}
			
		}
		stop();
	}
	public static void main(String args[]) {
		Principal matrix = new Principal();
		matrix.start();
		
	}

}
