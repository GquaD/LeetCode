package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1110 {
    //https://leetcode.com/problems/delete-nodes-and-return-forest/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/delete-nodes-and-return-forest/solutions/2934824/java-dfs-o-n-solution/
    //20-30 min
    //Runtime
    //3 ms
    //Beats
    //68.82%
    //Memory
    //48.4 MB
    //Beats
    //12.37%


    static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        if (!set.contains(root.val)) {
            list.add(root);
        } else {
            if (root.left != null && !set.contains(root.left.val)) list.add(root.left);
            if (root.right != null && !set.contains(root.right.val)) list.add(root.right);
        }
        traverseBST(root.left, root, true, list, set);
        traverseBST(root.right, root, false, list, set);
        return list;
    }

    private static void traverseBST(TreeNode node, TreeNode parent, boolean isLeft, List<TreeNode> list, Set<Integer> delete) {
        if (node == null) return;

        traverseBST(node.left, node, true, list, delete);
        traverseBST(node.right, node, false, list, delete);

        if (delete.contains(node.val)) {
            delete.remove(node.val);
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
        }
    }
}
