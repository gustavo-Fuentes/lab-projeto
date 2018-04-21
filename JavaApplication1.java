/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;


abstract class Engine{
    Timer t=new Timer();

    public Engine() {
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                recalcula();
            }
        }, new Date(), 1000);
    }
    
    abstract void onChange();
    
    void recalcula(){
        System.out.println("teste");
        onChange();
    }
}


/**
 *
 * @author unifgnascimento
 */
class Visualizador extends Frame {

    Timer t = new Timer();
    Engine e;
    
    public Visualizador(Engine e) throws HeadlessException {
        
        this.e = new Engine() {
            @Override
            void onChange() {
                repaint();
            }
        };
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setSize(300,300);        
    }

    @Override
    public void paint(Graphics g) {
        
        g.drawLine(0, 0, 100, 100);
        
    }

}

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Visualizador f = new Visualizador();

        f.setVisible(true);
    }

}
