package jsonParser.jsonParsers;

import jsonParser.jsonClasses.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    private int index;
    private String json;
    private static final char OPEN_CURLY_BRACE = '{';
    private static final char CLOSE_CURLY_BRACE = '}';
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char CLOSE_SQUARE_BRACKET = ']';
    private static final char DOUBLE_QUOTES = '"';
    private static final char COLON = ':';
    private static final char COMMA = ',';

    public JsonElement parse(String jsonString) {
        this.index = 0;
        this.json = jsonString;
        skipWhiteSpace();
        return parseValue();
    }

    private JsonElement parseValue() {
        char currentChar = json.charAt(index);
        if(currentChar==OPEN_CURLY_BRACE) {
            return parseObject();
        } else if(currentChar==OPEN_SQUARE_BRACKET) {
            return parseArray();
        } else if(currentChar==DOUBLE_QUOTES) {
            return parseString();
        } else if(Character.isDigit(currentChar) || currentChar=='-') {
            return parseNumber();
        } else if(currentChar=='t' || currentChar=='f') {
            return parseBoolean();
        } else if(currentChar=='n') {
            return parseNull();
        }
        throw new RuntimeException("Invalid Json");
    }

    private JsonElement parseArray() {
        List<JsonElement> result = new ArrayList<>();
        consume(OPEN_SQUARE_BRACKET);
        skipWhiteSpace();
        while(json.charAt(index)!=CLOSE_SQUARE_BRACKET) {
            JsonElement element = parseValue();
            result.add(element);
            skipWhiteSpace();

            if(json.charAt(index)==COMMA) {
                consume(COMMA);
                skipWhiteSpace();
            }
        }
        consume(CLOSE_SQUARE_BRACKET);
        return new JsonArray(result);
    }

    private JsonElement parseObject() {
        Map<String, JsonElement> properties = new HashMap<>();
        consume(OPEN_CURLY_BRACE);
        skipWhiteSpace();
        while(json.charAt(index)!=CLOSE_CURLY_BRACE) {
            String key = parseString().getValue().toString();
            skipWhiteSpace();
            consume(COLON);
            skipWhiteSpace();
            JsonElement value = parseValue();
            properties.put(key, value);
            skipWhiteSpace();

            if(json.charAt(index)==COMMA) {
                consume(COMMA);
                skipWhiteSpace();
            }
        }
        consume(CLOSE_CURLY_BRACE);

        return new JsonObject(properties);
    }

    private JsonElement parseNull() {
        consumeWord();
        return null;
    }

    private JsonElement parseBoolean() {
        String boolStr = consumeWord();
        if(boolStr.equals("true")) {
            return new JsonBoolean(true);
        } else {
            return new JsonBoolean(false);
        }
    }

    private String consumeWord() {
        StringBuilder sb = new StringBuilder();
        while(Character.isLetter(json.charAt(index))) {
            sb.append(json.charAt(index));
            index++;
        }
        return sb.toString();
    }

    private JsonElement parseNumber() {
        int startIndex = index;
        while(Character.isDigit(json.charAt(index)) || json.charAt(index)=='.') {
            index++;
        }

        String numStr = json.substring(startIndex, index);
        if(numStr.contains(".")) {
            return new JsonNumber(Double.parseDouble(numStr));
        } else {
            return new JsonNumber(Long.parseLong(numStr));
        }
    }

    private JsonElement parseString() {
        consume(DOUBLE_QUOTES);
        StringBuilder st = new StringBuilder();
        while(json.charAt(index)!=DOUBLE_QUOTES){
            st.append(json.charAt(index));
            index++;
        }
        consume(DOUBLE_QUOTES);
        return new JsonString(st.toString());
    }

    private void consume(char expected) {
        if(json.charAt(index)==expected)  {
            index++;
        } else{
            throw new RuntimeException("Excepted: "+expected);
        }
    }

    public  void skipWhiteSpace() {
        while(Character.isWhitespace(json.charAt(index))) {
            index++;
        }
    }
}
