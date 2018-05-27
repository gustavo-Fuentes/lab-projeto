import java.awt.Graphics;


import javax.imageio.ImageIO;


public class Enemy extends Entity {
	public Enemy(int x, int y, int id) {
		super(x, y, id);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/spicyspace.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void movimento() {
		y += 2;
	}

	@Override
	public void draw(Graphics g, Screen s) {
		g.drawImage(getImage(), getX(), getY(), getImage().getWidth() / 6, getImage().getHeight() / 6, s);

	}

}
