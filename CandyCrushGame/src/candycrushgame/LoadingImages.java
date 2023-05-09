
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoadingImages extends Application {

    private static final String[] IMAGE_PATHS = {
        "C:\\Users\\DELL\\Desktop\\photos\\1.jpg",
        "C:\\Users\\DELL\\Desktop\\photos\\2.jpg",
        "C:\\Users\\DELL\\Desktop\\photos\\3.jpg",
        "C:\\Users\\DELL\\Desktop\\photos\\4.jpg",
        "C:\\Users\\DELL\\Desktop\\photos\\5.jpg",
        "C:\\Users\\DELL\\Desktop\\photos\\6.jpg",
        "C:\\Users\\DELL\\Desktop\\photos\\7.jpg",
        "C:\\Users\\DELL\\Desktop\\photos\\8.jpg",};

    private static final int NUM_IMAGES = 64;
    private static final int GRID_SIZE = 8;

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(110));
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        Random random = new Random();
        for (int i = 0; i < NUM_IMAGES; i++) {
            String imagePath = IMAGE_PATHS[random.nextInt(IMAGE_PATHS.length)];
            Path path = Paths.get(imagePath);
            try {
                Image image = new Image(path.toUri().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(80);
                imageView.setFitHeight(80);
                int row = i / GRID_SIZE;
                int col = i % GRID_SIZE;
                gridPane.add(imageView, col, row);
            } catch (Exception e) {
                System.out.println("Failed to load image: " + imagePath);
            }
        }
        gridPane.setOnMouseClicked(event -> {
            // Get the clicked image view
            ImageView clickedImageView = (ImageView) event.getTarget();

            // Get the position of the clicked image view
            int row = GridPane.getRowIndex(clickedImageView);
            int col = GridPane.getColumnIndex(clickedImageView);

            // Print the position to the console
            System.out.println("Clicked image position: row=" + row + ", col=" + col);
        });

        Scene scene = new Scene(gridPane, 900, 900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
