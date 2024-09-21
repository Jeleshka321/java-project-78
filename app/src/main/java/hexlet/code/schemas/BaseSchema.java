package hexlet.code.schemas;

import lombok.Setter;

import java.util.function.Predicate;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseSchema<T> {
    @Setter
    protected boolean statusRequire;
    protected final Map<String, Predicate<T>> conditionsMap = new LinkedHashMap<>();

    public final void addCondition(String name, Predicate<T> predicate) {
        conditionsMap.put(name, predicate);
    }

    public final boolean isValid(T value) {
        if (value == null) {
            return !statusRequire;
        }
        return conditionsMap.values().stream().allMatch(predicate -> predicate.test(value));
    }
}