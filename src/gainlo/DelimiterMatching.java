package gainlo;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by mayank.gupta on 30/04/17.
 */
public class DelimiterMatching {


    public boolean match(String s) {
        HashMap<Character, Character> openClose = new HashMap<>();
        HashMap<Character,Character> closeOpen = new HashMap<>();

        openClose.put('{','}');
        closeOpen.put('}','{');

        openClose.put('(',')');
        closeOpen.put(')','(');

        openClose.put('[',']');
        closeOpen.put(']','[');

        Stack<Character> delimiterStack = new Stack<>();

        for(int i=0; i< s.length(); i++) {

            /*identify if char is open/close*/
            char c = s.charAt(i);


            if(openClose.containsKey(c)) {
                delimiterStack.add(c);
            }

            if(closeOpen.containsKey(c)) {
                /*The top item on stack should be the corresponding open otherwise return false*/
                if(delimiterStack.isEmpty())
                    return false;

                char top = delimiterStack.peek();
                if(top != closeOpen.get(c))
                    return false;
                else
                    delimiterStack.pop();
            }

        }

        /*Stack should be empty if all open delimiters are closed*/
        if(delimiterStack.isEmpty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        String s = "{df][d}";

        DelimiterMatching dm = new DelimiterMatching();

        System.out.println(dm.match(s));
    }
}
