

package candycrushgame;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.List;


public class logic {
    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public void moveButtons(GridPane gridPane, int fromCol, int fromRow, int toCol, int toRow) {
        Node fromButton = getNodeFromGridPane(gridPane, fromCol, fromRow);
        Node toButton = getNodeFromGridPane(gridPane, toCol, toRow);

        // Update button position
        gridPane.getChildren().remove(fromButton);
        gridPane.add(fromButton, toCol, toRow);

        // Update image position
        if (fromButton instanceof Button && toButton instanceof Button) {
            Button fromBtn = (Button) fromButton;
            Button toBtn = (Button) toButton;

            ImageView fromImageView = (ImageView) fromBtn.getGraphic();
            ImageView toImageView = (ImageView) toBtn.getGraphic();

            fromBtn.setGraphic(null);
            toBtn.setGraphic(null);

            fromBtn.setGraphic(toImageView);
            toBtn.setGraphic(fromImageView);
        }
    }

    public void handleButtonClick(Button button, GridPane gridPane, List<Button> selectedButtons) {
        Integer buttonCol = GridPane.getColumnIndex(button);
        Integer buttonRow = GridPane.getRowIndex(button);

        if (buttonCol != null && buttonRow != null) {
            if (selectedButtons.contains(button)) {
                // Button is already selected, so deselect it
                selectedButtons.remove(button);
                button.setStyle(""); // Reset button style if necessary
            } else {
                // Button is not selected, so select it
                selectedButtons.add(button);
                button.setStyle("-fx-background-color: yellow;"); // Example: Set a yellow background to indicate selection
            }

            if (selectedButtons.size() == 2) {
                // Two buttons are selected, perform the move operation
                Button firstButton = selectedButtons.get(0);
                Button secondButton = selectedButtons.get(1);

                Integer firstButtonCol = GridPane.getColumnIndex(firstButton);
                Integer firstButtonRow = GridPane.getRowIndex(firstButton);
                Integer secondButtonCol = GridPane.getColumnIndex(secondButton);
                Integer secondButtonRow = GridPane.getRowIndex(secondButton);

                if (firstButtonCol != null && firstButtonRow != null && secondButtonCol != null && secondButtonRow != null) {
                    // Swap the positions of the buttons
                    moveButtons(gridPane, firstButtonCol, firstButtonRow, secondButtonCol, secondButtonRow);
                    // Clear the selection
                    selectedButtons.clear();
                    firstButton.setStyle(""); // Reset button style if necessary
                    secondButton.setStyle(""); // Reset button style if necessary
                }
            }
        }

    }
}
