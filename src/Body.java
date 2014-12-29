import java.awt.Color;
import java.awt.Graphics;

public class Body {
	private Point start;
	private Point center;
	private int width;
	private int height;
	private Color color;
	private int speedX;
	private int speedY;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;

	public Body(int x, int y, int width, int height, Color color, int speedX,
			int speedY, int minX, int minY, int maxX, int maxY) {
		start = new Point(x, y);
		center = new Point(x + (width / 2), y + (height / 2));
		this.width = width;
		this.height = height;
		this.color = color;
		this.speedX = speedX;
		this.speedY = speedY;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	public void draw(Graphics g) {
		move();
		g.setColor(color);
		return;
	}

	public Point getStart() {
		return start;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return start.getX();
	}

	public int getY() {
		return start.getY();
	}

	public boolean checkCollision(Body other) {
		int distance = this.center.getDistance(other.center);
		if (distance > (this.height / 2) + (other.height / 2)
				&& (distance > (this.width / 2) + (other.width / 2)))
			return false;
		return true;
	}

	private void move() {
		if (this.start.getX() + this.width >= maxX && speedX > 0)
			speedX = 0;
		if (this.start.getX() <= minX && speedX < 0)
			speedX = 0;
		if (this.start.getY() + this.height >= maxY && speedY > 0)
			speedY = 0;

		if (this.start.getY() <= 0 && speedY < 0)
			speedY = 0;

		this.start.move(speedX, speedY);
		this.center.move(speedX, speedY);
	}
}
