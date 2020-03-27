package com.bene.entities;


import java.awt.image.BufferedImage;

import com.bene.main.Game;

public class Player extends Entity {

	public boolean direita, esquerda, sobe, desce;
	public boolean podeatirar = false;
	public Tiro tiro;
	public static double vidas = 100;
	public static boolean isEnd;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);

	}

	public void tick() {
		if (direita) {
			x += speed;
			if (x >= Game.WIDTH - 16) {
				x = (Game.WIDTH - 16) - speed;
			}

		}
		if (esquerda) {
			x -= speed;
			if (x <= 0) {
				x = 0;
			}

		}
		if (sobe) {
			y -= speed;
			if (y <= Game.HEIGHT / 2) {
				y = Game.HEIGHT / 2;
			}
		}
		if (desce) {
			y += speed;
			if (y >= Game.HEIGHT - 16) {
				y = Game.HEIGHT - 16;
			}
		}

		if (podeatirar) {
			podeatirar = false;
			int xx = this.getX() + 8;
			int yy = this.getY();
			tiro = new Tiro(xx, yy, 2, 3, 4, null);
			Game.entities.add(tiro);

		}

		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Enemy) {
				if (Entity.isColidding(this, e)|| this.vidas == 0) {
					isEnd = true;	
					Game.entities.remove(e);
					Explosao explosao = new Explosao(x, y, 16, 16, 0, null);
					Game.entities.add(explosao);
					Game.entities.remove(Game.player);
										
					return;
				}
				break;
			}
		}

	}

}
