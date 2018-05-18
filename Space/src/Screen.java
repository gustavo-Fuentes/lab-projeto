import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener, ActionListener {
	/*private BufferedImage image;
	
	private Image enemy;
	private URL url = this.getClass().getResource("spicy.png");*/
	private BufferedImage background;
	int x = 340;
	double velx = 25;
	int y = 440;
	int ym = -600;
	boolean dash = false;
	ArrayList<Enemy> e = new ArrayList<>();
	Player p = new Player(330,440);

	public Screen() {
		startEnemy();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		/*try {
			image = ImageIO.read(getClass().getResourceAsStream("/Nave.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		try {
			background = ImageIO.read(getClass().getResourceAsStream("/spicy_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*try {
			enemy = new ImageIcon(url).getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		int delay = 5; // milliseconds

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				recalcula();
				repaint();
				movimento();
			}
		};
		new Timer(delay, taskPerformer).start();

		int delay2 = 1000;
		ActionListener taskPerformer1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		};
		new Timer(delay2, taskPerformer1).start();

	}

	void recalcula() {
		for (int i = 0; i < e.size(); i++) {
			e.get(i).setY(ym);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);
		g.drawImage(p.getImage(), p.getX(), y, p.getImage().getWidth() / 6, p.getImage().getHeight() / 6, null);
		paintEnemy(g);

	}

	public void startEnemy() {
		for (int i = 0; i < 3; i++) {
			int xm = (int) (Math.random() * 750);
			e.add(new Enemy(xm, -400,null));
		}
	}

	public void paintEnemy(Graphics g) {
		for (int i = 0; i < e.size(); i++) {
			g.drawImage(e.get(i).getImg(), e.get(i).getX(), e.get(i).getY(), e.get(i).getImg().getWidth(null) / 2, e.get(i).getImg().getHeight(null) / 2,
					this);
		}	
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void movimento() {
		ym += 1;
	}

	public void left() {
		if (x - (p.getImage().getWidth() / 6) + 90 < 0) {
		} else {
			x += -1.5 * velx;
		}
	}

	public void right() {
		if (x + (p.getImage().getWidth() / 6) + 30 > 800) {
		} else {
			x += +1.5 * velx;
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SHIFT) {
			dash = true;
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
			if (dash == true) {
				x+= 50;
				dash = false;
			}
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
			if (dash == true) {
				x+= -50;
				dash = false;
			}
		}

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}
