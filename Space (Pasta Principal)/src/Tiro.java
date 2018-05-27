import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tiro extends Entity {

	public Tiro(int x, int y) {
		super(x, y, 1);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Green_laser.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void movimento() {
		if (shooting == true) {
			y-=20;
			if (y== -200) {
				shooting = false;
				y = -1000;
				cooldown = false;
			}
		}
	}

	@Override
	public void draw(Graphics g, Screen s) {
		if (shooting == true) {
			g.drawImage(getImage(), x+43, y, getImage().getWidth() / 6, getImage().getHeight() / 6, s);
		}
	}

	public void keyPressed(KeyEvent e, Player p) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SPACE) {
			shooting = true;
			if (cooldown == false) {
				this.setX(p.getX());
				this.setY(380);
				cooldown = true;
			}
		}
	}
	
	private boolean shooting = false;
	private boolean cooldown = false;
}
