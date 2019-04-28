package com.example.cs125final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// TODO: create banners for each of the songs

public class TitleActivity extends AppCompatActivity {


    TextView titleText;
    ImageView marionetteBanner;
    ImageView quaoarBanner;
    ImageView queenBeeBanner;
    ImageView metamorphosisBanner;
    Button song1;
    Button song2;
    Button song3;
    Button song4;
    String first = "first";
    String second = "second";
    String third = "third";
    String fourth = "fourth";
    static String songName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        titleText = findViewById(R.id.title);
        titleText.bringToFront();
        int white = getResources().getColor(R.color.white);
        titleText.setTextColor(white);

        marionetteBanner = findViewById(R.id.marionetteBanner);
        marionetteBanner.bringToFront();
        quaoarBanner = findViewById(R.id.quaoarBanner);
        quaoarBanner.bringToFront();
        queenBeeBanner = findViewById(R.id.queenBeeBanner);
        queenBeeBanner.bringToFront();
        metamorphosisBanner = findViewById(R.id.metamorphosisBanner);
        metamorphosisBanner.bringToFront();

        /** at this point, you may have to change something in your settings
         * go to file -> project structure -> app
         * then set both the target and source compatability to 1.8
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


    /** eventually, this will play the music that the person chose
     * for now, it just brings people to the game activity screen */
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
            songName = "metamorphosis";
        }
        Intent setupIntent = new Intent(this, GameActivity.class);
        startActivity(setupIntent);
        finish();
    }
    public static String getSong() {
        return songName;
    }

}
