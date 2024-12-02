package chapter1.scott.section3;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

public class Exercise12 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");


        System.out.println("Copied stack: " + copy(stack));
        System.out.println("Original stack: " + stack);
    }

    private static Stack<String> copy(Stack<String> stack) {

        Stack<String> tempStack = new Stack<>();
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            tempStack.push(item);
        }
        Stack<String> copiedStack = new Stack<>();
        while (!tempStack.isEmpty()) {
            copiedStack.push(tempStack.pop());
        }

        return copiedStack;
    }
}
