package candycrushgame;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;

public class MainWindow extends StackPane {

    public MainWindow() {
        // create an Image object from the file path
        String projectDir = System.getProperty("user.dir"); // get current project direction
        String img_dir = "\\src\\image\\candy-crush-saga-logo_1920.0.jpg"; //image dir
        Image pic = new Image("file:" + projectDir + img_dir);

        // create a BackgroundImage object with the Image
        BackgroundImage backgroundImage = new BackgroundImage (pic, null, null, null, new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO, false , false ,true,false));

        // create a Background object with the BackgroundImage
        Background background = new Background(backgroundImage);

        // set the background to the root StackPane object
        setBackground(background);
    }

}
