package com.example.cs125final;

import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChartProperties extends AppCompatActivity {

    String file;
    ArrayList<String> direction;
    ArrayList<Double> beat;
    String songName = TitleActivity.getSong();
    double offset;
    double BPM;

    public double getOffset() {
        if (songName.equals("marionette")) {
            offset = 0.411182;
        }
        return this.offset;
    }
    public double getBPM() {
        if (songName.equals("marionette")) {
            BPM = 165;
        }
        return this.BPM;
    }
    public ArrayList<String> getDirection() {
        return this.direction;
    }
    public ArrayList<Double> getBeat() {
        return this.beat;
    }
    public String convert(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }
    public void setFile() {
        InputStream chart = getResources().openRawResource(R.raw.marionettechart);
        try {
            file = convert(chart);
        } catch (IOException a) {
            throw new NullPointerException();
        }
    }
    public String getFile() {
        setFile();
        return file;
    }
    public void ParseNotes(){
        String toParse = getFile();
        String[] measures = toParse.split(",");
        double currentBeat;
        for (int i = 0; i < measures.length; i++) {
            String notes[] = measures[i].split(".");
            for (int j = 0; j < notes.length; j++) {
                currentBeat = 4 * (i + ((double) j / notes.length));
                if (notes[j].length() != 4) {
                    continue;
                }
                if (notes[j].charAt(0) != '0') {
                    direction.add("left");
                    beat.add(currentBeat);
                }
                if (notes[j].charAt(1) != '0') {
                    direction.add("down");
                    beat.add(currentBeat);
                }
                if (notes[j].charAt(2) != '0') {
                    direction.add("up");
                    beat.add(currentBeat);
                }
                if (notes[j].charAt(3) != '0') {
                    direction.add("right");
                    beat.add(currentBeat);
                }
            }
        }
    }
}
