package facebook.arrays_n_strings;

/**
 * Created by mayank.gupta on 13/05/17.
 */
public class AddBigNumbers {

    public String add(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();

        if(a.length() == 0)
            return b;

        if(b.length() == 0)
            return a;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int aDigit;
        int bDigit;

        while(aLength > 0 || bLength > 0) {

            if(aLength > 0) {
                aDigit = a.charAt(aLength -1) - '0';
            }else {
                aDigit = 0;
            }

            if(bLength > 0) {
                bDigit = b.charAt(bLength - 1) - '0';
            }else {
                bDigit = 0;
            }

            int result = aDigit + bDigit + carry;
            sb.append(String.valueOf(result%10));
            carry = result/10;
            aLength -= 1;
            bLength -= 1;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "9900022";
        String b = "19";

        AddBigNumbers bigN = new AddBigNumbers();
        System.out.println(bigN.add(a,b));
    }
}
