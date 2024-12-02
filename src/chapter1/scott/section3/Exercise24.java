package chapter1.scott.section3;

import java.util.Iterator;

public class Exercise24<Item> implements Iterable<Item> {
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

    public void removeAfter(Node node) {
        if (isEmpty() || node == null) {
            return;
        }

        Node current = first;
        for (int i = 0; i < size - 2; i ++) {
            if (current.item.equals(node.item)) {
                current.next = current.next.next;
                size --;
                break;
            }
            current = current.next;
        }
    }

    public Node createNode(Item item) {
        Node node = new Node();
        node.item = item;
        return node;
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
        Exercise24<String> nodes = new Exercise24<>();
        nodes.addItem("a");
        nodes.addItem("b");
        nodes.addItem("c");
        nodes.addItem("d");
        nodes.addItem("e");
        nodes.addItem("f");
        nodes.addItem("g");

        System.out.println("Should remove d");
        nodes.removeAfter(nodes.createNode("c"));
        for (String item : nodes) {
            System.out.println(item);
        }

        System.out.println("Shouldn't remove g");
        nodes.removeAfter(nodes.createNode("f"));
        for (String item : nodes) {
            System.out.println(item);
        }

        System.out.println("Should remove f");
        nodes.removeAfter(nodes.createNode("e"));
        for (String item : nodes) {
            System.out.println(item);
        }

        System.out.println("Should remove b");
        nodes.removeAfter(nodes.createNode("a"));
        for (String item : nodes) {
            System.out.println(item);
        }
    }


}
