package chapter1.scott.section3;

import java.util.Iterator;

public class Exercise26<Item> implements Iterable<Item>  {
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

    public Node createNode(Item item) {
        Node node = new Node();
        node.item = item;
        return node;
    }

    public void remove(String item) {

        //If First Node match, remove the first node, use 'while' to avoid
       while (first != null && first.item.equals(item)) {
           first = first.next;
           size --;
       }
       Node current;
       for (current = first; current!= null; current = current.next) {
           Node currentNext = current.next;
           //Use while
           while (currentNext != null && currentNext.item.equals(item)) {
               currentNext = currentNext.next;
               size --;
           }
           current.next = currentNext;
       }
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
        Exercise26<String> nodes = new Exercise26<>();
        nodes.addItem("a");
        nodes.addItem("b");
        nodes.addItem("a");
        nodes.addItem("a");
        nodes.addItem("a");
        nodes.remove("a");
        for(String item : nodes) {
            System.out.println(item);
        }

    }


}
