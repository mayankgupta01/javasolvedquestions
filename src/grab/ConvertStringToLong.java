package grab;

/**
 * Created by mayank.gupta on 17/05/17.
 */
//Convert string to long, take care of cases


public class ConvertStringToLong {

    public static long stringToLong(String s) {

        //validations
        // length > 0, no char except 0-9, + , -, + - (only in beginning), check for overflow, trim leading, tail spaces, remove leading zeros

        s = s.trim();
        String pattern = "\\d+|\\+\\d+|-\\d+";

        if(!s.matches(pattern))
            throw new IllegalArgumentException("Invalid input string");


        long result = 0;
        long factor = 1;
        boolean isNegative = false;
        int limit = 0;

        if (s.charAt(0) == '-') {
            isNegative = true;
            factor = -1;
            limit = 1;
        }

        if(s.charAt(0) == '+') {
            limit = 1;
        }

        if(String.valueOf(Long.MAX_VALUE).length() < s.length() - limit)
            throw new IllegalArgumentException("Long overflow, cannot convert to long");

        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

        for(int i=s.length()-1; i >= limit; i--) {
            int digit = s.charAt(i) -'0';

            if(isNegative) {
                if(Long.MIN_VALUE - digit*factor > result)
                    throw new IllegalArgumentException("Long overflow, cannot convert to long, cannot add :" + digit*factor+ " to result : " + result);
            }else {
                if(Long.MAX_VALUE - digit*factor < result)
                    throw new IllegalArgumentException("Long overflow, cannot convert to long, cannot add :" + digit*factor+ " to result : " + result);
            }


            result += (long)digit * factor;
            factor = factor*10;


        }

        return result;

    }

    public static double stringToDouble(String s) {

        if(s.length() == 0)
            throw new IllegalArgumentException("Invalid input");
        s = s.trim();
        String pattern = "\\d+\\.?\\d+|\\+\\d+\\.?\\d+|-\\d+\\.?\\d+";

        if(!s.matches(pattern)) {
            throw new IllegalArgumentException("Invalid input string");
        }

        int start = 0;
        int limit = 0;
        double factor = 1;
        boolean isNegative = false;
        double result = 0;

        if(s.charAt(0) == '-') {
            isNegative = true;
            limit = 1;
            factor = -1;
        }

        if(s.charAt(0) == '+') {
            limit = 1;
        }

        start = s.contains(".") ? s.indexOf('.') : s.length() -1;

        /*Calculate the part before decimal*/
        if(start-1 > String.valueOf(Double.MAX_VALUE).length())
            throw new IllegalArgumentException("Double Overflow ");

        for(int i=start-1; i >= limit; i--) {
            int digit = s.charAt(i) -'0';

            if(isNegative) {
                if(Double.MIN_VALUE - digit*factor > result)
                    throw new IllegalArgumentException("Double overflow detected. cannot add " + digit*factor + " to : " +result);
            }else {
                if(Double.MAX_VALUE - digit*factor < result)
                    throw new IllegalArgumentException("Double overflow detected. cannot add " + digit*factor + " to : " +result);
            }

            result += digit*factor;
            factor = factor*10;
        }

        /*Calculate the decimal part now*/
        factor = (double)1/10;
        for(int i=start+1; i<s.length(); i++) {
            int digit = s.charAt(i) -'0';
            result += digit*factor;
            factor = factor/10;

        }

        return result;
    }


    public static void main(String[] args) {
        String s = "+182212  ";

        //System.out.println(ConvertStringToLong.stringToLong(s));
        System.out.println(ConvertStringToLong.stringToDouble(s));
    }
}
