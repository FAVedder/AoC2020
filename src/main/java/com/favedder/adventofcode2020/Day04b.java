package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day04b {

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

            for (String pass : inputArray) {
                boolean validPass = false;

                if (pass.contains("byr") && pass.contains("iyr")
                        && pass.contains("eyr") && pass.contains("hgt")
                        && pass.contains("hcl") && pass.contains("ecl")
                        && pass.contains("pid")) {

                    pass = pass.trim();

                    String[] fields = pass.split(" ");

                    CHECKFIELDS:
                    for (String field : fields) {
                        if (field.contains("byr")) {
                            int year = Integer.parseInt(field.substring(4));
                            validPass = year >= 1920 && year <= 2002;
                            if (validPass == false) {
                                break;
                            }
                        } else if (field.contains("iyr")) {
                            int year = Integer.parseInt(field.substring(4));
                            validPass = year >= 2010 && year <= 2020;
                            if (validPass == false) {
                                break;
                            }
                        } else if (field.contains("eyr")) {
                            int year = Integer.parseInt(field.substring(4));
                            validPass = year >= 2020 && year <= 2030;
                            if (validPass == false) {
                                break;
                            }
                        } else if (field.contains("hgt")) {
                            if (null == field.substring(field.length() - 2)) {
                                validPass = false;
                                if (validPass == false) {
                                    break;
                                }
                            } else {
                                switch (field.substring(field.length() - 2)) {
                                    case "cm" -> {
                                        int number = Integer.parseInt(field.substring(4, field.length() - 2));
                                        validPass = number >= 150 && number <= 193;
                                        if (validPass == false) {
                                            break CHECKFIELDS;
                                        }
                                    }
                                    case "in" -> {
                                        int number = Integer.parseInt(field.substring(4, 6));
                                        validPass = number >= 59 && number <= 76;
                                        if (validPass == false) {
                                            break CHECKFIELDS;
                                        }
                                    }
                                    default -> {
                                        validPass = false;
                                        if (validPass == false) {
                                            break CHECKFIELDS;
                                        }
                                    }
                                }
                            }
                        } else if (field.contains("hcl")) {
                            validPass = field.length() == 11 && field.charAt(4) == '#' && field.substring(5, 11).matches("[a-f0-9]{6}");
                            if (validPass == false) {
                                break;
                            }
                        } else if (field.contains("ecl")) {
                            validPass = field.contains("amb") ^ field.contains("blu") ^ field.contains("brn") ^ field.contains("gry") ^ field.contains("grn") ^ field.contains("hzl") ^ field.contains("oth");
                            if (validPass == false) {
                                break;
                            }
                        } else if (field.contains("pid")) {
                            validPass = field.length() == 13 && field.substring(4, 13).matches("[0-9]{9}");
                            if (validPass == false) {
                                break;
                            }
                        }

                    }
                    
                } else {
                    validPass = false;
                }

                if (validPass == true) {
                    valid++;
                }

            }

            System.out.println("Solution: " + valid);

        } catch (IOException ex) {
            System.out.println("File not found.");
        }

    }
}
