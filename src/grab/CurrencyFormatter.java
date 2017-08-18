package grab;

/**
 * Created by mayank.gupta on 30/04/17.
 * Format a string of numbers to display a currency - example" "1234.678" to "1,234.68"

 */
public class CurrencyFormatter {

    public String format(String s) {

        double price = Double.valueOf(s);

        /*Round off to two digits after decimal*/
        price = (double)Math.round(price * 100)/100;

        /*Add commas after every 3 chars starting from . traversing left*/

        int counter = 0;

        StringBuilder sb = new StringBuilder(String.valueOf(price));

        for(int i=sb.indexOf(".")-1; i >=0; i--) {
            counter = counter +1;
            if(counter == 3) {

                sb.insert(i,",");
                counter = 0;
            }
        }

        return sb.toString();
    }

    public String formatBetter(String s) {

        StringBuilder sb = new StringBuilder(s);
        int indexOfDecimal = s.indexOf(".");

        /*If no decimal value present, add 00*/
        if(indexOfDecimal == -1) {
            sb.append(".00");
            indexOfDecimal = s.length();
        }else {
            double decimalValue = Double.valueOf(s.substring(indexOfDecimal));

        /*Round off decimal value to two digits*/
            decimalValue = (double) Math.round(decimalValue*100)/100;

        /*Create new string with rounded off decimal*/

            sb.replace(indexOfDecimal,sb.length(),String.valueOf(decimalValue).substring(1));

        }


        int counter = 0;

        for(int i=indexOfDecimal-1; i >=0; i--) {
            counter = counter+1;

            if(counter == 3) {
                sb.insert(i,",");
                counter = 0;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "11001223.2365";
//        String s = "11001223";

        CurrencyFormatter cf = new CurrencyFormatter();
        System.out.println(cf.format(s));
        System.out.println(cf.formatBetter(s));
    }
}
