package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1367 {
    //https://leetcode.com/problems/linked-list-in-binary-tree/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(1);
        TreeNode n10 = new TreeNode(3);
        n1.left = n2;
        n2.right = n3;
        n3.left = n4;

        n1.right = n5;
        n5.left = n6;
        n6.left = n7;
        n6.right = n8;
        n8.left = n9;
        n8.right = n10;

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(6);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        System.out.println(isSubPath(ln1, n1));
    }

    //https://leetcode.com/problems/linked-list-in-binary-tree/solutions/3963813/java-dfs-in-dfs-solution/
    //30 min
    //Runtime
    //8 ms
    //Beats
    //5.68%
    //Memory
    //44 MB
    //Beats
    //62.47%

    static boolean hasPath;
    static boolean isSubPath(ListNode head, TreeNode root) {
        hasPath = false;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        dfsMain(root, list.get(0), list);
        return hasPath;
    }

    private static void dfsMain(TreeNode node, int head, List<Integer> list) {
        if (node == null) return;

        if (node.val == head) dfs(node, list, 0);

        if (hasPath) return;
        dfsMain(node.left, head, list);
        dfsMain(node.right, head, list);
    }

    private static void dfs(TreeNode node, List<Integer> list, int idx) {
        if (node == null) return;

        idx = node.val == list.get(idx) ? idx + 1 : 0;

        if (idx == list.size()) {
            hasPath = true;
            return;
        }

        dfs(node.left, list, idx);
        dfs(node.right, list, idx);
    }


}
