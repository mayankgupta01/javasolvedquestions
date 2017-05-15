package cracking_coding_interview.chapter_1.arrays_strings;

/**
 * Created by mayank.gupta on 29/04/17.
 *
 * Problem : 1.5
 */
public class StringCompression {


    public String compress(String s) {

        if(s.length() == 0 || s.length() <=2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = 0;
        char prev = Character.MIN_VALUE;

        for(; i < s.length(); i++) {
            if((s.charAt(i) != prev && count !=0) ) {
                sb.append(prev);
                sb.append(count);
                count = 1;

            }else {
                count = count + 1;

            }
            if(i == s.length() -1)  {
                sb.append(s.charAt(i));
                sb.append(count);
            }
            prev =s.charAt(i);
        }


        return sb.toString().length() < s.length() ? sb.toString() : s;
    }

    public String compressBetter(String s) {

        if(s.length() <= 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        char prev = s.charAt(0);
        int count = 1;

        for(int i=1; i < s.length(); i++) {

            if(s.charAt(i) == prev) {
                count = count+1;
            }else {
                sb.append(prev);
                sb.append(count);
                prev = s.charAt(i);
                count = 1;
            }
        }

        sb.append(prev).append(count);

        return sb.toString().length() >= s.length() ? s : sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbddeeaaaaa";
//        String s = "aaa";

        StringCompression sc = new StringCompression();

        System.out.println(sc.compressBetter(s));
    }
}
