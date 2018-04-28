package frame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel{
    private BufferedImage image;
    
    public Screen(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Nave.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        repaint();
    }
    public void paint(Graphics g){
        g.drawImage(image,100,100,null);
    }
}