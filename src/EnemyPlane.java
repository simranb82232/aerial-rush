import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * 
 * EnemyPlane class creates and moves a enemy plane object 
 *
 */
public class EnemyPlane extends GameObj {
	private ObjectHandler objHandler;
	Random r = new Random();
	int pick = 0;
	int health = 100;
	int posX;
	int posY;
	private BufferedImage enemyPlane;
	/**
	 * Constructor for the Enemy Plane
	 * @param x - Enemy Plane's x position
	 * @param y - Enemy Plane's y position
	 * @param id - identifier for enemy plane
	 * @param objHandler - handles all objects in the game
	 * @param s - sprite for enemy plane
	 */
	public EnemyPlane(int x, int y, ID id, ObjectHandler objHandler, Sprite s) {
		super(x, y, id, s);
		this.objHandler = objHandler;
		enemyPlane = s.findImage(1, 1, 64, 64);

	}
	/**
	 * Overridden tick method 
	 * Checks whether the enemy plane will crashes into building objects
	 * If it will crash, the velocity is adjusted so it wont crash
	 * If the enemy plane is hit with a rocket, its object is removed
	 */
	public void tick() {
		x += velX;
		y += velY;

		pick = r.nextInt(10);
		for (int i = 0; i < objHandler.object.size(); i++) {
			GameObj tempO = objHandler.object.get(i);
			if (tempO.getId() == ID.Block || tempO.getId() == ID.Building) {
				if (getBoundsSecond().intersects(tempO.getBounds())) {
					x += (velX * 5) * -1;
					y += (velY * 5) * -1;
					velX *= -1;
					velY *= -1;
				} else if (pick == 0) {
					velX = (r.nextInt(4 - -4) + -4);
					velY = (r.nextInt(4 - -4) + -4);
				}
			}
			if (tempO.getId() == ID.Rocket) {
				if (getBounds().intersects(tempO.getBounds())) {
					health -= 100;
					objHandler.removeObject(tempO);
				}
			}
		}
		
		if(health <= 0) {
			objHandler.removeObject(this);
		}

	}
	/**
	 * Method to draw the enemy plane object
	 * @param - graphics Object
	 */
	public void render(Graphics g) {
		g.drawImage(enemyPlane, x, y, null);
	}
	/**
	 * Method to get the bounds of the enemy plane
	 * @return - a rectangle to the size of the bounds of the object
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}
	/**
	 * Method to get the bounds of the enemy plane after it has moved
	 * @return - a rectangle to the size so that bounds of current location
	 * and previous location are included
	 */
	public Rectangle getBoundsSecond() {
		return new Rectangle(x - 32, y - 32, 128, 128);
	}
	

}
