package gainlo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mayank.gupta on 29/04/17.
 * http://blog.gainlo.co/index.php/2016/10/07/facebook-interview-longest-substring-without-repeating-characters/
 */
public class LongestNonRepeatingString {

    public String find(String s) {

        /*Validate input and return for obvious cases*/
        HashSet<Character> set = new HashSet<>();
        boolean hasRepeats = false;

        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                hasRepeats = true;
            }else {
                set.add(c);
            }
        }

        /*Return whole string if no repeated characters*/
        if(!hasRepeats) {
            return s;
        }

        /*Return string with single character if only one character is repeated in whole string*/
        if(set.size() == 1) {
            for(char c : set) {
                return Character.toString(c);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> subset = new HashSet<>();

        int start = 0;
        int end = 1;


        String result = "";
        subset.add(s.charAt(start));
        queue.add(s.charAt(start));


        while(end < s.length()) {
            char c = s.charAt(end);
            if(!subset.contains(c)) {
                subset.add(c);
                queue.add(c);
                end++;
            }else {
                String curResult = s.substring(start,end);
                result = curResult.length() > result.length() ? curResult : result;
                while(queue.peek() != c) {
                    char a = queue.remove();
                    subset.remove(a);
                    start++;
                }
                queue.remove();
                subset.remove(c);
                start++;
            }
        }

        /*Check if last candidate is longest*/
        String curResult = s.substring(start,end);
        result = curResult.length() > result.length() ? curResult : result;

        return result;

    }

    public static void main(String[] args) {
        String s = "aaaaa";

        LongestNonRepeatingString ls = new LongestNonRepeatingString();
        System.out.println(ls.find(s));

    }
}
