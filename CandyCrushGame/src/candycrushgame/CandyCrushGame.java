/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package candycrushgame;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;

/**
 *
 * @author Desktop
 */
public class CandyCrushGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        
        // create an Image object from the file path
        String projectDir = System.getProperty("user.dir"); // get current project direction
        String img_dir = "\\src\\image\\candy-crush-saga-logo_1920.0.jpg"; //image dir
        Image pic = new Image("file:" + projectDir + img_dir);
        
        // create a BackgroundImage object with the Image
       
         BackgroundImage backgroundImage = new BackgroundImage (pic, null, null,null, new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO, false , false ,true,false));
         // create a Background object with the BackgroundImage
         Background background = new Background(backgroundImage);
        
         // create a BorderPane and set the background
         StackPane root = new StackPane();
         root.setBackground(background);
       

         Scene scene = new Scene(root, 1100,734);
         primaryStage.setScene(scene);
         primaryStage.setTitle("Candy Crush");
         primaryStage.setResizable(false);
        
         primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
