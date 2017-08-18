package udemy.masterOOdesign.ems.json_api.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 20/05/17.
 */
public class Must  {

    private List<Match> matches;
    private Bool nestedBool;

    public List<Match> getMatches() {
        return matches;
    }

    public Bool getNestedBool() {
        return nestedBool;
    }

    protected Must() {matches = new ArrayList<>();}

    protected Bool bool() {
        if (nestedBool == null) {
            nestedBool = new Bool();
        }

        return nestedBool;
    }

    protected void addMatch(String key, String value) {
        matches.add(new Match(key,value));
    }

}
