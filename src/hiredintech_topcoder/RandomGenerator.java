package hiredintech_topcoder;

import java.util.Random;

/**
 * Created by mayank.gupta on 03/05/17.
 *
 * https://www.careercup.com/page?pid=facebook-interview-questions
 *
 * generate random number which differs from the number generated last time in the range of [min, max)
 what is the best way to do it?
 public int getNumber(int min, int max){

 }
 */
public class RandomGenerator {


    int lastGenerated = -1;
    Random rand;


    RandomGenerator() {
        rand = new Random();
    }


    public int getNumber(int min, int max) {
        int random;

        if(min == 0 && max == 0) {
            return lastGenerated;
        }


        if(lastGenerated == -1) {
            random = rand.nextInt(max + min);
        }else {
            random = rand.nextInt(max + min) + (lastGenerated -min);
        }
        lastGenerated = random;
        return random;
    }

    public static void main(String[] args) {
        RandomGenerator r = new RandomGenerator();

        System.out.println(r.getNumber(10, 10));
        System.out.println(r.getNumber(10,10));
        System.out.println(r.getNumber(10,10));
        System.out.println(r.getNumber(10,10));
    }
}
