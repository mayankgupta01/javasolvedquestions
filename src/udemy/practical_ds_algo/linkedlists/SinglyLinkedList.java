package udemy.practical_ds_algo.linkedlists;

/**
 * Created by mayank.gupta on 12/02/17.
 */
public class SinglyLinkedList {

    private Node head = null;
    private Node tail = null;
    private int listLength = 0;


    public void addNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            tail.setNextNode(null);
        }else {
            node.setNextNode(null);
            Node oldTail = tail;
            oldTail.setNextNode(node);
            tail = node;
        }
    }
}
