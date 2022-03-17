import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
/**
 * 
 *  Mouse class handles all the mouse user input
 *
 */
public class Mouse extends MouseAdapter {
	private ObjectHandler objHandler;
	private Scroller scroller;
	private Game game;
	private BufferedImage rocket_sprite = null;
    private Sprite rocketSprite = null;
    /**
     * Constructor for the mouse object
     * Loads in a rocket sprite image
     * @param objHandler - handles all objects in game
     * @param scroller - passes in the scroller class which controls 
     * plane player around the map
     * @param game - current game object
     * @param s - image of rocket sprite
     */
	public Mouse(ObjectHandler objHandler, Scroller scroller, Game game, Sprite s) {
		this.objHandler = objHandler;
		this.scroller = scroller;
		this.game = game;
		LoadImage loader = new LoadImage();
		s = rocketSprite;
		rocket_sprite = loader.loadImage("/new_rocket_sheet.png");
		rocketSprite = new Sprite(rocket_sprite);
	}
	/**
	 * Method to fire ammo using a mouse
	 * Checks if plane exists and plane has ammo
	 * Shoots the rocket and adds the rocket to the object handler list
	 * Reduces the ammo of the user plane
	 */
	public void mousePressed(MouseEvent e) {
		int xx = (int) (e.getX() + scroller.getX());
		int yy = (int) (e.getY() + scroller.getY());
		
		for(int i = 0; i < objHandler.object.size(); i++) {
			GameObj tempO = objHandler.object.get(i);
			if(tempO.getId() == ID.Plane && game.planeAmmo >= 1) {
				objHandler.addObject(new Rocket(tempO.getX() + 16, tempO.getY() + 24, ID.Rocket, objHandler, xx, yy, rocketSprite));
				game.planeAmmo--;
			}
		}
	}

}
