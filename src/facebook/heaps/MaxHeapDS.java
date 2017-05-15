package facebook.heaps;

/**
 * Created by mayank.gupta on 09/05/17.
 */
public class MaxHeapDS {

    int[] array;
    int position;
    int maxSize;

    MaxHeapDS(int maxSize) {
        this.maxSize = maxSize;
        position =1;
        array = new int[maxSize+1];
    }

    public void insert(int a) {

        /*Check overflow*/
        if(position > maxSize)
            System.out.println("Max position crossed");

        array[position] = a;

        if(position == 1) {
            position += 1;
            return;
        }

        bubbleUp(position);
        if(position < maxSize)
            position += 1;
    }

    private void bubbleUp(int index) {
        int parentIndex = index/2;
        if(parentIndex >= 1 && array[parentIndex] < array[index]) {
            swap(parentIndex,index);
            bubbleUp(parentIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int extract() {

        int root = array[1];
        position = position -1;
        array[1] = array[position];
        sinkDown(1);
        return root;
    }

    private void sinkDown(int index) {

        if(index < position/2) {
            int leftChild = index*2;
            int rightChild = index*2+1;

            if(array[index] > array[leftChild] && array[index] > array[rightChild])
                return;

            if(array[leftChild] < array[rightChild]) {
                swap(index,rightChild);
                sinkDown(rightChild);
            }
            else {
                swap(index,leftChild);
                sinkDown(leftChild);
            }
        }
    }

    public void display() {

        for(int i=1; i < position; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("*******************");
    }


    public static void main(String[] args) {
        MaxHeapDS maxH = new MaxHeapDS(10);
        maxH.insert(10);
        maxH.insert(20);
        maxH.insert(30);
        maxH.insert(40);
        maxH.insert(50);

        maxH.display();

        System.out.println(maxH.extract());
        System.out.println(maxH.extract());
        System.out.println(maxH.extract());
        System.out.println(maxH.extract());

        maxH.display();
    }
}
