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
	private BufferedImage image;
	private BufferedImage background;
	private Image enemy;
	private URL url = this.getClass().getResource("spicy.png");
	int x = 340;
	double velx = 25;
	int y = 440;
	int ym = -600;
	boolean dash = false;
	ArrayList<Meteor> m = new ArrayList<>();

	public Screen() {
		startMeteor();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Nave.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			background = ImageIO.read(getClass().getResourceAsStream("/spicy_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			enemy = new ImageIcon(url).getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		for (int i = 0; i < m.size(); i++) {
			m.get(i).setY(ym);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);
		g.drawImage(image, x, y, image.getWidth() / 6, image.getHeight() / 6, null);
		paintEnemy(g);

	}

	public void startMeteor() {
		for (int i = 0; i < 3; i++) {
			int xm = (int) (Math.random() * 750);
			m.add(new Meteor(xm, -600));
		}
	}

	public void paintEnemy(Graphics g) {
		for (int i = 0; i < m.size(); i++) {
			g.drawImage(enemy, m.get(i).getX(), m.get(i).getY(), enemy.getWidth(null) / 2, enemy.getHeight(null) / 2,
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
		if (x - (image.getWidth() / 6) + 90 < 0) {
		} else {
			x += -1.5 * velx;
		}
	}

	public void right() {
		if (x + (image.getWidth() / 6) + 30 > 800) {
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
