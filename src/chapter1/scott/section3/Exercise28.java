package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise28<Item> implements Iterable<Item> {
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

    public Node createNode(Item item) {
        Node node = new Node();
        node.item = item;
        return node;
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
        if (isEmpty()) {
            return 0;
        }
        int currentMax = (Integer) first.item;
        return recursiveCompare(first.next, currentMax);
    }

    private int recursiveCompare(Node currentNode,int currentMax) {
        if (currentNode == null) {
            return currentMax;
        }
        int currentValue = (Integer) currentNode.item;
        if (currentMax < currentValue) {
            currentMax = currentValue;
        }
        return recursiveCompare(currentNode.next, currentMax);
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
   Exercise28<Integer> linkedList = new Exercise28<>();
        linkedList.addItem(3);
        linkedList.addItem(1);
        linkedList.addItem(2);
        linkedList.addItem(9);

        int maxValue = linkedList.max();
        StdOut.println("Max value: " + maxValue);
        StdOut.println("Expected: 9");

    }


}
