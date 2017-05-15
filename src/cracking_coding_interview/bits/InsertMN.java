package cracking_coding_interview.bits;

/**
 * Created by mayank.gupta on 29/04/17.
 *
 * 5.1
 *
 *
 */
public class InsertMN {

    public void execute(int M, int N, int i, int j) {
        System.out.println("Binary N : " + Integer.toBinaryString(N));
        System.out.println("Binary M : " + Integer.toBinaryString(M));

        /* First make bits j through i 0 in N */
        for(int k=j; k >=i; k--) {
            int x = ~(1 << k); // This will give 11111011111, j = 5;
            N = N & x;
            System.out.println("Binary N : " + Integer.toBinaryString(N));
        }
        System.out.println("N : " + Integer.toBinaryString(N));
        /*Shift M right so that it starts from jth index*/
        /*Find index of most significant bit in N*/
        int mostSignificantN = mostSignificant(N);
        int mostSignificantM = mostSignificant(M);
        System.out.println("Most Significatn N : " + mostSignificantN );
        System.out.println("Most Significatn N : " + mostSignificantM );

        /*Shift M by mostSignificantN - j places right */
        M = M << (j - mostSignificantM);

        System.out.println("Binary M : " + Integer.toBinaryString(M));

        /*Or N , M for the answer*/

        System.out.println("Answer : " + Integer.toBinaryString(N | M));
        System.out.println((N | M));

    }

    private int mostSignificant(int n) {
        int mostSignificantN = 31;
        for(; mostSignificantN >=0; mostSignificantN--) {
            if((n & (1 << mostSignificantN)) !=0)
                break;
        }

        return mostSignificantN;
    }

    public void betterImplementation(int N, int M, int i, int j) {
        System.out.println("Binary N : " + Integer.toBinaryString(N));
        System.out.println("Binary M : " + Integer.toBinaryString(M));


        /*Clear off i to j bits in N */
        int allOnes = ~0;
        int leftPart = allOnes << j+1;
        int rightPart = (1 << i) - 1 ; // has all ones after ith index
        System.out.println("left part : " + Integer.toBinaryString(leftPart));
        System.out.println("right part : " + Integer.toBinaryString(rightPart));
        N = N & (leftPart | rightPart);

        /*Shift M to left i times to align*/
        M = M << i;
        System.out.println("Final N : " + Integer.toBinaryString(N));
        System.out.println("Final M : " + Integer.toBinaryString(M));
        System.out.println("Answer :" +Integer.toBinaryString(N|M));

    }

    public static void main(String[] args) {
        int N = (1 << 11);
        int M = 19;

        InsertMN in = new InsertMN();
        in.betterImplementation( N,M, 2, 6);

    }
}
