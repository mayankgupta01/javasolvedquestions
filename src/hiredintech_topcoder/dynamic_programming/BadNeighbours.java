package hiredintech_topcoder.dynamic_programming;

/**
 * Created by mayank.gupta on 25/03/17.
 */
public class BadNeighbours {

    public static void main(String[] args) {
//        int[] input = new int[]{ 10, 3, 2, 5, 7, 8 };
        int[] input = new int[]{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
        System.out.println(maxDonations(input));

    }

    public static int maxDonations(int[] donations) {
        int maxDonation = 0;
        int[] maxDonationWithFirst = new int[donations.length];
        int[] maxDonationWithLast = new int[donations.length];

        /*Case 1 : including 0th element*/
        for(int i = 0 ; i < donations.length -1; i++) {
            maxDonationWithFirst[i] = donations[i];
            for(int j = 0; j < i -1; j++) {
                maxDonationWithFirst[i] = Math.max(maxDonationWithFirst[i],donations[i] + maxDonationWithFirst[j]);
            }
            maxDonation = Math.max(maxDonation,maxDonationWithFirst[i]);
        }

        /*Case 2 : without first element*/
        for(int i = 1 ; i < donations.length ; i++) {
            maxDonationWithLast[i] = donations[i];
            for(int j = 0; j < i -1; j++) {
                maxDonationWithLast[i] = Math.max(maxDonationWithLast[i],donations[i] + maxDonationWithLast[j]);
            }
            maxDonation = Math.max(maxDonation,maxDonationWithLast[i]);
        }

        return maxDonation;
    }
}
