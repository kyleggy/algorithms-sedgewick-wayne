package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;

public class Exercise40MoveToFront<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            first.next = null;
        } else {
            Node current = first;
            Node previous = null;
            boolean isDupExist = false;
            //handle intput is 1,2,1
            while (current.next != null || size == 2) {
                Item currentItem = current.item;
                if (!currentItem.equals(item)) {
                    previous = current;
                    current = current.next;
                } else {
                    isDupExist = true;
                    break;
                }
            }
            if (isDupExist) {
                previous.next = current.next;
            }
            Node newFirst = new Node();
            newFirst.item = item;
            newFirst.next = first;
            first = newFirst;
        }
        size ++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }

        Item item = first.item;
        first = first.next;
        size--;

        return item;
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


    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,2,1,3,4,5,6,7,6,5,4};
        Exercise40MoveToFront<Integer> integers = new Exercise40MoveToFront<>();
        Arrays.stream(input).forEach(value -> integers.insert(value));
        StdOut.println(integers);
        StdOut.println("Expected is: " + "4 5 6 7 3 1 2 ");

    }
}
