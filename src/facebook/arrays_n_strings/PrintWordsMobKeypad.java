package facebook.arrays_n_strings;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class PrintWordsMobKeypad {
    String[] numPad = new String[10];

    PrintWordsMobKeypad() {

        numPad[2] = "abc";
        numPad[3] = "def";
        numPad[4] = "ghi";
        numPad[5] = "jkl";
        numPad[6] = "mno";
        numPad[7] = "pqrs";
        numPad[8] = "tuv";
        numPad[9] = "wxyz";

    }
    public void print(String num) {

        if(num.length() == 0)
            return;

        print(num,0,new StringBuilder(),num.length());
    }

    public void print(String num, int numIndex,StringBuilder output, int length) {

        if(numIndex == length) {
            System.out.println(output.toString());
            output.deleteCharAt(output.length() -1);
            return;
        }


        int x = num.charAt(numIndex) - '0';

        if(x == 0 || x == 1) {
            print(num,numIndex+1,output,length);
            return;
        }

        for(char c : numPad[x].toCharArray()) {

            output.append(c);
            print(num,numIndex+1,output,length);
        }
        if(output.length() > 0)
            output.deleteCharAt(output.length() -1);

    }

    public static void main(String[] args) {
        String num = "234";

        PrintWordsMobKeypad pn = new PrintWordsMobKeypad();
        pn.print(num);

    }
}
