package grab;

import java.util.Scanner;

/**
 * Created by mayank.gupta on 24/05/17.
 */
public class Divisible {

    public void isDivisible(int divideBy) {

        int remainder = 0;

        //input validations
        if(divideBy <= 0)
            return;

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        while(input >=0 && input <= 1) {

            if(input == 0)
                remainder = remainder*2;
            else
                remainder = remainder*2 + 1;


            remainder = remainder % divideBy;
            System.out.println("Is Divisible : " + (remainder == 0));
            input = sc.nextInt();
            System.out.println("New input :" + input);
        }
    }

    public static void main(String[] args) {
        Divisible div = new Divisible();
        div.isDivisible(3);
    }
}
