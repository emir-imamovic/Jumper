import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameGraphics extends JPanel implements ActionListener {
	private Timer animation;
	Body[] elements;
	int elementCount;
	int width;
	int height;

	public GameGraphics(int width, int height) {
		super();
		animation = new Timer(17, this);
		elements = new Body[3];
		elementCount = 0;
		// ovo smo stavili radi debuging-a
		elementCount = 1;
		elements[0] = new Oval(0, 0, 20, 30, Color.RED, 10, 10, 0, 0, 500, 400);
		animation.start();
		this.width = width;
		this.height = height;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(184, 242, 245));
		g.setColor(new Color(54, 140, 22));
		g.fill3DRect(0, height - 100, width + 1000, height, true);
		for (int i = 0; i < elementCount; i++) {
			elements[i].draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
// treba imat set width i setHeight zbog promjene prozora
