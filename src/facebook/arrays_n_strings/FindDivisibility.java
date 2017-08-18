package facebook.arrays_n_strings;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public class FindDivisibility {

    public boolean isDivisible(int num, int divisor) {

        if(divisor == num)
            return true;

        if(divisor > num)
            return false;

        if(divisor <= 0)
            return false;

        int x = 1 << 31;
        int z = x-1;
        long y = (long)Math.pow(2,31);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        return findRemainder(num, divisor) == 0;

    }

    public int findRemainder(int num, int divisor) {

        /*Base case*/
        if(num == 0 || num == 1) {
            return num;
        }

        int prevRemainder = findRemainder(num >> 1,divisor);
        int lsb = num & 1;

        if(lsb == 0) {
            return prevRemainder*2 % divisor;
        }else{
            return (prevRemainder*2 + 1) % divisor;
        }

    }


    public static void main(String[] args) {
        FindDivisibility fd = new FindDivisibility();
        System.out.println(fd.isDivisible(21, 7));
    }
}
