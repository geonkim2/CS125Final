package com.example.cs125final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import android.view.animation.Animation;
import android.widget.TextView;

// TODO: fix the song title in GameActivity, CharProperties, and File

/** fantastic = blue
 *  excellent = yellow
 *  great = green
 *  miss = red
 */
public class GameActivity extends AppCompatActivity {

    /** this declares each of the variable names*/
    Button quit;
    ImageView box;
    ImageView leftMove;
    ImageView rightMove;
    ImageView upMove;
    ImageView downMove;
    ImageView leftMove1;
    ImageView rightMove1;
    ImageView upMove1;
    ImageView downMove1;
    ImageView leftMove2;
    ImageView rightMove2;
    ImageView upMove2;
    ImageView downMove2;
    ImageView leftMove3;
    ImageView rightMove3;
    ImageView upMove3;
    ImageView downMove3;
    ImageView leftMove4;
    ImageView rightMove4;
    ImageView upMove4;
    ImageView downMove4;
    ImageView leftMove5;
    ImageView rightMove5;
    ImageView upMove5;
    ImageView downMove5;
    ImageView leftMove6;
    ImageView rightMove6;
    ImageView upMove6;
    ImageView downMove6;
    ImageView leftArrow;
    ImageView upArrow;
    ImageView downArrow;
    ImageView rightArrow;
    ImageView leftOutline;
    ImageView upOutline;
    ImageView downOutline;
    ImageView rightOutline;
    Button leftButton;
    Button upButton;
    Button downButton;
    Button rightButton;
    String songName;
    MediaPlayer currentlyPlaying;
    ImageView background;
    public boolean onScreen;
    int songLength;
    long delayLength;
    ArrayList<String> marionetteDirection;
    ArrayList<Double> marionetteBeat;
    ArrayList<String> queenBeeDirection;
    ArrayList<Double> queenBeeBeat;
    ArrayList<String> quaoarDirection;
    ArrayList<Double> quaoarBeat;
    ArrayList<String> peacockDirection;
    ArrayList<Double> peacockBeat;
    TextView fantastic;
    TextView excellent;
    TextView great;
    TextView miss;
    int index;

    /** this is everything that happens when the app loads*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        quit = findViewById(R.id.quit);
        /** this declares the string of what song it is*/
        songName = TitleActivity.getSong();

        ChartProperties.parseNotes("peacock");
        peacockBeat = new ArrayList<>(ChartProperties.beat);
        peacockDirection = new ArrayList<>(ChartProperties.direction);
        ChartProperties.parseNotes("marionette");
        marionetteBeat = new ArrayList<>(ChartProperties.beat);
        marionetteDirection = new ArrayList<>(ChartProperties.direction);
        ChartProperties.parseNotes("queen bee");
        queenBeeBeat = new ArrayList<>(ChartProperties.beat);
        queenBeeDirection = new ArrayList<>(ChartProperties.direction);
        ChartProperties.parseNotes("quaoar");
        quaoarBeat = new ArrayList<>(ChartProperties.beat);
        quaoarDirection = new ArrayList<>(ChartProperties.direction);

