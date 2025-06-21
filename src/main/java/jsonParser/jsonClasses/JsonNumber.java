package jsonParser.jsonClasses;

public class JsonNumber implements JsonElement {
    private Number num;

    public JsonNumber(Number num) {
        this.num = num;
    }
    @Override
    public Object getValue() {
        return num;
    }
}
