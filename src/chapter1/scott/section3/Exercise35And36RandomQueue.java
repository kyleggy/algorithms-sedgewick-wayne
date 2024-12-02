package chapter1.scott.section3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static edu.princeton.cs.algs4.StdRandom.uniform;

public class Exercise35And36RandomQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] a;  // array of items

    public Exercise35And36RandomQueue() {
        a = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i ++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void enqueue(Item item) {
        if (size == a.length) {
            System.out.println("Resize to enlarge happen");
            resize(size *2 );
        }
        a[size ++] = item;
    }

    public Item dequeue() {
        if (a.length == size * 2) {
            System.out.println("Resize to decrease happen");
            resize(size);
        }
        int r = uniform(size -1);
        Item temp = a[r];
        a[r] = a[size-1];

        a[size -1 ] = null;
        size --;
        return temp;
    }

    public Item sample() {
        int r = uniform(size -1);
        Item temp = a[r];
        return temp;
    }



    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

       // an iterator, doesn't implement remove() since it's optional
    private class RandomQueueIterator implements Iterator<Item> {
        private int index = 0;
        private Item[] randomItems;

        public RandomQueueIterator() {
            randomItems = a;
            shuffleItems();
        }

        public boolean hasNext()  {
            return index < size;
        }

        public void remove()     {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return randomItems[index++];
        }

       private void shuffleItems() {
           for (int i = 0; i < size - 1; i++) {
               int randomIndex = StdRandom.uniform(i + 1, size);

               //Swap
               Item temp = randomItems[i];
               randomItems[i] = randomItems[randomIndex];
               randomItems[randomIndex] = temp;
           }
       }
    }

    public static void main(String[] args) {
        Exercise35And36RandomQueue<String> randomQueue = new Exercise35And36RandomQueue<>();
        randomQueue.enqueue("1");
        randomQueue.enqueue("2");
        randomQueue.enqueue("3");
        randomQueue.enqueue("4");
        randomQueue.enqueue("5");
        randomQueue.enqueue("6");
        randomQueue.enqueue("7");
        randomQueue.enqueue("8");
        randomQueue.enqueue("9");
        randomQueue.enqueue("10");
        randomQueue.enqueue("11");
        randomQueue.enqueue("12");
        randomQueue.enqueue("13");

        System.out.println("Random print: " + randomQueue.sample());

        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());
//        System.out.println("Pop: " + randomQueue.dequeue());
//        System.out.println("Pop: " + randomQueue.dequeue());
//        System.out.println("Pop: " + randomQueue.dequeue());
//        System.out.println("Pop: " + randomQueue.dequeue());        System.out.println("Pop: " + randomQueue.dequeue());
//        System.out.println("Pop: " + randomQueue.dequeue());
//        System.out.println("Pop: " + randomQueue.dequeue());
//        System.out.println("Pop: " + randomQueue.dequeue());

        System.out.println("Print left items in random queue");
        Iterator<String> iterator = randomQueue.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Continue pop");
        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());
        System.out.println("Pop: " + randomQueue.dequeue());


    }
}
