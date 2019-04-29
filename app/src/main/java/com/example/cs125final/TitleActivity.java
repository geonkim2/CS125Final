package com.example.cs125final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class TitleActivity extends AppCompatActivity {

    /** this states all teh variables*/
    TextView titleText;
    ImageView marionetteBanner;
    ImageView quaoarBanner;
    ImageView queenBeeBanner;
    ImageView fuckgravityBanner;
    Button song1;
    Button song2;
    Button song3;
    Button song4;
    String first = "first";
    String second = "second";
    String third = "third";
    String fourth = "fourth";
    static String songName;
    TextView easy;
    TextView medium;
    TextView hard;
    TextView demonic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        /** this sets the title
         * it becomes white
         * and is brought to the front
         */
        titleText = findViewById(R.id.title);
        titleText.bringToFront();
        int white = getResources().getColor(R.color.white);
        titleText.setTextColor(white);

        /** this determines each of the banners
         * it also brings them in front of the background
         */
        marionetteBanner = findViewById(R.id.marionetteBanner);
        marionetteBanner.bringToFront();
        quaoarBanner = findViewById(R.id.quaoarBanner);
        quaoarBanner.bringToFront();
        queenBeeBanner = findViewById(R.id.queenBeeBanner);
        queenBeeBanner.bringToFront();
        fuckgravityBanner = findViewById(R.id.fuckgravityBanner);
        fuckgravityBanner.bringToFront();

        /** this sets the difficulty texts*/
        easy = findViewById(R.id.easy);
        easy.setTextColor(white);
        easy.bringToFront();
        easy.setTextSize(25);
        medium = findViewById(R.id.medium);
        medium.setTextColor(white);
        medium.bringToFront();
        medium.setTextSize(25);
        hard = findViewById(R.id.hard);
        hard.setTextColor(white);
        hard.bringToFront();
        hard.setTextSize(25);
        demonic = findViewById(R.id.demonic);
        demonic.setTextColor(white);
        demonic.bringToFront();
        demonic.setTextSize(25);

        /* at this point, you may have to change something in your settings
         * go to file -> project structure -> app
         * then set both the target and source compatability to 1.8
         */
        /** this initializes each of the buttons
         * they're all invisible
         * but they're brought in front of the imageViews
         * it also allows you to determine which song is chosen
         * this will be used later on
         */
        song1 = findViewById(R.id.song_1);
        song1.bringToFront();
        song1.setOnClickListener((v) -> playMusic(first));
        song2 = findViewById(R.id.song_2);
        song2.bringToFront();
        song2.setOnClickListener((v) -> playMusic(second));
        song3 = findViewById(R.id.song_3);
        song3.bringToFront();
        song3.setOnClickListener((v) -> playMusic(third));
        song4 = findViewById(R.id.song_4);
        song4.bringToFront();
        song4.setOnClickListener((v) -> playMusic(fourth));
    }


    /** this brings you to the next screen
     * it also determines which song is played
     * and makes a variable called songName
     */
    protected void playMusic(String song) {
        if (song.equals(first)) {
            songName = "marionette";
        }
        if (song.equals(second)) {
            songName = "quaoar";
        }
        if (song.equals(third)) {
            songName = "queen bee";
        }
        if (song.equals(fourth)) {
            songName = "fuck gravity";
        }
        Intent setupIntent = new Intent(this, GameActivity.class);
        startActivity(setupIntent);
        finish();
    }
    /** this just gets the song name*/
    public static String getSong() {
        return songName;
    }

}
