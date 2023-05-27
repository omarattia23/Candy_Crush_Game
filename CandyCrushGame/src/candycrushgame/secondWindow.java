package candycrushgame;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        setMinSize(40, 30);
        setText(s);
        setFont(new Font("Cambria", 28));
    }
}

public class secondWindow {

    private static final int NUM_IMAGES = 64;
    private static final int GRID_SIZE = 8;

    private final Scene scene2;

    private final Button btnm;

    List<Button> selectedButtons = new ArrayList<>();

    public final int lvl;
    public final int mv;
    public final String sc;
    public static lbl scorelbl1;
    public static lbl movesLbl1;

    public static lbl Level1;
    // creating objects of logic and level_Scores
    logic logic = new logic();
    Level_Scores levelScores = new Level_Scores();

    public static final String[] IMAGE_PATHS = {
            "src\\items\\1.png",
            "src\\items\\2.png",
            "src\\items\\3.png",
            "src\\items\\4.png",
            "src\\items\\5.png",
            "src\\items\\6.png",
            "src\\items\\7.png",
            "src\\items\\8.jpeg" };

    public secondWindow() {
        VBox v = new VBox();
        HBox h = new HBox(10);
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
                // button.setStyle("-fx-background-color: transparent;");
                button.setOpacity(0.8);
                button.setGraphic(imageView);

                int row = i / GRID_SIZE;
                int col = i % GRID_SIZE;

                String buttonId = "button_" + i; // generate unique id for each button
                String imageId = "image_" + imagePath.hashCode(); // generate unique id for each image

                button.setId(buttonId);
                button.setOnAction(e -> logic.handleButtonClick(button, gridPane, selectedButtons));

                imageView.setId(imageId);

                gridPane.add(button, col, row);
            } catch (Exception e) {
                System.out.println("Failed to load image: " + imagePath);
            }
        }
        try{
            logic.checkMatchedImages(gridPane,selectedButtons);
        }catch (Exception e){
            System.out.println(e);
        }
        
        // Creating objection of level & scores
        levelScores.loadLevelScore();
        lvl = levelScores.level();
        sc = levelScores.getScore();
        mv = levelScores.getmoves() ;
         
        // levelScores.saveLevelScore();
        

        // set labels
        lbl scoreLbl0 = new lbl("Score:");
        scorelbl1 = new lbl(sc);
        lbl movesLbl0 = new lbl("Moves:");
        movesLbl1 = new lbl("" + mv);
        lbl Level0 = new lbl("Level:");
        Level1 = new lbl("" + lvl);

        btnm = new Button();

        // add the labels and gridpane
        h.getChildren()
                .addAll(scoreLbl0,
                        scorelbl1,
                        movesLbl0,
                        movesLbl1,
                        Level0,
                        Level1,
                        btnm);

        v.getChildren()
                .addAll(h, gridPane);

        h.setAlignment(Pos.CENTER);

        v.setAlignment(Pos.CENTER);

        String projectDir = System.getProperty("user.dir"); // get current project directory
        File imgFile = new File(projectDir, "src/image/wp2347583.jpg");

        String imgPath = imgFile.toURI().toString();
        v.setStyle("-fx-background-image: url('" + imgPath + "'); "
                + "-fx-background-position: center center; "
                + "-fx-background-repeat: stretch;");

                
                // Create a new scene
                scene2 = new Scene(v, 600, 650);
            }
            
    public Scene getScene2() {
        return scene2;
    }

    public Button getmutebtn() {
        return btnm;
    }

}
