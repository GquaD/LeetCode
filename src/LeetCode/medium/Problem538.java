package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem538 {
    //https://leetcode.com/problems/convert-bst-to-greater-tree/
    public static void main(String[] args) {

    }

    //Runtime: 17 ms, faster than 7.71% of Java online submissions for Convert BST to Greater Tree.
    //Memory Usage: 54.3 MB, less than 5.41% of Java online submissions for Convert BST to Greater Tree.
    static Set<Integer> set;
    static int sum;
    public TreeNode convertBST(TreeNode root) {
        set = new TreeSet<>();
        sum = 0;
        traverseBST(root);
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : set) {
            map.put(i, sum);
            sum -= i;
        }
        traverseBSTAndPutNewValues(root, map);
        return root;
    }

    private void traverseBSTAndPutNewValues(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        if (map.containsKey(node.val)) {
            node.val = map.get(node.val);
        }
        traverseBSTAndPutNewValues(node.left, map);
        traverseBSTAndPutNewValues(node.right, map);
    }

    private void traverseBST(TreeNode node) {
        if (node == null) {
            return;
        }

        if (set.add(node.val)) {
            sum += node.val;
        }
        traverseBST(node.left);
        traverseBST(node.right);
    }
}
