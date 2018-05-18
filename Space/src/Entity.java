import java.awt.Image;
import java.awt.image.BufferedImage;


public class Entity {
	public Entity(int x,int y) {
		this.x = x;
		this.y = y;
	}

	public Entity(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		Entity.image = image;
	}

	public Entity(int x, int y, Image img) {
		this.x = x;
		this.y = y;
		this.img = img;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	public BufferedImage getImage() {
		return image;
	}
	public Image getImg() {
		return img;
	}
	
	protected int x;
	protected int y;
	protected static BufferedImage image;
	protected Image img;
}
