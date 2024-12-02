package chapter1.scott.section3;

public class Exercise1 {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(3);
        stack.push("Scott");
        stack.push("Peter");
        System.out.println(stack.isFull() + " Expected: false");
        stack.push("James");
        System.out.println(stack.isFull() + " Expected: true");
        stack.pop();
        System.out.println(stack.isFull() + " Expected: false");
    }

    private static class FixedCapacityStackOfStrings {
        private String[] a; // stack entries
        private int N;      // size

        public FixedCapacityStackOfStrings(int cap)
        {  a = new String[cap];  }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void push(String item)
        {
            a[N++] = item;
        }

        public boolean isFull() {
            return N == a.length;
        }

        public String pop()
        {
            return a[--N];
        }



    }


}
