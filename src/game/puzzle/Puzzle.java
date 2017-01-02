package game.puzzle;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Puzzle extends Canvas {

	/** The image of the completed puzzle. */
	private Image image;
	/** The row and column size of the puzzle used to create the game grid. */
	private int size;

	/**
	 * The puzzle mapping containing all pieces of the puzzle and their absolute
	 * positions.
	 * <li>The {@code PuzzlePiece} images are created by segmenting the
	 * completed puzzle into a square grid.
	 * <li>The absolute position of a {@code PuzzlePiece} is the position of the
	 * piece which completes the puzzle and creates the desired image.
	 */
	private Map<PuzzlePiece, Position> pieces;

	public Puzzle(Image image, int size) {
		this.image = image;
		this.pieces = new HashMap<PuzzlePiece, Position>(size);
		createPuzzle(image, size);
	}

	/** Creates a {@code size x size} puzzle of the provided image. */
	private void createPuzzle(Image image, int size) {
		// Reads the pixels of the image to be segmented.
		PixelReader reader = image.getPixelReader();
		// Width of each puzzle piece
		int width = (int) image.getWidth() / size;
		// Height of each puzzle piece
		int height = (int) image.getHeight() / size;

		// The pieces image
		WritableImage image_writer = new WritableImage(width, height);
		// Appends pixels to the image_writer
		PixelWriter pixel_writer = image_writer.getPixelWriter();

		for (int piece_count = 0; piece_count < pieces.size(); piece_count++) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {

					// Appends each pixel to the writer to create the new image.
					int color = reader.getArgb(x, y);
					pixel_writer.setArgb(x, y, color);
				}
			}

			// Create new puzzle piece
			Position position = new Position(width * piece_count, height * piece_count);
			PuzzlePiece piece = new PuzzlePiece(image_writer);
			pieces.put(piece, position);

		}
	}

	public void displayPieces() {
	}
}
