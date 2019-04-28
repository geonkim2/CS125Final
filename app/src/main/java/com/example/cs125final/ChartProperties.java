package com.example.cs125final;

import java.util.ArrayList;

public class ChartProperties {
    static String file;
    static double offset;
    static double BPM;
    static ArrayList<String> direction = new ArrayList<>();
    static ArrayList<Double> beat = new ArrayList<>();
    static String songName = "marionette";


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
                    "0000\n" +
                    ",  // measure 2\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    ",  // measure 3\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    ",  // measure 4\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0000\n" +
                    "0001";
        }
        return file;
    }
    public static void parseNotes() {
        String toParse = getFile();
        String[] measures = toParse.split(",");
        double currentBeat = 0;
        for (int i = 1; i < measures.length; i++) {
            String notes[] = measures[i].split("\n");
            System.out.println(notes[0]);
            for (int j = 0; j < notes.length; j++) {
                currentBeat = 4 * (i + ((double) j / notes.length));
                if (notes[j].length() > 6) {
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
    public static void main(String[] args) {
        getOffset();
        getBPM();
        getFile();
        parseNotes();
        for (int i = 0; i < direction.size(); i++) {
            System.out.println(direction);
            System.out.println(beat);
        }
    }
}
