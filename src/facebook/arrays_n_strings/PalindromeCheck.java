package facebook.arrays_n_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class PalindromeCheck {

    public boolean canBePalindrome(String s) {

        int len = s.length();

        /*Is s is odd then only one character of odd count is permitted, if even there should be no odd count chars*/

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                int count = map.get(c);
                map.put(c,count+1);
            }else {
                map.put(c,1);
            }
        }

        /*make a pass to find out how many odd count chars are present*/
        int oddCount = 0;

        for(Character c : map.keySet()) {
            if(map.get(c)%2 != 0)
                oddCount += 1;
        }

        if(len%2 == 0 && oddCount == 0)
            return true;

        if(len%2 != 0 && oddCount == 1)
            return true;

        return false;
    }

    public static void main(String[] args) {
        String s = "MMMTTTYY";

        PalindromeCheck pc = new PalindromeCheck();
        System.out.println("String " + s + "can be rearranged into palindrome ? " + pc.canBePalindrome(s));
    }
}
