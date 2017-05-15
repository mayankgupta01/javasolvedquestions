package facebook.linkedlists;

/**
 * Created by mayank.gupta on 09/05/17.
 */
public class PrintLinkedList {

    public void reverse(LinkedNode head) {

        //Since this is an integer linked list, we can create a number while traversing and that will be our output for reverse
        // This will work if we have nodes of value from 0 -9 only
        int sum = 0;
        int factor = 1;

        LinkedNode node = head;
        while(node != null) {

            sum = sum + node.value*factor;
            factor = factor*10;
            node = node.next;
        }

        System.out.println("Reverse : " + sum);
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);

        PrintLinkedList pl = new PrintLinkedList();
        pl.reverse(head);

    }
}