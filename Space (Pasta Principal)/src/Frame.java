import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Frame extends JFrame {
	Screen s;
	JFrame f;

	public Frame() {
		f = new JFrame();
		s = new Screen();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.setResizable(false);
		f.setTitle("Spicy Invaders");
		f.setLocationRelativeTo(null);
		f.add(s);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Frame x = new Frame();
	}

}
