package jsonParser.jsonClasses;

public class JsonString implements JsonElement {

    private String val;

    public JsonString(String val) {
        this.val = val;
    }
    @Override
    public Object getValue() {
        return val;
    }
}
