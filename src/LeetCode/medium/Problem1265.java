package LeetCode.medium;

public class Problem1265 {
    //https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/print-immutable-linked-list-in-reverse/solutions/4654328/java-o-n-3-lines-100-faster-solution-recursive/
    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //42.33
    //MB
    //Beats
    //5.37%
    //of users with Java
/*    static void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }*/

    //Memory Limit Exceeded
/*
    static void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        ImmutableListNode cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = head.getNext();
        }
        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }*/
}
