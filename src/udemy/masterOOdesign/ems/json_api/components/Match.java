package udemy.masterOOdesign.ems.json_api.components;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 20/05/17.
 */
public class Match {

    private Map<String, String> valueMap;

    public Match(String key, String value) {
        valueMap = new HashMap<>();
        valueMap.put(key,value);
    }

    public Map<String, String> getValueMap() {
        return valueMap;
    }
}
