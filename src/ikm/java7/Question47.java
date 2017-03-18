package ikm.java7;

import java.text.DecimalFormat;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Question47 {
    public static void main(String[] args) {
        double myNum = 98765.4321;

//        Which of the following will guarantee output rounded to one decimal
        System.out.println(new DecimalFormat().format(myNum));
        System.out.println(myNum);
//        System.out.println(DecimalFormat.getInstance("00.0").format(myNum));
        System.out.println(myNum%98765.00);
        System.out.println(new DecimalFormat("0.0").format(myNum)); // Right Answer
    }

}
