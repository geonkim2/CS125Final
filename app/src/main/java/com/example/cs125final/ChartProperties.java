package com.example.cs125final;

import java.util.ArrayList;

public class ChartProperties {
    static double offset;
    static double BPM;
    static ArrayList<String> direction = new ArrayList<>();
    static ArrayList<Double> beat = new ArrayList<>();
    static String songName = TitleActivity.getSong();

    /** this determines the offset of the song
     * it MUST BE CALLED, even if the offset and BPM are static
     * this is because it initializes the offset
     */
    public static double getOffset() {
        if (songName.equals("marionette")) {
            offset = -0.411182;
        }
        if (songName.equals("quaoar")) {
            offset = -0.011;
        }
        if (songName.equals("queen bee")) {
            offset = -0.751;
        }
        if (songName.equals("peacock")) {
            offset = 0.018;
        }
        return offset;
    }

    /** this determines the BPM of the song
     * it MUST BE CALLED, even if the offset and BPM are static
     * this is because it initializes the BPM
     */
    public static double getBPM() {
        if (songName.equals("marionette")) {
            BPM = 165;
        }
        if (songName.equals("quaoar")) {
            BPM = 174;
        }
        if (songName.equals("queen bee")) {
            BPM = 159.985;
        }
        if (songName.equals("peacock")) {
            BPM = 110;
        }
        return BPM;
    }

    /** this parses the chart
     * basically, it determines the beat and direction of each note
     */
    public static void parseNotes(String song) {
        String toParse = File.getFile(song);
        if (toParse == null) {
            return;
        }
        direction.clear();
        beat.clear();
        String[] measures = toParse.split(",");
        double currentBeat = 0;
        for (int i = 0; i < measures.length; i++) {
            String notes[] = measures[i].split("\n");
            for (int j = 1; j < notes.length; j++) {
                currentBeat = 4 * (i + (j - 1) * (1.0 / (notes.length - 1)));
                if (notes[j].length() != 4) {
                    continue;
                }
                if (notes[j].charAt(0) == '1' || notes[j].charAt(0) == '2') {
                    direction.add("left");
                    beat.add(currentBeat);
                }
                if (notes[j].charAt(1) == '1' || notes[j].charAt(1) == '2') {
                    direction.add("down");
                    beat.add(currentBeat);
                }
                if (notes[j].charAt(2) == '1' || notes[j].charAt(2) == '2') {
                    direction.add("up");
                    beat.add(currentBeat);
                }
                if (notes[j].charAt(3) == '1' || notes[j].charAt(3) == '2') {
                    direction.add("right");
                    beat.add(currentBeat);
                }
            }

        }
    }

//    public static double getDelay(double currentBeat) {
//        double BPM = ChartProperties.getBPM();
//        double offset = ChartProperties.getOffset();
//        //3000 is the delay in move
//        return 1000 * ((60 / BPM)*currentBeat + offset + 1) - 1500;
//    }

    /** this is here for debugging
     * by pressing play, you can call all of the functions
     * it doesn't work in actual activity classes, though
     * you need to use the actual app to debug
     * for this to work, you need to set the song in ChartProperties
     * AND in File to something
     * otherwise, you get a null pointer exception
     */
    public static void main(String[] args) {
        songName = "marionette";
        System.out.println(direction);
        songName = "queen bee";
        System.out.println(direction);
    }
}
