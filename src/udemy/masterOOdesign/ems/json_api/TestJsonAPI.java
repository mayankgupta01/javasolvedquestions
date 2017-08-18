package udemy.masterOOdesign.ems.json_api;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import udemy.masterOOdesign.ems.json_api.components.JsonChef;
import udemy.masterOOdesign.ems.json_api.components.Query;

import java.io.IOException;

/**
 * Created by mayank.gupta on 20/05/17.
 */
public class TestJsonAPI {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);


        JsonChef builder = new JsonChef();
        builder.getQuery().bool().mustMatch("Name", "Mayank").mustMatch("Hobby","Tennis").shouldMatch("Height","6 ft").bool().mustMatch("Hair","black");

        Query query = new Query();
        query.bool().mustMatch("Name","mayank");

        String s = mapper.writeValueAsString(builder);
        String snew = mapper.writeValueAsString(query);

        System.out.println(s);
        System.out.println(snew);
    }
}
