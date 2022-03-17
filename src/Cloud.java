import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 * 
 * Cloud class creates a cloud object
 *
 */
public class Cloud extends GameObj{
	private BufferedImage cloud_img;
	/**
	 * Constructor for cloud object
	 * @param x - cloud's x position
	 * @param y - cloud's y position
	 * @param id - identifier for cloud
	 * @param s - sprite image of cloud
	 */
	public Cloud(int x, int y, ID id, Sprite s) {
		super(x, y, id, s);
		cloud_img = s.findImage(1, 1, 64, 64);
	}
	/**
	 * Extended from game object
	 */
	public void tick() {
		
	}
	/**
	 * Method to draw the cloud object
	 * @param - graphics Object
	 */
	public void render(Graphics g) {
		g.drawImage(cloud_img, x, y, null);
	}
	/**
	 * Method to get the bounds of the cloud
	 * @return - a rectangle to the size of the bounds of the object
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}

}
