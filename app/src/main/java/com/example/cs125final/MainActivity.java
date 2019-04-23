package com.example.cs125final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView titleText;

    Button song1;
    Button song2;
    Button song3;
    Button song4;

    String first = "first";
    String second = "second";
    String third = "third";
    String fourth = "fourth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // I'm just making title text work
        titleText = findViewById(R.id.title);
        titleText.bringToFront();
        int white = getResources().getColor(R.color.white);
        titleText.setTextColor(white);

        /** now I'm assigning buttons to what they do
         * for now, when they're clicked, they go to the game activity screen
         * eventually, they'll go to the song clicked
         * and then a chart will come down
         * im thinking the cart should prob be random arrows
         * making an actual chart would be a lot of work lmao */
        // first, set song equal to an id
        song1 = findViewById(R.id.song_1);
        // then, bring the button to the front
        song1.bringToFront();
        /** at this point, you may have to change something in your settings
         * go to file -> project structure -> app
         * then set both the target and source compatability to 1.8
         */
        // now, make the button clickable and call it to the play music
        // this will play a different song based on what you call
        // well need to figure out how to link it to game activity though
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
            Intent setupIntent = new Intent(this, GameActivity.class);
            startActivity(setupIntent);
            finish();
        }
        if (song.equals(second)) {
            Intent setupIntent = new Intent(this, GameActivity.class);
            startActivity(setupIntent);
            finish();
        }
        if (song.equals(third)) {
            Intent setupIntent = new Intent(this, GameActivity.class);
            startActivity(setupIntent);
            finish();
        }
        if (song.equals(fourth)) {
            Intent setupIntent = new Intent(this, GameActivity.class);
            startActivity(setupIntent);
            finish();
        }
    }
}
