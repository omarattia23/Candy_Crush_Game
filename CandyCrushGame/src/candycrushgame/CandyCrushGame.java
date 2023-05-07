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



// make class extends Button and setminsize(weidth, height) and opacity
//I did this  class instead of setminsize for each Button  
class Butt extends Button{
   
    public Butt(String s){
    
    setMinSize(300,40);
    setText(s);
    setOpacity(0.8);
    }
    
}


/**
 *
 * @author Desktop
 */
public class CandyCrushGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
 // creating 3 buttons 
         Butt btnnewgame =new Butt("NEW GAME ");
         Butt btnscores=new Butt("SCORES ");
         Butt btnExit =new Butt("EXIT "); 
       
         //creating vertical box (vbox) and add 3 Button in vbox
         //VBox(10) to make 10 pixel between button
         VBox v = new VBox(10);
         // getChildren() to add buttons in vbox
         v.getChildren().addAll(btnnewgame,btnscores,btnExit);
         // to make VBox in center .
         v.setAlignment(Pos.CENTER);
       
         //MAKE exit action for btnExit
         btnExit.setOnAction(e -> {
    
             
             
         Alert A = new Alert(Alert.AlertType.CONFIRMATION);
         A.setTitle("Confirm Exit");
         A.setHeaderText("Are you sure , you want to exit ?");
         A.setContentText("Pay attention please, All unsaved changes will be lost.");
         Optional<ButtonType> result = A.showAndWait();
          if (result.isPresent() && result.get() == ButtonType.OK){
         Platform.exit();
          }       
     });
        
      
          // create an Image object from the file path
          Image pic = new Image("file:C:\\Users\\Desktop\\Documents\\NetBeansProjects\\candygame\\src\\image\\candy-crush-saga-logo_1920.0.jpg");
      
        
         // create a BackgroundImage object with the Image
       
         BackgroundImage backgroundImage = new BackgroundImage (pic, null, null,null, new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO, false , false ,true,false));
         // create a Background object with the BackgroundImage
         Background background = new Background(backgroundImage);
        
         // create a BorderPane and set the background
         StackPane root = new StackPane();
         root.setBackground(background);
         root.getChildren().addAll(v);

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
