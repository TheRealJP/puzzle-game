package puzzle;

public class PuzzlePiece {

	/** The position of this puzzle piece. */
	private Position position;

	public PuzzlePiece(Position position) {
		this.setPosition(position);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
