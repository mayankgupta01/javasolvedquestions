package facebook.dp;

/**
 * Created by mayank.gupta on 09/05/17.
 * Given the alphabet encoded as numbers (e.g., a=1, b   =2, ..., z=26), and a sequence of numbers (e.g., "23413259802"), how many strings can be generated
 */
class NumStrings {

    public int find(String s) {

        if(s.length() <= 1)
            return s.length();



        int[] maxNumStrings = new int[s.length()];
        maxNumStrings[0] = s.charAt(0) == '0'? 0 : 1;

        if(Integer.parseInt(s.substring(0,2)) <= 26) {
            if(Integer.parseInt(s.substring(0,2)) != 0)
                maxNumStrings[1] = 2;
            else
                maxNumStrings[1] = 0;
        }else {
            maxNumStrings[1] = 1;
        }


        for(int i = 2; i < s.length(); i++) {

            int lastTwo = Integer.parseInt(s.substring(i-1,i+1));

            maxNumStrings[i] = lastTwo <= 26 && lastTwo >= 10 ? maxNumStrings[i-1] + maxNumStrings[i-2] : maxNumStrings[i-1];
            if(lastTwo < 10 && lastTwo >0)
                maxNumStrings[i] = Math.max(maxNumStrings[i-1],1);

        }

        return maxNumStrings[s.length() -1];


    }


    public static void main(String[] args) {
//        String s = "1234";
//        String s = "0001";
//        String s = "0000";
        String s = "24125";
        NumStrings num = new NumStrings();

        System.out.println(num.find(s));
    }
}
