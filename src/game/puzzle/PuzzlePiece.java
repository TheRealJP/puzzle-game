package game.puzzle;

import javafx.scene.image.Image;

/**
 * A single piece of the {@link Puzzle}.
 * 
 * @author Juan Ortiz <http://github.com/TheRealJP>
 */
public class PuzzlePiece {

	/** The current position of this game piece. */
	private Position position;

	/** The image of this {@code PuzzlePiece}. */
	private Image image;

	public PuzzlePiece(Image image) {
		this.setImage(image);
		this.setPosition(new Position((int) image.getWidth(), (int) image.getHeight()));
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
