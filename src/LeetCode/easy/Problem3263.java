package LeetCode.easy;

public class Problem3263 {
    //https://leetcode.com/problems/convert-doubly-linked-list-to-array-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/convert-doubly-linked-list-to-array-i/solutions/5725271/java-100-faster-o-n-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.16
    //MB
    //Beats
    //14.57%
    static int[] toArray(ListNode head) {
        ListNode t = head;
        int size = 0;
        while (t != null) {
            size++;
            t = t.next;
        }
        int[] arr = new int[size];
        size = 0;
        while (head != null) {
            arr[size++] = head.val;
            head = head.next;
        }
        return arr;
    }
}
