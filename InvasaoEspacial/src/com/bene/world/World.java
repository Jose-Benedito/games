package com.bene.world;

import java.awt.Graphics;

import com.bene.main.Game;




public class World {


	public static int WIDTH, HEIGHT;
	public static final int TILE_SIZE = 16;
	public static int dia = 0;
	public static int tarde = 1;
	public static int noite = 2;
	public static int ciclo = dia;
	

	public World(){
	/*	WIDTH = 500;
		HEIGHT = 80;
		String[] tilesTypes = {"terra", "grama", "areia", "neve"};
		int divisao = WIDTH/tilesTypes.length;
		tiles = new Tile[WIDTH * HEIGHT];
		
		for(int xx = 0; xx < WIDTH; xx++) {
			for(int yy = 0; yy < HEIGHT; yy++) {
				int initialHeight = Entity.rand.nextInt(12 - 8) + 8;
				if(yy == HEIGHT - 1 || xx == WIDTH -1 || xx == 0 || yy == 0) {
					tiles[xx + yy * WIDTH] = new WallTile(xx*16, yy*16, Tile.TILE_WALL);
					tiles[xx + yy * WIDTH].Solid = true;
				}else {
					if(yy >= initialHeight) {
						int indexBioma = xx / divisao;
						if(tilesTypes[indexBioma] == "terra") {
							tiles[xx + yy * WIDTH] = new WallTile(xx*16, yy*16, Tile.TILE_TERRA);
						}else if(tilesTypes[indexBioma] == "grama") {
							tiles[xx + yy * WIDTH] = new WallTile(xx*16, yy*16, Tile.TILE_GRAMA);
						}else if(tilesTypes[indexBioma] == "areia") {
							tiles[xx + yy * WIDTH] = new WallTile(xx*16, yy*16, Tile.TILE_AREIA);
						}else if(tilesTypes[indexBioma] == "neve"){
							tiles[xx + yy * WIDTH] = new WallTile(xx*16, yy*16, Tile.TILE_NEVE);
						}
					}else {
						
						tiles[xx + yy * WIDTH] = new FloorTile(xx*16, yy*16, Tile.TILE_AR);
					}
				}
			}
	}*/
		}


	public static void restartGame() {
		// TODO: Aplicar método para reiniciar o jogo corretamente.
		return;
	}

	public void render(Graphics g) {
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;

		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);

		for (int xx = xstart; xx <= xfinal; xx++) {
			for (int yy = ystart; yy <= yfinal; yy++) {
				if (xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
			//	Tile tile = tiles[xx + (yy * WIDTH)];
			//	tile.render(g);
			}
		}
	}

}
