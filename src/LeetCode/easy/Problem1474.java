package LeetCode.easy;

public class Problem1474 {
    //https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/solutions/5480154/java-in-place-solution/
    //5-10min
    //Runtime
    //1
    //ms
    //Beats
    //90.91%
    //Analyze Complexity
    //Memory
    //44.54
    //MB
    //Beats
    //81.82%
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode temp = head, prev = head;
        int leave = m, delete = n;
        while (temp != null) {
            if (leave == 0) {
                if (delete == 0) {
                    leave = m - 1;
                    delete = n;
                    prev.next = temp;
                    prev = temp;
                } else {
                    delete--;
                    prev.next = null;
                }
            } else {
                leave--;
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
