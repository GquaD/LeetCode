package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem590 {
    //https://leetcode.com/problems/n-ary-tree-postorder-traversal/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/n-ary-tree-postorder-traversal/discuss/2610109/Java-Solution-or-Easy-to-understand
    //10mins
    //Runtime: 2 ms, faster than 59.04% of Java online submissions for N-ary Tree Postorder Traversal.
    //Memory Usage: 46 MB, less than 57.79% of Java online submissions for N-ary Tree Postorder Traversal.
    static List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(Node root) {
        if (root == null) return;

        for (Node child : root.children) {
            traverse(child);
        }
        list.add(root.val);
    }
}
