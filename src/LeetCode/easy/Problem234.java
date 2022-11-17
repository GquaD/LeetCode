package LeetCode.easy;

public class Problem234 {
    //https://leetcode.com/problems/palindrome-linked-list/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/palindrome-linked-list/solutions/2823058/java-o-n-n-2-using-static-array-99-96-faster/
    //Runtime
    //3 ms
    //Beats
    //99.96%
    //Memory
    //104.9 MB
    //Beats
    //23.58%
    static int[] arr = new int[100_000];
    static boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        int len = 0;
        while (head != null) {
            arr[len++] = head.val;
            head = head.next;
        }

        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1]) return false;
        }
        return true;
    }
}
