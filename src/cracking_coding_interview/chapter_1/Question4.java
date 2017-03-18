package cracking_coding_interview.chapter_1;

import java.util.Scanner;

/**
 * Created by mayank.gupta on 13/01/17.
 */
public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] inputCharArray = sc.nextLine().toCharArray();
        char replaceThis = ' ';
        Question4 q4 = new Question4();
        String finalString = q4.replace(inputCharArray,replaceThis,"%20");
        System.out.println("Result is : " + finalString);
    }

    public String replace(char[] inputCharArray, char replaceThis, String filler) {
        StringBuffer sb = new StringBuffer();
        System.out.println(inputCharArray);
        System.out.println("Replace this : " + replaceThis);
        System.out.println("With this : " + filler);
        for(char c : inputCharArray) {
            if(c == replaceThis){
                sb.append(filler);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
