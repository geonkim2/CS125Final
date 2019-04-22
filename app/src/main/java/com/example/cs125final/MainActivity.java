package com.example.cs125final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//This is everything they imported on the json mp
//So I just copied and pasted lmao
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //I'm just making title text work
        titleText = findViewById(R.id.title);
        titleText.bringToFront();
        int white = getResources().getColor(R.color.white);
        titleText.setTextColor(white);
    }
}
