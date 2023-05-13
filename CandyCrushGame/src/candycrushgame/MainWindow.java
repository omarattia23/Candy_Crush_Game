package candycrushgame;

import java.util.Optional;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

class Butt extends Button {

    public Butt(String s) {

        setMinSize(300, 40);
        setText(s);
        setOpacity(0.8);
    }

}

public class MainWindow {
    private Scene scene1;
    private Button btnnewgame;

    public MainWindow() {

        // create an Image object from the file path
        String projectDir = System.getProperty("user.dir"); // get current project direction
        String img_dir = "\\src\\image\\candy-crush-saga-logo_1920.0.jpg"; //image dir
        Image pic = new Image("file:" + projectDir + img_dir);

        // create a BackgroundImage object with the Image
        BackgroundImage backgroundImage = new BackgroundImage(pic, null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        // create a Background object with the BackgroundImage
        Background background = new Background(backgroundImage);

        

        // creating 2 buttons 
        btnnewgame = new Butt("NEW GAME ");
        // Button btnscores=new Button("SCORES ");
        Butt btnExit = new Butt("EXIT ");
        //  btnnewgame.setStyle("-fx-background-color: #ff0000;");
        //creating vertical box (vbox) and add 3 Button in vbox
        //VBox(10) to make 10 pixel between button
        VBox v = new VBox(10);
        // getChildren() to add buttons in vbox
        v.getChildren().addAll(btnnewgame, btnExit);
        // to make VBox in center .
        v.setAlignment(Pos.CENTER);
        // set the background to the root StackPane object
        v.setBackground(background);

        //btnExit.setOpacity(0.8);
        //MAKE exit action for btnExit
        btnExit.setOnAction(e -> {

            Alert A = new Alert(Alert.AlertType.CONFIRMATION);
            A.setTitle("Confirm Exit");
            A.setContentText("Are you sure , you want to exit ?");
//            A.setContentText("Pay attention please, All unsaved changes will be lost.");
            Optional<ButtonType> result = A.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Platform.exit();
            }
        });
        

//         getChildren().addAll(v);
         scene1 = new Scene(v, 1100, 734);
    }

    public Scene getScene1(){
        return scene1;
    }
    public Button btnnewgame(){
        return btnnewgame;
    }

}
