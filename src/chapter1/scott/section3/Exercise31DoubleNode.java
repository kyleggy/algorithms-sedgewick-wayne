package chapter1.scott.section3;

import java.util.Iterator;
import java.util.StringJoiner;

public class Exercise31DoubleNode<Item> implements Iterable<Item> {
    private Node first;
    private Node end;
    private int size = 0;


    public class Node {
        Item item;
        Node next;
        Node previous;
    }

    public void insertBeginning(Item item) {
        if (size == 0) {
            first = new Node();
            first.item = item;
            first.previous = null;
            first.next = null;
            end = first;
        } else if (size == 1) {
            Node newFirst = new Node();
            newFirst.item = item;
            newFirst.next = end;
            newFirst.previous = null;
            end.previous = newFirst;
            first = newFirst;
        } else {
            Node newFirst = new Node();
            newFirst.item = item;
            newFirst.next = first;
            newFirst.previous = null;
            first.previous = newFirst;
            first = newFirst;
        }
        size ++;
    }

    public void insertEnd(Item item) {
        if (size == 0) {
            end = new Node();
            end.item = item;
            end.next = null;
            end.previous = null;
            first = end;
        } else if(size == 1) {
            Node newEnd = new Node();
            newEnd.item = item;
            newEnd.next = null;
            newEnd.previous = end;
            first.next = newEnd;
            end = newEnd;
        } else {
            Node newEnd = new Node();
            newEnd.item = item;
            newEnd.next = null;
            newEnd.previous = end;
            end.next = newEnd;
            end = newEnd;
        }
        size ++;
    }

    public void removeBeginning() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            first = null;
            end = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size --;
    }

    public void removeEnd() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Failed to execute removeEnd function due to there is on item exists in the nodes.");
        } else if (size == 1) {
            end = null;
            first = null;
        } else {
            end = end.previous;
            end.next = null;
        }
        size --;
    }

    public Node createNode(Item item) {
        Node node = new Node();
        node.item = item;
        return node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.item.equals(node.item)) {
                nodeToInsert.next = currentNode;
                Node previsousNode = currentNode.previous;
                currentNode.previous = nodeToInsert;
                nodeToInsert.previous = previsousNode;
                previsousNode.next = nodeToInsert;
                size ++;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.item.equals(node.item)) {
                Node nextNode = currentNode.next;
                nodeToInsert.next = nextNode;
                nodeToInsert.previous = currentNode;
                currentNode.next = nodeToInsert;
                if (nextNode != null) {
                    nextNode.previous = nodeToInsert;
                }
                size ++;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public void removeNode(Node node) {
        Node currentNode = first;
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        } else if (size == 1 && node.item.equals(first.item)) {
            first = null;
            end = null;
            size --;
        } else {
            while (currentNode != null) {
                if (node.item.equals(currentNode.item)) {
                    Node previousNode = currentNode.previous;
                    Node nextNode = currentNode.next;
                    if (previousNode != null) {
                        previousNode.next = nextNode;
                    }
                    if (nextNode != null) {
                        nextNode.previous = previousNode;
                    }
                    size--;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        Iterator<Item> iterator = this.iterator();
        while (iterator.hasNext()) {
            stringJoiner.add(String.valueOf(iterator.next()));
        }
        return stringJoiner.toString();
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
        Exercise31DoubleNode<String> nodes = new Exercise31DoubleNode<>();
        nodes.insertBeginning("c");
        nodes.insertBeginning("b");
        nodes.insertBeginning("a");
        nodes.insertEnd("d");
        nodes.insertEnd("e");
        nodes.insertEnd("f");
        System.out.println("Expected is a,b,c,d,e,f; actual is " + nodes.toString());
        nodes.removeBeginning();
        nodes.removeEnd();
        System.out.println("Expected is b,c,d,e; actual is " + nodes.toString());
        nodes.insertBefore(nodes.createNode("d"), nodes.createNode("k"));
        System.out.println("Expected is b,c,k,d,e; actual is " + nodes.toString());
        nodes.insertAfter(nodes.createNode("e"), nodes.createNode("j"));
        System.out.println("Expected is b,c,k,d,e,j; actual is " + nodes.toString());
        nodes.removeNode(nodes.createNode("d"));
        System.out.println("Expected is b,c,k,e,j; actual is " + nodes.toString());
        nodes.removeNode(nodes.createNode("j"));
        System.out.println("Expected is b,c,k,e; actual is " + nodes.toString());
    }


}
