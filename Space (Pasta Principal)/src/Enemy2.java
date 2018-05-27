import java.awt.Graphics;

import javax.imageio.ImageIO;

public class Enemy2 extends Enemy {

	public Enemy2(int x, int y, int id) {
		super(x, y, id);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(
					"/evilspicy.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void movimento() {
		y += 2;
	}

	@Override
	public void draw(Graphics g, Screen s) {
		g.drawImage(getImage(), getX(), getY(), getImage().getWidth() / 6, getImage().getHeight() / 6, s);

	}
}
