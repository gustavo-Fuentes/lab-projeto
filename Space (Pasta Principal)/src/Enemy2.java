import javax.swing.ImageIcon;

public class Enemy2 extends Enemy {

	public Enemy2(int x, int y) {
		super(x, y);
		setUrl(this.getClass().getResource("evilspicy.png"));
		try {
			 setIcon(new ImageIcon(url).getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
