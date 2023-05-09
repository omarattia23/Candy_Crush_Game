
package candycrushgame;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;

public class PopoutWindow extends Stage {
    public PopoutWindow(){
         // Create the layout for the popout window
        HBox layout1 = new HBox();
           
          Label lbl = new Label();
          lbl.setLayoutX(50);
          lbl.setLayoutY(50);
          lbl.setTranslateX(180);
          lbl.setTranslateY(140);
          
          lbl.setTextFill(Color.PURPLE);
          
        layout1.getChildren().add(lbl);
        
        
        
        
        HBox layout2 = new HBox();
        Button newgamebtn = new Button("New Game");
        Button closeButton = new Button("Close");
        
      
        newgamebtn.setLayoutX(200);
        newgamebtn.setLayoutY(150);
        closeButton.setLayoutX(200);
        closeButton.setLayoutY(150);
        layout2.getChildren().add(closeButton);
        layout2.getChildren().add(newgamebtn);
        newgamebtn.setTranslateX(50);
        newgamebtn.setTranslateY(70);
        closeButton.setTranslateX(110);
        closeButton.setTranslateY(105);
        
        // Create the scene for the popout window
        VBox root = new VBox () ;
        root.getChildren().addAll(layout1,layout2) ;
      
        Scene scene = new Scene(root, 250, 250,Color.BLANCHEDALMOND);
       
        // Set the scene for the popout window
       
        this.show();
        this.setScene(scene);
        this.setTitle("Candy Crush");
    }
    
}
