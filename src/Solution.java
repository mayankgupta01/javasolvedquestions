import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> parent = new ArrayList<Integer>();
        ArrayList<Integer> child = new ArrayList<Integer>();

        System.out.println("Enter lenght of parent array");
        int lenghtOfParent = scan.nextInt();
        for(int i = 0; i < lenghtOfParent; i++) {
            parent.add((Integer)scan.nextInt());
        }
        System.out.println("Enter length of child array");
        int lenghtOfChild = scan.nextInt();
        for(int i = 0; i < lenghtOfChild; i++) {
            child.add((Integer)scan.nextInt());
        }
        int matchIndex = findChildArray(parent, child);
        System.out.println("Match found at index : " + matchIndex);

    }

    private static int findChildArray(ArrayList<Integer> parent,ArrayList<Integer>  child) {
        if (isOccurencePossible(parent, child)) {
            int largestPossibleMatchIndex = parent.size() - child.size() + 1;
            System.out.println("limit is : " + largestPossibleMatchIndex);
            for (int i = 0; i < largestPossibleMatchIndex; i++) {
                if (findMatch(parent, child, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean isOccurencePossible(ArrayList<Integer> parent, ArrayList<Integer> child) {
        if(parent.size() == 0 || child.size() == 0) {
            throw new IllegalArgumentException("Either parent or child array has size 0");
        }

        if(child.size() > parent.size()) {
            throw new IllegalArgumentException("Child array size is greater than Parent array size");
        }
        return true;
    }

    private static boolean findMatch(ArrayList<Integer> parent, ArrayList<Integer> child, int offset) {
        for (int i = 0; i < child.size(); i++) {
            System.out.println("offset is : " + offset);
            System.out.println("parent is: " + parent.get(i +offset));
            System.out.println("child is: " + child.get(i ));

            if(parent.get(i + offset) != child.get(i)) {
                return false;
            }
        }
        return true;
    }


}