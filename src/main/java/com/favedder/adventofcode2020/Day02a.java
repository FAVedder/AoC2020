package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day02a {

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");

        try {
            int solution = 0;

            String input = Files.readString(path, StandardCharsets.US_ASCII);
            String[] inputArray = input.split("[\\r\\n]+");
            String[][] inputArrayFixed = new String[inputArray.length][3];
            for (int i = 0; i < inputArray.length; i++) {
                String[] temp = inputArray[i].split(" ");
                inputArrayFixed[i][0] = temp[0].trim();
                inputArrayFixed[i][1] = temp[1].trim();
                inputArrayFixed[i][2] = temp[2].trim();
            }

            for (String[] password : inputArrayFixed) {
                int amount = 0;
                int min = Integer.parseInt(password[0].substring(0, password[0].indexOf("-")));
                int max = Integer.parseInt(password[0].substring(password[0].indexOf("-") + 1, password[0].length()));
                char letter = password[1].charAt(0);
                for (int j = 0; j < password[2].length(); j++) {
                    char tocheck = password[2].charAt(j);
                    if (tocheck == letter) {
                        amount++;
                    }
                }
                if (amount <= max && amount >= min) {
                    solution++;
                }
            }

            System.out.println("Solution: " + solution);

        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
}
