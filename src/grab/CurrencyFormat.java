package grab;

/**
 * Created by mayank.gupta on 24/05/17.
 */
public class CurrencyFormat {

    public String format(String s) {

        // validate input
        s = s.trim();

        String pattern = "\\d+.?\\d+";

        if(!s.matches(pattern))
            return null;

        StringBuilder sb = new StringBuilder(s);

        //round to two decimal if there is a decimal
        int decimalIndex = s.indexOf(".");

        if(decimalIndex != -1) {

            double decimal = Double.valueOf(s.substring(decimalIndex,s.length()));

            decimal = (double) Math.round(decimal*100)/100;

            sb.replace(decimalIndex, sb.length(),String.valueOf(decimal).substring(1,4));
        }

        int counter = 0;
        decimalIndex = decimalIndex == -1 ? sb.length() -1 : decimalIndex;
        for(int i=decimalIndex-1; i >=0; i--) {
            counter += 1;

            if(counter == 3) {
                sb.insert(i,',');
                counter = 0;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "1235.45";
        CurrencyFormat cf = new CurrencyFormat();
        System.out.println(cf.format(s));
    }
}
