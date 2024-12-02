package chapter1.scott.section3;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

public class Exercise39RingBuffer<Item> implements Iterable<Item> {
    private Item[] bufferItems;
    private int size;
    private int last;
    private int first;
    private Queue<Item> producerAuxBuffer;


    public Exercise39RingBuffer(int capacity) {
        bufferItems = (Item[]) new Object[capacity];
        size = 0;
        last = -1;
        first = -1;
        producerAuxBuffer = new Queue<>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void produce(Item item) {
        if (isEmpty()) {
            bufferItems[size++] = item;
            last = 0;
            first = 0;
        } else {
            if (size < bufferItems.length) {
                if (last == bufferItems.length -1) {
                    last = 0;
                } else {
                    last ++;
                }
                bufferItems[last] = item;
                size ++;
            } else {
                producerAuxBuffer.enqueue(item);
            }
        }
    }

    public Item consume() {
        if (isEmpty()) {
            return null;
        }

        Item itemToConsume = bufferItems[first];
        bufferItems[first] = null;

        if (first == bufferItems.length -1) {
            first = 0;
        } else {
            first ++;
        }
        size --;

        if (!producerAuxBuffer.isEmpty()) {
            produce(producerAuxBuffer.dequeue());
        }
        return itemToConsume;
    }


    @Override
    public Iterator<Item> iterator() {
        return new RingBufferIterator();
    }

  private class RingBufferIterator implements Iterator<Item> {
      private int current = first;
      private int count = 0;

      @Override
      public boolean hasNext() {
          return count < size;
      }

      @Override
      public Item next() {
          Item item = bufferItems[current];

          if (current == bufferItems.length - 1) {
              current = 0; //Wrap around
          } else {
              current++;
          }

          count++;
          return item;
      }
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


    public static void main(String[] args) {
        Exercise39RingBuffer<Integer> buffer = new Exercise39RingBuffer<>(7);
        buffer.produce(1);
        buffer.produce(2);



        buffer.produce(3);
        buffer.produce(4);
        buffer.produce(5);
        buffer.produce(6);

        System.out.println(buffer.consume());
        System.out.println(buffer.consume());
        System.out.println(buffer.consume());

        buffer.produce(7);
        buffer.produce(8);
        buffer.produce(9);
        buffer.produce(10);
        buffer.produce(11);
        buffer.produce(12);
        buffer.produce(13);



        System.out.println(buffer.consume());

        System.out.println(buffer);

    }
}
