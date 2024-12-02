package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise38GeneralizedLinkedListQueue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    public Exercise38GeneralizedLinkedListQueue() {
        first = null;
        last = null;
        n = 0;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Item x) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = x;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item delete(int k) {   // delete and return the kth least recently inserted item
        if (k > n) {
            throw new IndexOutOfBoundsException();
        }
        Node<Item> nodeToRemove = first;
        int count = n - k;
        Node<Item> previousNode = null;
        while (count > 0) {
            previousNode = nodeToRemove;
            nodeToRemove = nodeToRemove.next;
            count --;
        }
        previousNode.next = nodeToRemove.next;
        n --;
        Item itemToRemove = nodeToRemove.item;

        return itemToRemove;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

      // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
          private Node<Item> current;

          public ListIterator(Node<Item> first) {
              current = first;
          }

          public boolean hasNext() {
              return current != null;
          }

          public void remove() {
              throw new UnsupportedOperationException();
          }

          public Item next() {
              if (!hasNext()) throw new NoSuchElementException();
              Item item = current.item;
              current = current.next;
              return item;
          }
      }

    public static void main(String[] args) {
        Exercise38GeneralizedLinkedListQueue<Integer> queue = new Exercise38GeneralizedLinkedListQueue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);

        queue.delete(2);
        StdOut.println(queue);

        queue.delete(2);
        StdOut.println(queue);


    }
}
