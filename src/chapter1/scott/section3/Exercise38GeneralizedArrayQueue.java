package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise38GeneralizedArrayQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    public Exercise38GeneralizedArrayQueue() {
        items = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Item x) {
        if (items.length == size) {
            resize(2 * size);
        }
        items[size ++] = x;
    }

    public void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i ++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public Item delete(int k) {
        if (k > size) {
            throw new IndexOutOfBoundsException();
        }
        if (items.length == size * 2) {
            resize(size);
        }
        int count = size -k;
        Item itemToDelete = items[count];
        for( int i = count; i < size -1 ; i ++) {
            items[i] = items[i + 1];
        }
        size --;
        return itemToDelete;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

     @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>
    {  // Support FIFO iteration.
        private int i = 0;
        public boolean hasNext() {  return i < size;   }
        public    Item next()    {  return items[i++];  }

    }

    public static void main(String[] args) {
        Exercise38GeneralizedArrayQueue<Integer> queue = new Exercise38GeneralizedArrayQueue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        StdOut.println(queue);
        queue.delete(2);

        StdOut.println(queue);
        queue.delete(2);
        StdOut.println(queue);

    }
}
