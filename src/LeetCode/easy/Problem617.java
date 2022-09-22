package LeetCode.easy;


public class Problem617 {
    //https://leetcode.com/problems/merge-two-binary-trees/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/merge-two-binary-trees/discuss/2609971/Java-recursion-solution-in-just-1ms
    //1.5 - 2 hours
    //Runtime: 1 ms, faster than 81.90% of Java online submissions for Merge Two Binary Trees.
    //Memory Usage: 51.3 MB, less than 21.64% of Java online submissions for Merge Two Binary Trees.
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode node = new TreeNode(root1.val + root2.val);
        traverseDFS(root1, node);
        traverseDFS(root2, node);
        return node;
    }

    private void traverseDFS(TreeNode root1, TreeNode node) {
        if (root1 == null || node == null) return;

        if (node.left == null && root1.left != null) {
            node.left = root1.left;
        } else if (node.left != null && root1.left != null) {
            node.left.val += root1.left.val;
            traverseDFS(root1.left, node.left);
        }

        if (node.right == null && root1.right != null) {
            node.right = root1.right;
        } else if (node.right != null && root1.right != null) {
            node.right.val += root1.right.val;
            traverseDFS(root1.right, node.right);
        }

    }


    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        binaryMerge(root1, root2, root);
        return root;
    }

    private void binaryMerge(TreeNode root1, TreeNode root2, TreeNode root) {
        if (root1 == null && root2 == null) {
            root = null;
            return;
        }

        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
            root.left = new TreeNode();
            root.right = new TreeNode();
            binaryMerge(root1.left, root2.left, root.left);
            binaryMerge(root1.right, root2.right, root.right);
        } else if (root1 != null && root2 == null) {
            root.val = root1.val;
            root.left = new TreeNode();
            root.right = new TreeNode();
            binaryMerge(root1.left, null, root.left);
            binaryMerge(root1.right, null, root.right);
        } else if (root1 == null && root2 != null) {
            root.val = root2.val;
            root.left = new TreeNode();
            root.right = new TreeNode();
            binaryMerge(null, root2.left, root.left);
            binaryMerge(null, root2.right, root.right);
        }
    }


    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
            merge(root1.left, root2.left, root);
            merge(root1.right, root2.right, root);
        } else if (root1 != null) {
            return root1;
        } else if (root2 != null) {
            return root2;
        }

        return root;
    }

    private void merge(TreeNode one, TreeNode two, TreeNode root) {
        if (one == null && two == null) {
            return;
        }
        if (one != null && two == null) {
            root.left = one.left;
            root.right = one.right;
            return;
        } else if (one == null && two != null) {
            root.left = two.left;
            root.right = two.right;
            return;
        }
        if (one.left != null && two.left != null) {
            root.left = new TreeNode(one.left.val + two.left.val);
        }
        if (one.left != null && two.left == null) {
            root.left = new TreeNode(one.left.val);
        } else if (one.left == null && two.left != null) {
            root.left = new TreeNode(two.left.val);
        }
        merge(one.left, two.left, root.left);
        if (one.right != null && two.right != null) {
            root.right = new TreeNode(one.right.val + two.right.val);
        }
        if (one.right != null && two.right == null) {
            root.right = new TreeNode(one.right.val);
        } else if (one.right == null && two.right != null) {
            root.right = new TreeNode(two.right.val);
        }
        merge(one.right, two.right, root.right);
    }
}
