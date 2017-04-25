package hiredintech_topcoder.blitz_rounds.round1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 23/04/17.
 * https://community.topcoder.com/stat?c=problem_statement&pm=10180
 * Solution : https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm428
 */
public class TheLuckyString {

    int[] have = new int[26];

    int cnt = 0, L;



    void solve(int pos, char prev) {

        if (pos == L) {

            cnt++;

            return;

        }

        for (char c = 'a'; c <= 'z'; c++)

            if (prev != c && have[c - 'a'] > 0) {

                have[c - 'a']--;

                solve(pos + 1, c);

                have[c - 'a']++;

            }

    }



    public int count(String s) {

        L = s.length();

        for (int i=0; i < L; i++)

            have[s.charAt(i) - 'a']++;

        solve(0, ' ');

        return cnt;

    }

}
