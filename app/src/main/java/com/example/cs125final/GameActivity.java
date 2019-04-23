package com.example.cs125final;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

/**
 * MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.ring);
 *         ring.start();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        leftArrow = findViewById(R.id.left_image);
        leftArrow.bringToFront();
        left = findViewById(R.id.left_button);
        left.setEnabled(true);
        left.bringToFront();

        upArrow = findViewById(R.id.up_image);
        upArrow.bringToFront();
        up = findViewById(R.id.up_button);
        up.setEnabled(true);
        up.bringToFront();

        rightArrow = findViewById(R.id.right_image);
        rightArrow.bringToFront();
        right = findViewById(R.id.right_button);
        right.setEnabled(true);
        right.bringToFront();

        downArrow = findViewById(R.id.down_image);
        downArrow.bringToFront();

        /** this is here for DEBUGGING PURPOSES*/
        down = findViewById(R.id.down_button);
        down.setEnabled(true);
        down.bringToFront();
        down.setOnClickListener((v) -> nextScreen());

        quit = findViewById(R.id.quit);
        quit.setEnabled(true);
        int green = getResources().getColor(R.color.green);
        quit.setBackgroundColor(green);
        quit.setOnClickListener((v) -> nextScreen());

        // it changes screens after a small delay
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                GameActivity.this.startActivity(intent);
                GameActivity.this.finish();
            }
            // add three zeros to however seconds x you want to make it
        }, 4000);
    }
    public void nextScreen() {
        Intent setupIntent = new Intent(this, ResultActivity.class);
        startActivity(setupIntent);
        finish();
    }
}