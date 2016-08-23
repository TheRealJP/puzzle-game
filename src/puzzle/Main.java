package puzzle;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Juan Ortiz
 * @since 8/17/2016
 */
public class Main extends Application {
	/**
	 * The root panel to hold all other components.
	 */
	private StackPane root = new StackPane();
	/**
	 * The overarching scene that will display our root and all other sub nodes.
	 */
	private Scene scene = new Scene(root, 800, 600);

	private VBox getImageViews() {
		VBox vbox = new VBox();

		ImageView beach = new ImageView(ImageFactory.get().getSprite("beach.jpg"));
		ImageView pets = new ImageView(ImageFactory.get().getSprite("pets.jpg"));

		for (ImageView image : Arrays.asList(beach, pets)) {
			image.setPreserveRatio(true);
			image.setFitWidth(vbox.getWidth());
			image.setFitHeight(vbox.getHeight());
			image.setStyle("-fx-border-color:darkblue ; \n" // #090a0c
					+ "-fx-border-insets:3;\n" + "-fx-border-radius:7;\n" + "-fx-border-width:1.0");
		}

		vbox.getChildren().addAll(beach, pets);
		vbox.setStyle("-fx-border-color:darkblue ; \n" // #090a0c
				+ "-fx-border-insets:3;\n" + "-fx-border-radius:7;\n" + "-fx-border-width:1.0");
		return vbox;
	}

	/** Populates the application with content using a {@link BorderPane}. Th */
	private BorderPane createBorders() {
		BorderPane border = new BorderPane();

		border.setCenter(getImageViews());
		root.getChildren().add(border);
		return border;
	}

	@Override
	public void start(Stage stage) throws Exception {

		createBorders();
		stage.setTitle("Sliding Puzzle Game");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
