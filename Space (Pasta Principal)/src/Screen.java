import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener, ActionListener {
	private BufferedImage background;
	int x = 340;
	int y = 440;
	int ym = -300;
	int xs = 0;
	boolean condition = false;
	boolean cd = false;
	ArrayList<Entity> enemy = new ArrayList<>();
	Player p = new Player(x, y);

	public Screen() {

		startEnemy();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		try {
			background = ImageIO.read(getClass().getResourceAsStream(
					"/spicy_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int delay = 5; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				recalcula();
				collision();
				movimento();
				repaint();

			}
		};
		new Timer(delay, taskPerformer).start();

		int delay2 = 6000;
		ActionListener taskPerformer1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clEnemy();
				startEnemy();
			}
		};
		new Timer(delay2, taskPerformer1).start();

	}

	void recalcula() {
		for (int i = 0; i < enemy.size(); i++) {
			enemy.get(i).setY(ym);
		}
	}

	void collision() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getX() == enemy.get(i).getX()
					& p.getY() == enemy.get(i).getY()) {
				try {
					background = ImageIO.read(getClass().getResourceAsStream(
							"/GameOver.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);
		p.draw(g);
		if (condition == true) {
			p.shoot(g, xs);
		}
		paintEnemy(g);

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

	public void paintEnemy(Graphics g) {
		for (int i = 0; i < enemy.size(); i++) {
			g.drawImage(((Enemy) enemy.get(i)).getIcon(), enemy.get(i).getX(),
					enemy.get(i).getY(), ((Enemy) enemy.get(i)).getIcon()
							.getWidth(null) / 6, ((Enemy) enemy.get(i))
							.getIcon().getHeight(null) / 6, this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void movimento() {
		ym += 1;
		if (condition == true) {
			p.setYs(p.getYs() - 5);
			if (p.getYs() == -200) {
				condition = false;
				p.setYs(p.getY() - 60);
				cd = false;
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SHIFT) {
			p.setDash(true);
		}
		if (code == KeyEvent.VK_SPACE) {
			condition = true;
			if (cd == false) {
				xs = p.getX();
				cd = true;
			}
		}

		if (code == KeyEvent.VK_RIGHT) {
			p.right();
			if (p.isDash() == true) {
				p.dash(0);
				p.setDash(false);
			}
		}
		if (code == KeyEvent.VK_LEFT) {
			p.left();
			if (p.isDash() == true) {
				p.dash(1);
				p.setDash(false);
			}
		}

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}
