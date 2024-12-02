package chapter1.scott.section3;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

public class Exercise37Josephus {
    private Queue<Integer> josepusQueue;

    public Exercise37Josephus() {
        josepusQueue = new Queue<>();
    }

    public  void initializeJosepusQueue(int m) {
        for (int i = 0 ; i <= m; i ++) {
            josepusQueue.enqueue(i);
        }
    }

    public void splitJosepusQueue(int n) {
       Iterator<Integer> iterator = josepusQueue.iterator();
       int size = josepusQueue.size();
       while (size > 0) {
           for (int i = 1; i < n; i ++) {
               josepusQueue.enqueue(josepusQueue.dequeue());
           }
           System.out.println(josepusQueue.dequeue());
           size --;
       }
    }

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        Exercise37Josephus queue = new Exercise37Josephus();
        queue.initializeJosepusQueue(M);
        queue.splitJosepusQueue(N);






    }


}
