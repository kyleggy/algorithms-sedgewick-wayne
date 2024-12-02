package chapter1.scott.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {

    public static void main(String[] args) {
        Stack<String> operators = new Stack<>();
        Stack<String> realOutput = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (item.equals("(")) {
            } else if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-")) {
                operators.push(item);
            } else if (item.equals(")")) {
                String operator = operators.pop();
                String valueRight = realOutput.pop();
                String newValue =  "( " + realOutput.pop() + " " + operator + " " + valueRight + " )";
                StdOut.println(newValue);
                realOutput.push(newValue);
            } else {
                realOutput.push(item);
            }
        }
        StdOut.println(realOutput.pop());

    }
}
