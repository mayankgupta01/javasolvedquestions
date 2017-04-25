package hiredintech_topcoder.bit_manipulation;

/**
 * Created by mayank.gupta on 24/04/17.
 *
 * https://www.hackerearth.com/practice/notes/bit-manipulation/
 */
public class PrintAllSubsets {

    public void subsets(String s)  {

        /*Possible combinations = 2 to the power of N, in all numbers from 0 to 2 power N, each number's binary representation
        * represents which index of set should be present (1 for present, 0 for absent)
        *
        * We are going to use this info to generate subsets
        *
        * */



        for(int i = 0 ; i < (1 << s.length()); i++) {
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < s.length(); j++) {
                /*Check if jth bit in i is set to 1*/
                if((i & (1 << j)) != 0)
                    sb.append(s.charAt(j));
            }
            System.out.println(sb.toString());
        }

     }

    public void findAllSubsetsOfLength(String s, int length) {


        for(int i = 0; i < (1 << s.length()); i++) {
            if(countOfOnes(i,length)) {
                StringBuilder sb = new StringBuilder();

                for(int j=0; j < s.length(); j++) {
                    if((i & (1 << j)) != 0)
                        sb.append(s.charAt(j));
                }
                System.out.println(sb.toString());
            }
        }
    }

    private boolean countOfOnes(int i, int cnt) {
        int count = 0;

        while(i != 0) {
            i = i & (i-1);
            count++;
        }

        return count == cnt;
    }

    public static void main(String[] args) {
        String s = "abcde";
        PrintAllSubsets p = new PrintAllSubsets();

        //p.subsets(s);
        p.findAllSubsetsOfLength(s,4);
    }

}
