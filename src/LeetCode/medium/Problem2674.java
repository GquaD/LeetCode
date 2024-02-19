package LeetCode.medium;

public class Problem2674 {
    //https://leetcode.com/problems/split-a-circular-linked-list/
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        System.out.println(splitCircularLinkedList(l1));
    }

    //https://leetcode.com/problems/split-a-circular-linked-list/solutions/4751862/java-o-n-solution/
    //15min
    //Runtime
    //2
    //ms
    //Beats
    //89.58%
    //of users with Java
    //Memory
    //65.53
    //MB
    //Beats
    //16.67%
    //of users with Java
    static ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode[] arr = new ListNode[2];

        ListNode t = list.next;
        int count = 1;
        while (t != list) {
            count++;
            t = t.next;
        }
        int one = count % 2 == 1 ? count / 2 + 1 : count / 2, two = count / 2;
        count = 1;
        arr[0] = list;
        t = list;

        while (count < one) {
            count++;
            t = t.next;
        }
        arr[1] = t.next;
        t.next = arr[0];
        t = arr[1];
        count = 1;

        while (count < two) {
            count++;
            t = t.next;
        }
        t.next = arr[1];
        return arr;
    }
}
