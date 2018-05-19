import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
	public Player(int x, int y) {
		super(x, y);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Nave.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	private BufferedImage image;
}
