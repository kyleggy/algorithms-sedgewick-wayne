package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Exercise33Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushLeft(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (oldFirst != null) {
            first.next = oldFirst;
            oldFirst.previous = first;
        } else {
            first.next = null;
            first.previous = null;
            last = first;
        }
        size ++;
    }

    public void pushRight(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (oldLast != null) {
            last.previous = oldLast;
            oldLast.next = last;
        } else {
            first = last;
            last.previous = null;
        }
        size ++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }
        Item item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }
        size --;
        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }
        Item item = last.item;
        last = last.previous;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        size --;
        return item;
    }

    private class DequeIterator implements Iterator<Item> {
        int index = 0;
        Node current = first;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Item next() {
            index++;

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        Iterator<Item> iterator = this.iterator();
        while (iterator.hasNext()) {
            stringJoiner.add(String.valueOf(iterator.next()));
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {
        Exercise33Deque<String> deque = new Exercise33Deque<>();
        deque.pushLeft("b");
        deque.pushRight("c");
        deque.pushLeft("a");
        deque.pushRight("d");

        StdOut.println("Expected a,b,c,d");
        StdOut.println("Actual is " + deque);

        deque.popLeft();
        deque.popRight();
        StdOut.println("Expected b,c");
        StdOut.println("Actual is " + deque);


    }

}
