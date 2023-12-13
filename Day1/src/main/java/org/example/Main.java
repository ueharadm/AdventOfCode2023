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
        //String input = "a1b99c7de5f";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            // Create a map to map spelled-out numbers to their corresponding numerical values
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

            // Read each line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Process each line as needed
                System.out.println("#### "+line);
                try{
                    // Define the pattern to match a number
                    //Pattern pattern = Pattern.compile("\\d");
                    Pattern pattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|\\d)(?!\\d)");



                    // Create a matcher for the input string
                    Matcher matcher = pattern.matcher(line);


                    // Find the first match
                    if (matcher.find()) {
                        // Extract and print the first matched number
                        String firstNumber = matcher.group();

                        String numericalFirstNumber = spelledOutNumbers.containsKey(firstNumber) ? ""+spelledOutNumbers.get(firstNumber) : firstNumber;

                        String lastNumber = firstNumber;
                        System.out.println("#### "+"First number: " + numericalFirstNumber);

                        // Find the last match
                        while (matcher.find()) {
                            lastNumber = matcher.group();
                        }
                        String numericalLastNumber = spelledOutNumbers.containsKey(lastNumber) ? ""+spelledOutNumbers.get(lastNumber) : lastNumber;
                        System.out.println("#### "+"Last number: " + numericalLastNumber);

                        int finalNumber = Integer.parseInt(""+numericalFirstNumber+numericalLastNumber);
                        System.out.println("#### "+"FinalNumber = " + finalNumber);
                        System.out.println("");
                        System.out.println("");
                        sum+=finalNumber;
                    }
                }
                catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.println("#### "+"Total sum: " + sum);
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential IOException
        }





    }
}
