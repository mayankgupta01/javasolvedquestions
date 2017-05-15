package hackerrank_world_champ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mayank.gupta on 28/04/17.
 */
public class PermutationHappiness {

    /*static int query(int n, int k){
        // Complete this function
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <=n; i++) {
            sb.append(i);
        }
        String s = sb.toString();
        return permute(s,k);

    }

    public static String[] permute(String string, int k)
    {
        int happyCount = 0;
        if(string!= null)
        {
            char[] chars= string.toCharArray();
            if(chars.length == 0)
                return 0;
            else if(chars.length == 1)
            {
                //Permutation for one char
                String[] strs = new String[1];
                strs[0] = new StringBuilder().append(chars[0]).toString();
                if(isHappy(strs[0],k))
                    happyCount = happyCount+1;

                return happyCount;
            }
            else if (chars.length == 2)
            {
                //Permutation for two chars
                String[] strings = new String[2];
                strings[0] = new StringBuilder().append(chars[0]).append(chars[1]).toString();
                strings[1] = new StringBuilder().append(chars[1]).append(chars[0]).toString();
                if(isHappy(strings[0],k))
                    happyCount = happyCount+1;

               if(isHappy(strings[1],k))
                   happyCount = happyCount+1;
                return happyCount;
            }
            else
            {
                Set<String> set = new HashSet();
                //Find permuation of n-1 chars
                String[] permutations = permute(string.substring(0, chars.length-1));
                //nth char
                char ch = chars[chars.length-1];
                //Place nth char in all places in Permutation(n-1)
                for(String str : permutations)
                {
                    char[] chrs = str.toCharArray();
                    int x=0,y=0;
                    StringBuilder newString = null;
                    while(x<=chrs.length)
                    {
                        newString = new StringBuilder();
                        y=0;
                        while(y<x)
                        {
                            newString.append(chrs[y]);
                            y++;
                        }
                        newString.append(ch);
                        while(y<chars.length-1)
                        {
                            newString.append(chrs[y]);
                            y++;
                        }
                        if(isHappy(newString.toString(),k)) {
                            happyCount = happyCount +1;

                        }

//                            set.add(newString.toString());
                        x++;
                    }
                }

                return happyCount % (int)(Math.pow(10,9) + 7);
            }
        }
        return 0;
    }

    private static boolean isHappy(String s, int k) {
        int happyCount = 0;

        if(s.charAt(0) < s.charAt(1))
            happyCount = happyCount+1;

        if(s.charAt(s.length()-1) < s.charAt(s.length()-2))
            happyCount = happyCount+1;


        for(int i = 1; i < s.length()-1; i++) {
            if(s.charAt(i-1) > s.charAt(i) || s.charAt(i+1) > s.charAt(i))
                happyCount = happyCount+1;
        }

        return happyCount >= k ? true : false;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            // Find the number of ways to arrange 'n' people such that at least 'k' of them will be happy
            // The return value must be modulo 10^9 + 7
            int result = query(n, k);
            System.out.println(result);
        }
    }*/
}
