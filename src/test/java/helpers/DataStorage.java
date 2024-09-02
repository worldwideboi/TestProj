package helpers;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static Map<String, String> dataMap = new HashMap<>();

    public static void setValue(String key, String value) {
        dataMap.put(key, value);
    }

    public static String getValue(String key) {
        return dataMap.get(key);
    }

    public <T> T getValue(String key, Class<T> type) {
        return type.cast(dataMap.get(key));
    }

    public boolean containsKey(String key) {
        return dataMap.containsKey(key);
    }

    public void clear() {
        dataMap.clear();
    }
}
