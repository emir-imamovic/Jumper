import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameGraphics extends JPanel implements ActionListener {
	private Body player;
	private Timer animation;
	Body[] elements;
	int elementCount;
	int width;
	int height;

	public GameGraphics(int width, int height) {
		super();
		animation = new Timer(17, this);
		elements = new Body[10];
		elementCount = 0;
		// ovo smo stavili radi debuging-a
		player = new Oval(250, 370, 20, 30, Color.RED, 0, 0, 0, 0, 500, 400);
		for (int i = 0; i < 10; i++)

		{

			elements[i] = new Rect(1000, 550, 20 + (int) (Math.random() * 50),
					20 + (int) (Math.random() * 75), Color.BLUE, -1
							- (int) (Math.random() * 10), 0,
					800 + (int) (Math.random() * 3500), 600, -100, -100);

		}
		animation.start();
		this.width = width;
		this.height = height;
		addKeyListener(new KeyHandler());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(184, 242, 245));
		g.setColor(new Color(54, 140, 22));
		g.fill3DRect(0, height - 100, width + 1000, height, true);
		player.draw(g);
		
		

		boolean stop = false;

		for (int i = 0; i < elements.length; i++)

		{

			elements[i].draw(g);

			elements[i].reset();

			if (stop == false)

				stop = player.checkCollision(elements[i]);

		}

		g.setColor(Color.GREEN);

		g.fillRect(0, 600, width + 1500, height);

		if (stop == true) {

			animation.stop();

			JOptionPane.showMessageDialog(null, "Izgubio si", "Prozor",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	private class KeyHandler extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent k) {
			player.jump();
		}
	}
}
// treba imati set width i setHeight zbog promjene prozora
