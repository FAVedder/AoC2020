package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day05a {

    String[] inputArray;

    public static void main(String[] args) {
        Day05a day05a = new Day05a();
        day05a.readInput();

        int highest = 0;

        for (String pass : day05a.inputArray) {
            int row = day05a.getRow(pass);
            int column = day05a.getColumn(pass);
            int seatID = row * 8 + column;
            System.out.println(seatID);
            if (seatID > highest) {
                highest = seatID;
            }
        }

        System.out.println("Solution: " + highest);

    }

    private void readInput() {
        Path path = Paths.get("input.txt");

        try {
            String input = Files.readString(path, StandardCharsets.US_ASCII);
            inputArray = input.split("[\\r\\n]+");

            for (String string : inputArray) {
                string = string.trim();
            }

        } catch (IOException ex) {
            System.out.println("File not found.");
        }

    }

    private int getRow(String pass) {
        int high = 127;
        int low = 0;

        String passTemp = pass.substring(0, 7);

        for (char ch : passTemp.toCharArray()) {
            if (ch == 'F') {
                high -= (high - low) / 2f;
            } else if (ch == 'B') {
                low += Math.ceil((high - low) / 2f);
            }

        }
        return low;
    }

    private int getColumn(String pass) {
        int high = 7;
        int low = 0;

        String passTemp = pass.substring(7, 10);
        
        for (char ch : passTemp.toCharArray()) {
            if (ch == 'L') {
                high -= (high - low) / 2f;
            } else if (ch == 'R') {
                low += Math.ceil((high - low) / 2f);
            }

        }
        return low;
    }

}
