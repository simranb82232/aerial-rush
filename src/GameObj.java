import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * 
 * Abstract class that creates a general template for all game objects
 *
 */
public abstract class GameObj {
	
	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ID id;
	protected Sprite s;
	/**
	 * Constructor to be used by all objects
	 * @param x - object's x position
	 * @param y - object's y position
	 * @param id - identifier for specific object
	 * @param s - object image in form of sprite
	 */
	public GameObj(int x, int y, ID id, Sprite s) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.s = s;
	}
	/**
	 * Abstract tick method to constantly update object
	 */
	public abstract void tick();
	/**
	 * Abstract method to render an object
	 * @param g - graphics Object
	 */
	public abstract void render(Graphics g);
	/**
	 * Abstract method to get bounds of an object
	 * @return - returns a rectangle mask for bounds of object
	 * Used in collision
	 */
	public abstract Rectangle getBounds();
	/**
	 * Getter for x position
	 * @return - x position
	 */
	public int getX() {
		return x;
	}
	/**
	 * Getter for identifier
	 * @return - ID of specific object
	 */
	public ID getId() {
		return id;
	}
	/**
	 * Setter for ID
	 * @param id - value of ID
	 */
	public void setId(ID id) {
		this.id = id;
	}
	/**
	 * Setter for x position
	 * @param x - value of x position of object
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Getter for y position
	 * @return - y position of object
	 */
	public int getY() {
		return y;
	}
	/**
	 * Setter for y position
	 * @param y - value of y position of object
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Getter for x velocity of object
	 * @return - gets velocity in the x direction
	 */
	public float getVelX() {
		return velX;
	}
	/**
	 * Setter for x velocity of object
	 * @param velX - value of velocity in the x direction
	 */
	public void setVelX(float velX) {
		this.velX = velX;
	}
	/**
	 * Getter for the y velocity of object
	 * @return - returns velocity in the y direction
	 */
	public float getVelY() {
		return velY;
	}
	/**
	 * Setter for the y velocity of object
	 * @param velY - value of velocity in the y direction
	 */
	public void setVelY(float velY) {
		this.velY = velY;
	}

}
