import java.awt.Image;
import javax.swing.ImageIcon;


public class Enemy extends Entity {
	public Enemy(int x,int y,Image img){
		super(x,y, img);
		try{
			img = new ImageIcon(this.getClass().getResource("spicy.png")).getImage();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}

