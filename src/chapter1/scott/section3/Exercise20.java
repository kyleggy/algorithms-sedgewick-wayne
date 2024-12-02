package chapter1.scott.section3;

import java.util.Iterator;

public class Exercise20<Item> implements Iterable<Item> {
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

    public void delete(int k) {
        if ( k < 1 || k > size) {
            System.out.println(String.format("Node does not exist on %s position.", k));
        }
        Node current = first;
        for (int i = 0; i < k - 2 ; i ++) {
            current = current.next;
        }
        current.next = current.next.next;
        size --;
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
        Exercise20<String> nodes = new Exercise20<>();
        nodes.addItem("a");
        nodes.addItem("b");
        nodes.addItem("c");
        nodes.addItem("d");
        nodes.addItem("e");

        for(String item : nodes) {
            System.out.println(item);
        }

        System.out.println("After delete...");
        nodes.delete(3);
        for(String item : nodes) {
            System.out.println(item);
        }
    }
}
