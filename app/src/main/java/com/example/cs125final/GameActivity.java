package com.example.cs125final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// TODO: animate the arrows
// TODO: add parsing classes for the other three songs

/** we'll want to use MEDIAPLAYER and use OBJECTANIMATOR
 * MediaPlayer allows you to mess with audio
 * includes a nice function called isPlaying()
 * ObjectAnimator allwos you to move an object a specific amount per second
 * doesn't blind from place to place
 */
public class GameActivity extends AppCompatActivity {

    Button quit;
    ImageView leftArrow;
    ImageView upArrow;
    ImageView downArrow;
    ImageView rightArrow;
    ImageView leftOutline;
    ImageView upOutline;
    ImageView downOutline;
    ImageView rightOutline;
    Button left;
    Button up;
    Button down;
    Button right;
    String songName;
    MediaPlayer currentlyPlaying;
    ImageView background;
    public boolean onScreen;
    int songLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        quit = findViewById(R.id.quit);
        songName = TitleActivity.getSong();
        if (songName.equals("marionette")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.marionette);
            int yellow = getResources().getColor(R.color.yellow);
            quit.setBackgroundColor(yellow);
            background = findViewById(R.id.marionetteImage);
            background.setVisibility(View.VISIBLE);
            downArrow = findViewById(R.id.yellowDown);
            rightArrow = findViewById(R.id.yellowRight);
            leftArrow = findViewById(R.id.yellowLeft);
            upArrow = findViewById(R.id.yellowUp);
            leftOutline = findViewById(R.id.blackLeftOutline);
            upOutline = findViewById(R.id.blackUpOutline);
            downOutline = findViewById(R.id.blackDownOutline);
            rightOutline = findViewById(R.id.blackRightOutline);
        }
        if (songName.equals("queen bee")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.queenbee);
            int greyish = getResources().getColor(R.color.greyish);
            quit.setBackgroundColor(greyish);
            background = findViewById(R.id.queenBeeBackground);
            background.setVisibility(View.VISIBLE);
            downArrow = findViewById(R.id.greyishDown);
            rightArrow = findViewById(R.id.greyishRight);
            upArrow = findViewById(R.id.greyishUp);
            leftArrow = findViewById(R.id.greyishLeft);
            leftOutline = findViewById(R.id.whiteLeftOutline);
            upOutline = findViewById(R.id.whiteUpOutline);
            downOutline = findViewById(R.id.whiteDownOutline);
            rightOutline = findViewById(R.id.whiteRightOutline);
        }
        if (songName.equals("quaoar")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.quaoar);
            background = findViewById(R.id.quaoarBackground);
            background.setVisibility(View.VISIBLE);
            int quaoarBrown = getResources().getColor(R.color.quaoarBrown);
            quit.setBackgroundColor(quaoarBrown);
            downArrow = findViewById(R.id.quaoarDown);
            rightArrow = findViewById(R.id.quaoarRight);
            upArrow = findViewById(R.id.quaoarUp);
            leftArrow = findViewById(R.id.quaoarLeft);
            leftOutline = findViewById(R.id.whiteLeftOutline);
            upOutline = findViewById(R.id.whiteUpOutline);
            downOutline = findViewById(R.id.whiteDownOutline);
            rightOutline = findViewById(R.id.whiteRightOutline);
        }
        if (songName.equals("metamorphosis")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.metamorphosis);
            background = findViewById(R.id.metamorphosisBackground);
            background.setVisibility(View.VISIBLE);
            int green = getResources().getColor(R.color.colorPrimary);
            quit.setBackgroundColor(green);
            downArrow = findViewById(R.id.metaDown);
            rightArrow = findViewById(R.id.metaRight);
            upArrow = findViewById(R.id.metaUp);
            leftArrow = findViewById(R.id.metaLeft);
            leftOutline = findViewById(R.id.blackLeftOutline);
            upOutline = findViewById(R.id.blackUpOutline);
            downOutline = findViewById(R.id.blackDownOutline);
            rightOutline = findViewById(R.id.blackRightOutline);
        }
        onScreen = true;
        songLength = currentlyPlaying.getDuration();

        leftOutline.setVisibility(View.VISIBLE);
        leftOutline.bringToFront();
        upOutline.setVisibility(View.VISIBLE);
        upOutline.bringToFront();
        downOutline.setVisibility(View.VISIBLE);
        downOutline.bringToFront();
        rightOutline.setVisibility(View.VISIBLE);
        rightOutline.bringToFront();

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
        }, songLength);
    }
    public void nextScreen() {
        onScreen = false;
        currentlyPlaying.stop();
        Intent setupIntent = new Intent(this, ResultActivity.class);
        startActivity(setupIntent);
        finish();
    }
}