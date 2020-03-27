package candyCrush;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {

	public static final int WIDTH = 6;
	public static final int HEIGHT = 6;
	public static int[][] TABULEIRO;

	public static int Doce_0 = 0, Doce_1 = 1, Doce_2 = 2;

	public Tabuleiro() {
		TABULEIRO = new int[WIDTH][HEIGHT];

		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				TABULEIRO[x][y] = new Random().nextInt(3);
			}
		}

	}

	public void update() {
		//na vertical
		ArrayList<Candy> combos = new ArrayList<Candy>();
		for (int yy = 0; yy < HEIGHT; yy++) {
			if (combos.size() == 3) {
				/* fez um combo de 3 peças */
				for (int i = 0; i < combos.size(); i++) {
					/* renovas os candys*/
					int xtemp = combos.get(i).x;
					int ytemp = combos.get(i).y;
					TABULEIRO[xtemp][ytemp] = new Random().nextInt(3);
				}
				combos.clear(); /*limpa a array*/
				System.out.println("Pontuei!");
				return;
			}
			combos.clear();
			for (int xx = 0; xx < WIDTH; xx++) {
				int cor = TABULEIRO[xx][yy];
				if (combos.size() == 3) {
					for (int i = 0; i < combos.size(); i++) {
						int xtemp = combos.get(i).x;
						int ytemp = combos.get(i).y;
						TABULEIRO[xtemp][ytemp] = new Random().nextInt(3);

					}
					combos.clear();
					System.out.println("Pontuei!");
					return;
				}
				if (combos.size() == 0) {
					combos.add(new Candy(xx, yy, cor));
				}else if(combos.size() > 0) {
					if(combos.get(combos.size() - 1).candy_type == cor) {
						combos.add(new Candy(xx, yy, cor));
					}else {
						combos.clear();
						combos.add(new Candy(xx, yy, cor));
					}
				}
			}
		}
		//na horizontal
		combos = new ArrayList<Candy>();
		for (int xx = 0; xx < WIDTH; xx++) {
			if (combos.size() == 3) {
				for (int i = 0; i < combos.size(); i++) {
					int xtemp = combos.get(i).x;
					int ytemp = combos.get(i).y;
					TABULEIRO[xtemp][ytemp] = new Random().nextInt(3);
				}
				combos.clear();
				System.out.println("Pontuei!");
				return;
			}
			combos.clear();
			for (int yy = 0; yy < HEIGHT; yy++) {
				int cor = TABULEIRO[xx][yy];
				if (combos.size() == 3) {
					for (int i = 0; i < combos.size(); i++) {
						int xtemp = combos.get(i).x;
						int ytemp = combos.get(i).y;
						TABULEIRO[xtemp][ytemp] = new Random().nextInt(3);

					}
					combos.clear();
					System.out.println("Pontuei!");
					return;
				}
				if (combos.size() == 0) {
					combos.add(new Candy(xx, yy, cor));
				}else if(combos.size() > 0) {
					if(combos.get(combos.size() - 1).candy_type == cor) {
						combos.add(new Candy(xx, yy, cor));
					}else {
						combos.clear();
						combos.add(new Candy(xx, yy, cor));
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				g.setColor(Color.white);
				g.drawRect(x * 48, y * 48, 48, 48);
				int doce = TABULEIRO[x][y];
				if (doce == Doce_0) {
					g.setColor(Color.RED);
					g.fillRect(x * 48 + 12, y * 48 + 12, 25, 25);
				}
				if (doce == Doce_1) {
					g.setColor(Color.green);
					g.fillRect(x * 48 + 12, y * 48 + 12, 25, 25);
				}
				if (doce == Doce_2) {
					g.setColor(Color.yellow);
					g.fillRect(x * 48 + 12, y * 48 + 12, 25, 25);
				}
				// selecionando os objetos
				if (Game.selected) {
					int posx = Game.previosx / 48;
					int posy = Game.previosy / 48;
					g.setColor(Color.black);
					g.drawRect(posx * 48, posy * 48, 48, 48);
				}
			}

		}
	}
}
