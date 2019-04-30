package com.example.cs125final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    /** this initializes each of the variables*/
    Button titleReturn;
    TextView nice;
    TextView percentage;
    TextView grade;
    TextView wordLeft;
    TextView LeftNumber;
    TextView wordDown;
    TextView DownNumber;
    TextView wordUp;
    TextView UpNumber;
    TextView wordRight;
    TextView RightNumber;

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
        grade = findViewById(R.id.grade);
        percentage = findViewById(R.id.percentage);
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

        String LeftCount = Integer.toString(GameActivity.LeftCount);
        String DownCount = Integer.toString(GameActivity.DownCount);
        String UpCount = Integer.toString(GameActivity.UpCount);
        String RightCount = Integer.toString(GameActivity.RightCount);
        String percentString = Integer.toString(getPercent()) + "%";
        LeftNumber.setText(LeftCount);
        DownNumber.setText(DownCount);
        UpNumber.setText(UpCount);
        RightNumber.setText(RightCount);
        percentage.setText(percentString);
        grade.setText(getGrade());
        grade.bringToFront();
        GameActivity.LeftCount = 0;
        GameActivity.DownCount = 0;
        GameActivity.UpCount = 0;
        GameActivity.RightCount = 0;
    }

    /** this returns you to the title screen when you click
     * "return to title"
     */
    public void returnToTitle() {
        Intent setupIntent = new Intent(this, TitleActivity.class);
        startActivity(setupIntent);
        finish();
    }

    /** this brings each of the texts in front of the background
     * it's called by onCreate
     */
    public void bringToFront() {
        percentage.bringToFront();
        grade.bringToFront();
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
        percentage.setTextSize(60);
        grade.setTextSize(60);
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
//        int blue = getResources().getColor(R.color.blue);
//        int yellow = getResources().getColor(R.color.yellow);
//        int green = getResources().getColor(R.color.green);
//        int red = getResources().getColor(R.color.red);
        percentage.setTextColor(white);
        grade.setTextColor(white);
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
        CharSequence first = LeftNumber.getText();
        CharSequence second = DownNumber.getText();
        CharSequence third = UpNumber.getText();
        CharSequence fourth = RightNumber.getText();
        if (first.toString().contains("69") || second.toString().contains("69")
            || third.toString().contains("69") || fourth.toString().contains("69")){
            nice.setVisibility(View.VISIBLE);
        } else {
            nice.setVisibility(View.GONE);
        }
    }
    public int getPercent() {
        if (TitleActivity.getSong().equals("marionette")) {
            return (int) (GameActivity.LeftCount + GameActivity.DownCount
                    + GameActivity.UpCount + GameActivity.RightCount) / GameActivity.marionetteDirection.size();
        }
        if (TitleActivity.getSong().equals("queen bee")) {
            return (int) (GameActivity.LeftCount + GameActivity.DownCount
                    + GameActivity.UpCount + GameActivity.RightCount) / GameActivity.queenBeeDirection.size();
        }
        if (TitleActivity.getSong().equals("quaoar")) {
            return (int) (GameActivity.LeftCount + GameActivity.DownCount
                    + GameActivity.UpCount + GameActivity.RightCount) / GameActivity.quaoarDirection.size();
        }
        if (TitleActivity.getSong().equals("peacock")) {
            return (int) (GameActivity.LeftCount + GameActivity.DownCount
                    + GameActivity.UpCount + GameActivity.RightCount) / GameActivity.peacockDirection.size();
        }
        return -1;
    }
    public String getGrade() {
        double percent = getPercent();
        if (percent > 90) {
            return "S";
        }
        if (percent > 80) {
            return "A";
        }
        if (percent > 70) {
            return "B";
        }
        if (percent > 60) {
            return "C";
        }
        if (percent > 50) {
            return "D";
        } else {
            return "F";
        }
    }
}