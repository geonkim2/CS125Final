package com.example.cs125final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button titleReturn;
    TextView nice;
    TextView score;
    TextView wordFantastic;
    TextView fantasticNumber;
    TextView wordExcellent;
    TextView excellentNumber;
    TextView wordGreat;
    TextView greatNumber;
    TextView wordMiss;
    TextView missNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        titleReturn = findViewById(R.id.return_to_title);
        titleReturn.setOnClickListener((v -> returnToTitle()));

        nice = findViewById(R.id.nice);
        score = findViewById(R.id.grade);
        wordFantastic = findViewById(R.id.fantastic_word);
        fantasticNumber = findViewById(R.id.fantastic_number);
        wordExcellent = findViewById(R.id.excellent_word);
        excellentNumber = findViewById(R.id.excellent_number);
        wordGreat = findViewById(R.id.great_word);
        greatNumber = findViewById(R.id.great_number);
        wordMiss = findViewById(R.id.miss_word);
        missNumber = findViewById(R.id.miss_number);

        bringToFront();
        makeWhite();
        textSize();
        isNice();
    }
    public void returnToTitle() {
        Intent setupIntent = new Intent(this, TitleActivity.class);
        startActivity(setupIntent);
        finish();
    }
    public void bringToFront() {
        score.bringToFront();
        nice.bringToFront();
        wordFantastic.bringToFront();
        fantasticNumber.bringToFront();
        wordExcellent.bringToFront();
        excellentNumber.bringToFront();
        wordGreat.bringToFront();
        greatNumber.bringToFront();
        wordMiss.bringToFront();
        missNumber.bringToFront();
    }
    public void textSize() {
        score.setTextSize(60);
        wordFantastic.setTextSize(20);
        fantasticNumber.setTextSize(20);
        wordExcellent.setTextSize(20);
        excellentNumber.setTextSize(20);
        wordGreat.setTextSize(20);
        greatNumber.setTextSize(20);
        wordMiss.setTextSize(20);
        missNumber.setTextSize(20);
    }
    public void makeWhite() {
        int white = getResources().getColor(R.color.white);
        score.setTextColor(white);
        nice.setTextColor(white);
        wordFantastic.setTextColor(white);
        fantasticNumber.setTextColor(white);
        wordExcellent.setTextColor(white);
        excellentNumber.setTextColor(white);
        wordGreat.setTextColor(white);
        greatNumber.setTextColor(white);
        wordMiss.setTextColor(white);
        missNumber.setTextColor(white);
    }
    public void isNice() {
        CharSequence first = fantasticNumber.getText();
        CharSequence second = excellentNumber.getText();
        CharSequence third = greatNumber.getText();
        CharSequence fourth = missNumber.getText();
        if (first.toString().contains("69") || second.toString().contains("69")
            || third.toString().contains("69") || fourth.toString().contains("69")){
            nice.setVisibility(View.VISIBLE);
        } else {
            nice.setVisibility(View.GONE);
        }
    }
}