package cracking_coding_interview.chapter_1.arrays_strings;

import java.util.HashSet;

/**
 * Created by mayank.gupta on 29/04/17.
 * Question 1.1
 */
public class UniqueChars {

    public boolean isUnique(String s) {

        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            if(set.contains(c))
                return false;
            set.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abcddeff";

        UniqueChars uc = new UniqueChars();
        System.out.println(uc.isUnique(s));
    }
}
