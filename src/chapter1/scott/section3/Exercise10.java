package chapter1.scott.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise10 {
    private static final String input = "( ( 3 - 4 ) * ( 5 - 6 ) )";
    private static final String wrongComplexInput = "( 8 + 7 ) / ( ( 3 - 2 ) * ( 9 - 4 + ( 7 - 1 ) ) )";
    private static final String complexInput = "( ( 8 + 7 ) / ( ( 3 - 2 ) * ( ( 9 - 4 ) + ( 7 - 1 ) ) ) )";

    //https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/
    public static void main(String[] args) {
        //StdOut.println(convertInfixToPostFix(input));
        StdOut.println(convertInfixToPostFix(complexInput));
    }

    private static String convertInfixToPostFix(String input) {
        String[] items = input.split("\\s");
        Stack<String> operators = new Stack<>();
        Stack<String> outPuts = new Stack<>();
        for( String item : items) {
            if (item.equals("(")){

            } else if (item.equals("-") || item.equals("+") || item.equals("*") || item.equals("/")) {
                operators.push(item);
            } else if (item.equals(")")) {
                String operator = operators.pop();
                String rightValue = outPuts.pop();
                String leftValue = outPuts.pop();
                String newValue = leftValue + " " + rightValue + " " + operator;
                outPuts.push(newValue);
            } else {
                outPuts.push(item);
            }
        }
        return outPuts.pop();
    }
}
