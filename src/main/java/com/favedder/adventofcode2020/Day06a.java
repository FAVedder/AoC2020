package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day06a {

    String[] inputArray;

    public static void main(String[] args) {
        long count = 0;

        Day06a day06a = new Day06a();
        day06a.readInput();

        for (String group : day06a.inputArray) {
            count += (group.chars().distinct().count() - 2);
        }

        System.out.println("Solution: " + count);
    }

    private void readInput() {
        Path path = Paths.get("input.txt");

        try {
            String input = Files.readString(path, StandardCharsets.US_ASCII);
            inputArray = input.split("(?m)^\\s*$");

            for (String string : inputArray) {
                string = string.trim();
            }
            
        } catch (IOException ex) {
            System.out.println("File not found.");
        }

    }
}
