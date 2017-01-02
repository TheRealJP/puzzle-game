package game;

import java.util.HashMap;

import javafx.scene.image.Image;

/**
 * The ImageFactory loads and caches all of the stock images for use in the
 * game game.
 * 
 * @author Juan Ortiz
 * @since 8/17/2016
 */
public final class ImageFactory {
	/** The single instance of this class */
	private static ImageFactory single = new ImageFactory();

	/**
	 * Get the single instance of this class
	 * 
	 * @return The single instance of this class
	 */
	public static ImageFactory get() {
		return single;
	}

	/** The cached image map, from reference to image instance */
	private HashMap<String, Image> images = new HashMap<String, Image>();

	/**
	 * Retrieve a sprite from the store
	 * 
	 * @param ref
	 *            The reference to the image to use for the sprite
	 * @return A sprite instance containing an accelerate image of the request
	 *         reference
	 * @throws InputStreamException
	 */
	public Image getSprite(String ref) {
		if (images.get(ref) != null) {
			return images.get(ref);
		}
		
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("images/" + ref));
		images.put(ref, image);

		return image;
	}

}
