import javax.swing.JFrame;


@SuppressWarnings("serial")
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
		new Frame();
	}

}
