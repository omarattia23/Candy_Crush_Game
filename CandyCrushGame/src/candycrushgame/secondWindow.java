package candycrushgame;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;

class lbl extends Label {

    public lbl(String s) {
        setMinSize(60, 30);
        setText(s);
        setFont(new Font("Cambria", 32));
    }
}

public class secondWindow {

    private static final int NUM_IMAGES = 64;
    private static final int GRID_SIZE = 8;
    private int prevRow = -1, prevCol = -1; // Initialize to -1 to indicate no previously clicked image
    int[] location = new int[4];
    ImageView temp = new ImageView();
    int k = 0;
    private Scene scene2;
    List<Button> selectedButtons = new ArrayList<>();

    private static final String[] IMAGE_PATHS = {
        "src\\items\\1.png",
        "src\\items\\2.png",
        "src\\items\\3.png",
        "src\\items\\4.png",
        "src\\items\\5.png",
        "src\\items\\6.png",
        "src\\items\\7.png",
        "src\\items\\8.jpeg"};

    public secondWindow() {
        VBox v = new VBox();
        HBox h = new HBox();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        Random random = new Random();
        

        for (int i = 0; i < NUM_IMAGES; i++) {
            String imagePath = IMAGE_PATHS[random.nextInt(IMAGE_PATHS.length)];
            Path path = Paths.get(imagePath);
            try {
                Image image = new Image(path.toUri().toString());
                Button button = new Button();
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(55);
                imageView.setFitHeight(55);
                button.setGraphic(imageView);

                int row = i / GRID_SIZE;
                int col = i % GRID_SIZE;

                String buttonId = "button_" + i; // generate unique id for each button
                String imageId = "image_" + imagePath.hashCode(); // generate unique id for each image

                button.setId(buttonId);
                button.setOnAction(e -> handleButtonClick(button, gridPane, selectedButtons));

                imageView.setId(imageId);

                gridPane.add(button, col, row);
            } catch (Exception e) {
                System.out.println("Failed to load image: " + imagePath);
            }
        }

        // Creating objection of level & scores
        Level_Scores levelScores = new Level_Scores();

        levelScores.saveLevelScore();
//        levelScores.loadLevelScore();
        int level = 1;//levelScores.level();
        String score = "0";//levelScores.getScore();
        // set labels 
        lbl scoreLbl0 = new lbl("Score:");
        lbl scorelbl1 = new lbl(score);
        lbl movesLbl0 = new lbl("Moves:");
        lbl movesLbl1 = new lbl("" /* +levelScores.getmoves()*/);
        lbl Level0 = new lbl("Level:");
        lbl Level1 = new lbl("" + level);

        // add the labels and gridpane
        h.getChildren()
                .addAll(scoreLbl0,
                        scorelbl1,
                        movesLbl0,
                        movesLbl1,
                        Level0,
                        Level1);

        v.getChildren()
                .addAll(h, gridPane);

        h.setAlignment(Pos.CENTER);

        h.setSpacing(
                20);
        v.setAlignment(Pos.CENTER);

        // Create a new scene
        scene2 = new Scene(v, 600, 650);
    }
    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    

    public Scene getScene2() {
        return scene2;
    }

    private void handleButtonClick(Button button, GridPane gridPane, List<Button> selectedButtons) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
