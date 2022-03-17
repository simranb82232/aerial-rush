import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 * 
 *Rocket Class creates and updates state of the rocket object
 *
 */
public class Rocket extends GameObj{
	private ObjectHandler objHandler;
	private BufferedImage rocket;
	/**
	 * Constructor for rocket objects
	 * Creates rocket and also the velocity of rocket
	 * @param x - old x position of rocket
	 * @param y - old y position of rocket
	 * @param id - identifier for rocket object
	 * @param objHandler - handles all objects within game
	 * @param xx - new x position
	 * @param yy - new y position
	 * @param s - sprite for Rocket
	 */
	public Rocket(int x, int y, ID id, ObjectHandler objHandler, int xx, int yy, Sprite s) {
		super(x, y, id, s);
		this.objHandler = objHandler;
		velX = (xx-x)/10;
		velY = (yy-y)/10;
		rocket = s.findImage(1, 1, 16, 16);
		
	}

	@Override
	/**
	 * Overridden method to update the position of rocket
	 * Checks for collision of rocket with block or building
	 * Removes rocket object if it hits building or block
	 */
	public void tick() {
		x+=velX;
		y+=velY;
		for(int i = 0; i < objHandler.object.size(); i++) {
			GameObj tempO = objHandler.object.get(i);
			if(tempO.getId() == ID.Block || tempO.getId() == ID.Building) {
				if(getBounds().intersects(tempO.getBounds())) {
					objHandler.removeObject(this);
					
				}
			}
			
		}
	}

	@Override
	/**
	 * Method to draw the rocket object
	 * @param - graphics Object
	 */
	public void render(Graphics g) {
		g.drawImage(rocket, x, y, null);
	}

	@Override
	/**
	 * Method to get the bounds of the rocket
	 * @return - a rectangle to the size of the bounds of the object
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	
}
