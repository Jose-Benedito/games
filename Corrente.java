package objetos;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.bene.main.Principal;

public class Corrente {
	
	public double x ;
	public int y ;
	private double velo;
	private int intervalo = 30;
	public static Random rand;
	
	public int numeroDeLetras;
	private List<Letras> letras;

	
	public Corrente() {
		
		rand = new Random();
		numeroDeLetras = rand.nextInt(30);
		velo = rand.nextDouble()* (12)+1; //+1 para não zerar
		letras = new ArrayList<Letras>();
		double xx = rand.nextDouble() * (Principal.WIDTH )+0.1 ;//só para não ficar no canto
		
		for(int i = 0; i < numeroDeLetras; i++) {
			Letras simb = new Letras(xx , this.y, this.velo);
		
			letras.add(simb);
			y-= intervalo+ this.velo;
			if(y < Principal.HEIGHT) {
				Principal.correnteDeLetras.remove(this);
			}
			
		}
		
	}
	public void tick() {
	
		for(int i = 0; i < letras.size(); i++) {
			Letras l = letras.get(i);
			l.tick();
		}
		
		
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < letras.size(); i++) {
			Letras l = letras.get(i);
			l.render(g);
		}
	}

}
