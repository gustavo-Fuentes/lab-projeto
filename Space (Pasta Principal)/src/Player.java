import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity implements ActionListener {
	public Player(int x, int y) {
		super(x, y, 0);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Nave.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			image2 = ImageIO.read(getClass().getResourceAsStream("/Green_laser.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getYs() {
		return ys;
	}

	public void setYs(int ys) {
		this.ys = ys;
	}

	public BufferedImage getImage2() {
		return image2;
	}

	public void setImage2(BufferedImage image2) {
		this.image2 = image2;
	}

	public void left() {
		if (x - (getImage().getWidth() / 6) + 90 < 0) {
		} else {
			x += -1.5 * velx;
		}
	}

	public void right() {
		if (x + (getImage().getWidth() / 6) + 30 > 800) {
		} else {
			x += +1.5 * velx;
		}
	}

	public void dash(int direction) {
		if (direction == 0) {
			if (x + (getImage().getWidth() / 6) + 30 > 800) {
			} else {
				x += 50;
			}
		}
		if (direction == 1) {
			if (x - (getImage().getWidth() / 6) + 90 < 0) {
			} else {
				x += -50;
			}
		}
	}

	public void draw(Graphics g) {
		g.drawImage(getImage(), x, y, getImage().getWidth() / 6, getImage().getHeight() / 6, null);
	}

	public boolean isDash() {
		return dash;
	}

	public void setDash(boolean dash) {
		this.dash = dash;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	public int getXs() {
		return xs;
	}

	public void setXs(int xs) {
		this.xs = xs;
	}


	@Override
	public void movimento() {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e, Player p) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SHIFT) {
			this.setDash(true);
		}

		if (code == KeyEvent.VK_RIGHT) {
			this.right();
			if (this.isDash() == true) {
				this.dash(0);
				this.setDash(false);
			}
		}
		if (code == KeyEvent.VK_LEFT) {
			this.left();
			if (this.isDash() == true) {
				this.dash(1);
				this.setDash(false);
			}
		}

	}

	@Override
	public void draw(Graphics g, Screen s) {
		this.draw(g);
	}

	private BufferedImage image2;
	private double velx = 25;
	private boolean dash;
	private int xs;
	private int ys = 380;

}
