package chapter1.scott.section3;

import chapter1.section3.LinkedList;

public class Exercise21 {

    public static void main(String[] args) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.insert("a");
        nodes.insert("b");
        nodes.insert("c");
        System.out.println(find(nodes, "d"));
        System.out.println(find(nodes, "c"));
    }

    private static boolean find(LinkedList<String> nodes, String key) {
        boolean isExist = false;
        for (String item : nodes) {
            if (key.equals(item)) {
                isExist = true;
            }
        }
        return isExist;
    }
}
