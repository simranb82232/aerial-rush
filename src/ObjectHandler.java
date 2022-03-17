import java.awt.Graphics;
import java.util.LinkedList;
/**
 * 
 * Object Handler class handles all the objects within the class
 * Creates a linked list which holds all objects and constantly updates
 * the state of those objects
 *
 */
public class ObjectHandler {
	LinkedList<GameObj> object = new LinkedList<GameObj>();
	private boolean up = false, down = false, right = false, left = false;
	/**
	 * Method to update the state of every object in the game
	 * Creates a temporary game object while iterating
	 * through the list of objects
	 */
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObj tempO = object.get(i);
			tempO.tick();
		}
	}
	/**
	 * Method to render the image of every object in the game
	 * @param g - graphics Object
	 */
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObj tempO = object.get(i);
			tempO.render(g);
		}
	}
	/**
	 * Method to check if up direction of object
	 * @return - returns true/false
	 */
	public boolean isUp() {
		return up;
	}
	/**
	 * Method to set up direction of object
	 * @param up - true/false if object is moving up
	 */
	public void setUp(boolean up) {
		this.up = up;
	}
	/**
	 * Method to check down direction of object
	 * @return - returns true/false
	 */
	public boolean isDown() {
		return down;
	}
	/**
	 * Method to set down direction of object
	 * @param down - true/false if object is moving down
	 */
	public void setDown(boolean down) {
		this.down = down;
	}
	/**
	 * Method to check right direction of object
	 * @return - returns true/false
	 */
	public boolean isRight() {
		return right;
	}
	/**
	 * Method to set right direction of object
	 * @param right - true/false if object is moving right
	 */
	public void setRight(boolean right) {
		this.right = right;
	}
	/**
	 * Method to check left direction of object
	 * @return - returns true/false
	 */
	public boolean isLeft() {
		return left;
	}
	/**
	 * Method to set left direction of object
	 * @param left - true/false if object is moving left
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}
	/**
	 * Method to add new object to list of objects
	 * @param tempO - temporary game object
	 */
	public void addObject(GameObj tempO) {
		object.add(tempO);
	}
	/**
	 * Method to remove objects from list of objects
	 * @param tempO - temporary game object
	 */
	public void removeObject(GameObj tempO) {
		object.remove(tempO);
	}

}
