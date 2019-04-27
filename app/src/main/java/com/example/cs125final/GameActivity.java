package com.example.cs125final;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import android.view.animation.Animation;
import java.lang.Cloneable;

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
    ImageView box;
    static ImageView leftMove;
    static ImageView rightMove;
    static ImageView upMove;
    static ImageView downMove;
    static ImageView leftMove1;
    static ImageView rightMove1;
    static ImageView upMove1;
    static ImageView downMove1;
    static ImageView leftMove2;
    static ImageView rightMove2;
    static ImageView upMove2;
    static ImageView downMove2;
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
    static ImageView background;
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
            box = findViewById(R.id.marionetteBox);
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
            leftMove = findViewById(R.id.yellowLeftMove);
            upMove = findViewById(R.id.yellowUpMove);
            downMove = findViewById(R.id.yellowDownMove);
            rightMove = findViewById(R.id.yellowRightMove);
            leftMove1 = findViewById(R.id.yellowLeftMove1);
            upMove1 = findViewById(R.id.yellowUpMove1);
            downMove1 = findViewById(R.id.yellowDownMove1);
            rightMove1 = findViewById(R.id.yellowRightMove1);
            leftMove2 = findViewById(R.id.yellowLeftMove2);
            upMove2 = findViewById(R.id.yellowUpMove2);
            downMove2 = findViewById(R.id.yellowDownMove2);
            rightMove2 = findViewById(R.id.yellowRightMove2);
        }
        if (songName.equals("queen bee")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.queenbee);
            int greyish = getResources().getColor(R.color.greyish);
            quit.setBackgroundColor(greyish);
            background = findViewById(R.id.queenBeeBackground);
            background.setVisibility(View.VISIBLE);
            box = findViewById(R.id.queenBeeBox);
            downArrow = findViewById(R.id.greyishDown);
            rightArrow = findViewById(R.id.greyishRight);
            upArrow = findViewById(R.id.greyishUp);
            leftArrow = findViewById(R.id.greyishLeft);
            leftOutline = findViewById(R.id.whiteLeftOutline);
            upOutline = findViewById(R.id.whiteUpOutline);
            downOutline = findViewById(R.id.whiteDownOutline);
            rightOutline = findViewById(R.id.whiteRightOutline);
            leftMove = findViewById(R.id.qbLeftMove);
            upMove = findViewById(R.id.qbUpMove);
            downMove = findViewById(R.id.qbDownMove);
            rightMove = findViewById(R.id.qbRightMove);
        }
        if (songName.equals("quaoar")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.quaoar);
            background = findViewById(R.id.quaoarBackground);
            background.setVisibility(View.VISIBLE);
            box = findViewById(R.id.quaoarBox);
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
            leftMove = findViewById(R.id.quaoarLeftMove);
            upMove = findViewById(R.id.quaoarUpMove);
            downMove = findViewById(R.id.quaoarDownMove);
            rightMove = findViewById(R.id.quaoarRightMove);
            leftMove1 = findViewById(R.id.quaoarLeftMove1);
            upMove1 = findViewById(R.id.quaoarUpMove1);
            downMove1 = findViewById(R.id.quaoarDownMove1);
            rightMove1 = findViewById(R.id.quaoarRightMove1);
            leftMove2 = findViewById(R.id.quaoarLeftMove2);
            upMove2 = findViewById(R.id.quaoarUpMove2);
            downMove2 = findViewById(R.id.quaoarDownMove2);
            rightMove2 = findViewById(R.id.quaoarRightMove2);
        }
        if (songName.equals("metamorphosis")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.metamorphosis);
            background = findViewById(R.id.metamorphosisBackground);
            background.setVisibility(View.VISIBLE);
            box = findViewById(R.id.metaBox);
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
            leftMove = findViewById(R.id.metaLeftMove);
            upMove = findViewById(R.id.metaUpMove);
            downMove = findViewById(R.id.metaDownMove);
            rightMove = findViewById(R.id.metaRightMove);
        }
        onScreen = true;
        songLength = currentlyPlaying.getDuration();

        leftMove.setVisibility(View.VISIBLE);
        leftMove.bringToFront();
        upMove.setVisibility(View.VISIBLE);
        upMove.bringToFront();
        downMove.setVisibility(View.VISIBLE);
        downMove.bringToFront();
        rightMove.setVisibility(View.VISIBLE);
        rightMove.bringToFront();
        leftMove1.setVisibility(View.VISIBLE);
        leftMove1.bringToFront();
        upMove1.setVisibility(View.VISIBLE);
        upMove1.bringToFront();
        downMove1.setVisibility(View.VISIBLE);
        downMove1.bringToFront();
        rightMove1.setVisibility(View.VISIBLE);
        rightMove1.bringToFront();
        leftMove2.setVisibility(View.VISIBLE);
        leftMove2.bringToFront();
        upMove2.setVisibility(View.VISIBLE);
        upMove2.bringToFront();
        downMove2.setVisibility(View.VISIBLE);
        downMove2.bringToFront();
        rightMove2.setVisibility(View.VISIBLE);
        rightMove2.bringToFront();

        box.setVisibility(View.GONE);
        box.bringToFront();

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

        final Handler delayHandler = new Handler();
        delayHandler.postDelayed(new Runnable() {
            public void run() {
                currentlyPlaying.start();
            }
        }, 1000);

        final Handler animateHandler = new Handler();
        for (int i = 0; i < direction.size(); i++) {
            current = getCurrent(direction.get(i));
//            delay = getDelay()
            animateHandler.postDelayed(new Runnable() {
                public void run() {
                    move(current);
                }
            }, 1000);
        }

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
    ImageView current;
    ArrayList<String> direction = ChartProperties.direction;
    ArrayList<Double> beat = ChartProperties.beat;

    public void move (ImageView toMove) {
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        toMove.startAnimation(animation1);
    }

    /**
     * determine which copy to use among three copies of each arrows.
     */
    int leftCount = 0;
    int downCount = 0;
    int upCount = 0;
    int rightCount = 0;
    public ImageView getCurrent(String which) {
        if (which.equals("left")) {
            if (leftCount == 0) {
                leftCount++;
                return leftMove;
            }
            if (leftCount == 1) {
                leftCount++;
                return leftMove1;
            }
            if (leftCount == 2) {
                leftCount = 0;
                return leftMove2;
            }
        }
        if (which.equals("down")) {
            if (downCount == 0) {
                downCount++;
                return downMove;
            }
            if (downCount == 1) {
                downCount++;
                return downMove1;
            }
            if (downCount == 2) {
                downCount = 0;
                return downMove2;
            }
        }
        if (which.equals("up")) {
            if (upCount == 0) {
                upCount++;
                return upMove;
            }
            if (upCount == 1) {
                upCount++;
                return upMove1;
            }
            if (upCount == 2) {
                upCount = 0;
                return upMove2;
            }
        }
        if (which.equals("right")) {
            if (rightCount == 0) {
                rightCount++;
                return rightMove;
            }
            if (rightCount == 1) {
                rightCount++;
                return rightMove1;
            }
            if (rightCount == 2) {
                rightCount = 0;
                return rightMove2;
            }
        }
        return null;
    }
    public double getDelay(double currentBeat) {
        double BPM = ChartProperties.getBPM();
        double offset = ChartProperties.getOffset();
        return 1000*((1/BPM) + offset + 1) * currentBeat;
    }
}