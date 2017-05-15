package hiredintech_topcoder;

import java.util.regex.Pattern;

/**
 * Created by mayank.gupta on 01/05/17.
 */
public class RegexLearning {

    public static void main(String[] args) {


        String pattern = "\\+65\\s\\d{8}";

        String phNum = "+65 12345678";

        System.out.println(phNum.matches(pattern));

        /*Return true if string matches three alphabets or three numbers*/
        String pattern2 = "[a-zA-Z]{3}|\\d{3}";

         /*Return true if string matches three alphabets or  numbers*/
        String pattern3 = "[a-zA-Z0-9]{3}";

        String num = "12a";
        System.out.println(num.matches(pattern3));

        /*Return true if a string does not have a number in the beginning*/
        String pattern4 = "^\\D.*";
        String s = "dfs";
        System.out.println(s.matches(pattern4));

        /*Remove whitespace between words*/
        String pattern5 = "(\\w)(\\s+)";
        String sample = "My name is Anthony Gonsalves";

        System.out.println("Original : " + sample + "\n" + "Final : " + sample.replaceAll(pattern5,"$1"));

        /*Number matches singapore number - starts with +65, then a space, then starts with either 3,6,9, 8 digits number*/
        String phonePattern = "\\+65\\s[369]\\d{7}";
        String phoneNum = "+65 79887878";
        System.out.println(phoneNum.matches(phonePattern));

    }
}
