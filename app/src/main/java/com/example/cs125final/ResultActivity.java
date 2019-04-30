package com.example.cs125final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.cs125final.GameActivity.downRecord;
import static com.example.cs125final.GameActivity.leftRecord;
import static com.example.cs125final.GameActivity.leftSize;
import static com.example.cs125final.GameActivity.rightRecord;
import static com.example.cs125final.GameActivity.rightSize;
import static com.example.cs125final.GameActivity.upRecord;

public class ResultActivity extends AppCompatActivity {

    /** this initializes each of the variables*/
    Button titleReturn;
    TextView nice;
    TextView results;
    TextView wordLeft;
    TextView LeftNumber;
    TextView wordDown;
    TextView DownNumber;
    TextView wordUp;
    TextView UpNumber;
    TextView wordRight;
    TextView RightNumber;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /** this lets you return to the title when you click the button that says
         * return to title*/
        titleReturn = findViewById(R.id.return_to_title);
        titleReturn.setOnClickListener((v -> returnToTitle()));

        /** this sets the id's of each text
         * so you can change the text, and it shows up on screen
         */
        nice = findViewById(R.id.nice);
        results = findViewById(R.id.results);
        wordLeft = findViewById(R.id.Left_word);
        LeftNumber = findViewById(R.id.Left_number);
        wordDown = findViewById(R.id.Down_word);
        DownNumber = findViewById(R.id.Down_number);
        wordUp = findViewById(R.id.Up_word);
        UpNumber = findViewById(R.id.Up_number);
        wordRight = findViewById(R.id.Right_word);
        RightNumber = findViewById(R.id.Right_number);

        /** this calls each of the functions*/
        bringToFront();
        makeWhite();
        textSize();
        isNice();

        String LeftCount = Integer.toString(leftRecord) + " / "
                + Integer.toString(leftSize);
        String DownCount = Integer.toString(downRecord) + " / "
                + Integer.toString(GameActivity.downSize);
        String UpCount = Integer.toString(upRecord) + " / "
                + Integer.toString(GameActivity.upSize);
        String RightCount = Integer.toString(rightRecord) + " / "
                + Integer.toString(rightSize);
        LeftNumber.setText(LeftCount);
        DownNumber.setText(DownCount);
        UpNumber.setText(UpCount);
        RightNumber.setText(RightCount);
    }

    /** this returns you to the title screen when you click
     * "return to title"
     */
    public void returnToTitle() {
        leftRecord = 0;
        downRecord = 0;
        upRecord = 0;
        rightRecord = 0;
        leftSize = 0;
        GameActivity.downSize = 0;
        GameActivity.upSize = 0;
        rightSize = 0;
        Intent setupIntent = new Intent(this, TitleActivity.class);
        startActivity(setupIntent);
        finish();
    }

    /** this brings each of the texts in front of the background
     * it's called by onCreate
     */
    public void bringToFront() {
        results.bringToFront();
        nice.bringToFront();
        wordLeft.bringToFront();
        LeftNumber.bringToFront();
        wordDown.bringToFront();
        DownNumber.bringToFront();
        wordUp.bringToFront();
        UpNumber.bringToFront();
        wordRight.bringToFront();
        RightNumber.bringToFront();
    }

    /**
     * this sets the size of each textView
     */
    public void textSize() {
        results.setTextSize(60);
        wordLeft.setTextSize(20);
        LeftNumber.setTextSize(20);
        wordDown.setTextSize(20);
        DownNumber.setTextSize(20);
        wordUp.setTextSize(20);
        UpNumber.setTextSize(20);
        wordRight.setTextSize(20);
        RightNumber.setTextSize(20);
    }

    /**
     * this makes each text view white
     */
    public void makeWhite() {
        int white = getResources().getColor(R.color.white);
        results.setTextColor(white);
        nice.setTextColor(white);
        wordLeft.setTextColor(white);
        LeftNumber.setTextColor(white);
        wordDown.setTextColor(white);
        DownNumber.setTextColor(white);
        wordUp.setTextColor(white);
        UpNumber.setTextColor(white);
        wordRight.setTextColor(white);
        RightNumber.setTextColor(white);
    }

    /**
     * this determines if something has the number "69"
     * if it does, there's a word that says "nice" which shows up
     */
    public void isNice() {
        if (GameActivity.leftRecord == 69 || GameActivity.upRecord == 69 || GameActivity.rightRecord == 69
                || GameActivity.downRecord == 69 || GameActivity.leftRecord == 169 || GameActivity.upRecord == 169 || GameActivity.rightRecord == 169
                || GameActivity.downRecord == 169 || GameActivity.leftRecord == 269 || GameActivity.upRecord == 269 || GameActivity.rightRecord == 269
                || GameActivity.downRecord == 269 || GameActivity.leftRecord == 369 || GameActivity.upRecord == 369 || GameActivity.rightRecord == 369
                || GameActivity.downRecord == 369) {
            nice.setVisibility(View.VISIBLE);
        } else {
            nice.setVisibility(View.GONE);
        }
    }
}