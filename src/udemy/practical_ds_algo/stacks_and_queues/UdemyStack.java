package udemy.practical_ds_algo.stacks_and_queues;

/**
 * Created by mayank.gupta on 12/02/17.
 */
public class UdemyStack {
    private int maxSize;
    private int top;
    private char[] stackArray;

    public UdemyStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char j) {
        top++;
        stackArray[top] = j;
    }

//    Interesting point here. If we change the return type to int or long, the code doesn't break, it just returns the int
//    representation of character at top.
    public char pop() {
        int old_top = top;
        top--;
        return stackArray[old_top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public char peek() {
        return stackArray[top];
    }
}

class testReverseStringWithStack {
    public static void main(String[] args) {
        String input = "Hellios Suvi Baby";
        System.out.printf(reverseString(input));
    }

    public static String reverseString(String input) {
        UdemyStack stack = new UdemyStack(input.length());
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()) {
            stack.push(c);
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
