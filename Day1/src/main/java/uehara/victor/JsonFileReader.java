package uehara.victor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File jsonFile = new File("src/main/java/uehara/victor/input.json");
            if (!jsonFile.exists()) {
                System.out.println("File not found: " + jsonFile.getAbsolutePath());
                return;
            }

            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            JsonNode keyValue = jsonNode.get("input");

            if (keyValue != null) {
                String value = keyValue.asText();
                System.out.println("Value: " + value);

                long countOpeningParenthesis = value.chars().filter(ch -> ch == '(').count();
                long countClosingParenthesis = value.chars().filter(ch -> ch == ')').count();
                long finalFloor = countOpeningParenthesis - countClosingParenthesis;
                System.out.println("Floor: " + finalFloor);
            } else {
                System.out.println("Key 'input' not found in the JSON file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
