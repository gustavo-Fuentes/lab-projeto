import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy extends Entity {
	public Enemy(int x, int y) {
		super(x, y);
		setUrl(this.getClass().getResource("spicyspace.png"));
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

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}


	protected URL url;
	private Image icon;

}
