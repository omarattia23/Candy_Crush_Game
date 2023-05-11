package candycrushgame;

import javafx.application.Application;
import javafx.stage.Stage;

public class CandyCrushGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // create an instance of the MainWindow class  
        MainWindow mainWindow = new MainWindow();
        // create an instance of the LoadingImages class
        LoadingImages LoadingImages = new LoadingImages();
        // create an instance of the popoutWindow class
        PopoutWindow popoutWindow = new PopoutWindow();
        popoutWindow.show();             // Show the popout window
        
        // create a Scene object with the MainWindow as the root
        
        primaryStage.setScene(mainWindow.getScene1());
        mainWindow.btnnewgame().setOnAction(e->{
        primaryStage.setScene(LoadingImages.getScene2());});
        primaryStage.setTitle("Candy Crush");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
