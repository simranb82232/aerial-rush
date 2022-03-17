import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * Load Image class gets the exact path of
 * the buffered image that is being read in and returns that image
 *
 */
public class LoadImage {
	private BufferedImage image;
	/**
	 * Constructor for the LoadImage class
	 * Checks if a path exists (try/catch)
	 * @param path - path for the image
	 * @return - returns a buffered image
	 */
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return image;
	}

}
