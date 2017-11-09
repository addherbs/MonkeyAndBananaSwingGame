package com.adipandey.monkeybanana;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class BackgroundMusicPlay extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        play();
    }

    static void play() {
        try {
            String bip = "resources/media/cheer.mp3";
            Media hit = new Media(new File(bip).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mediaPlayer.stop();
                }
            }, 750);
        } catch (IllegalStateException e) {
            Application.launch(BackgroundMusicPlay.class);
            play();
        }

    }

    static void playMusic() {
        Application.launch(BackgroundMusicPlay.class);
    }


    public BackgroundMusicPlay() {
    }
}
