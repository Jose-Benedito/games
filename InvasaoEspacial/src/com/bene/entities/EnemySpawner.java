package com.bene.entities;

import com.bene.main.Game;

public class EnemySpawner {
	
	public int currentTime = 0;
	public int interval = 60 * 2;
	
	public void tick() {
		currentTime++;
		if(currentTime == interval) {
			interval = Entity.rand.nextInt(150);
			currentTime = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);
			int yy = 0;
			Enemy enemy = new Enemy(xx, yy, 16, 16, 1, Game.spritesheet.getSprite(16,0, 16, 16));
			Game.entities.add(enemy);
		}
		
	}

}
