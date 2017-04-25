package udemy.practical_ds_algo.heap;

import java.util.ArrayList;

/**
 * Created by mayank.gupta on 19/03/17.
 *
 * http://algorithms.tutorialhorizon.com/binary-min-max-heap/
 *
 * Find out how to implement a heap without size. Also, find out how to implement to give out an error message if we try
 * to  insert more than the size. Currently on adding a condition in insert method. if(position == heapArray.length -1) return;,
 * we are unable to insert the last element, and it always remains o
 */
public class MaxHeap {

    private int[] heapArray;
    private int position;


    public MaxHeap(int size) {
        heapArray = new int[size + 1];
        position = 1;

    }

    public MaxHeap(int[] array) {
        heapArray = new int[array.length + 1];
        for(int i =1; i < heapArray.length;i++) {
            heapArray[i] = array[i-1];
            position = i;
        }

    }

    public int getElement(int index) {
        return heapArray[index];
    }

    public void display() {
        System.out.println();
        for(int i =1;i <  position; i++) {
            System.out.print(heapArray[i] + ", ");
        }
    }

    public void insert(int data) {
        if(position == 1) {
            heapArray[1] = data;
            position = 2;

            return;
        }
        /*
        * TO DO: add check for insert more than stipulated size
        * */
        heapArray[position] = data;
        bubbleUp(position,data);
        if(position < heapArray.length - 1) {
            position++;
        }
    }

    private void bubbleUp(int position,int data) {
        int parentPosition = position/2;
        int parent = heapArray[parentPosition];
        if(parent < data && position > 1) {
            heapArray[parentPosition] = data;
            heapArray[position] = parent;
            bubbleUp(parentPosition,data);
        }
        return;
    }

    public void extractMax() {
        heapArray[1] = heapArray[position];
        sinkdown(1);
    }

    private void sinkdown(int index) {
        while(index < heapArray.length/2) {
            int root = heapArray[index];
            int leftChild = heapArray[index*2];
            int rightChild = heapArray[index*2 + 1];

            if(root > leftChild && root > rightChild) {
                return;
            }
            if(root > leftChild && root > rightChild) {
                return;
            }
            if(leftChild > rightChild) {
                swap(index,index*2);
                index = index*2;
            }else {
                swap(index,index*2 + 1);
                index = index*2 +1;
            }
        }
        return;
    }

    private void swap(int index1, int index2) {
        int temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

}

class TestMaxHeapImplementation {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(7);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.display();
        maxHeap.extractMax();
        maxHeap.display();
        maxHeap.insert(100);
        maxHeap.display();
    }
}
