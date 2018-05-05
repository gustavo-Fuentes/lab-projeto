import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.*;
import java.awt.geom.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener, ActionListener{
    private BufferedImage image;
    Timer t = new Timer(5,this);
    double x = 330, velx = 0;
    
    public Screen(){
    	t.start();
    	addKeyListener(this);
    	setFocusable(true);
    	setFocusTraversalKeysEnabled(false); 
    	try{
            image = ImageIO.read(getClass().getResourceAsStream("/Nave.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void paint(Graphics g){
    	super.paint(g);
        g.drawImage(image,330,440,image.getWidth()/6,image.getHeight()/6,null);
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
        x += velx;    	
    }
    public void left(){
    	velx = -1.5;
    }
    
    public void right(){
    	velx = 1.5;
    }
    public void keyPressed(KeyEvent e){
    	int code = e.getKeyCode();
    	if(code == KeyEvent.VK_RIGHT){
    		right();
    	}
    	if(code == KeyEvent.VK_LEFT){
    		left();
    	}
    	
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}