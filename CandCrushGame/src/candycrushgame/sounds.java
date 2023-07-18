package candycrushgame;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class sounds {
    private String projectDir = System.getProperty("user.dir");
    private MediaPlayer mediaPlayer2;
    public void movesound() {
        File s4 = new File(projectDir, "/src/sound/move.wav");
        String s5 = s4.toURI().toString();
        Media media2 = new Media(s5);
        mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.play();
    }

    public void selectsound() {
        File s4 = new File(projectDir, "/src/sound/select.wav");
        String s5 = s4.toURI().toString();
        Media media2 = new Media(s5);
        mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.play();
    }

    public void removesound() {
        File s4 = new File(projectDir, "/src/sound/remove.wav");
        String s5 = s4.toURI().toString();
        Media media2 = new Media(s5);
        mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.play();
    }
}
