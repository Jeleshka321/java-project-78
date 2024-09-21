package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        addCondition("required", value -> !super.statusRequire || value != null);
    }

    public NumberSchema required() {
        setStatusRequire(true);
        return this;
    }

    public NumberSchema positive() {
        addCondition("positive", value -> value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCondition("range", value -> value >= min && value <= max);
        return this;
    }

}