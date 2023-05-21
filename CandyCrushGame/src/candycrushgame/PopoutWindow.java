package candycrushgame;

import java.util.Optional;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


class btn extends Button {

    public btn(String s) {

        setMinSize(270, 40);
        setText(s);
        setOpacity(0.8);
        
    }
}

public class PopoutWindow extends Stage {

    public PopoutWindow() {
        // Create the layout for the popout window
        HBox layout1 = new HBox(10);
        HBox layout2 = new HBox(10);
        HBox layout3 = new HBox(10);
        VBox root = new VBox();
        //padding
        layout2.setPadding(new Insets(7));
        // center
        layout1.setAlignment(Pos.BASELINE_CENTER);
        layout2.setAlignment(Pos.BASELINE_CENTER);
        layout3.setAlignment(Pos.BASELINE_CENTER);
        //create Label
        Label lbl = new Label("Congratulation");
        //lbl size
        lbl.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        lbl.setFont(new Font("Cambria",32));
        lbl.setPadding(new Insets(7));
        lbl.setTextFill(Color.PURPLE);
//        lbl.setTextFill(Color.PURPLE);
//        lbl.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, new Insets(10))));
        lbl.setOpacity(0.8);
        
        // create buttons
        btn newgamebtn = new btn("New Game");
        btn closeButton = new btn("Close");
        // set close button on action
        closeButton.setOnAction(e -> {

            Alert A = new Alert(Alert.AlertType.CONFIRMATION);
            A.setTitle("Confirm Exit");
            A.setContentText("Are you sure , you want to exit ?");
//          A.setContentText("Pay attention please, All unsaved changes will be lost.");
            Optional<ButtonType> result = A.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Platform.exit();
            }
        });

        // add items
        layout1.getChildren().add(lbl);
        layout2.getChildren().add(newgamebtn);
        layout3.getChildren().add(closeButton);


        // create an Image object from the file path
        String projectDir = System.getProperty("user.dir"); // get current project direction
        String img_dir = "\\src\\image\\popout.jpg"; //image dir
        Image image = new Image("file:" + projectDir + img_dir);

        // create a BackgroundImage object with the Image
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        // create a Background object with the BackgroundImage
        Background background = new Background(backgroundImage);

        // set the background to the root StackPane object
        root.setBackground(background);

        // Create the scene for the popout window
        root.getChildren().addAll(layout1, layout2, layout3);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setPadding(new Insets(40));
        Scene scene = new Scene(root, 300, 350);

        
        // Set the scene for the popout window
        this.setScene(scene);
        this.setTitle("Candy Crush");
        this.show();
    }

}