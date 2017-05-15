package cracking_coding_interview.chapter_1.arrays_strings;

/**
 * Created by mayank.gupta on 29/04/17.
 *
 * 1.8
 *
 * Really cool funda to find if a string or array is a rotation of another array.Sorted or Unsorted
 *
 *
 */
public class CheckStrings {

   public boolean isRotation(String s1, String s2) {

       /*If we divide s1 into two parts x and y, s1 = xy and rotation on x, s2 will be = yx . Now, no matter what we choose as index of x
       *
       * yx will always be a substring of xyxy that is s1s1.       *
       *
       * */
       String s = s1 + s1;

       if(s1.length() == s2.length() && s1.length() > 0) {
           return s.contains(s2);
       }

       return false;
    }

    public static void main(String[] args) {
        String s1 = "watermelon";
        String s2 = "melonwater";

        CheckStrings cs = new CheckStrings();

        System.out.println(cs.isRotation(s1,s2));
    }

}
