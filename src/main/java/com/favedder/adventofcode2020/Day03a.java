package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day03a {

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");

        try {
            int solution = 0;
            int currentCharPosition = 0;

            String input = Files.readString(path, StandardCharsets.US_ASCII);
            String[] inputArray = input.split("[\\r\\n]+");

            for (String string : inputArray) {
                string = string.trim();
            }

            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i + 1].charAt((currentCharPosition + 3) % inputArray[i].length()) == '#') {
                    solution++;
                }
                currentCharPosition += 3;
            }

            System.out.println("Solution: " + solution);

        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
}
