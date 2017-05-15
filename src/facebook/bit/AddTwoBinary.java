package facebook.bit;

import java.util.Stack;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class AddTwoBinary {

    public String add(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int aLen = a.length();
        int bLen = b.length();

        if(aLen > bLen) {
            for(int i=1; i <= aLen-bLen; i++) {
                sb.append("0");
            }
            sb.append(b);
            b = sb.toString();
        }

        if(bLen > aLen) {
            for(int i=1; i <= aLen-bLen; i++) {
                sb.append("0");
            }
            sb.append(a);
            a = sb.toString();
        }

        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        for(int i=a.length()-1; i >= 0; i--) {
            int x = Integer.parseInt(a.substring(i, i + 1));
            int y = Integer.parseInt(b.substring(i, i+1));

            int sum = x ^ y ^ carry;
            carry = (x & y) | (x & carry) | (y & carry);

            stack.push(sum);
        }

        if(carry != 0)
            stack.push(carry);

        sb.delete(0, a.length());
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "111100001010";
        String b = "11";

        AddTwoBinary bin = new AddTwoBinary();

        System.out.println(bin.add(a,b));
    }
}
