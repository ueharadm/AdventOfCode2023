package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/input.txt";
        //String input = "a1b99c7de5f";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            // Read each line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Process each line as needed
                System.out.println(line);
                try{
                    // Define the pattern to match a number
                    Pattern pattern = Pattern.compile("\\d");

                    // Create a matcher for the input string
                    Matcher matcher = pattern.matcher(line);

                    // Find the first match
                    if (matcher.find()) {
                        // Extract and print the first matched number
                        String firstNumber = matcher.group();
                        String lastNumber = firstNumber;
                        System.out.println("First number: " + firstNumber);

                        // Find the last match
                        while (matcher.find()) {
                            lastNumber = matcher.group();
                        }
                        System.out.println("Last number: " + lastNumber);

                        int finalNumber = Integer.parseInt(""+firstNumber+lastNumber);
                        System.out.println("FinalNumber = " + finalNumber);
                        sum+=finalNumber;
                    } else {
                        System.out.println("No number found in the string.");
                    }}
                catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.println("Total sum: " + sum);
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential IOException
        }





    }
}
