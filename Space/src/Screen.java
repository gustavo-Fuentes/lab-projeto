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
	boolean condition = false;
	boolean cd = false;
	boolean end = false;
	ArrayList<Entity> enemy = new ArrayList<>();
	Player p = new Player(x, y);
	Tiro tiro = new Tiro(x,y);

	public Screen() {

		startEnemy();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		enemy.add(p);

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
					recalcula();
					//collision();
					movimento();
					repaint();
				}
			}
		};
		new Timer(delay, taskPerformer).start();

		int delay2 = 10000;
		ActionListener taskPerformer1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (end == false) {
					clEnemy();
					startEnemy();
					enemy.add(p);
				}
			}
		};
		new Timer(delay2, taskPerformer1).start();

	}

	void recalcula() {
	}

	void collision() {
		for(int i=0; i<enemy.size();i++){
			if(tiro.colidiu(enemy.get(i))== true){
				if(tiro.getImage() == p.getImage()){	
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

		if (condition == true) {
			tiro.draw(g,this);
		}

	}

	public void startEnemy() {
		for (int i = 0; i < 3; i++) {
			int xm = (int) (Math.random() * 750);
			enemy.add(new Enemy(xm, -300));
		}
	}

	public void clEnemy() {
		enemy.clear();
		ym = -300;
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void movimento() {
		for (Entity e : enemy) {
			e.movimento();
		}

		if (condition == true) {
			tiro.setY(tiro.getY() - 10);
			if (tiro.getY() == -200) {
				condition = false;
				tiro.setY(p.getY() - 60);
				cd = false;
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		for (Entity en : enemy) {
			en.keyPressed(e);
		}
		if (code == KeyEvent.VK_SPACE) {
			condition = true;
			if (cd == false) {
				tiro.setX(p.getX());
				tiro.setY(p.getY()-30);
				cd = true;
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}
