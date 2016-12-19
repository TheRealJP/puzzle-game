package puzzle;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;

public class Puzzle extends Canvas {

	public List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();
	private ImageView image;
	private int size;

	public Puzzle(ImageView image, int size) {
		this.image = image;
		pieces = createPuzzle(size);
	}

	private final List<PuzzlePiece> createPuzzle(int rows) {
		List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>(rows);

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < rows; y++) {
				pieces.add(new PuzzlePiece(new Position(x + 120, y + 120)));
				image.setViewport(new Rectangle2D(x, y, rows, rows));
			}
		}
		return pieces;
	}

	public void displayPieces() {
		this.getGraphicsContext2D().drawImage(image.getImage(), this.getWidth() / 2, this.getHeight() / 2, size, size);
	}
}
