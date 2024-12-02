package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise14ResizingArrayQueueOfStrings {

    public static void main(String[] args) {
        ResizingArrayQueue resizingArrayQueue = new ResizingArrayQueue();
        resizingArrayQueue.enQueue("a");
        resizingArrayQueue.enQueue("b");
        resizingArrayQueue.enQueue("c");
        resizingArrayQueue.enQueue("d");
        resizingArrayQueue.enQueue("e");
        resizingArrayQueue.enQueue("f");
        resizingArrayQueue.enQueue("g");
        StdOut.println(resizingArrayQueue.deQueue());
        StdOut.println(resizingArrayQueue.deQueue());
//        StdOut.println(resizingArrayQueue.deQueue());
//        StdOut.println(resizingArrayQueue.deQueue());
//        StdOut.println(resizingArrayQueue.deQueue());
//        StdOut.println(resizingArrayQueue.deQueue());
//        StdOut.println(resizingArrayQueue.deQueue());
        StdOut.println("Iterator begins");
        Iterator<String> iterator = resizingArrayQueue.iterator();
        while (iterator.hasNext()){
            StdOut.println(iterator.next());
        }

    }

    private static class ResizingArrayQueue implements Iterable {
        private String[] a = new String[1];
        private int N = 0;

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        private void resize(int max) {
            String[] temp = new String[max];
            for (int i = 0; i < N; i ++) {
                temp[i] = a[i];
            }
            a = temp;
        }

        public void enQueue(String item) {
            if ( N == a.length) {
                resize(2 * a.length);
            }
            a[N++] = item;
        }

        public String deQueue() {
            String item = a[0];
            for (int i = 0; i < N; i++) {
                String temp = a[i + 1];
                a[i] = temp;
                a[i+1] = null;
            }
            N--;
            if (N > 0 && N == a.length/4) resize(a.length/2);
            return item;
        }

        @Override
        public Iterator<String> iterator() {
            return new ArrayIterator();
        }

        private class ArrayIterator implements Iterator<String>
        {  // Support FIFO iteration.
            private int i = 0;
            public boolean hasNext() {  return i < N;   }
            public    String next()    {  return a[i++];  }
            public    void remove()  {                  }
        }
    }
}
