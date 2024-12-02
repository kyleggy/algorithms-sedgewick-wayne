package chapter1.scott.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise11EvaluatePostfix {
    private static final String inFixInput = "( ( 8 + 14 ) / ( ( 3 - 2 ) * ( ( 9 - 4 ) + ( 7 - 1 ) ) ) )";
    private static final String postFixInput = "8 14 + 3 2 - 9 4 - 7 1 - + * /";

    public static void main(String[] args) {
        StdOut.println(evaluateInFix(inFixInput));
        StdOut.println(evaluatePostfix(postFixInput));
    }

    private static Integer evaluateInFix(String input) {
        String[] items = input.split("\\s");
        Stack<String> operators = new Stack<>();
        Stack<Integer> outPuts = new Stack<>();
        for( String item : items) {
            if (item.equals("(")){

            } else if (item.equals("-") || item.equals("+") || item.equals("*") || item.equals("/")) {
                operators.push(item);
            } else if (item.equals(")")) {
                String operator = operators.pop();
                Integer rightValue = outPuts.pop();
                Integer leftValue = outPuts.pop();
                if (operator.equals("+")) {
                    outPuts.push(rightValue + leftValue);
                } else if (operator.equals("-")) {
                    outPuts.push(leftValue - rightValue);
                } else if (operator.equals("*")) {
                    outPuts.push(leftValue * rightValue);
                } else if (operator.equals("/")) {
                    outPuts.push(leftValue / rightValue);
                }
            } else {
                outPuts.push(Integer.parseInt(item));
            }
        }
        return outPuts.pop();
    }

    private static Integer evaluatePostfix(String input) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> outPuts = new Stack<>();
        for (String item : input.split("\\s")) {
            if (item.equals("(")) {

            } else if (item.equals("-") || item.equals("+") || item.equals("*") || item.equals("/")) {
                Integer rightValue = outPuts.pop();
                Integer leftValue = outPuts.pop();
                if (item.equals("+")) {
                    outPuts.push(rightValue + leftValue);
                } else if (item.equals("-")) {
                    outPuts.push(leftValue - rightValue);
                } else if (item.equals("*")) {
                    outPuts.push(leftValue * rightValue);
                } else if (item.equals("/")) {
                    outPuts.push(leftValue / rightValue);
                }
            } else {
                outPuts.push(Integer.parseInt(item));
            }
        }
        return outPuts.pop();
    }


}
