package chapter1.scott.section3;

import java.util.Iterator;

public class Exercise30<Item> implements Iterable<Item>{
     private class Node {
        Item item;
        Node next;
    }

    private int size;
    private Node first;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        } else {
            Node current;
            for (current = first; current.next != null; current = current.next) ;

            Node newNode = new Node();
            newNode.item = item;
            current.next = newNode;
        }
        size++;
    }

    public Node reverse() {

        Node reverse = null;

        while(first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        first = reverse;
        return reverse;
    }

    public void recursiveReverse() {
        first=  recursiveReverse(first);
    }

    public Node recursiveReverse(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        //The rest is always the last one, it will become the first one after all reversing finished
        Node rest = recursiveReverse(second);
        second.next = first;
        first.next  = null;
        return rest;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    public static void main(String[] args) {
        Exercise30<String> nodes = new Exercise30<>();
        nodes.add("a");
        nodes.add("b");
        nodes.add("c");
        nodes.add("d");
        for(String node: nodes) {
            System.out.println(node);
        }

        System.out.println("After reverse");
        nodes.reverse();
        for(String node: nodes) {
            System.out.println(node);
        }

        System.out.println("After reverse using recursive");
        nodes.recursiveReverse();
        for(String node: nodes) {
            System.out.println(node);
        }




    }
}
