package com.elashry.omggroup;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {
    Button buttonStop,buttonStart ;

    String AudioURL ;

    MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        buttonStart = findViewById(R.id.button1);
        buttonStop = findViewById(R.id.button2);
        getDataFromIntent();
        mediaplayer = new MediaPlayer();
        mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        buttonStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    mediaplayer.setDataSource(AudioURL);
                    mediaplayer.prepare();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaplayer.start();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mediaplayer.stop();
            }
        });
    }
    private void getDataFromIntent() {

        Intent intent = getIntent();
        if (intent!=null)
        {
            AudioURL =  intent.getStringExtra("url");
        }
    }
}
