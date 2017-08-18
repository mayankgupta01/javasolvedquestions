package grab;

/**
 * Created by mayank.gupta on 23/05/17.
 * http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
 */
public class PowerWithoutMultiply {

    public int power(int x, int y) {

        if(y == 0)
            return 1;

        int answer = x;
        int increment = x;

        for(int i=1; i < y; i++) {

            for(int j=1; j < x; j++) {

                answer += increment;
            }

            increment = answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        PowerWithoutMultiply pw = new PowerWithoutMultiply();
        System.out.println(pw.power(3,5));

        System.out.println(-2 % 2);
    }
}
