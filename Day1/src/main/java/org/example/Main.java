package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/input.txt";
        String numericalFirstNumber = "";
        String numericalLastNumber = "";
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = reader.readLine()) != null) {
                System.out.println("\n#### line: " + line);
                numericalFirstNumber = RetrieveFirstNumber(line);
                numericalLastNumber = RetrieveLastNumber(line);
                int finalNumber = Integer.parseInt("" + numericalFirstNumber + numericalLastNumber);
                System.out.println("#### " + "FinalNumber = " + finalNumber);
                sum += finalNumber;
            }
            System.out.println("\n#### " + "Total sum: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String RetrieveFirstNumber(String line) {
        Map<String, Integer> spelledOutNumbers = new HashMap<>();
        spelledOutNumbers.put("one", 1);
        spelledOutNumbers.put("two", 2);
        spelledOutNumbers.put("three", 3);
        spelledOutNumbers.put("four", 4);
        spelledOutNumbers.put("five", 5);
        spelledOutNumbers.put("six", 6);
        spelledOutNumbers.put("seven", 7);
        spelledOutNumbers.put("eight", 8);
        spelledOutNumbers.put("nine", 9);

        String firstNumber = "No Matches found";
        String numericalFirstNumber = "No Matches found";
        Pattern pattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|\\d)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            firstNumber = matcher.group();
            numericalFirstNumber = spelledOutNumbers.containsKey(firstNumber) ? "" + spelledOutNumbers.get(firstNumber) : firstNumber;
        }
        return numericalFirstNumber;
    }

    public static String RetrieveLastNumber(String line) {
        Map<String, Integer> reverseSpelledOutNumbers = new HashMap<>();
        reverseSpelledOutNumbers.put("eno", 1);
        reverseSpelledOutNumbers.put("owt", 2);
        reverseSpelledOutNumbers.put("eerht", 3);
        reverseSpelledOutNumbers.put("ruof", 4);
        reverseSpelledOutNumbers.put("evif", 5);
        reverseSpelledOutNumbers.put("xis", 6);
        reverseSpelledOutNumbers.put("neves", 7);
        reverseSpelledOutNumbers.put("thgie", 8);
        reverseSpelledOutNumbers.put("enin", 9);

        String lastNumber = "No Matches found";
        String numericalLastNumber = "No Matches found";
        String reverseLine = new StringBuilder(line).reverse().toString();
        Pattern reversePattern = Pattern.compile("(eno|owt|eerht|ruof|evif|xis|neves|thgie|enin|\\d)");
        Matcher reverseMatcher = reversePattern.matcher(reverseLine);
        if (reverseMatcher.find()) {
            lastNumber = reverseMatcher.group();
            numericalLastNumber = reverseSpelledOutNumbers.containsKey(lastNumber) ? "" + reverseSpelledOutNumbers.get(lastNumber) : lastNumber;
        }
        return numericalLastNumber;
    }
}
