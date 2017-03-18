package codility;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 14/01/17.
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        K = K % A.length;
        if(A.length == 0 || A.length == 1 || K == 0)
            return A;
//        K = (K > A.length) ? (K - A.length) : K; : My original conditions
        int[] rotatedArray = new int[A.length];
        int j = 0;
        for(int i = (A.length - K); i < A.length; i++, j++) {
            rotatedArray[j] = A[i];
        }

        for(int i = 0 ; i < A.length - K; i++,j++) {
            rotatedArray[j] = A[i];
        }
        return rotatedArray;

    }

    public static void main(String[] args) {
        CyclicRotation cy = new CyclicRotation();
        int[] A = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(cy.solution(A,2)));
    }
}
