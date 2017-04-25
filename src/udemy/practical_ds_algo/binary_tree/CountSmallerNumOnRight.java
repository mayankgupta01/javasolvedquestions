package udemy.practical_ds_algo.binary_tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mayank.gupta on 19/03/17.
 *
 * http://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
 *
 *
 * Count smaller elements on right side
 Write a function to count number of smaller elements on right of each element in an array. Given an unsorted array arr[]
 of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of smaller elements
 on right side of each element arr[i] in array.
 *
 *Time Complexity - O(nlogn)
 *
 */
public class CountSmallerNumOnRight {

    public static void main(String[] args) {
        int[] inputArray = new int[]{1,2,3,100,40,20,10,900,102};
        ArrayList<Integer> ar = new ArrayList<>();
        int[] computeNumOfSmallerElementsOnRight = new int[inputArray.length];
        SBBST sb = new SBBST();
        for(int i = inputArray.length - 1; i >=0; i--) {
            sb.insert(inputArray,computeNumOfSmallerElementsOnRight,i);
        }
        System.out.println(Arrays.toString(inputArray));
        System.out.println(Arrays.toString(computeNumOfSmallerElementsOnRight));
    }
}

class SBBST {
    private BSNode root;

    private int height(BSNode node) {
        if(node == null) {
            return -1;
        }
        return Math.max(height(node.left),height(node.right)) + 1;
    }

    private int balanceLeftToRight(BSNode node) {
        int leftheight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;

        return (leftheight - rightHeight);
    }

    private int size(BSNode node) {
        if(node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    public void insert(int[] inputArray, int[] countArray, int index) {
        root = insert(root,inputArray[index],countArray,index);
    }

    private BSNode insert(BSNode node, int data, int[] count, int index) {
        if(node == null) {
            return new BSNode(data);
        }

        if(data < node.data) {
            node.left = insert(node.left,data,count,index);
        }

        if(data > node.data) {
            node.right = insert(node.right,data,count,index);
            count[index] = count[index] + size(node.left) + 1;
        }

        if(data == node.data) {
            return node;
        }

        node.height = height(node);
        node.size = size(node);

        /*Balance tree now*/
        /*Right Rotate*/
        if(balanceLeftToRight(node) > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        /*Left Rotate*/
        if(balanceLeftToRight(node) < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        if(balanceLeftToRight(node) > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if(balanceLeftToRight(node) < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private BSNode leftRotate(BSNode node) {
        BSNode child = node.right;
        node.right = child.left;
        child.left = node;
        node.height = height(node);
        node.size = size(node);
        child.height = height(child);
        child.size = size(child);
        return child;
    }

    private BSNode rightRotate(BSNode node) {
        BSNode child = node.left;
        node.left = child.right;
        child.right = node;
        node.height = height(node);
        node.size = size(node);
        child.height = height(child);
        child.size = size(child);
        return child;
    }

}

class BSNode {
    int data;
    BSNode left;
    BSNode right;
    int size;
    int height;

    public BSNode(int data) {
        this.data = data;
        left = right = null;
        size = 1;
        height = 0;
    }
}
