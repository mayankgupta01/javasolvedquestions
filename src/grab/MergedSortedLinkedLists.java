package grab;

/**
 * Created by mayank.gupta on 17/05/17.
 */
public class MergedSortedLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node sort(Node a, Node b) {

        if(a == null)
            return b;

        if(b == null)
            return a;

        Node root = new Node(100);

        Node result = root;

        while(a != null || b != null) {

            if(a == null){
                root.next = b;
                break;
            }

            if(b == null) {
                root.next = a;
                break;
            }

            if(a.data < b.data) {
                root.next = a;
                a = a.next;
            }else {
                root.next = b;
                b = b.next;
            }

            root = root.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        a.next =  new Node(20);
        a.next.next =  new Node(30);

        Node b = new Node(5);
        b.next = new Node(25);
        b.next.next = new Node(50);

        MergedSortedLinkedLists m = new MergedSortedLinkedLists();
        Node result = m.sort(a,b);

        while(result != null) {
            System.out.println(result.data);
            result = result.next;
        }

    }
}
