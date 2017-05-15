package cracking_coding_interview.chapter_1.arrays_strings;

/**
 * Created by mayank.gupta on 29/04/17.
 */
public class RemoveSpace {

    public String execute(String s) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++ ) {
            if(s.charAt(i) != ' ')
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public String replace(String s, String replacement) {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                sb.append(replacement);
            else
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "   ab c     d e g    ";

        RemoveSpace rs = new RemoveSpace();

        System.out.println(rs.execute(s));
    }
}
