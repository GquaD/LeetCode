package LeetCode.medium;

public class Problem2816 {
    //https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        System.out.println(doubleIt(n1).val);
    }

    //https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/solutions/3924730/java-using-stringbuilder/
    //15 - 20 min
    //Runtime
    //15 ms
    //Beats
    //24.2%
    //Memory
    //45 MB
    //Beats
    //50.76%
    static ListNode doubleIt(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }

        String s = sb.toString();
        sb.setLength(0);
        int mem = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = s.charAt(i) - '0';
            curr *= 2;
            curr += mem;
            sb.append(curr % 10);
            mem = curr / 10;
        }
        if (mem > 0) sb.append(mem);
        sb = sb.reverse();
        int c = 0;
        temp = head;
        while (c < sb.length()) {
            temp.val = sb.charAt(c++) - '0';
            if (temp.next == null && c < sb.length()) temp.next = new ListNode(sb.charAt(c++) - '0');
            temp = temp.next;
        }

        return head;
    }
}
