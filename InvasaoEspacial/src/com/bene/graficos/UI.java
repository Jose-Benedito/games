package com.bene.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.bene.entities.Player;
import com.bene.main.Game;
import com.bene.world.World;




public class UI {
	public int seconds = 0;
	public int minutes = 0;
	public int frames = 0;
	
	public void tick() {
		frames++;
		if(frames == 60) {
			//passou 1 segundo
			seconds++;
			frames = 0;
			if(seconds == 60) {
				//passou 1 minuto
				minutes++;
				seconds = 0;
				if(minutes % 1 == 0) {
					World.ciclo ++;
					if(World.ciclo > World.noite) {
						World.ciclo = 0;
					}
				}
			}
		}	
		
		
	}

	public void render(Graphics g) {
	
		
		//Formatando o relógio
		
		String formatTime = "";
		if(minutes < 10) {
			formatTime = "0"+minutes+":";	
		}else {
			formatTime+= minutes+":";
		}
		if(seconds < 10) {
			formatTime+="0"+seconds;
		}else {
			formatTime+= seconds;
		}
		g.setFont(new Font("arial", Font.BOLD, 18));
		g.setColor(Color.BLUE);
		g.drawString(formatTime, 30, 35);
		
		g.setFont(new Font("arial", Font.BOLD, 20));
		g.setColor(Color.WHITE);
		g.drawString("Score: "+ Game.score, 165, 35);
		
		
		g.setColor(Color.RED);
		g.fillRect(Game.WIDTH*Game.SCALE - 150,35,60, 20);
		
		g.setColor(Color.GREEN);
		g.fillRect(Game.WIDTH*Game.SCALE - 150,35,(int) ((Player.vidas/100)*60), 20);
		
		if(Player.isEnd) {
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.setColor(Color.RED);
			g.drawString("GAME OVER!", Game.WIDTH/2*Game.SCALE-150, Game.HEIGHT/2*Game.SCALE);
		}
		
	}
	
}
