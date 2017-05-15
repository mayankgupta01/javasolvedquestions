package cracking_coding_interview.stacks_queues;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by mayank.gupta on 07/05/17.
 *
 * 3.2
 */
public class StackMin {


    Stack<Integer> mainStack;
    Stack<Integer> trackMin;

    StackMin() {
        mainStack = new Stack<>();
        trackMin = new Stack<>();
    }

    public void push(int n) {
        if(n <= min()) {
            trackMin.push(n);
        }
        mainStack.push(n);
    }

    public int pop() {
        if(isEmpty())
            throw new EmptyStackException();

        int top = mainStack.peek();

        if(top == min()) {
            trackMin.pop();
        }

        return mainStack.pop();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int min() {
        if(trackMin.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return trackMin.peek();
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();

//        stackMin.pop();
        stackMin.push(10);
        stackMin.push(20);
        stackMin.push(4);
        stackMin.push(3);
        stackMin.push(4);
        stackMin.push(2);
        stackMin.push(5);

        System.out.println(stackMin.min());
        System.out.println("Popping now : " + stackMin.pop());
        System.out.println(stackMin.min());
        System.out.println("Popping now : " + stackMin.pop());
        System.out.println(stackMin.min());
        System.out.println("Popping now : " + stackMin.pop());
        System.out.println(stackMin.min());
        System.out.println("Popping now : " + stackMin.pop());
        System.out.println(stackMin.min());
        System.out.println("Popping now : " + stackMin.pop());
        System.out.println(stackMin.min());
        System.out.println("Popping now : " + stackMin.pop());
        System.out.println(stackMin.min());
        System.out.println("Popping now : " + stackMin.pop());
    }


}
