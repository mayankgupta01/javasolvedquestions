package udemy.masterOOdesign.ems.json_api.components;

/**
 * Created by mayank.gupta on 20/05/17.
 */
public class Query {

    protected Bool bool;

    public Query() {
        bool = new Bool();
    }

    public Bool bool() {
        return bool;
    }


}
