package frame;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame{
    Screen s;
    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,480);
        setResizable(false);
        setTitle("Projeto");
        
        init();
    }
    public void init(){
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 1, 0, 0));
        
        s = new Screen();
        add(s);
        setVisible(true);
    }
    public static void main(String[] args) {
     Frame x = new Frame();
    }
    
}
