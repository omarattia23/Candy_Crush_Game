
package candycrushgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridBackground extends Application {

    
    @Override
    public void start(Stage primaryStage) {
        
    	// Create an ImageView for the image
        ImageView imageView = new ImageView();
        
        // Setting the image path
        String FileDirection = System.getProperty("user.dir"); 
        String ImagePath = "\\src\\image\\GridBackground.jpg";
        
        // Load the image file
        Image image = new Image("file:" +FileDirection + ImagePath);
        
        // Set the image in the ImageView
        imageView.setImage(image);
        
        //Setting the dimensions 
        imageView.setFitWidth(900);
        imageView.setFitHeight(600);
        
        
        
        // Create a layout and add the ImageView to it
        VBox root = new VBox();
        root.getChildren().add(imageView);
        
        // Create a scene with the layout as the root node
        Scene scene = new Scene(root);
        
        // Set the scene on the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Play");
        primaryStage.setResizable(false);
        
        // Show the primary stage
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
