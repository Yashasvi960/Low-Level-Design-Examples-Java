package jsonParser.jsonClasses;

public class JsonBoolean implements JsonElement {

    private boolean toggle;

    public JsonBoolean(boolean toggle) {
        this.toggle = toggle;
    }
    @Override
    public Object getValue() {
        return toggle;
    }
}
