package jsonParser;

import jsonParser.jsonClasses.JsonElement;
import jsonParser.jsonParsers.Parser;

public class JsonParserMain {

    public static void main(String args[]) {
        String jsonString = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\", \"isAdmin\": true, \"scores\": [10, 20, 30] }";
        Parser parsedResult = new Parser();
        JsonElement element = parsedResult.parse(jsonString);

        System.out.println(element.getValue());

    }
}
