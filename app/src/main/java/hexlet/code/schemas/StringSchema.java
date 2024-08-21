package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        isValid(true);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCondition(s -> ((String) s).length() >= minLength);
        return this;
    }

    public StringSchema contains(String contains) {
        addCondition(s -> ((String) s).contains(contains));
        return this;
    }

    @Override
    public boolean checkIfNull(Object object) {
        return object == null || ((String) object).isEmpty();
    }
}