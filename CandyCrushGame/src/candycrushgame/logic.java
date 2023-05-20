package candycrushgame;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class logic {
    private Button selectedButton = null;
    private List<Button> buttonsToRemove1 = new ArrayList<>();
    private List<Button> buttonsToRemove2 = new ArrayList<>();
    private boolean state = true;

    Level_Scores levelScores = new Level_Scores();
    sounds sounds = new sounds();

    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private Button findButtonById(GridPane gridPane, String buttonId) {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Button && buttonId.equals(node.getId())) {
                return (Button) node;
            }
        }
        return null;
    }

    // Modify the handleButtonClick method
    public void handleButtonClick(Button button, GridPane gridPane, List<Button> selectedButtons) {
        // checkMatchedImages(gridPane);
        if (selectedButton == null) {
            // No button is currently selected, so select the clicked button
            selectedButton = button;
            sounds.selectsound();
            selectedButton.setStyle("-fx-border-color: red; -fx-border-width: 1;");
        } else {
            // A button is already selected, so perform the swap
            String buttonId1 = selectedButton.getId();
            System.out.println("button_id_one: " + buttonId1);
            String buttonId2 = button.getId();
            System.out.println("button_id_two: " + buttonId2);
            if (isNeighbors(gridPane, buttonId1, buttonId2)) {
                swapButtonsInGridPane(gridPane, buttonId1, buttonId2);

                checkMatchedImages(gridPane, selectedButtons);
                if (state) {
                    swapButtonsInGridPane(gridPane, buttonId2, buttonId1);
                }
            }
            // Deselect the buttons
            selectedButton.setStyle("");
            button.setStyle("");

            // Reset the selectedButton variable
            selectedButton = null;
        }
    }
    // public TranslateTransition createTranslateTransition(Node node, int targetColumn, int targetRow) {
    //     TranslateTransition transition = new TranslateTransition(Duration.millis(500), node);
    //     transition.setToX(targetColumn * node.getBoundsInParent().getWidth());
    //     transition.setToY(targetRow * node.getBoundsInParent().getHeight());
    //     return transition;
    // }

    public void swapButtonsInGridPane(GridPane gridPane, String buttonId1, String buttonId2) {
        // Retrieve the buttons using their IDs
        Button button1 = findButtonById(gridPane, buttonId1);
        Button button2 = findButtonById(gridPane, buttonId2);
        buttonsToRemove1.add(button2);
        buttonsToRemove2.add(button2);
        if (button1 != null && button2 != null) {
            // Get the row and column indices of each button
            int row1 = GridPane.getRowIndex(button1);
            int col1 = GridPane.getColumnIndex(button1);
            int row2 = GridPane.getRowIndex(button2);
            int col2 = GridPane.getColumnIndex(button2);

            if (row1 >= 0 && col1 >= 0 && row2 >= 0 && col2 >= 0) {
                // // Create TranslateTransition for button1
                // TranslateTransition transition1 = createTranslateTransition(button1, col2,
                // row2);
                // // Create TranslateTransition for button2
                // TranslateTransition transition2 = createTranslateTransition(button2, col1,
                // row1);
                
                // // Play the animations
                // transition1.play();
                // transition2.play();

                
                gridPane.getChildren().removeAll(button1, button2);
                gridPane.add(button1, col2, row2);
                button1.setId(buttonId2);
                gridPane.add(button2, col1, row1);
                button2.setId(buttonId1);

                
                sounds.movesound();

            }
        }
    }

    public boolean isNeighbors(GridPane gridPane, String buttonId1, String buttonId2) {
        int columnIndex = -1;
        int rowIndex = -1;
        int columnIndex2 = -1;
        int rowIndex2 = -1;
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

            }
        }

        if (((Math.abs(rowIndex - rowIndex2) == 1) && (columnIndex == columnIndex2))
                || ((Math.abs(columnIndex - columnIndex2) == 1) && (rowIndex == rowIndex2))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ***********************************************************************
     */
    /**
     * ***********************************************************************
     * 
     *
     */
    public void checkMatchedImages(GridPane gridPane, List<Button> selectedButtons) {

        int gridSize = 8; // Assuming an 8x8 grid

        // Check rows
        for (int row = 0; row < gridSize; row++) {
            int count = 1; // Counter for consecutive matching images in a row
            String previousId = null;

            for (int col = 0; col < gridSize; col++) {
                Node node = getNodeFromGridPane(gridPane, col, row);
                if (node instanceof Button button) {

                    ImageView imageView = (ImageView) button.getGraphic();

                    if (imageView != null) {
                        String currentId = imageView.getId();
                        buttonsToRemove1.add(button);

                        // System.out.println("error..");
                        if (previousId != null && currentId.equals(previousId)) {
                            count++;
                            buttonsToRemove1.add(button);

                            if (count >= 3) {
                                // Three or more consecutive matching images found in a row
                                System.out.println("true");
                                button.setGraphic(null);
                                // button.setId("-2");
                                System.out.println("Omaaaaaaaaaaaaaaaaaaaaaaaaaaaaaar");
                                state = false;
                                for (Button btn : buttonsToRemove1) {
                                    int col11 = GridPane.getColumnIndex(btn);
                                    int row11 = GridPane.getRowIndex(btn);
                                    createRandomButton(gridPane, col11, row11, selectedButtons);
                                }
                                gridPane.getChildren().removeAll(buttonsToRemove1);

                                System.out.println(buttonsToRemove1);

                                levelScores.score1();
                                secondWindow.scorelbl1.setText("" + levelScores.getScore());
                                levelScores.moves();
                                secondWindow.movesLbl1.setText("" + levelScores.getmoves());

                                
                                sounds.removesound();

                                System.out.println(buttonsToRemove1);

                            }

                        } else {
                            count = 1;
                            buttonsToRemove1.clear();

                            if (buttonsToRemove1.size() > 1) {
                                buttonsToRemove1.clear();

                            }
                        }
                        previousId = currentId;

                        if (count == 1) {
                            buttonsToRemove1.add(button);
                        }

                        if (count == 1) {
                            buttonsToRemove1.add(button);
                        }

                    }
                }
                // System.out.println("false");

            }
        }
        for (int col = 0; col < gridSize; col++) {
            int count = 1;
            String previousId = null;
            for (int row = 0; row < gridSize; row++) {
                Node node = getNodeFromGridPane(gridPane, col, row);

                if (node instanceof Button button) {

                    if (node instanceof Button) {

                        ImageView imageView = (ImageView) button.getGraphic();
                        if (imageView != null) {
                            String currentId = imageView.getId();
                            buttonsToRemove2.add(button);
                            // System.out.println("error..");
                            if (previousId != null && currentId.equals(previousId)) {
                                count++;
                                buttonsToRemove2.add(button);
                                if (count >= 3) {
                                    // Three or more consecutive matching images found in a row
                                    System.out.println("true");
                                    button.setGraphic(null);

                                    state = false;

                                    gridPane.getChildren().removeAll(buttonsToRemove2);

                                    // button.setId("-2");
                                    for (Button btn : buttonsToRemove2) {
                                        int col11 = GridPane.getColumnIndex(btn);
                                        int row11 = GridPane.getRowIndex(btn);
                                        createRandomButton(gridPane, col11, row11, selectedButtons);
                                    }
                                    gridPane.getChildren().removeAll(buttonsToRemove2);
                                    System.out.println(buttonsToRemove2);

                                    levelScores.score1();
                                    secondWindow.scorelbl1.setText("" + levelScores.getScore());
                                    levelScores.moves();
                                    secondWindow.movesLbl1.setText("" + levelScores.getmoves());

                                    
                                    sounds.removesound();

                                }
                            } else {
                                count = 1;
                                if (buttonsToRemove2.size() > 1) {
                                    buttonsToRemove2.clear();

                                }
                            }

                            previousId = currentId;
                            if (count == 1) {
                                buttonsToRemove2.add(button);
                            }

                        }

                    }
                    // System.out.println("false");
                }

            }

        }
    }

    /**
     * ***********************************************************************
     */
    /**
     * ***********************************************************************
     */
    private void createRandomButton(GridPane gridPane, int col, int row, List<Button> selectedButtons) {
        Node node = getNodeFromGridPane(gridPane, col, row);
        Button button11 = (Button) node;
        Random random = new Random();
        gridPane.getChildren().remove(button11);
        String[] img_paths = secondWindow.IMAGE_PATHS;
        String imagePath = img_paths[random.nextInt(img_paths.length)];
        java.nio.file.Path path = Paths.get(imagePath);
        try {
            Image image = new Image(path.toUri().toString());
            Button button = new Button();
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(55);
            imageView.setFitHeight(55);
            button.setOpacity(0.8);
            button.setGraphic(imageView);

            String buttonId = "button_" + col + "_" + row;
            String imageId = "image_" + imagePath.hashCode();

            button.setId(buttonId);
            button.setOnAction(e -> handleButtonClick(button, gridPane, selectedButtons));

            imageView.setId(imageId);

            gridPane.add(button, col, row);
        } catch (Exception e) {
            System.out.println("Failed to load image: " + imagePath);
        }
    }
}
