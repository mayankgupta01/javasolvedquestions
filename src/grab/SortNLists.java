package grab;

public class SortNLists {

    class Node {
        int value;
        int arrayIndex;
        int nextValueIndex;

        Node(int value, int i, int j) {
            this.value = value;
            this.arrayIndex = i;
            this.nextValueIndex = j;
        }
    }

    Node[] heap;
    int maxSize;
    int size;
    int[][] input;

    SortNLists(int[][] input) {
        this.maxSize = input.length;
        heap = new Node[maxSize+1];
        size = 0;
        this.input = input;
    }

    public void sort() {

        initialize();
        while(size >= 1 && heap[1].value != Integer.MAX_VALUE) {
            System.out.print(extractMin() + " , ");
        }

    }

    public void initialize() {

        for(int i=0; i < input.length; i++) {

            insert(i,0);
        }
    }

    public int extractMin() {


        Node minNode = heap[1];
        int i = minNode.arrayIndex;
        int j = minNode.nextValueIndex;


        if(j == -1) {
            heap[1] = new Node(Integer.MAX_VALUE,0,0);
        }else {
            int nextIndex = j == input[i].length -1 ? -1 : j+1;
            Node node = new Node(input[i][j], i, nextIndex);
            heap[1] = node;
        }

        heapify(1);
        return minNode.value;
    }



    public void heapify(int position) {

        if(!isLeaf(position)) {

            Node leftChild = heap[position*2];
            Node rightChild = heap[position*2 + 1]; // initialize array with Integer.MAX_VALUE to avoid problems when only one child is present
            int rightChildValue = rightChild == null ? Integer.MAX_VALUE : rightChild.value;


            if(heap[position].value > leftChild.value || heap[position].value > rightChildValue) {

                if(leftChild.value > rightChild.value) {
                    swap(position,position*2 +1);
                    heapify(position*2 +1);
                }else {
                    swap(position,position*2);
                    heapify(position*2);
                }
            }
        }
    }

    public boolean isLeaf(int position) {

        if(position > size/2 && position <= size)
            return true;

        return false;
    }



    public void insert(int i, int j) {
        int nextIndex;
        if (size < maxSize) {
            if (j == input[i].length -1) {
                nextIndex = -1;
            }else {
                nextIndex = j+1;
            }

            heap[++size] = new Node(input[i][j], i, nextIndex);
        }
        bubbleUp(size);
    }

    public void bubbleUp(int position) {

        int parent = position/2;

        if(parent > 0) {

            Node node = heap[parent];
            if(node.value > heap[position].value) {
                swap(position,parent);
                bubbleUp(parent);
            }
        }
    }

    public void swap(int index1, int index2) {

        Node temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{{10,20,30,40,50},{5,15,25,35,45,55},{3,13,23,33,43,53}};

        SortNLists sortNLists = new SortNLists(input);
        sortNLists.sort();

    }
}