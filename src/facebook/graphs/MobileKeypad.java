package facebook.graphs;

import java.util.*;

/**
 * Created by mayank.gupta on 11/05/17.
 */
public class MobileKeypad {

    LinkedList<Integer>[] adjList;

    MobileKeypad() {
        adjList = new LinkedList[10];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
        createKeyPad();
    }

    public void createKeyPad() {
        addEdge(0,0);
        addEdge(0,8);
        addEdge(1,1);
        addEdge(1,2);
        addEdge(1,4);
        addEdge(2,2);
        addEdge(2,3);
        addEdge(2,5);
        addEdge(3,3);
        addEdge(3,6);
        addEdge(4,5);
        addEdge(4,7);
        addEdge(4,4);
        addEdge(5,6);
        addEdge(5,8);
        addEdge(5,5);
        addEdge(6,9);
        addEdge(6,6);
        addEdge(7,8);
        addEdge(7,7);
        addEdge(8,9);
        addEdge(8,8);
        addEdge(9,9);
    }

    public void addEdge(int a, int b) {
        if(a == b) {
            adjList[a].add(a);
        }else {
            adjList[a].add(b);
            adjList[b].add(a);

        }
    }

    public int combinations(int length) {
        if(length == 0)
            return 0;

        List<String> result =  count(length, new LinkedList<>());
        return result.size();
    }

    public List<String> count(int length, Queue<String> queue) {

        if(length == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            list.add("6");
            list.add("7");
            list.add("8");
            list.add("9");
            return list;
        }

        queue.clear();
        List<String> result = count(length-1,queue);
        queue.addAll(result);
        result.clear();
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            String s = queue.poll();
            int comboLen = s.length();
            int lastDigit = Integer.parseInt(s.substring(comboLen - 1, comboLen));
            sb.delete(0,comboLen);
            sb.append(s);
            for(int i : adjList[lastDigit]) {
                sb.append(String.valueOf(i));
                result.add(sb.toString());
                sb.deleteCharAt(comboLen);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MobileKeypad mk = new MobileKeypad();
        int length = 10;
        System.out.println("Total num combinations for length : " + length + " = " + mk.combinations(length));
    }


}
