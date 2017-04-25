package hiredintech_topcoder.dynamic_programming.strings;

/**
 * Created by mayank.gupta on 09/04/17.
 */
public class WolfDelayMaster {
    private static final String VALID = "VALID";
    private static final String INVALID = "INVALID";

    public static String check(String str) {
        /*Base case handling*/
        if(str.length() < 4)
            return INVALID;
        if(str.length() == 4) {
            return str.equals("wolf") ? VALID : INVALID;
        }
        int counter = 0;
        for(int i = 0; i < str.length();) {
            while(i < str.length() && str.charAt(i) == 'w') {
                counter++;
                i++;
            }
            if(counter == 0)
                return INVALID;
            if(!isValidWordPart(str,'o',i,counter))
                return INVALID;
            i = i + counter;
            if(!isValidWordPart(str,'l',i,counter))
                return INVALID;
            i = i + counter;
            if(!isValidWordPart(str,'f',i,counter))
                return INVALID;
            i = i + counter;
            counter = 0;
        }
        return VALID;
    }

    private static boolean isValidWordPart(String str, char chrToValidate, int start, int occurence) {
        for(int i = start; i < start + occurence; i++) {
            if(i >= str.length())
                return false;
            if(str.charAt(i) != chrToValidate)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "wolfwolfwwwooolllffff";
        System.out.println("The word : " + word + " is : " + check(word));
    }
}
