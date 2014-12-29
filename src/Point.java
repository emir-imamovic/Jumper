public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDistance(Point other) {
		int result, dx, dy;
		dx = (int) (Math.pow(other.x - this.x, 2));
		dy = (int) (Math.pow(other.y - this.y, 2));
		result = (int) (Math.sqrt(dx) + Math.sqrt(dy));
		return result;
	}

	public void move(int speedX, int speedY) {

		this.x += speedX;
		this.y += speedY;

	}
}
