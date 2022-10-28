package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem109 {
    //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    public static void main(String[] args) {
        /*ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        TreeNode treeNode = sortedListToBST(n1);
        System.out.println(treeNode.val);*/
        System.out.println("///////////");
        ListNode no1 = new ListNode(0);
        ListNode no2 = new ListNode(1);
        ListNode no3 = new ListNode(2);
        ListNode no4 = new ListNode(3);
        ListNode no5 = new ListNode(4);
        ListNode no6 = new ListNode(5);
        ListNode no7 = new ListNode(6);
        no1.next = no2;
        no2.next = no3;
        no3.next = no4;
        no4.next = no5;
        no5.next = no6;
        no6.next = no7;
        TreeNode treeNode1 = sortedListToBST(no1);
        System.out.println(treeNode1.val);
    }

    //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solutions/2751515/java-recursive-solution-construct-binary-search-tree/
    //1-1.5 hours
    //Runtime
    //4 ms
    //Beats
    //15.60%
    //Memory
    //47.3 MB
    //Beats
    //40.87%

    static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        List<ListNode> list = new ArrayList<>();
        ListNode tempHead = head;
        while (tempHead != null) {
            list.add(tempHead);
            tempHead = tempHead.next;
        }
        boolean visited[] = new boolean[list.size()];
        TreeNode node = new TreeNode(list.get(list.size() / 2).val);
        constructBinarySearchTree(list, visited, node, 0, list.size() / 2, list.size() - 1);
        return node;
    }

    private static void constructBinarySearchTree(List<ListNode> list, boolean[] visited, TreeNode node,
                                                  int idxLeft, int idxCenter, int idxRight) {
        if (visited[idxCenter]) {
            return;
        }

        visited[idxCenter] = true;
        //go left
        int newCenterForLeft = idxLeft + (idxCenter - idxLeft) / 2;
        if (newCenterForLeft >= list.size() || newCenterForLeft < 0) return;
        if (!visited[newCenterForLeft] && list.get(newCenterForLeft).val < node.val) {
            node.left = new TreeNode(list.get(newCenterForLeft).val);
            constructBinarySearchTree(list, visited, node.left, idxLeft, newCenterForLeft, idxCenter);
        }
        //go right
        int newCenterForRight = idxRight - (idxRight - idxCenter) / 2;
        if (newCenterForRight >= list.size() || newCenterForRight < 0) return;
        if (!visited[newCenterForRight] && list.get(newCenterForRight).val > node.val) {
            node.right = new TreeNode(list.get(newCenterForRight).val);
            constructBinarySearchTree(list, visited, node.right, idxCenter, newCenterForRight, idxRight);
        }
    }
}
