package com.example.cs125final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/** we'll want to use MEDIAPLAYER and use OBJECTANIMATOR
 * MediaPlayer allows you to mess with audio
 * includes a nice function called isPlaying()
 * ObjectAnimator allwos you to move an object a specific amount per second
 * doesn't blind from place to place
 */
public class GameActivity extends AppCompatActivity {

    Button down;
    Button quit;

    ImageView leftArrow;
    ImageView upArrow;
    ImageView downArrow;
    ImageView rightArrow;
    Button left;
    Button up;
    Button right;

    String songName;
    MediaPlayer currentlyPlaying;

    ImageView background;

    public boolean onScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        quit = findViewById(R.id.quit);
        songName = MainActivity.getSong();
        if (songName.equals("marionette")) {
            int yellow = getResources().getColor(R.color.yellow);
            quit.setBackgroundColor(yellow);
            background = findViewById(R.id.marionetteImage);
            background.setVisibility(View.VISIBLE);
            downArrow = findViewById(R.id.yellowDown);
            rightArrow = findViewById(R.id.yellowRight);
            leftArrow = findViewById(R.id.yellowLeft);
            upArrow = findViewById(R.id.yellowUp);
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.marionette);
        } if (songName.equals("queen bee")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.queenbee);
            int greyish = getResources().getColor(R.color.greyish);
            quit.setBackgroundColor(greyish);
            background = findViewById(R.id.queenBeeBackground);
            background.setVisibility(View.VISIBLE);
            downArrow = findViewById(R.id.greyishDown);
            rightArrow = findViewById(R.id.greyishRight);
            upArrow = findViewById(R.id.greyishUp);
            leftArrow = findViewById(R.id.greyishLeft);
        }
        if (songName.equals("quaoar")) {
            background = findViewById(R.id.quaoarBackground);
            background.setVisibility(View.VISIBLE);
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.quaoar);
            int green = getResources().getColor(R.color.green);
            quit.setBackgroundColor(green);
            downArrow = findViewById(R.id.down_image);
            rightArrow = findViewById(R.id.right_image);
            upArrow = findViewById(R.id.up_image);
            leftArrow = findViewById(R.id.left_image);
        }
        if (songName.equals("???")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.rickroll);
            int green = getResources().getColor(R.color.green);
            quit.setBackgroundColor(green);
            downArrow = findViewById(R.id.down_image);
            rightArrow = findViewById(R.id.right_image);
            upArrow = findViewById(R.id.up_image);
            leftArrow = findViewById(R.id.left_image);
        }
        onScreen = true;

        upArrow.setVisibility(View.VISIBLE);
        leftArrow.setVisibility(View.VISIBLE);
        rightArrow.setVisibility(View.VISIBLE);
        downArrow.setVisibility(View.VISIBLE);

        leftArrow.bringToFront();
        left = findViewById(R.id.left_button);
        left.setEnabled(true);
        left.bringToFront();

        upArrow.bringToFront();
        up = findViewById(R.id.up_button);
        up.setEnabled(true);
        up.bringToFront();

        right = findViewById(R.id.right_button);
        right.setEnabled(true);
        right.bringToFront();
        rightArrow.bringToFront();

        /** this is here for DEBUGGING PURPOSES*/
        down = findViewById(R.id.down_button);
        down.setEnabled(true);
        down.bringToFront();
        down.setOnClickListener((v) -> nextScreen());
        downArrow.bringToFront();

        quit.setEnabled(true);
        quit.setOnClickListener((v) -> nextScreen());

        currentlyPlaying.start();

        // it changes screens after a small delay
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                if (onScreen) {
                    currentlyPlaying.stop();
                    GameActivity.this.startActivity(intent);
                    GameActivity.this.finish();
                }
            }
            // add three zeros to however seconds x you want to make it
        }, 40000);
    }
    public void nextScreen() {
        onScreen = false;
        currentlyPlaying.stop();
        Intent setupIntent = new Intent(this, ResultActivity.class);
        startActivity(setupIntent);
        finish();
    }
}