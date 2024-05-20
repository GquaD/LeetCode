package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1644 {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/solutions/5184031/java-o-n-solution/
    //30min
    //Runtime
    //13
    //ms
    //Beats
    //8.82%
    //of users with Java
    //Memory
    //46.32
    //MB
    //Beats
    //90.31%
    //of users with Java
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList<>();
        boolean foundp[] = new boolean[1];
        goDFS(root, p, listp, foundp);

        List<TreeNode> listq = new ArrayList<>();
        boolean foundq[] = new boolean[1];
        goDFS(root, q, listq, foundq);

        int size = Math.min(listp.size(), listq.size());
        TreeNode res = null;
        for (int i = 0; i < size; i++) {
            if (listp.get(i).val == listq.get(i).val) {
                res = listp.get(i);
            } else break;
        }

        return res;
    }

    private void goDFS(TreeNode node, TreeNode p, List<TreeNode> list, boolean[] found) {
        if (node == null || found[0]) {
            return;
        }

        if (!found[0]) {
            list.add(node);
        }

        if (node.val == p.val) {
            found[0] = true;
        }

        goDFS(node.left, p, list, found);
        goDFS(node.right, p, list, found);

        if (!found[0]) {
            list.remove(list.size() - 1);
        }
    }
}
