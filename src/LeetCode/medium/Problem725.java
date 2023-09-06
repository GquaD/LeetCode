package LeetCode.medium;

public class Problem725 {
    //https://leetcode.com/problems/split-linked-list-in-parts
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode[] arr = splitListToParts(n1, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].val);
        }
    }

    //https://leetcode.com/problems/split-linked-list-in-parts/solutions/4009867/java-o-n-100-faster/
    //10-15 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //43.8 MB
    //Beats
    //38.88%
    static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head, temp2 = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int div = count / k, rem = count % k;
        ListNode[] arr = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int size = div;
            if (rem-- > 0) size++;
            count = 0;
            arr[i] = temp2;
            while (temp2 != null) {
                count++;
                if (count == size) {
                    ListNode nodeNext = temp2.next;
                    temp2.next = null;
                    temp2 = nodeNext;
                    break;
                } else {
                    temp2 = temp2.next;
                }
            }
        }
        return arr;
    }
}
