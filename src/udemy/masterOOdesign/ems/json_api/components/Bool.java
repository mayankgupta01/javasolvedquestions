package udemy.masterOOdesign.ems.json_api.components;

/**
 * Created by mayank.gupta on 20/05/17.
 */
public class Bool {

    private Must must;
    private Should should;
    private boolean addBoolToMust = false;
    private boolean addBoolToShould = false;

    protected Bool() {}

    public Must getMust() {
        if(must == null) {
            must = new Must();
        }

        return must;
    }

    public Should getShould() {
        if(should == null) {
            should = new Should();
        }

        return should;
    }


    public Bool shouldMatch(String key, String value) {

        this.getShould().addMatch(key,value);
        addBoolToMust = false;
        addBoolToShould = true;
        return this;
    }

    public Bool mustMatch(String key, String value) {
        this.getMust().addMatch(key,value);
        addBoolToShould = false;
        addBoolToMust = true;
        return this;
    }


    public Bool bool() {
        if(addBoolToMust)
            return this.getMust().bool();

        if(addBoolToShould)
            return this.getShould().bool();

        return this;
    }


}
