package com.bene.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.bene.main.Game;

public class Explosao extends Entity {
	public int frames = 0;
	public int intervalo = 10;
	public int maxFrames = 3;
	public int atualFrame = 0;
	
	public BufferedImage[] explosion = new BufferedImage[4];
	
	public Explosao(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		explosion[0] = Game.spritesheet.getSprite(0,16,16,16);
		explosion[1] =  Game.spritesheet.getSprite(16, 16, 16, 16);
		explosion[2] = Game.spritesheet.getSprite(32, 16, 16, 16);
		explosion[3] = Game.spritesheet.getSprite(48,16, 16, 16);
		
	}
	public void tick() {
		
		frames++;
		if(frames == intervalo) {
			frames = 0;
			atualFrame++;
			if(atualFrame > maxFrames) {
				Game.entities.remove(this);
				return;
			}
		}
		
	}
	public void render(Graphics g) {
		
		g.drawImage(explosion[atualFrame],(int)x, (int)y, width, height, null);
	}

}
