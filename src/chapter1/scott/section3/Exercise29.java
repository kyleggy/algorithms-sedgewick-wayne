package chapter1.scott.section3;

import java.util.Iterator;

// Best efficiency defined in src/chapter1/section3/Exercise29.java
public class Exercise29<Item> implements Iterable<Item> {
    private Node last;
    //private Node nextNode;
    private int size = 0;

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

    public void enqueue(Item item) {
        if (size == 0) {
            last = new Node();
            last.item = item;
            last.next = last;
        } else if (size == 1) {
            Node nextNode = new Node();
            nextNode.item = item;
            nextNode.next = last;
            last.next = nextNode;
        } else {
           Node nextNode = last.next;
           Node newNode = new Node();
           newNode.item = item;
           newNode.next = nextNode;
           last.next = newNode;
        }
        size ++;
    }

    public Item dequeue() {
        if (size == 0) {
            throw new UnsupportedOperationException("Queue is already empty");
        }
        Item item = last.item;
        Node nextNode = last.next;
        Node newLastNode = last.next;
        while(newLastNode.next != last) {
            newLastNode = newLastNode.next;
        }
        newLastNode.next = nextNode;
        last = newLastNode;
        size --;
        return item;
    }



    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = last;
        private int count = 1;

        @Override
        public boolean hasNext() {
            return count <= size;
            //return current != last;
        }

        @Override
        public Item next() {
            Item  item = current.item;
            current = current.next;
            count ++;
            return item;
        }
    }

    public static void main(String[] args) {
        Exercise29<String> nodes = new Exercise29<>();
        nodes.enqueue("a");
        nodes.enqueue("b");
        nodes.enqueue("c");
        nodes.enqueue("d");
        nodes.enqueue("e");

        for (String node: nodes) {
            System.out.println(node);
        }

        nodes.dequeue();
        nodes.dequeue();
        nodes.dequeue();
        nodes.dequeue();
        nodes.dequeue();

    }

}
