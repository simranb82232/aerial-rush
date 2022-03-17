import java.awt.image.BufferedImage;
/**
 * 
 * Sprite class that allows for the reading in 
 * of sprite images and scaling of sprites
 *
 */
public class Sprite {
private BufferedImage image;
/**
 * Constructor for the sprite
 * @param image - image with Sprite
 */
public Sprite(BufferedImage image) {
	this.image = image;
}
/**
 * Method to get sub image from the image 
 * Used to help scale up sprites
 * @param col - column within image
 * @param row - row within image
 * @param width - width of sub image
 * @param height - height of sub image
 * @return - returns the sub image
 */
public BufferedImage findImage(int col, int row, int width, int height) {
	return image.getSubimage((col*32)-32, (row*32)-32, width, height);
}

}
