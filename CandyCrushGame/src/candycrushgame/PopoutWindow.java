
package candycrushgame;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopoutWindow extends Stage {
    public PopoutWindow(){
          // Create the layout for the popout window
        VBox layout = new VBox();
        Button closeButton = new Button("Close");
        layout.getChildren().add(closeButton);

        // Create the scene for the popout window
        Scene scene = new Scene(layout, 300, 200);

        // Set the scene for the popout window
        this.setScene(scene);
        this.setTitle("Popout Window");
    }
    
}
