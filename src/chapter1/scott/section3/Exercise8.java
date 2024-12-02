package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise8 implements Iterable<String>{
    private String[] a = new String[1];
    private int N = 0;

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    private void resize(int newSize) {
        String[] newArray = new String[newSize];
        for (int i = 0; i < N; i++) {
            newArray[i] = a[i];
        }
        a = newArray;
    }

    public void push(String item) {
        if ( N == a.length) {
            resize( 2 * N);
        }
        a[N++] = item;
    }

    public String pop() {
        String item = a[--N];
        a[N] = null;
        if ( N > 0 && N == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }


    public static void main(String[] args) {
        Exercise8 stack = new Exercise8();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.println(stack.pop());
            }
        }
        StdOut.println(stack.size() + " left on stack.");
        Iterator<String> iterator = stack.iterator();
        StdOut.println("Print the left items");
        while (iterator.hasNext()) {
            StdOut.println(iterator.next());
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<String> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public String next() {
            return a[--i];
        }
    }
}
