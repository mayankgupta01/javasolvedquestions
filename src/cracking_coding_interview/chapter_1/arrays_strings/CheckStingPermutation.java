package cracking_coding_interview.chapter_1.arrays_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 29/04/17.
 */
public class CheckStingPermutation {

    public boolean isPermutation(String a, String b) {

        Map<Character, Integer> countChars = new HashMap<>();


        /*Check is size is same*/
        if(a.length() != b.length())
            return false;

        for(char c : a.toCharArray()) {
            if(countChars.containsKey(c)) {
                int count = countChars.get(c);
                countChars.put(c,count+1);
            }else {
                countChars.put(c,1);
            }
        }

        /*Check if b has same characters occuring same number of times */
        for(char c : b.toCharArray()) {

            if(!countChars.containsKey(c))
                return false;

            int count = countChars.get(c);

            /*Character present but occurs more times than original string*/
            if(count == 0)
                return false;

            count = count-1;

            countChars.put(c,count);
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "aabcdef";
        String b = "defaacf";

        CheckStingPermutation checkPerm = new CheckStingPermutation();
        System.out.println(checkPerm.isPermutation(a,b));
    }
}
