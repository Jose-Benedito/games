package objetos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.bene.main.Principal;

public class Letras {
	private double x;
	private int y;
	private double velo ;
	public static int size = 18;
	public Random rand;
	 
	private int framesAnimation = 0;
	private int maxAnimation = 4;
	
	private int currentSprite = 0;
	private int maxSprite = 49;
	
	
	public Letras(double x, int y, double velo) {
		this.x = x;
		this.y = y;
		this.velo = velo;
		rand = new Random();
		
		
		
	}
	
	public  void render(Graphics g) {
		currentSprite = rand.nextInt(29);
		framesAnimation++;
		if(framesAnimation == maxAnimation) {
			currentSprite++;
			framesAnimation = 0;
		}
		if(currentSprite == maxSprite) {
			currentSprite = 0;
		}
	
		for(int i = 0; i < Kanaka.LETRAS.length; i++) {
		g.drawImage(Kanaka.LETRAS[currentSprite],(int) this.x, this.y, size, size, null);
		
		}
	}
	public void tick() {
		y+= velo;
		if(y >= Principal.HEIGHT) {
			y = 0;
			
			
		}
		
	}

}
