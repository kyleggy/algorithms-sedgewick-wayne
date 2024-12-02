package chapter1.scott.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Exercise6 {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        invertQueue(queue);

        for (String item : queue) {
            System.out.println(item);
        }

    }

    private static void invertQueue(Queue<String> queue) {
        Stack<String> stack = new Stack<String>();
        while (!queue.isEmpty())
            stack.push(queue.dequeue());
        while (!stack.isEmpty())
            queue.enqueue(stack.pop());
    }
}
