package facebook.arrays_n_strings;

import gainlo.LongestNonRepeatingString;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class LongestNonRepeatingSubString {

    public int find(String s) {
        /*Considering only lower case alphabets*/
        int[] visited = new int[26];
        Arrays.fill(visited,-1);

        int curr_length = 0;
        int max_length = 0;

        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(visited[c - 'a'] == -1) {
                curr_length += 1;
                visited[c -'a'] = i;
            }else {
                /*Check if visited index is present in current string*/
                int lastOccurence = visited[c -'a'];
                visited[c -'a'] = i;
                if(i - curr_length <= lastOccurence) {
                    curr_length = i - lastOccurence;
                }else {
                    curr_length += 1;
                }
            }
            max_length = Math.max(max_length, curr_length);
        }

        return max_length;
    }

    public static void main(String[] args) {
        String s = "aaabbbcdeasaasijklmnop";
        LongestNonRepeatingSubString ls = new LongestNonRepeatingSubString();
        System.out.println(ls.find(s));
    }
}
