package ikm.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Question28 {
    public static void main(String[] args) {
        List<Map<List<Integer>, List<String>>> officeParameterList = new ArrayList<>();
        Map<List<Integer>, List<String>> officeParamMap = new HashMap<>();
        officeParameterList.add(null);
        officeParameterList.add(null);
        officeParameterList.add(officeParamMap);
        officeParameterList.add(new HashMap<List<Integer>, List<String>>());

        for(Map element : officeParameterList) {
            System.out.println(element + " ");
        }
    }

}
