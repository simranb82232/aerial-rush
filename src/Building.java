import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 * 
 * Building class creates a building object
 *
 */
public class Building extends GameObj{
	private BufferedImage building_img;
	/**
	 * Constructor for the building object
	 * @param x - object's x position
	 * @param y - - object's y position
	 * @param id - identifier of object
	 * @param s - sprite of Building
	 */
	public Building(int x, int y, ID id, Sprite s) {
		super(x, y, id, s);
		building_img = s.findImage(1, 1, 96, 192);
	}
	/**
	 * Extended from GameObject
	 */
	public void tick() {
	
		
	}
	/**
	 * Method to draw the building object
	 * @param - graphics Object
	 */
	public void render(Graphics g) {
		g.drawImage(building_img, x, y, null);
	}
	/**
	 * Method to get the bounds of the object
	 * @return - a rectangle to the size of the bounds of the object
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 96, 192);
	}

}