        /** each of these declare what to make each variable equal to
         * since the layout of each song is different, we need to do this.
         */
        if (songName.equals("marionette")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.marionette);
            songLength = 94000;
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
            leftMove3 = findViewById(R.id.yellowLeftMove3);
            upMove3 = findViewById(R.id.yellowUpMove3);
            downMove3 = findViewById(R.id.yellowDownMove3);
            rightMove3 = findViewById(R.id.yellowRightMove3);
            leftMove4 = findViewById(R.id.yellowLeftMove4);
            upMove4 = findViewById(R.id.yellowUpMove4);
            downMove4 = findViewById(R.id.yellowDownMove4);
            rightMove4 = findViewById(R.id.yellowRightMove4);
            leftMove5 = findViewById(R.id.yellowLeftMove5);
            upMove5 = findViewById(R.id.yellowUpMove5);
            downMove5 = findViewById(R.id.yellowDownMove5);
            rightMove5 = findViewById(R.id.yellowRightMove5);
            leftMove6 = findViewById(R.id.yellowLeftMove6);
            upMove6 = findViewById(R.id.yellowUpMove6);
            downMove6 = findViewById(R.id.yellowDownMove6);
            rightMove6 = findViewById(R.id.yellowRightMove6);
        }
        if (songName.equals("queen bee")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.queenbee);
            songLength = 125000;
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
            leftMove1 = findViewById(R.id.qbLeftMove1);
            upMove1 = findViewById(R.id.qbUpMove1);
            downMove1 = findViewById(R.id.qbDownMove1);
            rightMove1 = findViewById(R.id.qbRightMove1);
            leftMove2 = findViewById(R.id.qbLeftMove2);
            upMove2 = findViewById(R.id.qbUpMove2);
            downMove2 = findViewById(R.id.qbDownMove2);
            rightMove2 = findViewById(R.id.qbRightMove2);
            leftMove3 = findViewById(R.id.qbLeftMove3);
            upMove3 = findViewById(R.id.qbUpMove3);
            downMove3 = findViewById(R.id.qbDownMove3);
            rightMove3 = findViewById(R.id.qbRightMove3);
            leftMove4 = findViewById(R.id.qbLeftMove4);
            upMove4 = findViewById(R.id.qbUpMove4);
            downMove4 = findViewById(R.id.qbDownMove4);
            rightMove4 = findViewById(R.id.qbRightMove4);
            leftMove5 = findViewById(R.id.qbLeftMove5);
            upMove5 = findViewById(R.id.qbUpMove5);
            downMove5 = findViewById(R.id.qbDownMove5);
            rightMove5 = findViewById(R.id.qbRightMove5);
            leftMove6 = findViewById(R.id.qbLeftMove6);
            upMove6 = findViewById(R.id.qbUpMove6);
            downMove6 = findViewById(R.id.qbDownMove6);
            rightMove6 = findViewById(R.id.qbRightMove6);
        }
        if (songName.equals("quaoar")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.quaoar);
            songLength = 159000;
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
            leftMove3 = findViewById(R.id.quaoarLeftMove3);
            upMove3 = findViewById(R.id.quaoarUpMove3);
            downMove3 = findViewById(R.id.quaoarDownMove3);
            rightMove3 = findViewById(R.id.quaoarRightMove3);
            leftMove4 = findViewById(R.id.quaoarLeftMove4);
            upMove4 = findViewById(R.id.quaoarUpMove4);
            downMove4 = findViewById(R.id.quaoarDownMove4);
            rightMove4 = findViewById(R.id.quaoarRightMove4);
            leftMove5 = findViewById(R.id.quaoarLeftMove5);
            upMove5 = findViewById(R.id.quaoarUpMove5);
            downMove5 = findViewById(R.id.quaoarDownMove5);
            rightMove5 = findViewById(R.id.quaoarRightMove5);
            leftMove6 = findViewById(R.id.quaoarLeftMove6);
            upMove6 = findViewById(R.id.quaoarUpMove6);
            downMove6 = findViewById(R.id.quaoarDownMove6);
            rightMove6 = findViewById(R.id.quaoarRightMove6);
        }
        if (songName.equals("peacock")) {
            currentlyPlaying = MediaPlayer.create(GameActivity.this, R.raw.peackock);
            songLength = 136000;
            background = findViewById(R.id.peacockBackground);
            background.setVisibility(View.VISIBLE);
            box = findViewById(R.id.peacockBox);
            int green = getResources().getColor(R.color.white);
            quit.setBackgroundColor(green);
            downArrow = findViewById(R.id.peacockDown);
            rightArrow = findViewById(R.id.peacockRight);
            upArrow = findViewById(R.id.peacockUp);
            leftArrow = findViewById(R.id.peacockLeft);
            leftOutline = findViewById(R.id.blackLeftOutline);
            upOutline = findViewById(R.id.blackUpOutline);
            downOutline = findViewById(R.id.blackDownOutline);
            rightOutline = findViewById(R.id.blackRightOutline);
            leftMove = findViewById(R.id.peacockLeftMove);
            upMove = findViewById(R.id.peacockUpMove);
            downMove = findViewById(R.id.peacockDownMove);
            rightMove = findViewById(R.id.peacockRightMove);
            leftMove1 = findViewById(R.id.peacockLeftMove1);
            upMove1 = findViewById(R.id.peacockUpMove1);
            downMove1 = findViewById(R.id.peacockDownMove1);
            rightMove1 = findViewById(R.id.peacockRightMove1);
            leftMove2 = findViewById(R.id.peacockLeftMove2);
            upMove2 = findViewById(R.id.peacockUpMove2);
            downMove2 = findViewById(R.id.peacockDownMove2);
            rightMove2 = findViewById(R.id.peacockRightMove2);
            leftMove3 = findViewById(R.id.peacockLeftMove3);
            upMove3 = findViewById(R.id.peacockUpMove3);
            downMove3 = findViewById(R.id.peacockDownMove3);
            rightMove3 = findViewById(R.id.peacockRightMove3);
            leftMove4 = findViewById(R.id.peacockLeftMove4);
            upMove4 = findViewById(R.id.peacockUpMove4);
            downMove4 = findViewById(R.id.peacockDownMove4);
            rightMove4 = findViewById(R.id.peacockRightMove4);
            leftMove5 = findViewById(R.id.peacockLeftMove5);
            upMove5 = findViewById(R.id.peacockUpMove5);
            downMove5 = findViewById(R.id.peacockDownMove5);
            rightMove5 = findViewById(R.id.peacockRightMove5);
            leftMove6 = findViewById(R.id.peacockLeftMove6);
            upMove6 = findViewById(R.id.peacockUpMove6);
            downMove6 = findViewById(R.id.peacockDownMove6);
            rightMove6 = findViewById(R.id.peacockRightMove6);
        }
        /**this says I'm still on the screen
         * this prevents double screen changing
         * the app is set up so that it automatically changes screens when the song is finished
         * it's on a timer, so we need ths variable to do that
         */
        onScreen = true;

        /** i set the arrow "outlines" to visible
         * this is what tells you when to hit the arrows
         */
        leftOutline.setVisibility(View.VISIBLE);
        leftOutline.bringToFront();
        upOutline.setVisibility(View.VISIBLE);
        upOutline.bringToFront();
        downOutline.setVisibility(View.VISIBLE);
        downOutline.bringToFront();
        rightOutline.setVisibility(View.VISIBLE);
        rightOutline.bringToFront();

        /** this brings literally every moving arrow to the front
         * this must be done before bringing the box of the arrows to the front
         */
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
        leftMove3.setVisibility(View.VISIBLE);
        leftMove3.bringToFront();
        upMove3.setVisibility(View.VISIBLE);
        upMove3.bringToFront();
        downMove3.setVisibility(View.VISIBLE);
        downMove3.bringToFront();
        rightMove3.setVisibility(View.VISIBLE);
        rightMove3.bringToFront();
        leftMove4.setVisibility(View.VISIBLE);
        leftMove4.bringToFront();
        upMove4.setVisibility(View.VISIBLE);
        upMove4.bringToFront();
        downMove4.setVisibility(View.VISIBLE);
        downMove4.bringToFront();
        rightMove4.setVisibility(View.VISIBLE);
        rightMove4.bringToFront();
        leftMove5.setVisibility(View.VISIBLE);
        leftMove5.bringToFront();
        upMove5.setVisibility(View.VISIBLE);
        upMove5.bringToFront();
        downMove5.setVisibility(View.VISIBLE);
        downMove5.bringToFront();
        rightMove5.setVisibility(View.VISIBLE);
        rightMove5.bringToFront();
        leftMove6.setVisibility(View.VISIBLE);
        leftMove6.bringToFront();
        upMove6.setVisibility(View.VISIBLE);
        upMove6.bringToFront();
        downMove6.setVisibility(View.VISIBLE);
        downMove6.bringToFront();
        rightMove6.setVisibility(View.VISIBLE);
        rightMove6.bringToFront();

        /** I'm initializing the judgements
         * and im making them each specific color
         * and making them visible using shadow
         */
        int black = getResources().getColor(R.color.black);
        int blue = getResources().getColor(R.color.blue);
        fantastic = findViewById(R.id.fantasticText);
        fantastic.setTextColor(blue);
        fantastic.setTextSize(35);
        fantastic.setShadowLayer(0.02f, -4, 4, black);
        int yellow = getResources().getColor(R.color.yellow);
        excellent = findViewById(R.id.excellentText);
        excellent.setTextColor(yellow);
        excellent.setTextSize(35);
        excellent.setShadowLayer(0.02f, -4, 4, black);
        int green = getResources().getColor(R.color.green);
        great = findViewById(R.id.greatText);
        great.setTextColor(green);
        great.setTextSize(35);
        great.setShadowLayer(0.02f, -4, 4, black);
        int red = getResources().getColor(R.color.red);
        miss = findViewById(R.id.missText);
        miss.setTextColor(red);
        miss.setTextSize(35);
        miss.setShadowLayer(0.02f, -4, 4, black);


        /** now i set the box to the front so that the arrows are covered up*/
        box.setVisibility(View.VISIBLE);
        box.bringToFront();

        /** this is where the outline bring front was*/

        /** this sets the visibility of the ImageViews */
        upArrow.setVisibility(View.VISIBLE);
        leftArrow.setVisibility(View.VISIBLE);
        rightArrow.setVisibility(View.VISIBLE);
        downArrow.setVisibility(View.VISIBLE);

        /** now, i bring each of the buttons to the front
         * they're invisible, so you can't see them
         * but if they're not in front, you cant click them
         */
        leftArrow.bringToFront();
        leftButton = findViewById(R.id.left_button);
        leftButton.setEnabled(true);
        leftButton.bringToFront();
        upArrow.bringToFront();
        upButton = findViewById(R.id.up_button);
        upButton.setEnabled(true);
        upButton.bringToFront();
        rightButton = findViewById(R.id.right_button);
        rightButton.setEnabled(true);
        rightButton.bringToFront();
        rightArrow.bringToFront();

        /** this is here for DEBUGGING PURPOSES
         * basically, by making the button do something, you prove it works
         */
        downButton = findViewById(R.id.down_button);
        downButton.setEnabled(true);
        downButton.bringToFront();
        downButton.setOnClickListener((v) -> hit());
        downArrow.bringToFront();

        /** now, i set the quit button to quit*/
        quit.setEnabled(true);
        quit.setOnClickListener((v) -> nextScreen());

        /** this delays the song start by one second
         * as per Geon's request
         */
        final Handler delayHandler = new Handler();
        delayHandler.postDelayed(new Runnable() {
            public void run() {
                currentlyPlaying.start();
            }
        }, 1000);

        /** this actually animates the arrows
         * it's on a timer
         */
        final Handler animateHandler = new Handler();
        ArrayList<String> direction = new ArrayList<>();
        ArrayList<Double> beat = new ArrayList<>();
        if (songName.equals("marionette")) {
            direction = marionetteDirection;
            beat = marionetteBeat;
        }
        if (songName.equals("quaoar")) {
            direction = quaoarDirection;
            beat = quaoarBeat;
        }
        if (songName.equals("queen bee")) {
            direction = queenBeeDirection;
            beat = queenBeeBeat;
        }
        if (songName.equals("peacock")) {
            direction = peacockDirection;
            beat = peacockBeat;
        }
        index = 0;
        for (int i = 0; i < beat.size(); i++) {
            String currentDirection = direction.get(i);
            delayLength = (long) getDelay(beat.get(i));
            index++;
            animateHandler.postDelayed(new Runnable() {
                public void run() {
                    if (currentDirection.equals("left")) {
                        leftCount++;
                        if (leftCount == 7) {
                            leftCount = 0;
                        }
                        if (leftCount == 0) {
                            move(leftMove);
                        }
                        if (leftCount == 1) {
                            move(leftMove1);
                        }
                        if (leftCount == 2) {
                            move(leftMove2);
                        }
                        if (leftCount == 3) {
                            move(leftMove3);
                        }
                        if (leftCount == 4) {
                            move(leftMove4);
                        }
                        if (leftCount == 5) {
                            move(leftMove5);
                        }
                        if (leftCount == 6) {
                            move(leftMove6);
                        }
                    }
                    if (currentDirection.equals("down")) {
                        downCount++;
                        if (downCount == 7) {
                            downCount = 0;
                        }
                        if (downCount == 0) {
                            move(downMove);
                        }
                        if (downCount == 1) {
                            move(downMove1);
                        }
                        if (downCount == 2) {
                            move(downMove2);
                        }
                        if (downCount == 3) {
                            move(downMove3);
                        }
                        if (downCount == 4) {
                            move(downMove4);
                        }
                        if (downCount == 5) {
                            move(downMove5);
                        }
                        if (downCount == 6) {
                            move(downMove6);
                        }
                    }
                    if (currentDirection.equals("up")) {
                        upCount++;
                        if (upCount == 7) {
                            upCount = 0;
                        }
                        if (upCount == 0) {
                            move(upMove);
                        }
                        if (upCount == 1) {
                            move(upMove1);
                        }
                        if (upCount == 2) {
                            move(upMove2);
                        }
                        if (upCount == 3) {
                            move(upMove3);
                        }
                        if (upCount == 4) {
                            move(upMove4);
                        }
                        if (upCount == 5) {
                            move(upMove5);
                        }
                        if (upCount == 6) {
                            move(upMove6);
                        }
                    }
                    if (currentDirection.equals("right")) {
                        rightCount++;
                        if (rightCount == 7) {
                            rightCount = 0;
                        }
                        if (rightCount == 0) {
                            move(rightMove);
                        }
                        if (rightCount == 1) {
                            move(rightMove1);
                        }
                        if (rightCount == 2) {
                            move(rightMove2);
                        }
                        if (rightCount == 3) {
                            move(rightMove3);
                        }
                        if (rightCount == 4) {
                            move(rightMove4);
                        }
                        if (rightCount == 5) {
                            move(rightMove5);
                        }
                        if (rightCount == 6) {
                            move(rightMove6);
                        }
                    }
                }
            }, delayLength);
        }

        /** the changes screens after the song is over*/
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

    /** this is the function called by the green button*/
    public void nextScreen() {
        onScreen = false;
        currentlyPlaying.stop();
        Intent setupIntent = new Intent(this, ResultActivity.class);
        startActivity(setupIntent);
        finish();
    }

    /** this is the functioned called by the animation*/
    public void move(ImageView toMove) {
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        toMove.startAnimation(animation1);
    }
    int leftCount = 0;
    int downCount = 0;
    int upCount = 0;
    int rightCount = 0;

    /** this is the delay put into the animation
     * each arrow has its own delay
     */
    public double getDelay(double currentBeat) {
        double BPM = ChartProperties.getBPM();
        double offset = ChartProperties.getOffset();
        return 1000 * ((60 / BPM)*currentBeat + offset + 1) - 1178.57143;
    }
    static int fantasticCount = 0;
    static int excellentCount = 0;
    static int greatCount = 0;
    static int missCount = 0;
    public void hit(double delay, double currentPosition) {
        if ((currentPosition < (delay + 100)) && currentPosition > (delay - 100)) {
            fantasticCount++;
            fantastic.setVisibility(View.VISIBLE);
            excellent.setVisibility(View.INVISIBLE);
            great.setVisibility(View.INVISIBLE);
            miss.setVisibility(View.INVISIBLE);
        } else if ((currentPosition < (delay + 500)) && currentPosition > (delay - 500)) {
            excellentCount++;
            fantastic.setVisibility(View.INVISIBLE);
            excellent.setVisibility(View.VISIBLE);
            great.setVisibility(View.INVISIBLE);
            miss.setVisibility(View.INVISIBLE);
        } else if ((currentPosition < (delay + 1000)) && currentPosition > (delay - 1000)) {
            greatCount++;
            fantastic.setVisibility(View.INVISIBLE);
            excellent.setVisibility(View.INVISIBLE);
            great.setVisibility(View.VISIBLE);
            miss.setVisibility(View.INVISIBLE);
        } else {
            missCount++;
            fantastic.setVisibility(View.INVISIBLE);
            excellent.setVisibility(View.INVISIBLE);
            great.setVisibility(View.INVISIBLE);
            miss.setVisibility(View.VISIBLE);
        }

    }
    public void hit() {
        hit(delayLength + 1178.57143, currentlyPlaying.getCurrentPosition());
    }
}