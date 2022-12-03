package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem114 {
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solutions/2871918/java-1ms-solution/
    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //83.19%
    //Memory
    //43.2 MB
    //Beats
    //13.28%
    static void flatten(TreeNode root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        traverseBST(root, list);
        root.left = null;
        root.right = null;
        TreeNode curr = root;
        for (int i = 1; i < list.size(); i++) {
            curr.right = new TreeNode(list.get(i));;
            curr = curr.right;
        }
    }

    private static void traverseBST(TreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);
        traverseBST(node.left, list);
        traverseBST(node.right, list);
    }


}
