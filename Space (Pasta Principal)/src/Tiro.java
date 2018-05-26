import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tiro extends Entity {

	public Tiro(int x, int y) {
		super(x, y);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Green_laser.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void movimento() {
		y -= 2;
	}

	@Override
	public void draw(Graphics g, Screen s) {
		g.drawImage(getImage(), x, y, getImage().getWidth() / 6, getImage().getHeight() / 6, s);
		g.drawImage(getImage(), x+80, y, getImage().getWidth() / 6, getImage().getHeight() / 6, s);
	}

	public void keyPressed(KeyEvent e) {
	}
}
