import javax.imageio.ImageIO;

public class Enemy2 extends Enemy {

	public Enemy2(int x, int y) {
		super(x, y);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(
					"/evilspicy.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
