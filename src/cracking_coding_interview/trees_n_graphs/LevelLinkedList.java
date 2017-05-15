package cracking_coding_interview.trees_n_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mayank.gupta on 07/05/17.
 */
public class LevelLinkedList {

    public List<LinkedList<BNode>> create(BTree tree) {


        BNode root = tree.root;

        if(root == null)
            return null;

        List<LinkedList<BNode>> result = new ArrayList<>();

        Queue<BNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        /*Null will identify level change*/

        while(!queue.isEmpty()) {

            LinkedList<BNode> list = new LinkedList<>();

            /*Add all level elements to list, add all next level elements to queue*/
            while(queue.peek() != null) {

                BNode top = queue.remove();
                list.add(top);

                if(top.left != null)
                    queue.add(top.left);

                if(top.right != null)
                    queue.add(top.right);

            }

            /*Pop the null element*/
            queue.remove();

            /*Add another null element to mark level end if there are any items on this level*/
            if(queue.size() != 0)
                queue.add(null);

            /*Add list to ArrayList*/
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        BNode root = new BNode(10);
        /*Level 2*/
        root.left = new BNode(20);
        root.right = new BNode(30);

        /*Level 3*/
        root.left.left = new BNode(40);
        root.right.right = new BNode(50);

        /*Level 4*/
        root.left.left.left = new BNode(60);

        /*Level 5*/
        root.left.left.left.left = new BNode(70);
        root.left.left.left.right = new BNode(80);

        LevelLinkedList ll = new LevelLinkedList();

        List<LinkedList<BNode>> result = ll.create(new BTree(root));

        for(LinkedList<BNode> list : result) {
            System.out.println();
            for(BNode node : list) {
                System.out.print(node.value  + " ");
            }
            System.out.println();
        }
    }
}
