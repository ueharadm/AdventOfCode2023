package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLineReader {

    public static void readLinesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Process each line as needed
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential IOException
        }
    }
}
