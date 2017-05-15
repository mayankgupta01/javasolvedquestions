package hiredintech_topcoder.grab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 30/04/17.
 */
public class ReverseWords {



    public String reverse(String s) {

        /*Trim leading and ending spaces, Find out how to trim spaces in java*/
        s = s.trim();

        /*Validate if no spaces , i.e only one word then return*/
        if(!s.contains(" "))
            return s;

        /*Find out how to split using space regex, so that more than one space if present is split in two proper words and not three*/
        /*Remove extra whitespaces in between words as per requirement*/
        s = s.replaceAll("\\s+"," ");

        String[] wordsArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i= wordsArray.length-1; i >=0; i--) {
            sb.append(wordsArray[i]).append(" ");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "  How    Come   You are   Here! ? ";

        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverse(s));
    }
}
