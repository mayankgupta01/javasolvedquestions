package grab;

/**
 * Created by mayank.gupta on 23/05/17.
 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 */
public class Power {


    public int calculateRaiseTo(int x, int y) {

        if(y == 0)
            return 1;

        if(y % 2 == 0)
            return calculateRaiseTo(x,y/2)*calculateRaiseTo(x,y/2);
        else
            return x*calculateRaiseTo(x,y/2)*calculateRaiseTo(x,y/2);

    }



    //Better solution, in the above solution, same x,y/2 is getting calculated multiple times, we can reduce that by storing it in a temp variable
    public int powerBetter(int x, int y) {

        if( y == 0)
            return 1;

        int temp = powerBetter(x,y/2);
        if(y % 2 == 0)
            return temp*temp;
        else
            return x*temp*temp;
    }

    public static void main(String[] args) {
        Power pw = new Power();
        //System.out.println(pw.calculateRaiseTo(2, 10));
        System.out.println(pw.powerBetter(2,10));
    }
}
