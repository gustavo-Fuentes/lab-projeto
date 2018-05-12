import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener, ActionListener{
    private BufferedImage image;
    private BufferedImage background;
    private BufferedImage meteoro;
    private Image asteroide;
    Timer t = new Timer(5,this);
    int x = 340; 
    double velx = 25;
    int y = 440;
    int xm = (int)(Math.random()*700+50);
    int ym= -100;
    
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
    	try{
            background = ImageIO.read(getClass().getResourceAsStream("/background.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
    	try{
            meteoro = ImageIO.read(getClass().getResourceAsStream("/Asteroid.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    	/**try{
    		asteroide = new ImageIcon(new URL("https://opengameart.org/sites/default/files/rock_01_loop.gif")).getImage();
    	}catch(IOException e){
    		e.printStackTrace();
    	}**/
    	 int delay = 5; //milliseconds
    	  ActionListener taskPerformer = new ActionListener() {
    	      public void actionPerformed(ActionEvent evt) {
    	    	  	recalcula();
    	    	  	repaint();
    	    	  	movimento();
    	      }
    	  };
    	  new Timer(delay, taskPerformer).start();
    	
    }
    
    void recalcula(){
    	
    }
    
    public void paint(Graphics g){
    	super.paint(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(image,x,y,image.getWidth()/6,image.getHeight()/6,null);
        g.drawImage(meteoro, xm, ym,meteoro.getWidth()/3,meteoro.getHeight()/3,this);
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    public void movimento(){
    	ym += 1; 
    }
    
    public void left(){
    	if(x-(image.getWidth()/6)+90<0){}
    	else{
    		x += -1.5*velx;
    	}
    }
    
    public void right(){
    	if(x+(image.getWidth()/6)+30>800){}
    	else{
    	x += +1.5*velx;
    	}
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
