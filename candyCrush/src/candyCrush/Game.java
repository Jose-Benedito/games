package candyCrush;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, MouseMotionListener, MouseListener{
	public static final int WIDTH = 288;
	public static final int HEIGHT = 288;
	public static final int SCALE = 2;
	public BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public static JFrame janela;
	public static final int FPS = 1000/60;
	public Tabuleiro tabuleiro;
	public static boolean selected = false;
	public static int previosx = 0, previosy = 0;
	public static int nextx = -1, nexty = -1;
	
	public Game() {
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		tabuleiro = new Tabuleiro();
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
	}
	public static void main(String[]args) {
		janela = new JFrame("CandyCrush");
		Game game = new Game();
		janela.add(game);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		new Thread(game).start();
	}
	public void update() {
		tabuleiro.update();
		
		if(Game.selected && (Game.nextx !=-1 && Game.nexty != -1)) {
			int posx = Game.previosx/48;
			int posy = Game. previosy/48;
			
			int proxposx = Game.nextx/48;
			int proxposy = Game.nexty/48;
			/* validando as posições vizinhas */
			if((proxposx == posx + 1 || proxposx == posx - 1) && 
			proxposy == posy || proxposy == posy - 1 || proxposy == posy + 1 ){
				// descomente se quiser eviar movimentos na diagonal
				if((proxposx >= posx + 1 || proxposx <= posx - 1) && 
						( proxposy >= posy + 1 || proxposy <= posy - 1) ) {
					System.out.println("Não pode mover!");
					return;
				}
				
				
				/*trocando as figuras*/
				int novopos1 = Tabuleiro.TABULEIRO[proxposx][proxposy];
				int novopos2 = Tabuleiro.TABULEIRO[posx][posy];
				Tabuleiro.TABULEIRO[proxposx][proxposy] = novopos2;
				Tabuleiro.TABULEIRO[posx][posy] = novopos1;
				/* resetando as variáveis*/
				Game.nextx = -1;
				Game.nexty = -1;
				Game.selected = false;
				
				
				
			}else {
				System.out.println("Não moveu!");
			}
		}
		
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(2);
			return;
			
		}
		Graphics g = image.getGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		tabuleiro.render(g);
		
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0 ,WIDTH*SCALE, HEIGHT*SCALE, null);
		bs.show();
		
		
	}
	
	
	@Override
	public void run() {
		while(true) {
			update();
			render();
			try {
				Thread.sleep(FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(selected == false) {
		Game.selected = true;
			Game.previosx = e.getX()/2;
			Game.previosy = e.getY()/2;
		}else {
			Game.nextx = e.getX()/2;
			Game.nexty = e.getY()/2;
			
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
