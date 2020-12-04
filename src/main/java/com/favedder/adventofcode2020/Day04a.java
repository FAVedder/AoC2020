package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day04a {

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        String[] inputArray;
        int valid = 0;

        try {
            String input = Files.readString(path, StandardCharsets.US_ASCII);
            inputArray = input.split("(?m)^\\s*$");

            for (int i = 0; i < inputArray.length; i++) {
                inputArray[i] = inputArray[i].replaceAll("\\r\\n|\\r|\\n", " ");
            }

            for (String text : inputArray) {
                if (text.contains("byr") && text.contains("iyr")
                        && text.contains("eyr") && text.contains("hgt")
                        && text.contains("hcl") && text.contains("ecl")
                        && text.contains("pid")) {

                    valid++;

                }
            }

            System.out.println("Solution: " + valid);

        } catch (IOException ex) {
            System.out.println("File not found.");
        }

    }

}
