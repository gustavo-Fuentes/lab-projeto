import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public abstract class Entity {
	public Entity(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract void movimento();

	public abstract void draw(Graphics g, Screen s);

	public void keyPressed(KeyEvent e, Player p) {
	}

	/*
	 * boolean colidiu(Entity e) { return Math.sqrt((e.x * e.x - this.x * this.x) +
	 * (e.y * e.y - this.y * this.y)) < 10; }
	 */

	boolean colidiu(Entity e) {
		if (e.x <= this.x+this.getImage().getWidth()/6 & e.x+e.getImage().getWidth()/6 >= this.x & e.y+e.getImage().getHeight()/6 >= this.y)
			return true;
		else
			return false;

	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	protected int x;
	protected int y;
	protected int id;
	protected BufferedImage image;

}
