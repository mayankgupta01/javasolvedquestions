package facebook.arrays_n_strings;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class CountNumbers {

    public void printCount(int num, int numOftimes) {

        if(numOftimes == 0)
            return;

        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char prev = s.charAt(0);

        for(int i=1; i < s.length(); i++) {
            if(s.charAt(i) == prev)
                count += 1;
            else {
                sb.append(count).append(prev);
                count = 1;
                prev = s.charAt(i);
            }
        }

        sb.append(count).append(prev);
        System.out.println(sb.toString());

        printCount(Integer.parseInt(sb.toString()),numOftimes -1);
    }

    public static void main(String[] args) {
        int num = 112233;
        CountNumbers cn = new CountNumbers();
        cn.printCount(num,2);
    }
}
