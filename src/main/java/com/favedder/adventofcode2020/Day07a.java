package com.favedder.adventofcode2020;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07a {

    String[] inputArray;
    List<String> bags = new ArrayList<>();
    List<String> bagsWithoutDubs = new ArrayList<>();

    public static void main(String[] args) {

        Day07a day07a = new Day07a();
        day07a.readInput();
        day07a.addBags("shiny gold bag");
        for (String bag : day07a.bags) {
            if (!day07a.bagsWithoutDubs.contains(bag)) {
                day07a.bagsWithoutDubs.add(bag);
            }
        }

        System.out.println("Solution: " + day07a.bagsWithoutDubs.size());

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

    private void addBags(String name) {
        name = name.trim();

        if (name.charAt(name.length() - 1) == 's') {
            name = name.substring(0, name.length() - 1);
        }

        for (String rule : inputArray) {
            String parentBag = "";
            String currentRule = "";

            Pattern patternParent = Pattern.compile("(^(?:\\S+\\s+\\n?){1,3})");
            Matcher matcherParent = patternParent.matcher(rule);
            if (matcherParent.find()) {

                parentBag = matcherParent.group(1);

            }

            Pattern patternCurrent = Pattern.compile("(?<=contain).*$");
            Matcher matcherCurrent = patternCurrent.matcher(rule);
            if (matcherCurrent.find()) {

                currentRule = matcherCurrent.group(0);

            }

            if (currentRule.contains(name)) {
                bags.add(parentBag);
                addBags(parentBag);
            }

        }
    }

}
