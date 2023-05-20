package candycrushgame;

import java.io.File;
import java.util.Optional;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

class btn extends Button {

    public btn(String s) {
        setMinSize(300, 40);
        setText(s);
        setOpacity(0.8);
    }

}

public class firstWindow {

    private Scene scene1;
    private Button newgamebtn;

    public firstWindow() {

        // creating 2 buttons
        newgamebtn = new btn("NEW GAME ");
        // Button btnscores=new Button("SCORES ");
        btn exitbtn = new btn("EXIT ");
        // btnnewgame.setStyle("-fx-background-color: #ff0000;");

        // creating vertical box (vbox) and add 3 Button in vbox
        // VBox(10) to make 10 pixel between button
        VBox v = new VBox(10);

        // getChildren() to add buttons in vbox
        v.getChildren().addAll(newgamebtn, exitbtn);
        // to make VBox in center .
        v.setAlignment(Pos.CENTER);
        // set the background

        String projectDir = System.getProperty("user.dir"); // get current project directory
        File imgFile = new File(projectDir, "src/image/candy-crush-saga-logo_1920.0.jpg");

        String imgPath = imgFile.toURI().toString();
        v.setStyle("-fx-background-image: url('" + imgPath + "'); "
                + "-fx-background-position: center center; "
                + "-fx-background-repeat: stretch;");

        // btnExit.setOpacity(0.8);
        // set highscorebtn on action
        // MAKE exit action for exitbtn
        exitbtn.setOnAction(e -> {
            Alert A = new Alert(Alert.AlertType.CONFIRMATION);
            A.setTitle("Confirm Exit");
            A.setContentText("Are you sure , you want to exit ?");
            // A.setContentText("Pay attention please, All unsaved changes will be lost.");
            Optional<ButtonType> result = A.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Platform.exit();
            }
        });

        // getChildren().addAll(v);
        scene1 = new Scene(v, 600, 650);
    }

    public Scene getScene1() {
        return scene1;
    }

    public Button newgamebtn() {
        return newgamebtn;
    }

}
