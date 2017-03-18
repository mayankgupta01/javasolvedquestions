package udemy.practical_ds_algo.linkedlists;

/**
 * Created by mayank.gupta on 12/02/17.
 */
public class DoublyLinkedList {

    private DoublyLinkedNode first;
    private DoublyLinkedNode last;

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode();
        newNode.data = data;

        if(isEmpty()) {
            last = newNode;
            first = newNode;
        }else {
            newNode.nextNode = first;
            first.previousNode = newNode;
            first = newNode;
        }
    }

    public void insertLast(int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode();
        newNode.data = data;

        if(isEmpty()) {
            last = newNode;
            first = newNode;
        }else {
            last.nextNode = newNode;
            newNode.previousNode = last;
            last = newNode;
        }
    }

    public int deleteLast() {
        if(isEmpty()) {
            System.out.println("Linked list is already empty !");
            return -1;
        }else {
            int oldlastNodeValue = last.data;
            if(first == last) {
                first = null;
                last = null;
            }else {
                last = last.previousNode;
                last.nextNode = null;
            }
            return oldlastNodeValue;
        }
    }

    public int deleteFirst() {
        if(isEmpty()) {
            System.out.println("List is already empty !");
            return -1;
        }
        int oldFirstvalue = first.data;
        if(first == last) {
            first = null;
            last = null;

        }else {
            first = first.nextNode;
            first.previousNode = null;
        }
        return oldFirstvalue;
    }

    public boolean insertAfter(int key, int data) {
        if(isEmpty()) {
            return false;
        }
        DoublyLinkedNode current = first;
        while(current != null) {
            if(current.data == key) {
                DoublyLinkedNode newNode = new DoublyLinkedNode();
                newNode.data = data;
                newNode.nextNode = current.nextNode;
                newNode.previousNode = current;
                current.nextNode = newNode;
                if(last == current)
                    last = newNode;
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public boolean deleteKey(int key) {
        if(isEmpty()) {
            return false;
        }
        DoublyLinkedNode current = first;
        while(current.data !=key) {
            current = current.nextNode;
            if(current == null) {
                return false;
            }
        }
        if(current == first) {
            deleteFirst();
            return true;
        }
        if(current == last) {
            deleteLast();
            return true;
        }
        current.previousNode.nextNode = current.nextNode;
        current.nextNode.previousNode = current.previousNode;
        return  true;
    }

    public void displayList() {
        DoublyLinkedNode current = first;
        System.out.println("Diplaying list from first -> last");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.nextNode;
        }
    }
}

class DoublyLinkedNode {
    int data;
    DoublyLinkedNode nextNode;
    DoublyLinkedNode previousNode;
}

class testDoublyLinkeList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertFirst(50);
        list.insertAfter(10,99);
        list.insertLast(88);

        System.out.println(list.deleteKey(20));
        System.out.println(list.deleteKey(20));
        list.deleteKey(50);
        list.deleteKey(40);
        list.deleteKey(88);
//        list.deleteFirst();
//        list.insertLast(1000);
//        list.deleteLast();



        list.displayList();
    }
}