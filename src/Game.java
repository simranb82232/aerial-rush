import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
/**
 * 
 * The Game class instantiates game objects, renders objects,
 * loads game screen and runs game
 *
 */
public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private Thread thread;
	private ObjectHandler objHandler;
	private Scroller scroller;
	private Sprite s;
	private Sprite sPlane;
    private	BufferedImage level = null;
    private BufferedImage sprite_sheet = null;
    private BufferedImage sprite_sheet_plane = null;
    private BufferedImage sky = null;
    private BufferedImage sprite_sheet_cloud = null;
    private BufferedImage sprite_building_sheet = null;
    private Sprite buildingSprite = null;
    private Sprite cloudSprite = null;
    private BufferedImage sprite_sheet_enemy_plane = null;
    private Sprite enemySprite = null;
    private BufferedImage sprite_sheet_over = null;
    private Sprite over = null;
    public int planeAmmo = 30;
    public int health_plane = 100;
    /**
     * Constructor for game class
     * Creates a window for the game
     * Instantiates object for level
     * Allows for keyboard and mouse listening
     */
	public Game() {
		new Window(1000, 563, "Airplane Rush", this);
		start();
		
		objHandler = new ObjectHandler();
		scroller = new Scroller(0, 0);
		
		this.addKeyListener(new Input(objHandler));
		
		LoadImage load = new LoadImage();
		level = load.loadImage("/LEVEL_NEW_NEW_NEW.png");
		sprite_sheet = load.loadImage("/sprite_sheet_final.png");
		sprite_sheet_plane = load.loadImage("/Airplane.png");
		sprite_sheet_cloud = load.loadImage("/cloud_final.png");
		sprite_building_sheet = load.loadImage("/building_sprite.png");
		sprite_sheet_enemy_plane = load.loadImage("/enemy_plane_sheet.png");
		sprite_sheet_over = load.loadImage("/game_over.png");
		over = new Sprite(sprite_sheet_over);
		enemySprite = new Sprite(sprite_sheet_enemy_plane);
		buildingSprite = new Sprite(sprite_building_sheet);
		cloudSprite = new Sprite(sprite_sheet_cloud);
		s = new Sprite(sprite_sheet);
		sPlane = new Sprite(sprite_sheet_plane);
		sky = s.findImage(4, 2, 32, 32);
		
		
		this.addMouseListener(new Mouse(objHandler, scroller, this, s));
		loadLevel(level);
	}
	/**
	 * Method to start the thread of the game
	 */
	private void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * Method to stop the thread of the game
	 */
	private void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to update the computer time and the time within the game
	 */
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	/**
	 * Method to update the back end (state) of all the objects
	 */
	public void tick() {	
		for(int i = 0; i < objHandler.object.size(); i++) {
			if(objHandler.object.get(i).getId() == ID.Plane) {
				scroller.tick(objHandler.object.get(i));
			}
		}
		objHandler.tick();
	}
	/**
	 * Method to update the back end (visual representation) of all the objects
	 */
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		//DRAW
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1000, 563);
		
		g2d.translate(-scroller.getX(), -scroller.getY());
		for(int i = 0; i < 32*72; i+=32) {
			for(int j = 0; j < 32*72; j++) {
				g.drawImage(sky, i, j, null);
			}
		}
		
		objHandler.render(g);
		g2d.translate(scroller.getX(), scroller.getY());
		g.setColor(Color.gray);
		g.fillRect(10, 5, 200, 32);
		g.setColor(Color.green);
		g.fillRect(10, 5, health_plane*2, 32);
		g.setColor(Color.black);
		g.drawRect(10, 5, 200, 32);
		
		g.setColor(Color.white);
		g.drawString("Ammo: " + planeAmmo, 50, 60);
		
		//HERE
		g.dispose();
		bs.show();
		
	}
	/**
	 * A helper method to load in images of oject
	 * @param image - image of object to be created
	 * Checks for RBG value of image and adds a new object
	 * to objectHandler based on result of conditional
	 */
	private void loadLevel(BufferedImage image)
	{	
		int w = image.getWidth();
		int h = image.getHeight();
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				int pixel = image.getRGB(i, j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255) {
					objHandler.addObject(new Block(i * 32, j * 32, ID.Block, s));
				}
				if(blue == 255 && green == 0) {
					objHandler.addObject(new Plane(i * 32, j * 32, ID.Plane, objHandler, this, sPlane));
				}
				if(green == 255 && blue == 0) {
					objHandler.addObject(new EnemyPlane(i * 32, j * 32, ID.EnemyPlane, objHandler, enemySprite));
				}
				if(green == 255 && blue == 255) {
					objHandler.addObject(new Cloud(i * 32, j * 32, ID.Cloud, cloudSprite));
				}
				if(green == 120 && blue == 100 && red == 110) {
					objHandler.addObject(new Building(i * 32, j * 32, ID.Building, buildingSprite));
				}
				
			}
		}
		
	}
	/**
	 * Runs the game method
	 * @param args - driver arguments
	 */
	public static void main(String[] args) {
		new Game();
	}
}
