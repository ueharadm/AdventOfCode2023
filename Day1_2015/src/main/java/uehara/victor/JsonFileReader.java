package uehara.victor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        int indexIterator = 1;

        try {
            File jsonFile = new File("src/main/java/uehara/victor/input.json");
            if (!jsonFile.exists()) {
                System.out.println("File not found: " + jsonFile.getAbsolutePath());
                return;
            }

            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            //Use input1 and input5 for test cases with results on index 1 and 5
            JsonNode keyValue = jsonNode.get("input");

            if (keyValue != null) {
                long countOpeningParenthesis;
                long countClosingParenthesis;
                long floor;
                int i;
                String value = keyValue.asText();
                System.out.println("Value: " + value);

                //Day 1 Solve
                //long countOpeningParenthesis = value.chars().filter(ch -> ch == '(').count();
                //long countClosingParenthesis = value.chars().filter(ch -> ch == ')').count();
                //long finalFloor = countOpeningParenthesis - countClosingParenthesis;
                //System.out.println("Floor: " + finalFloor);

                while (indexIterator <= value.length()){
                    String newValue = value.substring(0, indexIterator);
                    countOpeningParenthesis = newValue.chars().filter(ch -> ch == '(').count();
                    countClosingParenthesis = newValue.chars().filter(ch -> ch == ')').count();
                    floor = countOpeningParenthesis - countClosingParenthesis;
                    System.out.println("");
                    System.out.println("Index atual: " + indexIterator);
                    System.out.println("Valor atual: " + floor);
                    if (floor == -1){
                        break;
                    }
                    //increments indexIterator based on the distance (abs of the difference) of the actual Floor to the target value (-1)
                    indexIterator = indexIterator + (int) (Math.abs(floor - (-1)));
                }
            } else {
                System.out.println("Key 'input' not found in the JSON file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
