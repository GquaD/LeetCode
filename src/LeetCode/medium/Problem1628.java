package LeetCode.medium;

public class Problem1628 {
    //https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/solutions/6323910/java-2ms-solution-by-tbekpro-4ogf/
    //15min
    //Runtime
    //2
    //ms
    //Beats
    //88.71%
    //Analyze Complexity
    //Memory
    //41.22
    //MB
    //Beats
    //66.13%

//    abstract class Node {
//        public abstract int evaluate();
//        String[] arr;
//        // define your fields here
//    };
//
//    class MyNode extends Node{
//        public MyNode(String[] a) {
//            arr = a;
//        }
//
//        public int evaluate() {
//            Stack<Integer> stack = new Stack<>();
//            Queue<String> q = new LinkedList<>();
//            for (String s: arr) {
//                if (s.equals("+")) {
//                    int b = stack.pop(), a = stack.pop();
//                    stack.push(a + b);
//                } else if (s.equals("-")) {
//                    int b = stack.pop(), a = stack.pop();
//                    stack.push(a - b);
//                } else if (s.equals("/")) {
//                    int b = stack.pop(), a = stack.pop();
//                    stack.push(a / b);
//                } else if (s.equals("*")) {
//                    int b = stack.pop(), a = stack.pop();
//                    stack.push(a * b);
//                } else {
//                    Integer n = Integer.parseInt(s);
//                    stack.push(n);
//                }
//            }
//            return stack.pop();
//        }
//    }
//
//
//    /**
//     * This is the TreeBuilder class.
//     * You can treat it as the driver code that takes the postinfix input
//     * and returns the expression tree representing it as a Node.
//     */
//
//    class TreeBuilder {
//        Node buildTree(String[] postfix) {
//            return new MyNode(postfix);
//        }
//    };

}
