import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Enemy extends Entity {
	public Enemy(int x, int y) {
		super(x,y);
		try {
			 setIcon(new ImageIcon(url).getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Image getIcon() {
		return icon;
	}
	public void setIcon(Image icon) {
		this.icon = icon;
	}
	private URL url = this.getClass().getResource("spicy.png");
	private Image icon;

}
