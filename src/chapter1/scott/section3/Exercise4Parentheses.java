package chapter1.scott.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Exercise4Parentheses {
    private static char leftSquareBrackets = '[';
    private static char rightSquareBrackets = ']';
    private static char leftParenthesis = '(';
    private static char rightParenthesis = ')';
    private static char leftBrace = '{';
    private static char rightBrace = '}';


    public static void main(String[] args) {
        boolean isParentheses = true;
        Stack<Character> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            char item = StdIn.readChar();
            if (item == leftSquareBrackets || item == leftBrace || item == leftParenthesis) {
                stack.push(item);
            } else {
                if ((item != rightBrace) && (item != rightParenthesis) && (item != rightSquareBrackets)) {
                    isParentheses = false;
                    break;
                }
                //Right side is more than left side
                if (stack.isEmpty()) {
                    isParentheses = false;
                    break;
                }
                char poppedItem = stack.pop();
                if ( (poppedItem == leftSquareBrackets && item != rightSquareBrackets) ||( poppedItem == leftBrace && item != rightBrace)
                    || (poppedItem == leftParenthesis && item != rightParenthesis)) {
                    isParentheses = false;
                    break;
                }
            }
        }
        // Left side is more than right side
        if (!stack.isEmpty()) {
            isParentheses = false;
        }
        System.out.println(isParentheses);
//        Iterator<Character> stringIterator = stack.iterator();
//        while (stringIterator.hasNext()) {
//            StdOut.print(stringIterator.next());
//        }
    }


}
