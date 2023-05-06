
package candycrushgame;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PopoutWindow extends Stage {
    public PopoutWindow(){
         // Create the layout for the popout window

        HBox layout = new HBox();
        Button newgamebtn = new Button("New Game");
        Button closeButton = new Button("Close");
        layout.getChildren().add(closeButton);
        layout.getChildren().add(newgamebtn);
        


        // Create the scene for the popout window
        Scene scene = new Scene(layout, 300, 200);

        // Set the scene for the popout window
        this.setScene(scene);
        this.setTitle("Candy Crush");
    }
    
}
