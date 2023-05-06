package candycrushgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CandyCrushGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create an instance of the MainWindow class
        MainWindow mainWindow = new MainWindow();

        
        // create a Scene object with the MainWindow as the root
        Scene scene = new Scene(mainWindow, 1100, 734);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Candy Crush");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
