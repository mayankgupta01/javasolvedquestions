package hiredintech_topcoder.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 26/04/17.
 * http://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
 */
public class DifferentAdjacentString {
    Map<Character,Integer> charCount = new HashMap<>();
    String[] allAnswers = new String[1];

    public String isPossible(String s) {
        allAnswers[0] = "NOT POSSIBLE";
        for(char c : s.toCharArray()) {
            if(charCount.containsKey(c)) {
                int cnt = charCount.get(c);
                charCount.put(c,cnt+1);
            }else {
                charCount.put(c,1);
            }
        }
        isPossible(s,0,Character.MIN_VALUE,"");
        return allAnswers[0];

    }

    private boolean isPossible(String s, int index, char prev, String result) {

        /*Base condition*/
        if(index == s.length()) {
            allAnswers[0] = result;
            return true;
        }

        for(Map.Entry<Character,Integer> entry : charCount.entrySet()) {
            char present = entry.getKey();
            int presentCount = entry.getValue();

            if(present != prev && presentCount > 0) {
                charCount.put(present,presentCount-1);
                index++;
                result = result+ present;
                if(isPossible(s, index,present,result))
                    return true;
                /*Reduce index by 1 so that another combination can be tried*/
                index--;
                charCount.put(present,presentCount);
                result = result.substring(0,result.length()-1);
            }

        }

        return  false;
    }


    public static void main(String[] args) {
        String s = "aaabb";

        DifferentAdjacentString ds = new DifferentAdjacentString();
        System.out.println(ds.isPossible(s));


        stringOperation(s);
        System.out.println("In main, s = " + s);

        String another = new String("abc");
        stringOperation(another);
        System.out.println("In main, another = " + another);
    }

    public static void stringOperation(String s) {

        System.out.println("Inside stringOperation, before operating, s = " + s);
        System.out.println(s.hashCode());

        s = "abc";
        System.out.println("Inside stringOperation method, after operating, s = " + s);
        System.out.println(s.hashCode());
    }
}
