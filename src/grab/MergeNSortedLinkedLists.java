package grab;

/**
 * Created by mayank.gupta on 17/05/17.
 */
public class MergeNSortedLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node[] heap;
    int size;
    int maxSize;

    MergeNSortedLinkedLists(int maxSize) {
        heap = new Node[maxSize+1];
        size = 0;
        this.maxSize = maxSize;
    }

    public Node sort(Node[] array) {

        Node root = new Node(Integer.MAX_VALUE);
        Node result = root;

        constructMinHeap(array);
        while(size >= 1) {
            root.next = extractMin();
            root = root.next;
        }

        return result.next;
    }

    public void constructMinHeap(Node[] array) {

        for(Node node : array) {
            insert(node);
        }
    }

    public void insert(Node node) {

        if(size < maxSize) {
            heap[++size] = node;
        }
        bubbleUp(size);
    }

    public void bubbleUp(int pos) {

        int parent = pos/2;

        if(parent > 0 && heap[parent].data > heap[pos].data) {
            swap(parent,pos);
            bubbleUp(parent);
        }
    }

    public void swap(int index1, int index2) {
        Node temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public Node extractMin() {

        Node result = heap[1];

        if(result.next != null)
            heap[1] = result.next;
        else {
            heap[1] = heap[size];
            size -= 1;
        }


        heapify(1);
        return result;
    }

    public void heapify(int pos) {

        if(!isLeaf(pos)) {

            Node leftChild = heap[pos*2];
            Node rightChild = pos*2 + 1 > size ? null : heap[pos*2 +1];

            int rightChildData = rightChild == null ? Integer.MAX_VALUE : rightChild.data;

            if(heap[pos].data > leftChild.data || heap[pos].data > rightChildData) {

                if(leftChild.data < rightChildData) {
                    swap(pos,pos*2);
                    heapify(pos*2);
                }else{
                    swap(pos,pos*2+1);
                    heapify(pos*2+1);
                }
            }
        }
    }

    public boolean isLeaf(int pos) {

        if(pos > size/2 && pos <= size)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        a.next = new Node(20);
        a.next.next = new Node(30);
        a.next.next.next = new Node(40);

        Node b = new Node(15);
        b.next = new Node(20);


        Node c = new Node(35);
        c.next = new Node(45);

        Node d = new Node(12);
        d.next = new Node(50);

        Node[] array = new Node[4];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        array[3] = d;

        MergeNSortedLinkedLists m = new MergeNSortedLinkedLists(4);

        Node result = m.sort(array);

        while(result != null) {
            System.out.print(result.data + " --> ");
            result = result.next;
        }

    }

}
