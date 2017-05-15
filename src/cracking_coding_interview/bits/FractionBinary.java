package cracking_coding_interview.bits;

/**
 * Created by mayank.gupta on 29/04/17.
 */
public class FractionBinary {

    public String convertToBinary(double n)  {

        StringBuilder sb = new StringBuilder();
        sb.append(".");
        int count = 0;

        while(n > 0) {
            double r = n*2;
            if(r >= 1) {
                n = r -1;
                sb.append(1);

            }else {
                sb.append(0);
                n = r;
            }
            count++;

            if(count > 32)
                return "ERROR";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        double n = 0.7;

        FractionBinary fb = new FractionBinary();
        System.out.println(fb.convertToBinary(n));
    }
}
