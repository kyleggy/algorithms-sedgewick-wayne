package chapter1.scott.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise15 {

    public static void main(String[] args) {
        Integer k = Integer.parseInt(args[0]);

        List<String> inputs = new ArrayList<>();
        while (!StdIn.isEmpty() ) {
            String item = StdIn.readString();
            inputs.add(item);
        }

        Queue<String> queue = new Queue<>();
        Integer beginIndex = inputs.size() - k;
        Iterator<String> inputsIterator = inputs.iterator();
        int count = 0;
        while (inputsIterator.hasNext()) {
            count++;
            if (count > beginIndex) {
                queue.enqueue(inputsIterator.next());
            } else {
                inputsIterator.next();
            }
        }
        StdOut.println(queue);

    }
}
