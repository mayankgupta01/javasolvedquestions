package grab;

/**
 * Created by mayank.gupta on 17/05/17.
 */
public class MinHeap {


    int[] heap;
    int size;
    int maxSize;

    MinHeap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        heap = new int[maxSize+1];
    }

    public void insert(int num) {

        if(size < maxSize)
            heap[++size] = num;
        else {
            System.out.println("Max size reached cannot insert new ! ");
            return;
        }

        bubbleUp(size);

    }

    public void bubbleUp(int position) {

        int parent = position/2;

        if(parent > 0 && heap[parent] > heap[position]) {
            swap(parent,position);
            bubbleUp(parent);
        }
    }

    public void heapify(int position) {

        if(!isLeaf(position)) {

            int leftChild = heap[position*2];
            int rightChild = heap[position*2 +1];

            if(heap[position] > leftChild || heap[position] > rightChild) {

                if(leftChild < rightChild) {
                    swap(position,leftChild);
                    heapify(leftChild);
                }else {
                    swap(position,rightChild);
                    heapify(rightChild);
                }
            }
        }
    }

    public boolean isLeaf(int position) {

        if(position >= size/2 && position <= size)
            return true;

        return false;
    }

    public void swap(int index1, int index2) {

        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }


}
