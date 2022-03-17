public class Scroller {
	private float x, y;
	/**
	 * Constructor for scroller object
	 * @param x - x position
	 * @param y - y position
	 */
	public Scroller(float x, float y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Method to set the x and y position of the game camera
	 * bared on the position of the specified object
	 * @param obj - object within the game
	 */
	public void tick(GameObj obj) {
		x += ((obj.getX() - x) - 1000/2) * 0.05f;
		y += ((obj.getY() - y) - 563/2) * 0.05f;
		if(x <= 0) {
			x = 0;
		}
		if(x >= 1032) {
			x = 1032;
		}
		if(y <= 0) {
			y = 0;
		}
		if(y >= 563+48) {
			y = 563 + 48;
		}
		
	}
	/**
	 * Getter for x position
	 * @return - x posiiton
	 */
	public float getX() {
		return x;
	}
	/**
	 * Setter for x position
	 * @param x - value of x position
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * Getter for y position
	 * @return - y position
	 */
	public float getY() {
		return y;
	}
	/**
	 * Setter for y position
	 * @param y - value of y position
	 */
	public void setY(float y) {
		this.y = y;
	}

}
