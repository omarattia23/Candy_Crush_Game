package candycrushgame;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class logic {
    private ImageView selectedButton = null;
    private Color rememberColor;
    private boolean isClicked = true;
    private void handleClick(ImageView button) {
        if (isClicked) {
            selectedButton = button;
//            rememberColor = getButtonColor(selectedButton);
            selectedButton.setEffect(new ColorAdjust(0, -0.5, -0.5, 0));
            isClicked = false;
        } else {
            if (selectedButton == button) {
                selectedButton.setEffect(null);
                isClicked = true;
                return;
            }

//            if (isNeighbors(selectedButton, button)) {
//                swapButtons(selectedButton, button);
//                markTiles(selectedButton);
//                markTiles(button);
//            }

            selectedButton.setEffect(null);
            isClicked = true;
        }
    }
    
}
