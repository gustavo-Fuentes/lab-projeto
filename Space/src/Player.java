import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
	public Player(int x,int y){
		super(x,y);
		
		try{
			image = ImageIO.read(getClass().getResourceAsStream("/Nave.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}		