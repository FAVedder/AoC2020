package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day02b {

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
                int indexA = Integer.parseInt(password[0].substring(0, password[0].indexOf("-"))) - 1;
                int indexB = Integer.parseInt(password[0].substring(password[0].indexOf("-") + 1, password[0].length())) - 1;
                char letter = password[1].charAt(0);
                
                if (letter == password[2].charAt(indexA) ^ letter == password[2].charAt(indexB)) {
                    solution++;
                }
            }

            System.out.println("Solution: " + solution);

        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
}
