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
    private int[] location = new int[4];
    private Scene scene2;
    private Button selectedButton = null;
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

    // Modify the handleButtonClick method
    private void handleButtonClick(Button button, GridPane gridPane, List<Button> selectedButtons) {
        if (selectedButton == null) {
            // No button is currently selected, so select the clicked button
            selectedButton = button;
            selectedButton.setStyle("-fx-border-color: red; -fx-border-width: 1;");
        } else {
            // A button is already selected, so perform the swap
            String buttonId1 = selectedButton.getId();
            String buttonId2 = button.getId();
            if(isNeighbors(gridPane, buttonId1, buttonId2)){
            swapButtonsInGridPane(gridPane, buttonId1, buttonId2);
            checkMatchedImages( gridPane);
             
            }
            // Deselect the buttons
            selectedButton.setStyle("");
            button.setStyle("");

            // Reset the selectedButton variable
            selectedButton = null;
        }
    }

    public void swapButtonsInGridPane(GridPane gridPane, String buttonId1, String buttonId2) {
        // Retrieve the buttons using their IDs
        Button button1 = findButtonById(gridPane, buttonId1);
        Button button2 = findButtonById(gridPane, buttonId2);

        if (button1 != null && button2 != null) {
            // Get the row and column indices of each button
            int row1 = GridPane.getRowIndex(button1);
            int col1 = GridPane.getColumnIndex(button1);
            int row2 = GridPane.getRowIndex(button2);
            int col2 = GridPane.getColumnIndex(button2);

            if (row1 >= 0 && col1 >= 0 && row2 >= 0 && col2 >= 0) {
                // Remove the buttons from the GridPane
                gridPane.getChildren().removeAll(button1, button2);

                // Set each button to the new positions
                gridPane.add(button1, col2, row2);
                gridPane.add(button2, col1, row1);
            }
        }
    }

    private Button findButtonById(GridPane gridPane, String buttonId) {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Button && buttonId.equals(node.getId())) {
                return (Button) node;
            }
        }
        return null;
    }
    public boolean isNeighbors(GridPane gridPane, String buttonId1 ,String buttonId2) {
    int columnIndex=-1;
    int rowIndex=-1;
    int columnIndex2 =-1;
    int rowIndex2 =-1;
    for (Node node : gridPane.getChildren()) {
        
        if (node instanceof Button && buttonId1.equals(node.getId())) {
            columnIndex = GridPane.getColumnIndex(node);
            rowIndex = GridPane.getRowIndex(node);
            
            
        }
        
    }
    for (Node node : gridPane.getChildren()) {
        if (node instanceof Button && buttonId2.equals(node.getId())) {
            columnIndex2 = GridPane.getColumnIndex(node);
            rowIndex2 = GridPane.getRowIndex(node);
            
        }}
        
    
    if(((Math.abs(rowIndex - rowIndex2)==1) && ( columnIndex == columnIndex2) )|| ((Math.abs(columnIndex - columnIndex2)==1)&&(rowIndex == rowIndex2)))
    {
        return true;
    }
    else{
        return false;
    } 
    }
    
    
    
    
    
    /**************************************************************************/
    /**************************************************************************/
        public void checkMatchedImages(GridPane gridPane) {
        int gridSize = 8; // Assuming an 8x8 grid

        // Check rows
        for (int row = 0; row < gridSize; row++) {
            int count = 1; // Counter for consecutive matching images in a row
            String previousId = null;

            for (int col = 0; col < gridSize; col++) {
                ImageView imageView = getImageFromGridPane(gridPane, col, row);

                if (imageView != null) {
                    String currentId = imageView.getId();

                    if (previousId != null && currentId.equals(previousId)) {
                        count++;

                        if (count >= 3) {
                            // Three or more consecutive matching images found in a row
                            System.out.println("true");
                        }
                    } else {
                        count = 1;
                    }

                    previousId = currentId;
                }
            }
        }

        // Check columns
        for (int col = 0; col < gridSize; col++) {
            int count = 1; // Counter for consecutive matching images in a column
            String previousId = null;

            for (int row = 0; row < gridSize; row++) {
                ImageView imageView = getImageFromGridPane(gridPane, col, row);

                if (imageView != null) {
                    String currentId = imageView.getId();

                    if (previousId != null && currentId.equals(previousId)) {
                        count++;

                        if (count >= 3) {
                            // Three or more consecutive matching images found in a column
                            System.out.println("false");
                        }
                    } else {
                        count = 1;
                    }

                    previousId = currentId;
                }
            }
        }

        System.out.println("false");
    }

    private ImageView getImageFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row && node instanceof ImageView) {
                return (ImageView) node;
            }
        }

        return null;
    }
    
    /**************************************************************************/
    /**************************************************************************/
    public Scene getScene2() {
        return scene2;
    }

}
