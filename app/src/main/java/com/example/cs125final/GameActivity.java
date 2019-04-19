package com.example.cs125final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.ring);
 *         ring.start();
 */
public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

