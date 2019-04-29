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
import android.widget.TextView;

import java.lang.Cloneable;

import static com.example.cs125final.ChartProperties.getBPM;

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
    ImageView current;
    ArrayList<String> direction;
    ArrayList<Double> beat;
    TextView fantastic;
    TextView excellent;
    TextView great;
    TextView miss;

    /** this is everything that happens when the app loads*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        quit = findViewById(R.id.quit);
        /** this declares the string of what song it is*/
        songName = TitleActivity.getSong();
        /** each of these declare what to make each variable equal to
         * since the layout of each song is different, we need to do this.
         */
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
            leftMove3 = findViewById(R.id.yellowLeftMove3);
            upMove3 = findViewById(R.id.yellowUpMove3);
            downMove3 = findViewById(R.id.yellowDownMove3);
            rightMove3 = findViewById(R.id.yellowRightMove3);
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
            leftMove3 = findViewById(R.id.quaoarLeftMove3);
            upMove3 = findViewById(R.id.quaoarUpMove3);
            downMove3 = findViewById(R.id.quaoarDownMove3);
            rightMove3 = findViewById(R.id.quaoarRightMove3);
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
            leftMove1 = findViewById(R.id.metaLeftMove1);
            upMove1 = findViewById(R.id.metaUpMove1);
            downMove1 = findViewById(R.id.metaDownMove1);
            rightMove1 = findViewById(R.id.metaRightMove1);
            leftMove2 = findViewById(R.id.metaLeftMove2);
            upMove2 = findViewById(R.id.metaUpMove2);
            downMove2 = findViewById(R.id.metaDownMove2);
            rightMove2 = findViewById(R.id.metaRightMove2);
            leftMove3 = findViewById(R.id.metaLeftMove3);
            upMove3 = findViewById(R.id.metaUpMove3);
            downMove3 = findViewById(R.id.metaDownMove3);
            rightMove3 = findViewById(R.id.metaRightMove3);
        }
        /**this says I'm still on the screen
         * this prevents double screen changing
         * the app is set up so that it automatically changes screens when the song is finished
         * it's on a timer, so we need ths variable to do that
         */
        onScreen = true;
        songLength = currentlyPlaying.getDuration();

        /** this is where we get the chart
         * beat is the current beat that we're on
         * direction is which arrow we want to move
         */
        ChartProperties.parseNotes();
        beat = ChartProperties.beat;
        direction = ChartProperties.direction;

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
        downButton.setOnClickListener((v) -> nextScreen());
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
        for (int i = 0; i < beat.size(); i++) {
            String currentDirection = direction.get(i);
            delayLength = (long) getDelay(beat.get(i));
            animateHandler.postDelayed(new Runnable() {
                public void run() {
                    if (currentDirection.equals("left")) {
                        leftCount++;
                        if (leftCount == 4) {
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
                    }
                    if (currentDirection.equals("down")) {
                        downCount++;
                        if (downCount == 4) {
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
                    }
                    if (currentDirection.equals("up")) {
                        upCount++;
                        if (upCount == 4) {
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
                    }
                    if (currentDirection.equals("right")) {
                        rightCount++;
                        if (rightCount == 4) {
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
        //3000 is the delay in move
        return 1000 * ((60 / BPM)*currentBeat + offset + 1) - 1178.57143;
    }
    static int fantasticcount;
    static int excellentcount;
    static int greatcount;
    static int misscount;
    public void hit(String direction, double delay, double currentPosition) {
        if ((currentPosition < (delay + 50)) && currentPosition > (delay - 50)) {
            fantasticcount++;
            fantastic.setVisibility(View.VISIBLE);
            excellent.setVisibility(View.INVISIBLE);
            great.setVisibility(View.INVISIBLE);
            miss.setVisibility(View.INVISIBLE);
        } else if ((currentPosition < (delay + 100)) && currentPosition > (delay - 100)) {
            excellentcount++;
            fantastic.setVisibility(View.INVISIBLE);
            excellent.setVisibility(View.VISIBLE);
            great.setVisibility(View.INVISIBLE);
            miss.setVisibility(View.INVISIBLE);
        } else if ((currentPosition < (delay + 150)) && currentPosition > (delay - 150)) {
            greatcount++;
            fantastic.setVisibility(View.INVISIBLE);
            excellent.setVisibility(View.INVISIBLE);
            great.setVisibility(View.VISIBLE);
            miss.setVisibility(View.INVISIBLE);
        } else {
            misscount++;
            fantastic.setVisibility(View.INVISIBLE);
            excellent.setVisibility(View.INVISIBLE);
            great.setVisibility(View.INVISIBLE);
            miss.setVisibility(View.VISIBLE);
        }

    }

}