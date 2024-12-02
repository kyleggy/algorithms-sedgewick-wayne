package chapter1.scott.section3;

import java.util.Iterator;

public class Exercise27<Item> implements Iterable<Item>{
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

    public void addItem(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            first.next = null;
        } else {
            Node current;
            for (current = first; current.next != null; current = current.next);
            Node nodeToInsert = new Node();
            nodeToInsert.item = item;
            nodeToInsert.next = null;
            current.next = nodeToInsert;
        }
        size ++;
    }

    public int max() {
        int max = 0;
        if (isEmpty()) {
            return max;
        }
        Node current = first;
        max = (Integer) current.item;
        while(current.next != null) {
            current = current.next;
            int value = (Integer) current.item;
            if (value > max) {
               max = value;
            }
        }
        return max;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

     private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item  item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Exercise27<Integer> nodes = new Exercise27<>();

        nodes.addItem(4);
        nodes.addItem(1);
        nodes.addItem(90);
        nodes.addItem(8);
        System.out.println(nodes.max());

        nodes = new Exercise27<>();
        nodes.addItem(12);
        nodes.addItem(1);
        nodes.addItem(3);
        nodes.addItem(8);
        System.out.println(nodes.max());

        nodes = new Exercise27<>();
        nodes.addItem(13);
        nodes.addItem(1);
        nodes.addItem(3);
        nodes.addItem(14);
        System.out.println(nodes.max());

    }

}
