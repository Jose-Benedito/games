package com.bene.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.bene.main.Game;



public class Enemy extends Entity{
	
	public boolean right = true,left = false;
	public int dir = 1;
	public double vida = 3;
	public BufferedImage sprite;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	
	}
	
	public void tick() {
		y+= speed;
		if(y >= Game.HEIGHT) {
			Player.vidas--;
			Game.entities.remove(this);
			return;
		}
		
		//destruindo os enemies
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Tiro ) {
				if(Entity.isColidding(this, e)) {
					Game.entities.remove(e); 
					vida--;
					if(vida == 0) {
						
						Explosao explosao = new Explosao(x, y, 16, 16, 0, null);
						Game.entities.add(explosao);
						Game.score++;
						Game.entities.remove(this);
						return;
					}
					break;
				}
				
			
			}
		}
	
	}
	
	
	
}

	
