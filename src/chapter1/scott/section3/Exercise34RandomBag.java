package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import static edu.princeton.cs.algs4.StdRandom.uniform;

public class Exercise34RandomBag<Item> implements Iterable<Item> {
    private Item[] a;  // array of items
    int size;         // number of elements on bag

    public Exercise34RandomBag() {
        a = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        if (size == a.length) {
            resize(2 * size);
        }
        a[size ++] = item;
    }

    private void resize(int n) {
        Item[] temp = (Item[]) new Object[n];
        for (int i = 0; i < size; i ++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void shuffle() {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = size;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);     // between i and n-1
            Item temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

        // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public ArrayIterator() {
            shuffle();
        }

        public boolean hasNext()  {
            return i < size;
        }

        public void remove()     {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
    }

    public static void main(String[] args) {
        Exercise34RandomBag<String> randomBag = new Exercise34RandomBag<>();
        randomBag.add("a");
        randomBag.add("b");
        randomBag.add("c");
        randomBag.add("d");
        randomBag.add("e");
        randomBag.add("f");

        StringJoiner stringJoiner = new StringJoiner(",");
        Iterator<String> iterator = randomBag.iterator();
        while (iterator.hasNext()) {
            stringJoiner.add(iterator.next());
        }
        StdOut.println(stringJoiner.toString());
    }
}
