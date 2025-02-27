package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem236 {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public static void main(String[] args) {

    }

    //10min
    //Runtime
    //6
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.15
    //MB
    //Beats
    //99.38%
    //public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //        TreeNode[] result = new TreeNode[1];
    //        goDFS(root, p.val, q.val, result);
    //        return result[0];
    //    }
    //
    //    private int goDFS(TreeNode node, int p, int q, TreeNode[] result) {
    //        if (node == null) return 0;
    //
    //        int left = goDFS(node.left, p, q, result), right = goDFS(node.right, p, q, result);
    //        if (node.val == p || node.val == q) {
    //            left++;
    //        }
    //        left += right;
    //        if (left >= 2 && result[0] == null) {
    //            result[0] = node;
    //        }
    //        return left;
    //    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solutions/3262947/java-dfs-solution/
    //15 min
    //Runtime
    //8 ms
    //Beats
    //25.47%
    //Memory
    //44.5 MB
    //Beats
    //18.70%
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> listBig = new ArrayList<>();
        goDFS(root, p, q, new ArrayList<>(), listBig);
        List<TreeNode> one = listBig.get(0), two = listBig.get(1);
        for (int i = one.size() - 1; i >= 0; i--) {
            TreeNode node1 = one.get(i);
            for (int j = two.size() - 1; j >= 0; j--) {
                TreeNode node2 = two.get(j);
                if (node1.equals(node2)) return node1;
            }
        }
        return root;
    }

    private static void goDFS(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> list, List<List<TreeNode>> listBig) {
        if (node == null) return;

        list.add(node);
        if (node.val == p.val || node.val == q.val) listBig.add(new ArrayList<>(list));

        goDFS(node.left, p, q, list, listBig);
        goDFS(node.right, p, q, list, listBig);
        list.remove(list.size() - 1);
    }
}
