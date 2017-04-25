package hiredintech_topcoder.dynamic_programming;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 09/04/17.
 * https://community.topcoder.com/tc?module=ProblemDetail&rd=4482&pm=1592
 * http://www.topcoder.com/tc?module=Static&d1=match_editorials&d2=tccc03_regfinal
 */
public class ChessMetric {

    public static long howMany(int size, int[] start, int[] end, int numMoves) {
        int[] hMove = new int[]{1,-1,0,0,1,-1,1,-1,2,2,-2,-2,1,1,-1,-1};
        int[] vMove = new int[]{0,0,1,-1,1,-1,-1,1,1,-1,1,-1,2,-2,2,-2};
        long[][] matrix = new long[size][size];
        matrix[start[0]][start[1]] = 1;
        long[][] matrixSnapShot = cloneMatrix(matrix);

        /*Add conditions to check that both start and end positions are valid*/
        /*After ith move we will populate the number of ways of reach a position in the matrix in i moves*/
        for(int moves = 1; moves <= numMoves; moves++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(matrixSnapShot[i][j] != 0) {
                    /*Make all possible moves and increment number of ways of reaching those positions in matrix cells*/
                        for(int k = 0; k < hMove.length; k++) {
                            int vPos = i + vMove[k];
                            int hPos = j + hMove[k];
                            if(hPos >=0 && vPos >=0 && hPos < size && vPos < size) {
                                matrix[vPos][hPos] =  matrix[vPos][hPos] + 1;
                            }
                        }
                    }
                }
            }
            matrixSnapShot = cloneMatrix(matrix);
        }

        return matrix[end[0]][end[1]];
    }

    public static long[][] cloneMatrix(long[][] matrix) {
        long[][] clone = new long[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                clone[i][j] = matrix[i][j];
            }
        }
        return clone;
    }

    public static void main(String[] args) {
       /* int[] start = new int[]{0,0};
        int[] end = new int[]{1,0};
        int size = 3;
        int numMoves = 1;*/

      /*  int[] start = new int[]{0,0};
        int[] end = new int[]{0,0};
        int size = 3;
        int numMoves = 2;*/

        int[] start = new int[]{0,0};
        int[] end = new int[]{0,99};
        int size = 100;
        int numMoves = 50;

        long result = howMany(size,start,end,numMoves);
        System.out.println("Num of ways of reaching " + Arrays.toString(end) + " from " + Arrays.toString(start) + " is : " + result);
    }
}
