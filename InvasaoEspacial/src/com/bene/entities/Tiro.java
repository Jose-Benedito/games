package com.bene.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.bene.main.Game;

public class Tiro  extends Entity {


	public Tiro(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, null);
		
	}
	public void tick() {
		y-= speed;
		if(y < 0) {
			Game.entities.remove(this);
			return;
			
		}

	}
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)this.x,(int)this. y, width, height );
	}
		
	

}
