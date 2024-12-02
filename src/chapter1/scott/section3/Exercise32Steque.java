package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.StringJoiner;

public class Exercise32Steque<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int size;

    public class Node {
        Item item;
        Node next;
        Node previous;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(Item item) {
        Node previousFirst = first;
        first = new Node();
        first.item = item;
        first.next = previousFirst;
        first.previous = null;
        if (previousFirst != null) {
            previousFirst.previous = first;
        } else {
            last = first;
        }
        size ++;
    }

    /*
     In Steque, it pops the first item (pop item) in the list
     */
    public Item pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Steque is already empty");
        }
        Item popedItem = first.item;
        Node nextFirst = first.next;
        if (nextFirst != null) {
            first = nextFirst;
            first.previous = null;
        } else {
            first = null;
            last = null;
        }
        size --;
        return popedItem;
    }

    /*
    In Steque, it add item into the last node for enqueue method
     */
    public void enqueue(Item item) {
        Node newLast = new Node();
        newLast.item = item;
        newLast.next = null;
        if (!isEmpty()) {
            newLast.previous = last;
            last.next = newLast;
            last = newLast;
        } else {
            newLast.previous = null;
            last = newLast;
            first = last;
        }
        size ++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StequeIterator();
    }

     private class StequeIterator implements Iterator<Item> {

        Node current = first;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            index++;

            return item;
        }
    }

    public static void main(String[] args) {
        Exercise32Steque<Integer> steque = new Exercise32Steque<>();
        steque.push(3);
        steque.push(2);
        steque.push(1);
        steque.pop();
        steque.enqueue(5);
        steque.enqueue(6);

        StringJoiner stequeItems = new StringJoiner(" ");
        for (int number : steque) {
            stequeItems.add(String.valueOf(number));
        }

        StdOut.println("Steque items: " + stequeItems.toString());
        StdOut.println("Expected: 2 3 5 6");
    }
}
