import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public abstract class Entity {
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
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

	public Rectangle getImageBound() {
		return imageBound;
	}

	public void setImageBound(Rectangle imageBound) {
		this.imageBound = imageBound;
	}

	public abstract void movimento();

	public abstract void draw(Graphics g, Screen s);

	public void keyPressed(KeyEvent e) {
	}

	boolean colidiu(Entity e) {
		return Math.sqrt((e.x * e.x - this.x * this.x)
				+ (e.y * e.y - this.y * this.y)) < 10;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	protected int x;
	protected int y;
	protected Rectangle imageBound;
	protected BufferedImage image;

}
