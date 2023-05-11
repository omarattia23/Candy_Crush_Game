package candycrushgame;

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

public class LoadingImages {

    private static final int NUM_IMAGES = 64;
    private static final int GRID_SIZE = 8;
    private int prevRow = -1, prevCol = -1; // Initialize to -1 to indicate no previously clicked image
    int[] location = new int[4];
    ImageView temp = new ImageView();
    int k = 0;

    private Scene scene2;
    private static final String[] IMAGE_PATHS = {
        "src\\items\\1.png",
        "src\\items\\2.png",
        "src\\items\\3.png",
        "src\\items\\4.png",
        "src\\items\\5.png",
        "src\\items\\6.png",
        "src\\items\\7.png",
        "src\\items\\8.jpeg",};

    public LoadingImages() {
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

        scene2 = new Scene(gridPane, 900, 900);

        /*******************************************************************************/
        /*******************************************************************************/
        gridPane.setOnMouseClicked(event -> {
            // Get the clicked image view
            ImageView clickedImageView = (ImageView) event.getTarget();
            // Get the position of the clicked image view
            int row = GridPane.getRowIndex(clickedImageView);
            int col = GridPane.getColumnIndex(clickedImageView);
            location[0] = prevRow;
            location[1] = prevCol;
            // Print the position to the console
            System.out.println("Clicked image position: row=" + row + ", col=" + col);
            // Check if there was a previously clicked image
            if (prevRow != -1 || prevCol != -1) {
                // Compare the positions of the previously clicked image and the current clicked image
                if (prevRow == row && prevCol == col) {
                    System.out.println("You clicked the same image twice!");
                } else {
                    System.out.println("Previously clicked image position: row=" + prevRow + ", col=" + prevCol);
                    location[2] = row;
                    location[3] = col;
                }
            }
            if (temp != null && clickedImageView != null) {
                if ((Math.abs(row - prevRow) == 1 && col == prevCol) || (Math.abs(row - prevRow) == 0 || col == prevCol)) {
                    swapImages(gridPane, temp, clickedImageView);
                }
            }
            // Store the current clicked image position as the previously clicked image position
            prevRow = row;
            prevCol = col;
            temp = clickedImageView;
            k++;
            if (k == 2) {
                temp = null;
                k = 0;
                location[0] = -1;
                location[1] = -1;
                location[2] = -1;
                location[3] = -1;
            }
            System.out.println("row1=" + location[0] + ",col1=" + location[1] + ",row2=" + location[2] + ",col2=" + location[3]);
        });

    }

    /*******************************************************************************/
    
    /******************************swapping***************************************/
    /*******************************************************************************/

    
    private void swapImages(GridPane gridPane, ImageView imageView1, ImageView imageView2) {
        int row1 = GridPane.getRowIndex(imageView1);
        int col1 = GridPane.getColumnIndex(imageView1);
        int row2 = GridPane.getRowIndex(imageView2);
        int col2 = GridPane.getColumnIndex(imageView2);
        if (row1 == -1 || col1 == -1 || row2 == -1 || col2 == -1) {
            // One of the image views is not in the grid pane, so we can't swap them
            return;
        }
        // Remove the image views from their current positions in the grid pane
        gridPane.getChildren().removeAll(imageView1, imageView2);
        // Add the image views to their new positions in the grid pane
        gridPane.add(imageView1, col2, row2);
        gridPane.add(imageView2, col1, row1);
    }


public Scene getScene2(){
        return scene2;
    }
}
