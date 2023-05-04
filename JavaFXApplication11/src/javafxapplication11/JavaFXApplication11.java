/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Desktop
 */
public class JavaFXApplication11 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      Image x = new Image("file:C:\\Users\\Desktop\\Documents\\NetBeansProjects\\candygame\\src\\image\\candy-crush-saga-logo_1920.0.jpg");
      
      ImageView y =new ImageView(x);
      
      
        
        
        
        StackPane root = new StackPane();
        root.getChildren().add(y);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
