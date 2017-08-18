/*
Upackage hiredintech_topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * Created by mayank.gupta on 24/04/17.
 *//*

public class Permutations {

    public List<char[]> permuteRecursive(String s) {

        if(s.length() == 1) {
            char[] permutations = new char[s.length()];
            ArrayList<char[]> result = new ArrayList<>();
            permutations[0] = s.charAt(0);
            result.add(permutations);
            return result;
        }

        List<char[]> permute = new ArrayList<>();
        char last = s.substring(s.length()-1).toCharArray()[0];
        String rightPart = s.substring(0,s.length()-1);

        for(char[] chars : permuteRecursive(rightPart)) {

            for(int i = 0; i < s.length(); i++) {
                char[] result = new char[s.length()];
                for(int j = 0; j < s.length(); j++) {
                    if(j < i)
                        result[j] = chars[j];
                    if(j == i)
                        result[j] = last;
                    if(j > i)
                        result[j] = chars[j-1];

                }
                permute.add(result);
            }
        }

        return permute;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<char[]> result = new ArrayList<>();
        String s = "abcdef";
        result = p.permuteRecursive(s);
        System.out.println("Total permutations : " + result.size());
        for( char[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}
*/
