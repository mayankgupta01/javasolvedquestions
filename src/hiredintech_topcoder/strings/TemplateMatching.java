package hiredintech_topcoder.dynamic_programming.strings;

/**
 * Created by mayank.gupta on 09/04/17.
 */
import java.io.*;
import java.util.*;

public class TemplateMatching {
    public static String bestMatch(String text, String prefix, String suffix) {
        int n = text.length();
        int mps = -1;
        int mp = -1;
        String ans = "hi, Egor!";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String t = text.substring(i, j);
                int p = Math.min(t.length(), prefix.length());
                while (p > 0 && !prefix.substring(prefix.length() - p).equals(t.substring(0, p)))
                    p--;
                int s = Math.min(t.length(), suffix.length());
                while (s > 0 && !suffix.substring(0, s).equals(t.substring(t.length() - s)))
                    s--;
                if (p + s > mps) {
                    mps = p + s;
                    mp = p;
                    ans = t;
                } else if (p + s == mps && p > mp) {
                    mp = p;
                    ans = t;
                } else if (p + s == mps && p == mp && ans.compareTo(t) > 0) {
                    ans = t;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String text = "something";
        String prefix = "awesome";
        String suffix = "ingenious";

        bestMatch(text,prefix,suffix);

    }

}