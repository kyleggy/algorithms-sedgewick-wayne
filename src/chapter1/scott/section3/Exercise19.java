package chapter1.scott.section3;

import java.util.Iterator;

public class Exercise19<Item> implements Iterable<Item> {
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
            Node firstNode = new Node();
            firstNode.item = item;
            firstNode.next = null;
            first = firstNode;
        } else {
            Node current = first;
            while(current.next != null) {
                current = current.next;
            }
            Node nodeToInsertLastPosition = new Node();
            nodeToInsertLastPosition.item = item;
            nodeToInsertLastPosition.next = null;
            current.next = nodeToInsertLastPosition;
        }
        size ++;
    }

    public void removeLastNode() {
        Node current = first;
        for ( int i = 0; i < size - 2; i++) {
            current = current.next;
        }
        current.next = null;
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
        Exercise19<String> nodes = new Exercise19<>();
        nodes.addItem("a");
        nodes.addItem("b");
        nodes.addItem("c");
        nodes.addItem("d");

        Iterator<String> iterator = nodes.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Remove last node...");
        nodes.removeLastNode();
        iterator = nodes.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
