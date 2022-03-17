import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 * 
 * Plane class creates and controls aspects of user plane object
 *
 */
public class Plane extends GameObj{
	ObjectHandler objHandler;
	Game game;
	private BufferedImage plane_img;
	private BufferedImage game_over;
	/**
	 * Constructor for plane object
	 * @param x - x position of user plane
	 * @param y - y position of user plane
	 * @param id - identifier for plane object
	 * @param objHandler - handles all objects in game
	 * @param game - current game
	 * @param s - sprite for user plane
	 */
	public Plane(int x, int y, ID id, ObjectHandler objHandler, Game game, Sprite s) {
		super(x, y, id, s);
		this.objHandler = objHandler;
		this.game = game;
		plane_img = s.findImage(1, 1, 64, 64);
	
	}
	/**
	 * Method to constantly update the position and velocity of plane
	 * Takes into account collision
	 * Based on WASD keys, sets the velocity in x and y direction
	 */
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		if(objHandler.isRight()) {
			velX = 5;
		} else if (!objHandler.isLeft()) {
			velX = 0;
		}
		
		if(objHandler.isLeft()) {
			velX = -5;
		} else if (!objHandler.isRight()) {
			velX = 0;
		}
		
		if(objHandler.isDown()) {
			velY = 5;
		} else if (!objHandler.isUp()) {
			velY = 0;
		}
		
		if(objHandler.isUp()) {
			velY = -5;
		} else if (!objHandler.isDown()) {
			velY = 0;
		}
		
		
	}
	/**
	 * Method to check for collision with various objects
	 * If user plane collides with building or block objects, it dies
	 * and object is removed
	 * If user plane collides with cloud, health and ammo are incremented
	 * If user plane collides with enemy plane, health is decreased
	 * linearly and plane is checked to see if it is dead
	 */
	private void collision() {
		for(int i = 0; i < objHandler.object.size(); i++) {
			GameObj tempO = objHandler.object.get(i);
			if(tempO.getId() == ID.Block || tempO.getId() == ID.Building) {
				if(getBounds().intersects(tempO.getBounds())) {
					x += velX * -1;
					y += velY * -1;
					game.health_plane -= 100;
					objHandler.removeObject(this);
				}
			}
			if(tempO.getId() == ID.Cloud) {
				if(getBounds().intersects(tempO.getBounds())) {
					game.planeAmmo += 10;
					checkFullHealth();
					objHandler.removeObject(tempO);
				}
			}
			if(tempO.getId() == ID.EnemyPlane) {
				if(getBounds().intersects(tempO.getBounds())) {
					game.health_plane--;
					dead();
					
					
				}
			}
			
		}
	}

	/**
	 * Method to draw the plane object
	 * @param - graphics Object
	 */
	public void render(Graphics g) {
		g.drawImage(plane_img, x, y, null);
	}
	/**
	 * Method to get the bounds of the plane
	 * @return - a rectangle to the size of the bounds of the object
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 54, 54);
	}
	/**
	 * Method to check if plane is dead
	 * Checks if plane health is less than or equal to 0
	 * @return - true/false based on conditional
	 */
	public boolean dead() {
		if(game.health_plane <= 0) {
			
			objHandler.removeObject(this);
			return true;
		}
		return false;
	}
	/**
	 * Method to check the health level of the plane
	 * Used when plane intersects with clouds
	 * The method makes sure health never goes over 100
	 * 
	 */
	public void checkFullHealth() {
		if(game.health_plane > 90) {
			game.health_plane = 100;
			
		} else if(game.health_plane <= 90){
			game.health_plane += 10;
		}
		
	}
	
	

}
