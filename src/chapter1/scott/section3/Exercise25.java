package chapter1.scott.section3;

import java.util.Iterator;
import java.util.StringJoiner;

public class Exercise25<Item> implements Iterable<Item> {
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

    public void insertAfter(Node firstNode, Node secondNode) {
        if (firstNode == null || secondNode == null)
            return;
        Node current;
        // boolean isExist = false;
//        for(current = first; current.next != null; current = current.next) {
//            if (current.item.equals(firstNode.item)) {
//                Node temp = current.next;
//                current.next = secondNode;
//                secondNode.next = temp;
//                size ++;
//                isExist = true;
//                break;
//            }
//        }
//        if (current.next == null && !isExist) {
//            Node temp = current.next;
//            current.next = secondNode;
//            secondNode.next = temp;
//            size ++;
//            isExist = true;
//        }

        //You can directly use current!= null to let the current to the last node
        for(current = first; current != null; current = current.next) {
            if (current.item.equals(firstNode.item)) {
                Node temp = current.next;
                current.next = secondNode;
                secondNode.next = temp;
                size ++;

                break;
            }
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
        Exercise25<String> nodes = new Exercise25<>();
        nodes.addItem("a");
        nodes.addItem("b");
        nodes.addItem("c");
        nodes.addItem("e");
        nodes.addItem("f");

        nodes.insertAfter(nodes.createNode("c"), nodes.createNode("d"));
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String node : nodes) {
            stringJoiner.add(node);
        }
        System.out.println(stringJoiner);

        System.out.println("Test insert last one ");
        nodes.insertAfter(nodes.createNode("f"), nodes.createNode("g"));
        stringJoiner = new StringJoiner(" ");
        for (String node : nodes) {
            stringJoiner.add(node);
        }
        System.out.println(stringJoiner);

        System.out.println("Test insert first one ");
        nodes.insertAfter(nodes.createNode("a"), nodes.createNode("a1"));
        stringJoiner = new StringJoiner(" ");
        for (String node : nodes) {
            stringJoiner.add(node);
        }
        System.out.println(stringJoiner);
    }

}
