import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 * 
 * Block class creates a block object for the game
 *
 */
public class Block extends GameObj{
	/**
	 * Constructor to create block object
	 * @param x - object's x position
	 * @param y - object's y position
	 * @param id - identifier for specific object
	 * @param s - object image in form of sprite
	 */
	public Block(int x, int y, ID id, Sprite s) {
		super(x, y, id, s);
	}
	/**
	 * 
	 * Extended from GameObject
	 */
	public void tick() {
		
	}
	/**
	 * Method to draw the block
	 * @param g - graphics Object
	 */
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
	}
	/**
	 * Method to get the bounds of the object
	 * @return - a rectangle with the bounds of the object
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
