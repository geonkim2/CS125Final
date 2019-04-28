package com.example.cs125final;

import android.support.v7.app.AppCompatActivity;

public class ChartProperties extends AppCompatActivity {
    static String file;
    static double offset;
    static double BPM;
    static String[] direction;
    static Double[] beat;
    static String songName = TitleActivity.getSong();

    public static double getOffset() {
        if (songName.equals("marionette")) {
            offset = 0.411182;
        }
        return offset;
    }
    public static double getBPM() {
        if (songName.equals("marionette")) {
            BPM = 165;
        }
        return BPM;
    }
    public static String getFile() {
        if (songName.equals("marionette")) {
            file = ",  // measure 0\n" +
                    "1000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    ",  // measure 1\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000";
        }
        return file;
    }
    public static void parseNotes() {
        String toParse = getFile();
        String[] measures = toParse.split(",");
        double currentBeat = 0;
        int kl = -1;
        for (int i = 0; i < measures.length; i++) {
            String notes[] = measures[i].split("\n");
            for (int j = 0; j < notes.length; j++) {
                currentBeat = 4 * (i + ((double) j / notes.length));
                kl++;
                if (notes[j].length() > 6) {
                    continue;
                }
                if (notes[j].charAt(0) != '0') {
                    direction[kl] = "left";
                    beat[kl] = currentBeat;
                }
                if (notes[j].charAt(1) != '0') {
                    direction[kl] = "down";
                    beat[kl] = currentBeat;
                }
                if (notes[j].charAt(2) != '0') {
                    direction[kl] = "up";
                    beat[kl] = currentBeat;
                }
                if (notes[j].charAt(3) != '0') {
                    direction[kl] = "right";
                    beat[kl] = currentBeat;
                }
            }
        }
    }
}
