package udemy.masterOOdesign.ems.json_api.components;



/**
 * Created by mayank.gupta on 20/05/17.
 */
public class JsonChef {

    private Query query;



    public JsonChef() {
        query = new Query();
    }

    public Query getQuery() {
        return query;
    }

   /*public static class Builder {

        private Query query;
        private boolean canAddBoolToShould = false;
        private boolean canAddBoolToMust = false;

        public Builder() {
            this.query = new Query();
        }

        public Builder shouldMatch(String key, String value) {

            this.query.bool.getShould().addMatch(key,value);
            canAddBoolToShould = true;
            canAddBoolToMust = false;
            return this;
        }

        public Builder mustMatch(String key, String value) {
            this.query.bool.getMust().addMatch(key,value);
            canAddBoolToShould = false;
            canAddBoolToMust = true;
            return this;
        }

        public Builder bool() {
            if(canAddBoolToMust)
                this.query.bool.getMust().bool();
        }


    }*/
}
