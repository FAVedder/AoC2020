package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class Day06b {

    String[] inputArray;

    public static void main(String[] args) {
        long count = 0;

        ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            alphabet.add((char) i);
        }

        Day06b day06b = new Day06b();
        day06b.readInput();

        for (String group : day06b.inputArray) {
            group = group.trim();
            String[] lines = group.split("\r\n|\r|\n");
            int all = lines.length;

            for (char ch : alphabet) {
                int countCurrent = StringUtils.countMatches(group, ch);
                if (countCurrent == all) {
                    count++;
                }
            }
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
