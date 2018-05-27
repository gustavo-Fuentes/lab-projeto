import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen extends JPanel implements KeyListener, ActionListener {
	private BufferedImage background;
	int x = 340;
	int y = 440;
	int ym = -300;
	int xs = 0;
	boolean end = false;
	boolean reset = false;
	ArrayList<Entity> enemy = new ArrayList<>();
	Player p = new Player(x, y);
	Tiro tiro = new Tiro(1000,-1000);

	public Screen() {

		startEnemy();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		enemy.add(p);
		enemy.add(tiro);

		try {
			background = ImageIO.read(getClass().getResourceAsStream(
					"/spicy_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int delay = 5; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				if (end == false) {
					clear();
					collision();
					movimento();
					repaint();
				}
				else {
					enemy.clear();
					try {
						background = ImageIO.read(getClass().getResourceAsStream(
								"/GameOver.png"));
						repaint();
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (reset == true) {
						
						enemy.clear();
						startEnemy();
						enemy.add(p);
						enemy.add(tiro);
						try {
							background = ImageIO.read(getClass().getResourceAsStream(
									"/spicy_background.jpg"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						repaint();
						end = false;
						reset = false;
						
					}
					
				}
			}
		};
		new Timer(delay, taskPerformer).start();

		int delay2 = 6000;
		ActionListener taskPerformer1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (end == false) {
					enemy.clear();
					startEnemy();
					enemy.add(p);
					enemy.add(tiro);
				}
				
			}
		};
		new Timer(delay2, taskPerformer1).start();

	}

	void clear() {
		for(int i=0; i<enemy.size();i++) {
			if(enemy.get(i).getY()> 600) {
				enemy.clear();
				enemy.add(p);
				enemy.add(tiro);
			}
		}
	}

	void collision() {
			
		for(int i=0; i<enemy.size();i++){
			if(p.colidiu(enemy.get(i))== true){
				if(enemy.get(i).getId() < 2){	
				}else{
					end = true;
				}
				
				
			}
		}
		
		for(int i=0; i<enemy.size();i++){
			if(tiro.colidiu(enemy.get(i))== true){
				if(enemy.get(i).getId() < 2){	
				}else{
					enemy.remove(i);
				
				}
				
				
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);
		for (Entity e : enemy) {
			e.draw(g, this);
		}

	}

	public void startEnemy() {
		for (int i = 0; i < 3; i++) {
			int xm = (int) (Math.random() * 750);
			enemy.add(new Enemy(xm, -300, i+2));
		}
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void movimento() {
		for (Entity e : enemy) {
			e.movimento();
		}

	}

	public void keyPressed(KeyEvent e) {
		for (Entity en : enemy) {
			en.keyPressed(e,p);
		}
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_R) {
			if(end == true) {
				reset = true;
			}
			
				
		}
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}
