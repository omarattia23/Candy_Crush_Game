package candycrushgame;

import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class CandyCrushGame extends Application {

    @Override

    public void start(Stage primaryStage) {
        // Path
        String projectDir = System.getProperty("user.dir");

        // sound of main window
        File s0 = new File(projectDir, "src/sound/Candy.wav");
        String s1 = s0.toURI().toString();
        System.out.println(s1);
        Media media = new Media(s1);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        // sound of game
        File s2 = new File(projectDir, "/src/sound/game.wav");
        String s3 = s2.toURI().toString();
        Media media1 = new Media(s3);
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        //

        // create an instance of the MainWindow class
        firstWindow firstWindow = new firstWindow();
        // create an instance of the LoadingImages class
        secondWindow secondWindow = new secondWindow();
        // create an instance of the popoutWindow class
        // PopoutWindow popoutWindow = new PopoutWindow();
        // popoutWindow.show(); // Show the popout window

        // create a Scene object with the MainWindow as the root

        primaryStage.setScene(firstWindow.getScene1());
        

        firstWindow.newgamebtn().setOnAction(e -> {
            primaryStage.setScene(secondWindow.getScene2());
            mediaPlayer.stop();
            mediaPlayer1.play();
        });

        primaryStage.setTitle("Candy Crush");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
