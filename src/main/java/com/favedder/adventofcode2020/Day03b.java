package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day03b {

    String[] inputArray;

    public static void main(String[] args) {
        Day03b day03b = new Day03b();
        day03b.readInput();
        long a = day03b.checkSlope(1, 1);
        long b = day03b.checkSlope(3, 1);
        long c = day03b.checkSlope(5, 1);
        long d = day03b.checkSlope(7, 1);
        long e = day03b.checkSlope(1, 2);
        System.out.println("Solution: " + a * b * c * d * e);
    }

    private long checkSlope(int right, int down) {
        long result = 0;
        int currentCharPosition = 0;

        for (int i = 0; i < inputArray.length - down; i += down) {
            if (inputArray[i + down].charAt((currentCharPosition + right) % inputArray[i].length()) == '#') {
                result++;
            }
            currentCharPosition += right;
        }

        System.out.println(result);
        return result;
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

}
