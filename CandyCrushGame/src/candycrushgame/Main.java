package candycrushgame;

import java.io.File;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
    private int clickCount = 0;
    private MediaPlayer mediaPlayer1;


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
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(javafx.util.Duration.ZERO));

        // sound of the game
        File s2 = new File(projectDir, "/src/sound/game.wav");
        String s3 = s2.toURI().toString();
        Media media1 = new Media(s3);
        mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.setOnEndOfMedia(() -> mediaPlayer1.seek(javafx.util.Duration.ZERO));

        firstWindow firstWindow = new firstWindow();
        secondWindow secondWindow = new secondWindow();
        File mute = new File(projectDir, "src/image/images2.jpg");
        File sound = new File(projectDir, "src/image/images1.jpg");
        String muteDir = mute.toURI().toString();
        String soundDir = sound.toURI().toString();
        Image image1 = new Image(muteDir);
        Image image2 = new Image(soundDir);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        imageView1.setFitHeight(20);
        imageView1.setFitWidth(20);
        imageView2.setFitHeight(20);
        imageView2.setFitWidth(20);
        
        secondWindow.getmutebtn().setGraphic(imageView1);
        secondWindow.getmutebtn().setStyle("-fx-background-color: transparent;");
        secondWindow.getmutebtn().setOnAction(e -> {
            clickCount++;
            if (clickCount == 1) {
                secondWindow.getmutebtn().setGraphic(imageView2);
                mediaPlayer1.stop();
            } else if (clickCount == 2) {
                secondWindow.getmutebtn().setGraphic(imageView1);
                mediaPlayer1.play();
                clickCount = 0;
            }

        });
        primaryStage.setScene(firstWindow.getScene1());
        firstWindow.newgamebtn().setOnAction(e -> {
            primaryStage.setScene(secondWindow.getScene2());
            mediaPlayer.stop();
            mediaPlayer1.play();
        });

        
        primaryStage.setTitle("Candy Crush");
        primaryStage.setResizable(false);
        primaryStage.show();
        PopoutWindow popoutWindow = new PopoutWindow();
        popoutWindow.setOnCloseRequest(e->{primaryStage.setScene(firstWindow.getScene1());}); 
        
    }

    

    

    public static void main(String[] args) {
        launch(args);
    }

}
