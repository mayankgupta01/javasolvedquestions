package facebook.arrays_n_strings;

/**
 * Created by mayank.gupta on 15/05/17.
 *
 * Matches * for 0 or more occurences, ? for one occurence any character
 */
public class WildCardMatching {

    public boolean match(String text, String pattern) {

        /*Assuming that pattern contains only alphabets, ?s, *s */

        boolean[][] table = new boolean[text.length()][pattern.length()];

        table[0][0] = true;
        for(int j=0;j<pattern.length();j++) {
            if(pattern.charAt(j) == '*') {
                table[0][j] = true;
            }else
                break;
        }

        /*Build from bottom up*/
        for(int i=1; i<text.length();i++) {
            for(int j=1; j< pattern.length(); j++) {

                if(pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '?') {
                    table[i][j] = table[i-1][j-1];
                }

                if(pattern.charAt(j) == '*') {
                    table[i][j] = table[i][j-1] || table[i-1][j];
                }
            }
        }

        return false;
    }

}
