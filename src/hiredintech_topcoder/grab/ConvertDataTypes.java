package hiredintech_topcoder.grab;

/**
 * Created by mayank.gupta on 30/04/17.
 */
public class ConvertDataTypes {

    public int covertToInt(String s) {

        int length = s.length();
        int result = 0;
        int factor = 1;
        /*Validations*/
        if(length == 0)
            return -1;

        for(int i=length-1; i >= 0; i--) {
            result = result + factor*(s.charAt(i) - '0');
            factor = factor*10;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "";

        ConvertDataTypes cv = new ConvertDataTypes();
        System.out.println(cv.covertToInt(s));
    }
}
