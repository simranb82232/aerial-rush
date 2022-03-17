import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * 
 * Input class handles all the keyboard user input
 *
 */
public class Input extends KeyAdapter{
	
	ObjectHandler objHandler;
	/**
	 * Constructor for the Input class
	 * @param objHandler - handles all objects within game
	 */
	public Input(ObjectHandler objHandler) {
		this.objHandler = objHandler;
	}
	/**
	 * Method to check if a WASD key was pressed
	 * If the key was pressed, the plane moves towards that direction
	 * @param - parameter that indicates a keystroke has been made
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < objHandler.object.size(); i++) {
			GameObj tempO = objHandler.object.get(i);
			if(tempO.getId() == ID.Plane) {
				if(key == KeyEvent.VK_W) {
					objHandler.setUp(true);
				} if(key == KeyEvent.VK_A) {
					objHandler.setLeft(true);
				} if(key == KeyEvent.VK_S) {
					objHandler.setDown(true);
				} if(key == KeyEvent.VK_D) {
					objHandler.setRight(true);
				}
				
			}
		}
	}
	/**
	 * Method to check is a WASD key was released
	 * If key was released, the plane stops moving in that direction
	 * @param - parameter that indicates a keystroke has been made
	 */
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		for(int i = 0; i < objHandler.object.size(); i++) {
			GameObj tempO = objHandler.object.get(i);
			if(tempO.getId() == ID.Plane) {
				if(key == KeyEvent.VK_W) {
					objHandler.setUp(false);
				} if(key == KeyEvent.VK_A) {
					objHandler.setLeft(false);
				} if(key == KeyEvent.VK_S) {
					objHandler.setDown(false);
				} if(key == KeyEvent.VK_D) {
					objHandler.setRight(false);
				}
				
			}
		}
		
	}
}
