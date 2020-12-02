package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day01a {

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");

        try {
            int solution = 0;

            String input = Files.readString(path, StandardCharsets.US_ASCII);
            String[] inputArray = input.split("[\\r\\n]+");

            int[] inputInt = new int[inputArray.length];

            for (int i = 0; i < inputArray.length; i++) {
                inputInt[i] = Integer.parseInt(inputArray[i]);
            }

            for (int i = 0; i < inputInt.length; i++) {
                for (int j = 0; j < inputInt.length; j++) {
                    if (i != j && inputInt[i] + inputInt[j] == 2020) {
                        solution = inputInt[i] * inputInt[j];
                    }
                }
            }

            System.out.println("Solution: " + solution);

        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }

}
