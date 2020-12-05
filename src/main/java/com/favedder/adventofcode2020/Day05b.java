package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Day05b {

    String[] inputArray;
    ArrayList<Integer> list;

    public static void main(String[] args) {
        Day05b day05b = new Day05b();
        day05b.readInput();
        day05b.list = new ArrayList();
        int solution = 0;

        for (String pass : day05b.inputArray) {
            int row = day05b.getRow(pass);
            int column = day05b.getColumn(pass);
            if (row != 0 && row != 127) {

                int seatID = row * 8 + column;
                day05b.list.add(seatID);
            }
        }
        Collections.sort(day05b.list);

        int min = day05b.list.get(0);
        int max = day05b.list.get(day05b.list.size() - 1);

        for (int i = 0; i < day05b.list.size() - 1; i++) {
            if (day05b.list.get(i + 1) != day05b.list.get(i) + 1) {
                solution = day05b.list.get(i) + 1;
            }
        }

        System.out.println("Solution: " + solution);

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
